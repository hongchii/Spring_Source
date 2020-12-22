package com.spring.mb2replay.comment;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mapper.CommentMapper;

@Service("mCommentService")
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int commentCount() throws Exception {
		CommentMapper mCommentMapper = sqlSession.getMapper(CommentMapper.class);
		
		return mCommentMapper.commentCount();
	}

	@Override
	public List<CommentVO> commentList(int bno) throws Exception {
		CommentMapper mCommentMapper = sqlSession.getMapper(CommentMapper.class);
		
		return mCommentMapper.commentList(bno);
	}

	@Override
	public int commentInsert(CommentVO comment) throws Exception {
		CommentMapper mCommentMapper = sqlSession.getMapper(CommentMapper.class);
		
		return mCommentMapper.commentInsert(comment);
	}

	@Override
	public int commentUpdate(CommentVO comment) throws Exception {
		CommentMapper mCommentMapper = sqlSession.getMapper(CommentMapper.class);
		
		return mCommentMapper.commentUpdate(comment);
	}

	@Override
	public int commentDelete(int cno) throws Exception {
		CommentMapper mCommentMapper = sqlSession.getMapper(CommentMapper.class);
		
		return mCommentMapper.commentDelete(cno);
	}

}
