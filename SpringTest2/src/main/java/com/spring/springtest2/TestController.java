package com.spring.springtest2;



import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	@RequestMapping(value = "input_form.bo")
	public String input() {
		// 뷰문서로 이동하면 되는거기때문에 파라메타 값이 없음. String타입이라서 리턴값에 뷰이름을 적어줌.
		return "input_form";
	}
	/*
	@RequestMapping(value = "input.bo", method = RequestMethod.POST)
	public String res(HttpServletRequest request, Model model) {
		// request와 model에 저장한 id 와 pw 값이 저장되어 있음. 
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		return "res";
	}
	*/
	
	/*
	@RequestMapping(value = "input.bo", method = RequestMethod.POST)
	public String res(LoginVO vo, Model model) {
		// vo객체 사용. 
		String id = vo.getId();
		String pw = vo.getPw();
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		return "res";
	}
	*/
	
	@RequestMapping(value = "input.bo", method = RequestMethod.POST)
	public ModelAndView res(HttpServletRequest request, ModelAndView mav) {
		// ModelAndView로 파라메터를 바꿔줄땐 타입도 변경해줄것. addObject를 사용함. 
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		mav.addObject("id", id);
		mav.addObject("pw", pw);
		mav.setViewName("res"); // mav를 사용하면 setViewName을 통해서 뷰를 불러옴. 
		
		return mav;
	}
	
	
}
