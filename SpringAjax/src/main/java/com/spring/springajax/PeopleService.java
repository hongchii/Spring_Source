package com.spring.springajax;

import java.util.List;

public interface PeopleService {
	List<PeopleVO> getPeoplejson();
	void insertPeople(PeopleVO vo);
	PeopleVO getPeople(String id);
	void deletePeople(String id);
	void updatePeople(PeopleVO vo);
}
