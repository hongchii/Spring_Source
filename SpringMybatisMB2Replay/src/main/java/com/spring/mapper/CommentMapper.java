package com.spring.mapper;

import java.util.List;

import com.spring.mb2replay.comment.CommentVO;

public interface CommentMapper {
	public int commentCount() throws Exception; //댓글갯수
	public List<CommentVO> commentList(int bno) throws Exception; //댓글리스트
	public int commentInsert(CommentVO comment) throws Exception; //댓글추가
	public int commentUpdate(CommentVO comment) throws Exception; //댓글수정
	public int commentDelete(int cno) throws Exception; //댓글삭제
	
}
