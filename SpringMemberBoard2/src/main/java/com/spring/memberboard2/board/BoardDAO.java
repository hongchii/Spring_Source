package com.spring.memberboard2.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.memberboard2.JDBCUtil;

@Repository
public class BoardDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//글의 개수 구하기.
	public int getListCount() {
		int x= 0;
		
		try{
			conn=JDBCUtil.getConnection();
			pstmt=conn.prepareStatement("select count(*) from smemberboard2");
			rs = pstmt.executeQuery(); // 컬럼(데이터)의 갯수가 저장. 
			
			if(rs.next()){
				x=rs.getInt(1); // getInt(1); 컬럼의 위치. 
				System.out.println("x=" + x);
			}
		}catch(Exception ex){
			System.out.println("getListCount 에러: " + ex);			
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(conn!=null) try{conn.close();}catch(SQLException ex){}
			// JDBCUtil close사용. 
		}
		return x; // 데이터갯수 아니면 0 반환. 
	}
	
	//글 목록 보기.
	public List<BoardVO> getBoardList(int page,int limit){
		String board_list_sql="select * from "+
		"(select rownum rnum,num,id,subject,"+
		"content,re_ref,re_lev,"+
		"re_seq,readcount,boarddate from "+
		"(select * from smemberboard2 order by "+
		"re_ref desc,re_seq asc)) "+
		"where rnum>=? and rnum<=?";
		
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		int startrow=(page-1)*10+1; //읽기 시작할 row 번호. - 1페이지면 1이 나오게 적절하게 식 설정.
		int endrow=startrow+limit-1; //읽을 마지막 row 번호. 
		try{
			conn=JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(board_list_sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				BoardVO board = new BoardVO();
				board.setNum(rs.getInt("num"));
				board.setId(rs.getString("id"));
				board.setSubject(rs.getString("subject"));
				board.setContent(rs.getString("content"));
				board.setRe_ref(rs.getInt("re_ref"));
				board.setRe_lev(rs.getInt("re_lev"));
				board.setRe_seq(rs.getInt("re_seq"));
				board.setReadcount(rs.getInt("readcount"));
				board.setBoarddate(rs.getDate("boarddate"));
				list.add(board); // list에 board 객체를 저장. 
			}
			
			return list; // list 리턴. 
		}catch(Exception ex){
			System.out.println("getBoardList 에러 : " + ex);
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(conn!=null) try{conn.close();}catch(SQLException ex){}
		}
		return null;
	}
	
	//글 내용 보기.
	public BoardVO getDetail(int num) {
		BoardVO board = null;
		try{
			conn=JDBCUtil.getConnection();
			pstmt = conn.prepareStatement("select * from smemberboard2 where num = ?");
			pstmt.setInt(1, num);
			
			rs= pstmt.executeQuery();
			
			if(rs.next()){
				board = new BoardVO();
				
				board.setNum(rs.getInt("num"));
				board.setId(rs.getString("id"));
				board.setSubject(rs.getString("subject"));
				board.setContent(rs.getString("content"));
				board.setOrg_file(rs.getString("org_file"));
				board.setUp_file(rs.getString("up_file"));
				board.setRe_ref(rs.getInt("re_ref"));
				board.setRe_lev(rs.getInt("re_lev"));
				board.setRe_seq(rs.getInt("re_seq"));
				board.setReadcount(rs.getInt("readcount"));
				board.setBoarddate(rs.getDate("boarddate"));
			}
			return board;
		}catch(Exception ex){
			System.out.println("getDetail 에러 : " + ex);
		}finally{
			if(rs!=null)try{rs.close();}catch(SQLException ex){}
			if(pstmt !=null)try{pstmt.close();}catch(SQLException ex){}
			if(conn !=null)try{conn.close();}catch(SQLException ex){}
		}
		return null;
	}
	
	//글 등록.
	public boolean boardInsert(BoardVO board){
		int num =0;
		String sql="";
		
		int result=0;
		
		try{
			conn=JDBCUtil.getConnection();
			pstmt=conn.prepareStatement("select max(num) from smemberboard2");
			rs = pstmt.executeQuery();
			
			if(rs.next()) // 새로운 글 번호를 설정하는 과정
				num =rs.getInt(1)+1; // 원래 글이 있을때 그 다음 글 번호로 설정.
			else
				num=1; // 첫글일때는 1로. 
			
			sql="insert into smemberboard2 (num,id,subject,";
			sql+="content,org_file,up_file,re_ref,re_lev,re_seq,readcount," +
				"boarddate) values(?,?,?,?,?,?,?,?,?,?,sysdate)";
				//re_ref글 그룹 = 글번호와 같음. 
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, board.getId());
			pstmt.setString(3, board.getSubject());
			pstmt.setString(4, board.getContent());
			pstmt.setString(5, board.getOrg_file());
			pstmt.setString(6, board.getUp_file());
			pstmt.setInt(7, num); //re_ref글 그룹 = 글번호와 같음. num=num
			pstmt.setInt(8, 0);
			pstmt.setInt(9, 0);
			pstmt.setInt(10, 0);
			
			result=pstmt.executeUpdate();
			if(result==0)
				return false;
			
			return true;
		}catch(Exception ex){
			System.out.println("boardInsert 에러  : "+ex);
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(conn!=null) try{conn.close();}catch(SQLException ex){}
		}
		return false;
	}
	
	//글 답변.
	public int boardReply(BoardVO board){
		String board_max_sql="select max(num) from smemberboard2";
		String sql="";
		int num=0;
		
		int re_ref=board.getRe_ref();
		int re_lev=board.getRe_lev();
		int re_seq=board.getRe_seq(); // 원글에 대한 정보. 
		
		try{
			conn=JDBCUtil.getConnection();
			pstmt=conn.prepareStatement(board_max_sql);
			rs = pstmt.executeQuery();
			if(rs.next())
				num =rs.getInt(1)+1;
			else 
				num=1;
			
			sql="update smemberboard2 set re_seq=re_seq+1 "; // 답글에대한 정보 1씩 증가
			sql+="where re_ref=? and re_seq>?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,re_ref);
			pstmt.setInt(2,re_seq);
			pstmt.executeUpdate();
			
			re_seq = re_seq + 1;
			re_lev = re_lev + 1; // 답글에대한거 1씩 증가 시킴.  
			
			sql="insert into smemberboard2 (num,id,subject,";
			sql+="content,re_ref,re_lev,";
			sql+="re_seq,readcount,boarddate) ";
			sql+="values(?,?,?,?,?,?,?,?,sysdate)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, board.getId());
			pstmt.setString(3, board.getSubject());
			pstmt.setString(4, board.getContent());
			pstmt.setInt(5, re_ref);
			pstmt.setInt(6, re_lev);
			pstmt.setInt(7, re_seq);
			pstmt.setInt(8, 0);
			pstmt.executeUpdate();
			return num;
		}catch(SQLException ex){
			System.out.println("boardReply 에러 : "+ex);
		}finally{
			if(rs!=null)try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null)try{pstmt.close();}catch(SQLException ex){}
			if(conn!=null)try{conn.close();}catch(SQLException ex){}
		}
		return 0;
	}
	
	//글 수정.
	public boolean boardModify(BoardVO modifyboard) {
		String sql="update smemberboard2 set subject=?,";
		sql+="content=? where num=?";
		
		try{
			conn=JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, modifyboard.getSubject());
			pstmt.setString(2, modifyboard.getContent());
			pstmt.setInt(3, modifyboard.getNum());
			pstmt.executeUpdate();
			return true;
		}catch(Exception ex){
			System.out.println("boardModify 에러 : " + ex);
		}finally{
			if(rs!=null)try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null)try{pstmt.close();}catch(SQLException ex){}
			if(conn!=null)try{conn.close();}catch(SQLException ex){}
			}
		return false;
	}
	
	//글 삭제.
	public boolean boardDelete(int num){
		String board_delete_sql="delete from smemberboard2 where num=?";
		
		int result=0;
		
		try{
			conn=JDBCUtil.getConnection();
			pstmt=conn.prepareStatement(board_delete_sql);
			pstmt.setInt(1, num);
			result=pstmt.executeUpdate();
			if(result==0)return false;
			
			return true;
		}catch(Exception ex){
			System.out.println("boardDelete 에러 : "+ex);
		}finally{
			try{
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception ex) {}
		}
		
		return false;
	}
	
	//조회수 업데이트.
	public void setReadCountUpdate(int num) {
		String sql="update smemberboard2 set readcount = " +
			"readcount+1 where num = " + num;
		
		try{
			conn=JDBCUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.executeUpdate();
		}catch(SQLException ex){
			System.out.println("setReadCountUpdate 에러 : "+ex);
		}
		finally{
			try{
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception ex) {}
		}
	}

	//글쓴이인지 확인.
	public boolean isBoardWriter(int num,String id){
		String board_sql="select * from smemberboard2 where num=?";
		
		try{
			conn=JDBCUtil.getConnection();
			pstmt=conn.prepareStatement(board_sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			rs.next();
			
			if(id.equals(rs.getString("id"))){
				return true;
			}
		}catch(SQLException ex){
			System.out.println("isBoardWriter 에러 : "+ex);
		}
		finally{
			try{
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception ex) {}
		}
		return false;
	}
}
