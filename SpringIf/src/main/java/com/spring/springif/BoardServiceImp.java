package com.spring.springif;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mapper.BoardMapper;

@Service("boardService")
public class BoardServiceImp implements BoardService {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public int boardInsert(BoardVO vo) {
		BoardMapper boardMapper = 
				sqlSession.getMapper(BoardMapper.class);
		int res = boardMapper.boardInsert(vo);
		System.out.println("res = " + res);
		return res;
	}
	
	@Override
	public void boardList(BoardVO vo) {
		BoardMapper boardMapper =
				sqlSession.getMapper(BoardMapper.class);
	}
}
