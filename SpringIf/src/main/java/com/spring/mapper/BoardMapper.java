package com.spring.mapper;

import com.spring.springif.BoardVO;

public interface BoardMapper {
	public int boardInsert(BoardVO vo);
	public void boardList(BoardVO vo);
}
