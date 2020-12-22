package com.spring.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	
	@RequestMapping(value = "input_form.bo")
	public String input() {
		// 뷰문서로 이동하면 되는거기때문에 파라메타 값이 없음. String타입이라서 리턴값에 뷰이름을 적어줌.
		return "input_form";
	}
	
	@RequestMapping(value = "input.bo", method = RequestMethod.POST)
	public ModelAndView res(HttpServletRequest request, ModelAndView mav) {
		// ModelAndView로 파라메터를 바꿔줄땐 타입도 변경해줄것. addObject를 사용함. 
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String jumin1 = request.getParameter("jumin1");
		String jumin2 = request.getParameter("jumin2");	
		String gender = request.getParameter("gender");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		String email = request.getParameter("email");
		String hobby = request.getParameter("hobby");
		String intro = request.getParameter("intro");
		
		mav.addObject("id", id);
		mav.addObject("pw", pw);
		mav.addObject("jumin1", jumin1);
		mav.addObject("jumin2", jumin2);
		mav.addObject("gender", gender);
		mav.addObject("tel1", tel1);
		mav.addObject("tel2", tel2);
		mav.addObject("tel3", tel3);
		mav.addObject("email", email);
		mav.addObject("hobby", hobby);
		mav.addObject("intro", intro);
		
		mav.setViewName("res"); // mav를 사용하면 setViewName을 통해서 뷰를 불러옴. 
		
		return mav;
	}
}
