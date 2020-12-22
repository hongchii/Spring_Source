package com.spring.mb2replay.comment;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //restcontroller를 사용하게 되면 반환값은 데이터임. 
public class CommentController {

	@Autowired
	CommentService mCommentService;
	
	@RequestMapping(value="/comment_list.bo",
			produces="application/json;charset=UTF-8")
	private List<CommentVO> mCommentServiceList(@RequestParam int bno) throws Exception{
		List<CommentVO> comment_list = mCommentService.commentList(bno);
		
		return comment_list;
	}
	
	@RequestMapping(value="/comment_insert.bo",
			produces="application/json;charset=UTF-8")
	private int mCommentServiceInsert(CommentVO comment, HttpSession session) throws Exception{
		comment.setWriter((String)session.getAttribute("id"));
		
		return mCommentService.commentInsert(comment);
	}
	
	/*
	@RequestMapping(value="/comment_update.bo",
			produces="application/json;charset=UTF-8")
	private int mCommentServiceUpdateProc(@RequestParam int cno, @RequestParam String content) throws Exception{
		CommentVO comment = new CommentVO(); 
		comment.setCno(cno);
		comment.setContent(content);
		
		return mCommentService.commentUpdate(comment);
	}
	*/
	
	@RequestMapping(value="/comment_update.bo",
			produces="application/json;charset=UTF-8")
	private int mCommentServiceUpdateProc(CommentVO comment) throws Exception{
		
		return mCommentService.commentUpdate(comment);
	}
	
	@RequestMapping(value="/comment_delete.bo",
			produces="application/json;charset=UTF-8")
	private int mCommentServiceDelete(@RequestParam(value="cno") int cno) throws Exception{
		return mCommentService.commentDelete(cno);
	}
}
