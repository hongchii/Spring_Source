<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<%@ page import="java.util.*"%>
<%@ page import="som.spring.sungjuksystem.SysVO" %>
<% 
		
		ArrayList<SysVO> sys_list =
				(ArrayList<SysVO>)request.getAttribute("sys_list");
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
				<td><a href="sungjukinput.go">성적입력</a></td>
			</tr>
			
			<%
	for(int i=0; i < sys_list.size(); i++){
		SysVO vo = (SysVO)sys_list.get(i);
	
%>		
			
			<tr align=center>
				<td><a href="sungjukinfo.go?id=<%=vo.getId() %>">
						<%= vo.getId() %>
				</a>
				</td>
				<td><a href="sungjukupdate.go?id=<%=vo.getId() %>">수정</a></td>
				<td><a href="sungjukdelete.go?id=<%=vo.getId() %>">삭제</a>
				</td>				
			</tr>
			<%} %>
		</table>
	</center>
	</form>
</body>
</html>
