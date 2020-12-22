package com.spring.mb2replay.comment;

import java.util.List;

public interface CommentService {
	public int commentCount() throws Exception; //댓글갯수
	public List<CommentVO> commentList(int bno) throws Exception; //댓글리스트
	public int commentInsert(CommentVO comment) throws Exception; //댓글추가
	public int commentUpdate(CommentVO comment) throws Exception; //댓글수정
	public int commentDelete(int cno) throws Exception; //댓글삭제
}
