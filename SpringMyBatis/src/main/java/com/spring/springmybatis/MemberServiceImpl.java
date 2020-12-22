package com.spring.springmybatis;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired //Mybatis(ibatis) 라이브러리가 제공하는 클래스
	private SqlSession sqlSession;
	
	@Override
	public ArrayList<MemberVO> getMembers() {
		ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();
		MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
		//getMembers()의 메소드명과 mapper.xml의 id는 동일해야한다.
		memberList = memberMapper.getMembers(); // 어레이리스트를 반환받아야기때문에 어레이리스트 타입이어야함. 
		System.out.println(memberMapper.getCount());
		//memberList = memberMapper.getMembers("tab_mybatis");
		
		return memberList;
	}

	@Override
	public MemberVO getMember(String id) {
		MemberVO member = new MemberVO();
		
		//member = memberMapper.getMember(id);
		
		HashMap<String, String> vo = new HashMap<String, String>();
		MemberMapper memberMapper =					
				sqlSession.getMapper(MemberMapper.class);
		vo = memberMapper.getMember(id); 			 // HashMap 이용시
		System.out.println("vo.id=" + vo.get("id")); // HashMap 이용시
		member.setId(vo.get("id")); 				 // HashMap 이용시
		member.setName(vo.get("name")); 			 // HashMap 이용시
		member.setEmail(vo.get("email")); 			 // HashMap 이용시
		member.setPhone(vo.get("phone")); 			 // HashMap 이용시
		
		return member;
	}

	@Override
	public void insertMember(MemberVO member) {
		MemberMapper memberMapper =
				sqlSession.getMapper(MemberMapper.class);
		int res = memberMapper.insertMember(member);
		System.out.println("res=" + res);
	}

	@Override
	public void insertMember2(HashMap<String, String> map) {
		System.out.println("hashmap");
		MemberMapper memberMapper = 
				sqlSession.getMapper(MemberMapper.class);
		memberMapper.insertMember2(map);
	}

	@Override
	public void updateMember(MemberVO member) {
		MemberMapper memberMapper =
				sqlSession.getMapper(MemberMapper.class);
		memberMapper.updateMember(member);
	}

	@Override
	public void deleteMember(String id) {
		MemberMapper memberMapper =
				sqlSession.getMapper(MemberMapper.class);
		memberMapper.deleteMember(id);
	}

}
