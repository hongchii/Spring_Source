<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

	ArrayList<String> list_text = (ArrayList<String>)request.getAttribute("list_text");
	ArrayList<String> list_link = (ArrayList<String>)request.getAttribute("list_link");
	ArrayList<String> list_point = (ArrayList<String>)request.getAttribute("list_point");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="0" align="center">
<tr><td><a href="crawl.do"><img src="https://ssl.pstatic.net/imgmovie/2007/img/super_db/tab_movie_1_off.gif" alt="조회순" width="112" height="28"></a></td>&nbsp;
<td><a href="crawl2.do"><img src="https://ssl.pstatic.net/imgmovie/2007/img/super_db/tab_movie_2_on.gif" alt="평점순(현재상영영화)" width="126" height="28"></a></td>
<td><a href="crawl3.do"><img src="https://ssl.pstatic.net/imgmovie/2007/img/super_db/tab_movie_3_off.gif" alt="평점순(모든영화)" width="126" height="28"></a></td></tr>
<tr>
		<th>순위</th>
		<th>영화명</th>
		<th>평점</th>
</tr>

</table>
<table border="0" align="center">


<%
for(int i=0;i<list_text.size();i++)
{
%>
	<tr>
		<td><%=i+1 %></td>
		<td><a href=<%=list_link.get(i).toString() %>><%=list_text.get(i).toString() %></a></td>
		<td><%=list_point.get(i).toString() %></td>
	</tr>
<%
}
%>				
</table>
</body>
</html>