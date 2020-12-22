package com.spring.springwebsocket2;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

public class HandshakeInterceptor extends HttpSessionHandshakeInterceptor {
	// 클라이언트에서 요청을 보내면 http 프로토콜에서 웹소켓 프로토콜로 변환이 필요하다. 그걸변환해주는거. 
	// 그 전에 수행되는게 비포
	// 그 후에 애프터.
	
	//@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
			WebSocketHandler wshandler, Map<String, Object> map) throws Exception{
		//위의 파라미터 중, attributes에 값을 저장하면 웹소켓 핸들러 클래스의 WebSocketSession에 전달된다.
		
		System.out.println("Before Handshake");
		
		ServletServerHttpRequest ssreq = (ServletServerHttpRequest) request; // request. 서블릿request객체.  
		System.out.println("URI : " + request.getURI());
		
		HttpServletRequest req = ssreq.getServletRequest();
		
		/*
		  String name = (String)req.getSession().getAttribute("name");
		  map.put("userName", name);
		  System.out.println("HttpSession에 저장된 name : " + name);
		 */
		
		String id = (String)req.getSession().getAttribute("id");
		map.put("userId", id); // 정보는 map으로 전달. 핸들러에 정보를 전달해주는 거 map 
		System.out.println("HttpSession에 저장된 id : " + id);
		
		return super.beforeHandshake(request, response, wshandler, map);
	}
	
	//@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, 
			WebSocketHandler wshandler, Exception ex) {
		System.out.println("After Handshake");
		
		super.afterHandshake(request, response, wshandler, ex);
	}
}
