<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.spring.springsungjuk.SungjukVO" %> 

<% 
	
	SungjukVO vo =(SungjukVO)request.getAttribute("sungjukVO");
	
%>
<html>
<head>
<title>성적 정보 수정</title>
</head>
<body>
<form name="sungjukupdate" action="./updateprocess.me" method="post">
<center>
	<table border=1 width=300>
		<tr>
			 <td>학번 : </td>
     		 <td><%=vo.getHakbun() %>
     		 <input type="hidden" name="hakbun" value="<%=vo.getHakbun() %>"></td>
   		</tr>
		
		<tr>
			<td>이름 : </td>
			<td><input type="text" name="name" value="<%=vo.getName() %>"></td>
		</tr>
		
		<tr>
			<td>국어 : </td>
			<td><input type="text" name="kor" value="<%=vo.getKor() %>"></td>
		</tr>
			
		<tr>
			<td>영어 : </td>
			<td><input type="text" name="eng" value="<%=vo.getEng() %>"></td>
		</tr>
		
		<tr>
			<td>수학 : </td>
			<td><input type="text" name="math" value="<%=vo.getMath() %>"></td>
		</tr>
		
		<tr>
			<td colspan=2>
			<a href="javascript:sungjukupdate.submit()">수정</a>&nbsp;&nbsp;
			<a href="./sungjuklist.me">리스트로 돌아가기</a></td>
		</tr>	
		
	</table>
</center>
</body>
</html>