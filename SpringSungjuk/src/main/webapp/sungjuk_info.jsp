<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %> 
<%@ page import="com.spring.springsungjuk.SungjukVO" %>   
 
<!DOCTYPE html>
<html>
<head>
<title>성적 보기</title>
</head>
<body>
<center>
	
	<table border=1 width=300>
		<tr>
			<td colspan="2" align=center>
			<b><font size=5>성적조회 페이지</font></b> </td>
		</tr>
		<tr align=center><td>학번 : </td><td>${sungjukVO.getHakbun() }</td></tr>
		<tr align=center><td>이름 : </td><td>${sungjukVO.getName() }</td></tr>
		<tr align=center><td>국어 : </td><td>${sungjukVO.getKor() }</td></tr>
		<tr align=center><td>영어 : </td><td>${sungjukVO.getEng() }</td></tr>
		<tr align=center><td>수학 : </td><td>${sungjukVO.getMath() }</td></tr>
		<tr align=center><td>합계 : </td><td>${sungjukVO.getTot() }</td></tr>
		<tr align=center><td>평균 : </td><td>${sungjukVO.getAvg() }</td></tr>
		<tr align=center><td>등급 : </td><td>${sungjukVO.getGrade() }</td></tr>	
		<tr align=center>
			<td colspan=2><a href="sungjuklist.me">리스트로 돌아가기</a></td>
		</tr>	
	</table>
</center>
</body>
</html>