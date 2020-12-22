package com.spring.springmovie;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
	
	@RequestMapping(value="/home.do" , method = RequestMethod.GET)
	public String home() {
		return "home";
	}

	@RequestMapping(value="/crawl.do", method = RequestMethod.GET)
	public ModelAndView crawl(ModelAndView model) {
		String url = "https://movie.naver.com/movie/sdb/rank/rmovie.nhn?sel=cnt";
		Document doc = null;
		
		try {
			doc = Jsoup.connect(url).get();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		//영화 랭킹을 가져온다.
		Elements element = doc.select("table.list_ranking");
		System.out.println("################# div.tit5###############");
		System.out.println(element);
		
		 ArrayList<String> list_text = new ArrayList<String>();
		 ArrayList<String> list_link = new ArrayList<String>();		
	     
		
	      
		//2. 하위 목록들을 for문 돌면서 출력
	     for(Element el : element.select("div.tit3")) {
	    	 String text = el.text().toString();
	    	 String link = "https://movie.naver.com"+ el.select("a").attr("href");
	    	 System.out.println(text);
	    	 System.out.println(link);   	
	    	 
	    	 System.out.println("--------------------------------------------");
	         list_text.add(text);
	         list_link.add(link);
	         
	     }
	   
	     model.addObject("list_text", list_text);
	     model.addObject("list_link", list_link);
	     model.setViewName("crawl");
	      
	      return model;
	
	}
	
	@RequestMapping(value="crawl2.do", method=RequestMethod.GET)
	public ModelAndView crawl2(ModelAndView model) {
		String url= "https://movie.naver.com/movie/sdb/rank/rmovie.nhn?sel=cur";
		Document doc = null;
		
		try {
			doc = Jsoup.connect(url).get();	
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		//영화랭킹을 가져옵니다.
		Elements element = doc.select("table.list_ranking");
		System.out.println(element);
	
		ArrayList<String> list_text = new ArrayList<String>();
		ArrayList<String> list_link = new ArrayList<String>();
		ArrayList<String> list_point = new ArrayList<String>();
		
		
		//2.for문으로 값을 가져온다.
		for(Element el: element.select("div.tit5")) {
			String text = el.text().toString();
			String link = "https://movie.naver.com" +el.select("a").attr("href");
		
			System.out.println(text);
			System.out.println(link);
			System.out.println("----------------------------------------");
			list_text.add(text);
			list_link.add(link);
			
			
		}
		
		for(Element el: element.select("td.point")) {
			String point = el.text().toString();
			
			list_point.add(point);
		}
			
		model.addObject("list_text", list_text);
	    model.addObject("list_link", list_link);
	    model.addObject("list_point", list_point);
	    model.setViewName("crawl2");
	      
	      return model;
	}
	
	@RequestMapping(value="crawl3", method=RequestMethod.GET)
	public ModelAndView crawl3(ModelAndView model) {
		String url="https://movie.naver.com/movie/sdb/rank/rmovie.nhn?sel=pnt";
		Document doc = null;
		
		try {
			doc = Jsoup.connect(url).get();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		//영화랭킹을 가져옵니다.(내용을 뽑을 데이터를 점점좁혀간다. 
		Elements element = doc.select("table.list_ranking");
		System.out.println(element);
		
		ArrayList<String> list_text = new ArrayList<String>();
		ArrayList<String> list_link = new ArrayList<String>();
		ArrayList<String> list_point = new ArrayList<String>();
		
		//for문돌리기
		//영화명
		for(Element el:element.select("div.tit5")) {
			String text = el.text().toString();
			String link = "https://movie.naver.com" + el.select("a").attr("href");
			list_text.add(text);
			list_link.add(link);

		}
		
		for(Element el:element.select("td.point")) {
			String point = el.text().toString();
			list_point.add(point);
		}
		
		model.addObject("list_text", list_text);
	    model.addObject("list_link", list_link);
	    model.addObject("list_point", list_point);
	    model.setViewName("crawl3");
	      
	      return model;
		
		
	}
	
	
}
