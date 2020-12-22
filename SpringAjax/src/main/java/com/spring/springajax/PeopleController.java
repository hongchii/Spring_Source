package com.spring.springajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PeopleController {
	
	@Autowired
	private PeopleService peopleService;
											
	@RequestMapping(value="/home.do", method=RequestMethod.GET)
	public String home() {
		
		return "home";
	}
	
	//Produces 속성을 이용해 Response의 Content-Type
	@RequestMapping(value="/getPeopleJSON.do", 
			method=RequestMethod.POST, 
			produces="application/json;charset=UTF-8")
	
	@ResponseBody // jsp와 같은 뷰를 전달 하는게 아닌 데이터를 전달 하기 위해 사용
	public List<PeopleVO> getPeopleJSONGET(){
		List<PeopleVO> list = peopleService.getPeoplejson();
		
		return list;
	}
	
	@RequestMapping(value="/insertPeople.do",
			method=RequestMethod.POST,	
			produces="application/json;charset=UTF-8")

	@ResponseBody // 뷰가아닌 데이터를 반환시켜줌. 
	public Map<String, Object> insertPeople(PeopleVO vo){
		Map<String, Object> retVal = new HashMap<String, Object>(); //리턴값
		try {
			peopleService.insertPeople(vo);
			
		}
		catch(Exception e) {
			retVal.put("res", "FAIL");
			retVal.put("message", "Failure");
		}
		
		return retVal;
		
	}
	
	@RequestMapping(value="/deletePeople.do",
			produces="application/json;charset=UTF-8")
	
	@ResponseBody
	public Map<String, Object> deletePeople(
			@RequestParam(value="id") String id) {
		Map<String, Object> retVal = new HashMap<String, Object>(); // 리턴값 저장
		try {
			peopleService.deletePeople(id);
			
			retVal.put("res", "OK");
		}
		catch(Exception e) {
			retVal.put("res", "FAIL");
			retVal.put("message", "Failure");
		}
		
		return retVal;
	}
	
	@RequestMapping(value="/updatePeople.do",
			method=RequestMethod.POST,	
			produces="application/json;charset=UTF-8")

	@ResponseBody // 뷰가아닌 데이터를 반환시켜줌. 
	public Map<String, Object> updatePeople(PeopleVO vo){
		Map<String, Object> retVal = new HashMap<String, Object>(); //리턴값
		try {
			peopleService.updatePeople(vo);
			
			retVal.put("res", "OK");
		}
		catch(Exception e) {
			retVal.put("res", "FAIL");
			retVal.put("message", "Failure");
		}
		
		return retVal;
		
	}
			
}
