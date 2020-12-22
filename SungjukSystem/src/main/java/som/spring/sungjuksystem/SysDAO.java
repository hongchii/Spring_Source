package som.spring.sungjuksystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;


@Repository
public class SysDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	
	public int insertSungjuk(SysVO sysVO) {
		
		int result = 0;
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = conn.prepareStatement("insert into sungjuk3 (id, password, name, age, gender, email, "
					+ "kor, eng, math, tot, avg, grade) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, sysVO.getId());
			pstmt.setString(2, sysVO.getPassword());
			pstmt.setString(3, sysVO.getName());
			pstmt.setInt(4, sysVO.getAge());
			pstmt.setString(5, sysVO.getGender());
			pstmt.setString(6, sysVO.getEmail());
			pstmt.setInt(7, sysVO.getKor());
			pstmt.setInt(8, sysVO.getEng());
			pstmt.setInt(9, sysVO.getMath());
			pstmt.setInt(10, sysVO.getTot());
			pstmt.setDouble(11, sysVO.getAvg());
			pstmt.setString(12, sysVO.getGrade());
			
			result = pstmt.executeUpdate();
		}
		catch(Exception ex) {
			System.out.println("입력오류!" + ex.getMessage());
			ex.printStackTrace();
		}
		finally {
			JDBCUtil.closeResource(pstmt, conn);
		}
		return result;
	}
	
public int insertMember(SysVO sysVO) {
		
		int result = 0;
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = conn.prepareStatement("insert into sungjuk3 (id, password, name, age, gender, email, "
					+ "kor, eng, math, tot, avg, grade) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, sysVO.getId());
			pstmt.setString(2, sysVO.getPassword());
			pstmt.setString(3, sysVO.getName());
			pstmt.setInt(4, sysVO.getAge());
			pstmt.setString(5, sysVO.getGender());
			pstmt.setString(6, sysVO.getEmail());
			pstmt.setInt(7, sysVO.getKor());
			pstmt.setInt(8, sysVO.getEng());
			pstmt.setInt(9, sysVO.getMath());
			pstmt.setInt(10, sysVO.getTot());
			pstmt.setDouble(11, sysVO.getAvg());
			pstmt.setString(12, sysVO.getGrade());
			
			result = pstmt.executeUpdate();
		}
		catch(Exception ex) {
			System.out.println("입력오류!" + ex.getMessage());
			ex.printStackTrace();
		}
		finally {
			JDBCUtil.closeResource(pstmt, conn);
		}
		return result;
	}

	public int userCheck(SysVO sysVO) {
		String dbpasswd = "";
		
		int x = -1;
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = conn.prepareStatement("select * from sungjuk3 where id = ?");
			pstmt.setString(1,  sysVO.getId());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dbpasswd = rs.getString("password");
				if(dbpasswd.contentEquals(sysVO.getPassword()))
					x = 1; // 1이면 일치. 
				else
					x = 0;
			}
			else
				x = -1; // 
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			JDBCUtil.closeResource(rs, pstmt, conn);
		}
		return x;
	}
	
	public ArrayList<SysVO> getSyslist(){
		SysVO vo = null;
		ArrayList<SysVO> Sys_list = null;
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = conn.prepareStatement("select * from sungjuk3 order by id");
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				Sys_list = new ArrayList<SysVO>();
				do {
					vo = new SysVO();
					vo.setId(rs.getString("id"));
					vo.setPassword(rs.getString("password"));
					vo.setName(rs.getString("name"));
					vo.setAge(rs.getInt("Age"));
					vo.setGender(rs.getString("gender"));
					vo.setEmail(rs.getString("email"));
					vo.setKor(rs.getInt("kor"));
					vo.setEng(rs.getInt("eng"));
					vo.setMath(rs.getInt("math"));
					vo.setTot(rs.getInt("tot"));
					vo.setAvg(rs.getDouble("avg"));
					vo.setGrade(rs.getString("grade"));
					Sys_list.add(vo);
					
				} while(rs.next());
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			JDBCUtil.closeResource(rs, pstmt, conn);
		}
		return Sys_list;
	}
	
	public SysVO selectMember(SysVO sysVO) {
		SysVO vo = null;
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = conn.prepareStatement("select * from sungjuk3 where id = ?");
			pstmt.setString(1,  sysVO.getId());
			rs = pstmt.executeQuery();
			rs.next();
			
			vo = new SysVO();
			vo.setId(rs.getString("id"));
			vo.setPassword(rs.getString("password"));
			vo.setName(rs.getString("name"));
			vo.setAge(rs.getInt("Age"));
			vo.setGender(rs.getString("gender"));
			vo.setEmail(rs.getString("email"));
			vo.setKor(rs.getInt("kor"));
			vo.setEng(rs.getInt("eng"));
			vo.setMath(rs.getInt("math"));
			vo.setTot(rs.getInt("tot"));
			vo.setAvg(rs.getDouble("avg"));
			vo.setGrade(rs.getString("grade"));
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			JDBCUtil.closeResource(rs, pstmt, conn);
		}
		return vo;
	}
	
	public int deleteMember(SysVO sysVO) {
		int result = 0;
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = conn.prepareStatement(
					"delete from sungjuk3 where id = ?");
			pstmt.setString(1,  sysVO.getId());
			result = pstmt.executeUpdate();
			// 삭제 성공하면 result에 1저장. 실패하면 0. 
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			JDBCUtil.closeResource(pstmt, conn);
		}
		
		return result;
	}
	
	public SysVO update(SysVO sysVO) {
		SysVO vo = null;
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = conn.prepareStatement("select * from sungjuk3 where id = ?");
			pstmt.setString(1,  sysVO.getId());
			rs = pstmt.executeQuery();
			rs.next();
			
			vo = new SysVO();
			vo.setId(rs.getString("id"));
			vo.setPassword(rs.getString("password"));
			vo.setName(rs.getString("name"));
			vo.setAge(rs.getInt("Age"));
			vo.setGender(rs.getString("gender"));
			vo.setEmail(rs.getString("email"));
			vo.setKor(rs.getInt("kor"));
			vo.setEng(rs.getInt("eng"));
			vo.setMath(rs.getInt("math"));
			vo.setTot(rs.getInt("tot"));
			vo.setAvg(rs.getDouble("avg"));
			vo.setGrade(rs.getString("grade"));
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			JDBCUtil.closeResource(rs, pstmt, conn);
		}
		return vo;
	}
	
	public int updateMember(SysVO sysVO) {
		int result = 0;
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = conn.prepareStatement(
					"update sungjuk3 set password=?, name=?, age=?, gender=?, email=? "+
								"kor=?, eng=?, math=?, tot=?, avg=?, grade=? WHERE id=?");
			
			pstmt.setString(1, sysVO.getPassword());
			pstmt.setString(2, sysVO.getName());
			pstmt.setInt(3, sysVO.getAge());
			pstmt.setString(4, sysVO.getGender());
			pstmt.setString(5, sysVO.getEmail());
			pstmt.setInt(6, sysVO.getKor());
			pstmt.setInt(7, sysVO.getEng());
			pstmt.setInt(8, sysVO.getMath());
			pstmt.setInt(9, sysVO.getTot());
			pstmt.setDouble(10, sysVO.getAvg());
			pstmt.setString(11, sysVO.getGrade());
			pstmt.setString(12, sysVO.getId());
			result = pstmt.executeUpdate();
		}
		catch(Exception ex) {
			System.out.println("수정오류" + ex.getMessage());
			ex.printStackTrace();
		}
		finally {
			JDBCUtil.closeResource(pstmt, conn);
		}
		return result;
	}
}
