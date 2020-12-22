package com.spring.mapper;

import java.util.ArrayList;

import com.spring.mymember.MemberVO;

public interface MemberMapper {
	int insertMember(MemberVO memberVO);
	//int userCheck(MemberVO memberVO);
	ArrayList<MemberVO> getMemberlist();
	MemberVO selectMember(MemberVO memberVO);
	void deleteMember(MemberVO memberVO);
	MemberVO update(MemberVO memberVO);
	int updateMember(MemberVO memberVO);
}
