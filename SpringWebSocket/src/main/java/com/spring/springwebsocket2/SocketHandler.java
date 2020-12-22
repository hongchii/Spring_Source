package com.spring.springwebsocket2;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class SocketHandler extends TextWebSocketHandler {
	
	private Set<WebSocketSession> sessionSet = new HashSet<WebSocketSession>();
	
	public SocketHandler() {
		super();
	}
	
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception{
		super.afterConnectionClosed(session, status);
		
		sessionSet.remove(session);
		
	}
	
	public void afterconnectionEstableished(WebSocketSession session) throws Exception{
		super.afterConnectionEstablished(session);
		
		sessionSet.add(session);
	}
	
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception{
		super.handleMessage(session, message);
		
		Map<String, Object> map = session.getAttributes(); // map으로 전달된 정보.
		
		String userId = (String)map.get("userId");
		
		for(WebSocketSession client_session : this.sessionSet) {
			if(client_session.isOpen()) {
				try {
					client_session.sendMessage(message);
				}
				catch(Exception ignored) {
					System.out.println("fail to send message!" + ignored);
				}
			}
		}
	}

	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception{
		System.out.println("web socket error!" + exception);
	}
	
	public boolean supportsPartialMessage() {
		System.out.println("call method!");
		
		return false;
	}
}
