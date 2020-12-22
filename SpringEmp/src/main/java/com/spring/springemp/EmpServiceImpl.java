package com.spring.springemp;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mapper.EmpMapper;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<EmpVO> getList() {
		//List<EmpVO> list = null;
		EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
		List<EmpVO> list = empMapper.getList();
//		for(EmpVO vo : list) {
//			System.out.println(vo.toString());
//		}
		return list;
	}
	
	
	@Override
	public List<EmpVO> getDeptno(String[] deptno){
		System.out.println("deptno"+deptno);
		EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
		List<EmpVO> list = empMapper.getDeptno(deptno);
		System.out.println("deptno="+deptno);
		
		return list;
	}
	
	/*
	@Override
	public List<EmpVO> getDeptno(Map<String, Object> map){
		EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
		List<EmpVO> list = empMapper.getList();
	}
 	*/
	@Override
	public List<EmpVO> getJob(String job){
		EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
		List<EmpVO> list = empMapper.getList();
		
		return list;
	}
	
	
	/*
	  @Override 
	  public Map<String, Object> getDeptno(String[] deptno){ 
		  EmpMapper empMapper =  sqlSession.getMapper(EmpMapper.class); 
		  Map<String, Object> map =  empMapper.getDeptno(deptno);
	  
	  return map; 
	 }
	*/
	
	
	/*
	@Override
	public void getDeptno(HashMap<String, Integer> deptno){
		EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
		
		empMapper.getDeptno(null);
		
		return;
	}
	*/
	/*
	@Override
	public void getDeptno(HashMap<String, Object> map){
		EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
		
		empMapper.getDeptno(vo);
		
		return map;
	}
	*/
}
