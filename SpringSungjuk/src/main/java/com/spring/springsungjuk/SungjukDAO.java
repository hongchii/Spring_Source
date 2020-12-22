package com.spring.springsungjuk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

@Repository
public class SungjukDAO { //데이터 베이스 연결 작업. DAO로 만들어줌. 
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public int insertSungjuk(SungjukVO sungjukVO) {
		
		int result = 0;
	
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = conn.prepareStatement("insert into sungjuk2 (hakbun, name, kor, eng, math, " + "tot, avg, grade) VALUES(?,?,?,?,?,?,?,?)");
			pstmt.setString(1, sungjukVO.getHakbun());
			pstmt.setString(2, sungjukVO.getName());
			pstmt.setInt(3, sungjukVO.getKor());
			pstmt.setInt(4, sungjukVO.getEng());
			pstmt.setInt(5, sungjukVO.getMath());
			pstmt.setInt(6, sungjukVO.getTot());
			pstmt.setDouble(7,sungjukVO.getAvg());
			pstmt.setString(8, sungjukVO.getGrade());
			
			result = pstmt.executeUpdate();
		}
		catch(Exception ex) {
			System.out.println("입력오류" + ex.getMessage());
			ex.printStackTrace();
		}
		finally {
			JDBCUtil.closeResource(pstmt, conn);
		}
		return result;
	}
	

	public ArrayList<SungjukVO> getSungjuklist(){
		SungjukVO vo = null;
		ArrayList<SungjukVO> sungjuk_list = null;
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = conn.prepareStatement("select * from sungjuk2 order by hakbun");
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				sungjuk_list = new ArrayList<SungjukVO>();
				do {
					vo = new SungjukVO();
					vo.setHakbun(rs.getString("hakbun"));
					vo.setName(rs.getString("name"));
					vo.setKor(rs.getInt("kor"));
					vo.setEng(rs.getInt("eng"));
					vo.setMath(rs.getInt("math"));
					vo.setTot(rs.getInt("tot"));
					vo.setAvg(rs.getDouble("avg"));
					vo.setGrade(rs.getString("grade"));
					sungjuk_list.add(vo);
					
				} while(rs.next());
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			JDBCUtil.closeResource(rs, pstmt, conn);
		}
		return sungjuk_list;
	}
	
	public SungjukVO selectSungjuk(SungjukVO sungjukVO) {
		SungjukVO vo = null;
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = conn.prepareStatement("select * from sungjuk2 where hakbun = ?");
			pstmt.setString(1,  sungjukVO.getHakbun());
			rs = pstmt.executeQuery();
			rs.next();
			
			vo = new SungjukVO();
			vo.setHakbun(rs.getString("hakbun"));
			vo.setName(rs.getString("name"));
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
	
	public int deleteSungjuk(SungjukVO sungjukVO) {
		int result = 0;
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = conn.prepareStatement(
					"delete from sungjuk2 where hakbun = ?");
			pstmt.setString(1,  sungjukVO.getHakbun());
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
	
	public SungjukVO update(SungjukVO sungjukVO) {
		SungjukVO vo = null;
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = conn.prepareStatement("select * from sungjuk2 where hakbun = ?");
			pstmt.setString(1,  sungjukVO.getHakbun());
			rs = pstmt.executeQuery();
			rs.next();
			
			vo = new SungjukVO();
			vo.setHakbun(rs.getString("hakbun"));
			vo.setName(rs.getString("name"));
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
	
	public int updateSungjuk(SungjukVO sungjukVO) {
		int result = 0;
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = conn.prepareStatement(
					"update sungjuk2 set name=?, kor=?, eng=?, math=?, tot=?, avg=?, grade=? WHERE hakbun=?");
			
			pstmt.setString(1, sungjukVO.getName());
			pstmt.setInt(2, sungjukVO.getKor());
			pstmt.setInt(3, sungjukVO.getEng());
			pstmt.setInt(4, sungjukVO.getMath());
			pstmt.setInt(5, sungjukVO.getTot());
			pstmt.setDouble(6, sungjukVO.getAvg());
			pstmt.setString(7, sungjukVO.getGrade());
			pstmt.setString(8, sungjukVO.getHakbun());
			
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
