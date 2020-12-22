package com.spring.mymember;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired(required=false)
	private SqlSession sqlSession;
	
	@Override
	public int insertMember(MemberVO memberVO) {
		MemberMapper memberMapper =
				sqlSession.getMapper(MemberMapper.class);
		int res = memberMapper.insertMember(memberVO); 

		return res;
	}
	
	@Override
	public void userCheck(MemberVO memberVO) {
		MemberMapper memberMapper =
				sqlSession.getMapper(MemberMapper.class);
		//int res = memberMapper.userCheck(memberVO);
		
		return;
	}
	
	@Override
	public ArrayList<MemberVO> getMemberlist() {
		ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		memberList = memberMapper.getMemberlist(); // 어레이리스트를 반환받아야기때문에 어레이리스트 타입이어야함. 
	
		
		return memberList;
	}
	
	
	@Override
	public MemberVO selectMember(MemberVO memberVO) {
		MemberMapper memberMapper =	
				sqlSession.getMapper(MemberMapper.class);
		MemberVO member = memberMapper.selectMember(memberVO); 			 
				 
		return member;
	}

	@Override
	public void deleteMember(MemberVO memberVO) {
		MemberMapper memberMapper =
				sqlSession.getMapper(MemberMapper.class);
		memberMapper.deleteMember(memberVO);
		
	}

	@Override
	public MemberVO update(MemberVO memberVO) {
		MemberMapper memberMapper = 
				sqlSession.getMapper(MemberMapper.class);
		MemberVO member = memberMapper.selectMember(memberVO); 	
		
		return member;
	}

	@Override
	public int updateMember(MemberVO memberVO) {
		MemberMapper memberMapper =
				sqlSession.getMapper(MemberMapper.class);
	//	memberMapper.updateMember(memberVO);
		int res = memberMapper.updateMember(memberVO);
		
		return res;
		
	}


}
