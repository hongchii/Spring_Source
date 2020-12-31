package com.spring.springif;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@Autowired
	private BoardService boardService;
	
	
	@RequestMapping("/")
	public String index1() {
		
		return "index2";
	}
	
	@RequestMapping("/index")
	public String index2() {
		
		return "index2";
	}
	
	@RequestMapping("/login")
	public String login() {
		
		return "login";
	}
	
	@RequestMapping("/shop")
	public String shop() {
		
		return "shop";
	}
	
	@RequestMapping("/collection")
	public String collection() {
		
		return "collection";
	}
	
	@RequestMapping("/blog")
	public String blog() {
		
		return "blog";
	}
	
	@RequestMapping("/contact")
	public String contact() {
		
		return "contact";
	}
	
	@RequestMapping("/shopping-cart")
	public String shoppingcart() {
		
		return "shopping-cart";
	}
	
	@RequestMapping("/main")
	public String main() {
		
		return "main";
	}
	
	@RequestMapping("/blog-details")
	public String blogdetails() {
		
		return "blog-details";
	}
	
	@RequestMapping("/chek-out")
	public String chekout() {
		
		return "chek-out";
	}
	
	@RequestMapping("/faq")
	public String faq() {
		
		return "faq";
	}
	
	@RequestMapping("/register")
	public String register() {
		
		return "register";
	}
	
	@RequestMapping("/insert")
	public String insert() {
		
		return "insert";
	}
	
	@RequestMapping("/map.html")
	public String map() {
		
		return "map";
	}
	@RequestMapping("/boardinsert")
	public String boardInsert(BoardVO vo) {
		System.out.println("in");
		System.out.println(vo.toString());
		boardService.boardInsert(vo);
		
		return "list";
	}
	
	/*
	@RequestMapping("/boardinsert")
	public Map<String, Object> insertPeople(BoardVO vo){
		Map<String, Object> retVal = new HashMap<String, Object>(); //리턴값
		try {
			boardService.boardInsert(vo);
			
		}
		catch(Exception e) {
			retVal.put("res", "FAIL");
			retVal.put("message", "Failure");
		}
		
		return retVal;
		
	}
	*/
	@RequestMapping("/boardlist")
	public String boardList(BoardVO vo) {
		boardService.boardList(vo);
	
		return "index2";
	}
}