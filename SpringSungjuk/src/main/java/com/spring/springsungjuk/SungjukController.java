package com.spring.springsungjuk;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SungjukController {
		
		@Autowired
		private SungjukService sungjukService;
		
		
		@RequestMapping("/sungjukinput.me")
		public String sungjukinput() throws Exception{
			return "sungjuk_input";
			
		}
		
		@RequestMapping("/sungjukprocess.me")
		public String insertSungjuk(SungjukVO sungjukVO, HttpServletResponse response) throws Exception{
			int res = sungjukService.insertSungjuk(sungjukVO);
			
			response.setCharacterEncoding("utf-8"); 
			response.setContentType("text/html; charset=utf-8");  
			PrintWriter writer = response.getWriter();
			
			return "redirect:/sungjuklist.me";
		}
		
			
		@RequestMapping("/sungjuklist.me")
		public String getSugnjuklist(Model model) throws Exception {
			
			ArrayList<SungjukVO> sungjuk_list = sungjukService.getSungjuklist();
			model.addAttribute("sungjuk_list", sungjuk_list);
			
			return "sungjuk_list";
		}
		
		@RequestMapping("/sungjukinfo.me")
		public String selectSungjuk(SungjukVO sungjukVO, Model model) throws Exception{
			
			SungjukVO vo = sungjukService.selectSungjuk(sungjukVO);
			model.addAttribute("sungjukVO", vo);
			
			return "sungjuk_info";
		}
		
		@RequestMapping("/sungjukdelete.me")
		public String deleteSungjuk(SungjukVO sungjukVO, Model model) throws Exception{
			sungjukService.deleteSungjuk(sungjukVO);
			
			return "redirect:/sungjuklist.me";
		}
		
		@RequestMapping("/sungjukupdate.me")
		public String update(SungjukVO sungjukVO, Model model) throws Exception{
			
			SungjukVO vo = sungjukService.selectSungjuk(sungjukVO);
			model.addAttribute("sungjukVO", vo);
			
			return "sungjuk_update";
		}
		
		@RequestMapping("/updateprocess.me")
		public String updateSungjuk(SungjukVO sungjukVO, HttpServletResponse response) throws Exception{
			int res = sungjukService.updateSungjuk(sungjukVO);
			
			response.setCharacterEncoding("utf-8"); 
			response.setContentType("text/html; charset=utf-8");  
			PrintWriter writer = response.getWriter();
			
			return "redirect:/sungjuklist.me";
		}
	

}
