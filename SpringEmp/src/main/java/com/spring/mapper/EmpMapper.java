package com.spring.mapper;

import java.util.List;
import java.util.Map;

import com.spring.springemp.EmpVO;

public interface EmpMapper {
	List<EmpVO> getList();
	List<EmpVO> getDeptno(String[] deptno);
	//Map<String, Object> getDeptno(String[] deptno);
}
