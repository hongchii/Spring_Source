package com.spring.members;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping(value = "/form_input.me", method = RequestMethod.GET)
	public String form_input() {
		
		return "form_input";
	}
	
	@RequestMapping(value = "/input_form.me", method = RequestMethod.GET)
	public String input_form(MemberVO memberVO, Model model) {	
		
		model.addAttribute("memberVO", memberVO);
		return "input_form"; // 결과를 출력할 view문서. input_form 
	}
	
	@RequestMapping(value = "/career.me", method = RequestMethod.GET)
	public String career() {
		
		return "career";
	}
	
	@RequestMapping(value = "/register.me", method = RequestMethod.GET)
	public String register() {
		
		return "register";
	}
	
}
