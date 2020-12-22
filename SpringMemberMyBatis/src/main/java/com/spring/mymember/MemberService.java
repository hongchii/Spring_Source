package com.spring.mymember;

import java.util.ArrayList;

public interface MemberService {
	public int insertMember(MemberVO memberVO);
	public void userCheck(MemberVO memberVO);
	public ArrayList<MemberVO> getMemberlist();
	public MemberVO selectMember(MemberVO memberVO);
	public void deleteMember(MemberVO memberVO);
	public MemberVO update(MemberVO memberVO);
	public int updateMember(MemberVO memberVO);
	
}
