package com.spring.memberboard2.member;

import java.util.ArrayList;
import java.util.List;


public interface MemberService {
	public int insertMember(MemberVO memberVO);
	public int userCheck(MemberVO memberVO);
	public ArrayList<MemberVO> getMemberlist();
	public MemberVO selectMember(MemberVO memberVO);
	public int deleteMember(MemberVO memberVO);
	public MemberVO update(MemberVO memberVO);
	public int updateMember(MemberVO memberVO);
	//public List<MemberVO> getBoardList(int page, int limit);
}
