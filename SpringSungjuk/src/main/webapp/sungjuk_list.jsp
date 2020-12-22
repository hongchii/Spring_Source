<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.spring.springsungjuk.SungjukVO" %>
<% 
		
		ArrayList<SungjukVO> sungjuk_list =
				(ArrayList<SungjukVO>)request.getAttribute("sungjuk_list");
%>
<html>
<head>
<title>성적관리 성적리스트</title>
</head>
<body>
	<center>
		<table border=1 width=300>
			<tr align=center>
				
				<td colspan=2>성적 리스트</td>
				<td><a href="sungjukinput.me">성적입력</a></td>
			</tr>
			
			<%
	for(int i=0; i<sungjuk_list.size(); i++){
		SungjukVO vo = (SungjukVO)sungjuk_list.get(i);
	
%>		
			
			<tr align=center>
				<td><a href="sungjukinfo.me?hakbun=<%=vo.getHakbun() %>">
						<%= vo.getHakbun() %>
				</a>
				</td>
				<td><a href="sungjukupdate.me?hakbun=<%=vo.getHakbun() %>">수정</a></td>
				<td><a href="sungjukdelete.me?hakbun=<%=vo.getHakbun() %>">삭제</a>
				</td>				
			</tr>
			<%} %>
		</table>
	</center>
	</form>
</body>
</html>
