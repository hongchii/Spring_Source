 package com.spring.mymember;

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
	// 의존성 주입. 
	
	@RequestMapping("/main.go")
	public String mainPage() throws Exception{
		return "main";
	}
	
	@RequestMapping("/login.go")
	public String userCheck(MemberVO memberVO, HttpSession session,
			HttpServletResponse response) throws Exception {
		// session, response 객체를 파라메타로 넘겨 받음. 직접 객체를 생성할 필요가 없음. 
		// membervo 에는 id 와 pw 가 저장되어있음. 
		MemberVO vo = memberService.selectMember(memberVO);
		
		response.setCharacterEncoding("utf-8"); // 인코딩방식
		response.setContentType("text/html; charset=utf-8"); // 텍스트형식
		PrintWriter writer = response.getWriter(); // 결과출력. 
		if(vo != null) {
			if(memberVO.getPassword().equals(vo.getPassword())) {
			session.setAttribute("id", memberVO.getId());
			writer.write("<script>alert('로그인성공!!');"
			+ "location.href='./main.go';</script>");
			//return "redirect:/main.me";
			// 경고창을 안띄우려면 25~27 / 31~32 주석처리 35 주석해제. 
		}else {
			writer.write("<script>alert('로그인실패!!');"
					+"location.href='./loginform.go';</script>");
			//return "redirect:/loginform.me";
		}
		}
		return null;
	}

	
	@RequestMapping("/loginform.go")
	public String loginform() throws Exception{
		return "loginForm";
	}
	
	@RequestMapping("/joinform.go")
	public String joinForm() throws Exception{
		return "joinForm";
	}
	
	@RequestMapping("/joinprocess.go")
	public String insertMember(MemberVO memberVO) {
		memberService.insertMember(memberVO);
		return "loginForm";
	}
	
	
	@RequestMapping("/memberlist.go")
	public String getMemberlist(Model model) throws Exception {
		// model을 쓴 이유는 조회한 결과를 출력하기 위해서. 
		ArrayList<MemberVO> member_list = memberService.getMemberlist();
		model.addAttribute("member_list", member_list);
		
		return "member_list";
	}
	
	@RequestMapping("/memberinfo.go")
	public String selectMember(MemberVO memberVO, Model model) throws Exception{
		// membervo에 아이디 저장. 
		MemberVO vo = memberService.selectMember(memberVO);
		model.addAttribute("memberVO", vo);
		
		return "member_info";
	}
	
	@RequestMapping("/memberdelete.go")
	public String deleteMember(MemberVO member) {
		memberService.deleteMember(member);
		System.out.println("delete complete");
		
		return "redirect:/memberlist.go";	
	}
	
	@RequestMapping("/memberupdate.go")
	public String update(MemberVO memberVO, Model model) throws Exception{
		MemberVO vo = memberService.selectMember(memberVO);
		model.addAttribute("memberVO", vo);
		
		return "member_update";
	}
	
	@RequestMapping("/updateprocess.go")
	public String updateMember(MemberVO memberVO, HttpServletResponse response) throws Exception{
		
		int res = memberService.updateMember(memberVO);
		System.out.println(memberVO.getName());
		response.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html; charset=utf-8");  
		PrintWriter writer = response.getWriter();
		if (res != 0) {
			writer.write("<script>alert('정보 수정 성공!!');"
					+ "location.href='./memberlist.go';</script>");
		}else {
			writer.write("<script>alert('정보 수정 실패!!');"
					+ "location.href='./memberlist.go';</script>");
		}
		return null;
	}
}
