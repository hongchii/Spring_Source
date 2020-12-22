package com.spring.memberboard2.member;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/login.me") 
	public String userCheck(MemberVO memberVO, HttpSession session, 
			HttpServletResponse response) throws Exception { 
		int res = memberService.userCheck(memberVO);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		if (res == 1)
		{
			session.setAttribute("id",memberVO.getId());
			writer.write("<script>alert('로그인 성공!!');location.href='./boardlist.bo';</script>");
			//return "redirect:/main.me";
		}
		else 
		{
			writer.write("<script>alert('로그인 실패!!');location.href='./loginform.me';</script>");
			//return "redirect:/loginform.me";
		}
		return null;
	}
	
	@RequestMapping("/main.me") 
	public String mainPage() throws Exception { 
		return "member/main";
	}
	
	@RequestMapping("/loginform.me") 
	public String loginForm() throws Exception { 
		return "member/loginForm"; // 항상 webapp이 기준이 되기때문에 하위폴더, 파일이름 적어줌. 
	}
	
	@RequestMapping("/joinform.me") 
	public String joinForm() throws Exception { 
		return "member/joinForm";
	}
	
	@RequestMapping("/joinprocess.me") 
	public String insertMember(MemberVO memberVO, HttpServletResponse response) 
		throws Exception { 
		int res = memberService.insertMember(memberVO);
		// res에는 1아니면 0이 저장되어있음. 
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		if (res != 0)
		{
			writer.write("<script>alert('회원 가입 성공!!');"
					+ "location.href='./loginform.me';</script>"); // 성공하면 loginform으로 이동. 
		}
		else
		{
			writer.write("<script>alert('회원 가입 실패!!');"
					+ "location.href='./joinform.me';</script>");
		}
		return null; // 경고창 안띄우고 싶을땐 redirect 
	}
	
	@RequestMapping("/memberlist.me") 
	public String getMemberlist(Model model) throws Exception { 
		ArrayList<MemberVO> member_list = memberService.getMemberlist();
		model.addAttribute("member_list", member_list);
		
		return "member/member_list";
	}
	
	@RequestMapping("/memberinfo.me") 
	public String selectMember(MemberVO memberVO, Model model) throws Exception { 
		MemberVO vo = memberService.selectMember(memberVO);
		model.addAttribute("memberVO", vo);
		
		return "member/member_info";
	}
	
	@RequestMapping("/memberdelete.me") 
	public String deleteMember(MemberVO memberVO, Model model) throws Exception { 
		memberService.deleteMember(memberVO);
		
		return "redirect:/memberlist.me";
	}
	
	@RequestMapping("/memberupdate.me")
	public String update(MemberVO memberVO, Model model) throws Exception{
		MemberVO vo = memberService.selectMember(memberVO);
		model.addAttribute("memberVO", vo);
		
		return "member/member_update";
	}
	
	@RequestMapping("/updateprocess.me")
	public String updateMember(MemberVO memberVO, HttpServletResponse response) throws Exception{
		int res = memberService.updateMember(memberVO);
		
		response.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html; charset=utf-8");  
		PrintWriter writer = response.getWriter();
		if (res != 0) {
			writer.write("<script>alert('정보 수정 성공!!');"
					+ "location.href='./memberlist.me';</script>");
		}else {
			writer.write("<script>alert('정보 수정 실패!!');"
					+ "location.href='./memberlist.me';</script>");
		}
		return null;
	}
}