package com.spring.mapper;

import java.util.List;

import com.spring.springajax.PeopleVO;

public interface PeopleMapper {
	  List<PeopleVO> getPeopleList();
	  void insertPeople(PeopleVO vo);
	  PeopleVO getPeople(String id);
	  void deletePeople(String id);
	  void updatePeople(PeopleVO vo);
	  
}
