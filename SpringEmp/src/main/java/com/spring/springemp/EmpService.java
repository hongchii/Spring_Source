package com.spring.springemp;

import java.util.List;
import java.util.Map;

public interface EmpService {
	List<EmpVO> getList();
	List<EmpVO> getDeptno(String[] deptno);
	List<EmpVO> getJob(String job);
	//Map<String, Object> getDeptno(String[] deptno);
	//public void getDeptno(HashMap<String, Integer> deptno);
	//public void getDeptno(HashMap<String, Object> map);
	//List<EmpVO> getDeptno(Map<String, Object> map);
	
}
