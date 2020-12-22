<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%
	String title = (String)request.getAttribute("title");
	ArrayList<String> list_text = (ArrayList<String>)request.getAttribute("list_text");
	ArrayList<String> list_link = (ArrayList<String>)request.getAttribute("list_link");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>네이버 영화 크롤링</title>
</head>
<body>
<br/>
<table border="0" align="center" >
	<tr>
		<td><a href="crawl.do"><img src="https://ssl.pstatic.net/imgmovie/2007/img/super_db/tab_movie_1_on.gif" alt="조회순" width="112" height="28"></a></td>
		<td><a href="crawl2.do"><img src="https://ssl.pstatic.net/imgmovie/2007/img/super_db/tab_movie_2_on.gif" alt="평점순(현재상영영화)" width="126" height="28"></a></td>
		<td><a href="crawl3.do"><img src="https://ssl.pstatic.net/imgmovie/2007/img/super_db/tab_movie_3_off.gif" alt="평점순(모든영화)" width="126" height="28"></a></td>	
		
	</tr>
	<tr>
		<th >순위</th>
		<th >영화명</th>
	</tr>
</table>

<table border="0" align="center">
<%
for(int i=0; i<list_text.size(); i++){
%>

<tr>
	<td width="100" align="center"><%=i+1 %></td>
	<td ><a href=<%=list_link.get(i).toString() %>><%=list_text.get(i).toString() %></a></td>
</tr>
<%
}
%>
</table>
</body>
</html>