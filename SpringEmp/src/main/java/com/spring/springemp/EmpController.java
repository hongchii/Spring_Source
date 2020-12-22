
package com.spring.springemp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.binding.MapperMethod.ParamMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmpController {
	
	@Autowired
	private EmpService empservice;
/*	
	@RequestMapping(value ="/home.do")
	public ModelAndView getList(){
		ModelAndView result = new ModelAndView();
		List<EmpVO> list = empservice.getList();
		result.addObject("list", list);
		result.setViewName("home2");
		
		return result; 
	}
*/
/*	
	@RequestMapping(value ="/home.do",
			produces="application/json;charset=UTF-8")
	@ResponseBody
	public List<EmpVO> getList(){
		List<EmpVO> list = empservice.getList();
			
		return list; 	
		
	}
*/	

/*	
	@RequestMapping(value="/home.do")
	public String home() {
		return "home2";
	}
	@RequestMapping(value="/getEmpJSON.do", 
					produces="application/json;charset=UTF-8")
	@ResponseBody
	public List<EmpVO> getList(){
		List<EmpVO> list = empservice.getList();
		
		return list;
	}
*/
/*	
	@RequestMapping(value="/home.do")
	public String home() {
		return "home4";
	}
	
	
	@RequestMapping(value="/getEmpJSON.do", 
					produces="application/json;charset=UTF-8")
	@ResponseBody
	public List<EmpVO> getList(){
		List<EmpVO> list = empservice.getList();
		
		return list;
	}
	
	
	@RequestMapping(value="/getDept.do",
					
					produces="application/json;charset=UTF-8")
	@ResponseBody
	public List<EmpVO> deptList(
		@RequestParam(value="deptno") int deptno){
				System.out.println("AAAAAAAAA");

				
				List<EmpVO> list = empservice.getDeptno(deptno);
				System.out.println("list"+list);	
				
				
				
			return list;
	}
*/
	@RequestMapping(value="/home.do")
	public String home() {
		return "home6";
	}
	
	
	@RequestMapping(value="/getEmpJSON.do", 
					produces="application/json;charset=UTF-8")
	@ResponseBody
	public List<EmpVO> getList(){
		List<EmpVO> list = empservice.getList();
		
		return list;
	}
	
	/*
	@RequestMapping(value="/getDept.do",
					
					produces="application/json;charset=UTF-8")
	@ResponseBody
	public List<EmpVO> deptList(
		@RequestParam(value="deptno") int deptno){
				
				List<EmpVO> list = empservice.getDeptno(deptno);
				System.out.println("list"+list);	
				
				
				
			return list;
	}
	
	*/
	@RequestMapping(value="/getJob.do",
					produces="application/json;charset=UTF-8")
	@ResponseBody
	public List<EmpVO> getJob(
			@RequestParam(value="job") String job){
			
			List<EmpVO> list = empservice.getJob(job);
			
			return list;
	}
	
	/*
	@RequestMapping(value="/getDept.do",
			produces="application/json;charset=UTF-8")
	@ResponseBody
	public Map<String, Object> getDeptno(
			@RequestParam(value="deptno") String[] deptno){
		Map<String, Object> map = empservice.getDeptno();
		map.put("deptno", deptno);
	
	return map;
	}
	*/
	
	
	  @RequestMapping(value="/getDept.do", method=RequestMethod.POST,
			  	produces="application/json;charset=UTF-8")
	  @ResponseBody 
	  public List<EmpVO> getDeptno(
			  @RequestParam(value="deptno[]", required =false) String[] deptno){
		 
		 
		  for(String no : deptno) {
			  System.out.println("deptno=" + no);
		  }
		  Map<String, String[]> map = new HashMap<String, String[]>();
		  map.put("deptno", deptno);
		  
		  List<EmpVO> list = empservice.getDeptno(deptno);
		  System.out.println("list=" + list);
		  
//	  Map<String, Object> map = empservice.getDeptno(deptno);
//	  map.put("deptno",deptno);
	  
	  return list; 
	  }
	 
}
	

