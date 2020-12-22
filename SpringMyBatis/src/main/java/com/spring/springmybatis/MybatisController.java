package com.spring.springmybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MybatisController {
	
	@Autowired
	private MemberServiceImpl memberService; //의존성주입으로 들어온 데이터 
	
	@RequestMapping("/list.do")
	public ModelAndView main() {
		
		//view 화면인 main.jsp에 DB로부터 읽어온 데이터를 보여준다.
		ModelAndView result = new ModelAndView();
		// addObject view에 넘어가는 데이터
		List<MemberVO> memberList = memberService.getMembers();
		result.addObject("memberList", memberList);
		result.setViewName("list");
		return result;
	}
	
	//insert 버튼 클릭시 값을 가져와서 list.jsp로 화면전환 해준다.
	@RequestMapping("/insert.do")
	public String /*ModelAndView*/ insert(MemberVO member) {
		memberService.insertMember(member);
		
		/*
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", member.getId()); //HashMap
		map.put("name", member.getName()); //HashMap
		map.put("email", member.getEmail()); //HashMap
		map.put("phone", member.getPhone()); //HashMap
		memberService.insertMember2(map); //HashMap
		*/
		
		/*ModelAndView result = new ModelAndView();
		List<MemberVO> memberList = memberService.getMembers();
		result.addObject("memberList", memberList);
		result.setViewName("list");
		
		return result;*/
		
		return "redirect:/list.do";	
		
	}
	
	@RequestMapping("/updateForm.do")
	public ModelAndView updateForm(MemberVO member) {
		String id = member.getId();
		member = memberService.getMember(id);
		System.out.println("updateForm complete");
		
		ModelAndView result = new ModelAndView();
		result.addObject("member", member);
		result.setViewName("updateForm");
		
		return result;
	}
	
	/*
	@RequestMapping("/update.do")
	public ModelAndView update(MemberVO member) {
		memberService.updateMember(member);
		System.out.println("update complete");
		
		ModelAndView result = new ModelAndView();
		List<MemberVO> memberList = memberService.getMembers();
		result.addObject("memberList", memberList);
		result.setViewName("list");
		return result;
	}
	*/
	
	@RequestMapping("/update.do")
	public String update(MemberVO member) {
		memberService.updateMember(member);
		System.out.println("update complete");
		
		return "redirect:/list.do";
	}
	
	@RequestMapping("/delete.do")
	public ModelAndView delete(MemberVO member) {
		String id = member.getId();
		memberService.deleteMember(id);
		System.out.println("delete complete");
		
		ModelAndView result = new ModelAndView();
		List<MemberVO> memberList = memberService.getMembers();
		result.addObject("memberList", memberList);
		result.setViewName("list");
		
		return result;	
	}
	
	/*
	@RequestMapping("/delete.do")
	public String delete(MemberVO member) {
		memberService.deleteMember(member);
		System.out.println("delete complete");
		
		return "redirect:/list.do";	
	}
	*/
}

