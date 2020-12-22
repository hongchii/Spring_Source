package com.spring.springmember;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService") // 내가 만들어주고 싶은 객체 이름이 있을 경우 괄호안에 적기. 생성될 객체이름을 의미함.
public class MemberServiceImpl implements MemberService {
	
	@Autowired(required=false)
	// required = false 로 주면 
	private MemberDAO memberDAO = null;
	// MemberDAO 클래스를 만들어서 필드에 대입을 시켜주면 따로 new로 객체 생성을 할 필요가 없음. 
	// 해당 클래스의 객체가 MemberDAO 대입됨.
	
	@Override
	public int insertMember(MemberVO memberVO) {
		int res = memberDAO.insertMember(memberVO);
		
		return res;
	}

	@Override
	public int userCheck(MemberVO memberVO) {
		int res = memberDAO.userCheck(memberVO);
		
		return res;
	}
	
	@Override
	public ArrayList<MemberVO> getMemberlist(){
		ArrayList<MemberVO> member_list = new ArrayList<MemberVO>();
		member_list = memberDAO.getMemberlist();
		
		return member_list;
	}
	
	@Override
	public MemberVO selectMember(MemberVO memberVO) {
		MemberVO vo = memberDAO.selectMember(memberVO);
		
		return vo;
	}

	@Override
	public int deleteMember(MemberVO memberVO) {
		int res = memberDAO.deleteMember(memberVO);
		
		return res;
	}
	
	@Override
	public MemberVO update(MemberVO memberVO) {
		MemberVO vo = memberDAO.selectMember(memberVO);
		
		return vo;
	}      
	
	@Override
	public int updateMember(MemberVO memberVO) {
		int res = memberDAO.updateMember(memberVO);
		
		return res;
		
	}

}
