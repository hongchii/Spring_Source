package som.spring.sungjuksystem;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SysController {

	@Autowired
	private SysService sysService;
	
	// 로그인 후 유저체크
	
	@RequestMapping("/login.go")
	public String userCheck(SysVO sysVO, HttpSession session,
			HttpServletResponse response) throws Exception {

		int res = sysService.userCheck(sysVO);
		
		response.setCharacterEncoding("utf-8"); // 인코딩방식
		response.setContentType("text/html; charset=utf-8"); // 텍스트형식
		PrintWriter writer = response.getWriter(); // 결과출력. 
		if (res == 1) { 
			session.setAttribute("id", sysVO.getId());
			writer.write("<script>alert('로그인성공!!');"
			+ "location.href='./main.go';</script>");
			
		}else {
			writer.write("<script>alert('로그인실패!!');"
					+"location.href='./loginform.go';</script>");
			//return "redirect:/loginform.me";
		}
		return null;
	}
	
	// 로그인 후 메인 페이지 
	@RequestMapping("/main.go")
	public String mainPage() throws Exception{
		return "main";
	}
	
	// 로그인 페이지
	@RequestMapping("/loginform.go")
	public String loginform() throws Exception{
		return "loginForm";
	}
	
	
	@RequestMapping("/sungjukinput.go")
	public String sungjukinput() throws Exception{
		return "sungjuk_input";
		
	}
	
	@RequestMapping("/joinform.go")
	public String joinForm() throws Exception{
		return "joinForm";
	}
	
	@RequestMapping("/joinprocess.go")
	public String insertSungjuk(SysVO sysVO, HttpServletResponse response) throws Exception{
		int res = sysService.insertSungjuk(sysVO);
		
		response.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html; charset=utf-8");  
		PrintWriter writer = response.getWriter();
		
		return "redirect:/main.go";
	}
	@RequestMapping("/sungjukprocess.go")
	public String insertMember(SysVO sysVO, HttpServletResponse response) throws Exception{
		int res = sysService.insertSungjuk(sysVO);
		
		response.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html; charset=utf-8");  
		PrintWriter writer = response.getWriter();
		
		return "redirect:/sungjuklist.go";
	}
	
		
	@RequestMapping("/sungjuklist.go")
	public String getSugnjuklist(Model model) throws Exception {
		
		ArrayList<SysVO> sys_list = sysService.getSyslist();
		model.addAttribute("sys_list", sys_list);
		
		return "sungjuk_list";
	}
	
	@RequestMapping("/sungjukinfo.go")
	public String selectSungjuk(SysVO sysVO, Model model) throws Exception{
		
		SysVO vo = sysService.selectMember(sysVO);
		model.addAttribute("sysVO", vo);
		
		return "sungjuk_info";
	}
	
	@RequestMapping("/sungjukdelete.go")
	public String deleteSungjuk(SysVO sysVO, Model model) throws Exception{
		sysService.deleteMember(sysVO);
		
		return "redirect:/sungjuklist.go";
	}
	
	@RequestMapping("/sungjukupdate.go")
	public String update(SysVO sungjukVO, Model model) throws Exception{
		
		SysVO vo = sysService.selectMember(sungjukVO);
		model.addAttribute("sungjukVO", vo);
		
		return "sungjuk_update";
	}
	
	@RequestMapping("/updateprocess.go")
	public String updateSungjuk(SysVO sungjukVO, HttpServletResponse response) throws Exception{
		int res = sysService.updateMember(sungjukVO);
		
		response.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html; charset=utf-8");  
		PrintWriter writer = response.getWriter();
		
		return "redirect:/sungjuklist.go";
	}


}
