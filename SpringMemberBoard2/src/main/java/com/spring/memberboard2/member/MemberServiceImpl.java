package com.spring.memberboard2.member;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Autowired(required=false) // 의존성 주입을 주더라도 에러가 발생되지 않게 해줌. - false 
	private MemberDAO memberDAO=null; // memberDAO는 외존성 주입, bean으로 만들어줘야함. 
	
	@Override
	public int insertMember(MemberVO memberVO) {
		int res  = memberDAO.insertMember(memberVO); 
		
		return res;
	}

	@Override
	public int userCheck(MemberVO memberVO) {
		int res  = memberDAO.userCheck(memberVO); 
		
		return res;
	}

	@Override
	public ArrayList<MemberVO> getMemberlist() {
		ArrayList<MemberVO> member_list = new ArrayList<MemberVO>();
		member_list = memberDAO.getMemberlist();
	
		return member_list;
	}

	@Override
	public MemberVO selectMember(MemberVO memberVO) {
		MemberVO vo  = memberDAO.selectMember(memberVO);
			
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
	
//	@Override
//	public List<MemberVO> getBoardList(int page, int limit) {
//		List<BoardVO> boardlist = memberDAO.get     .getBoardList(page, limit);
//		return boardlist;
//	}

}
