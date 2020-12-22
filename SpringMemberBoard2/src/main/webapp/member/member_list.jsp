<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%@ page import="java.util.*" %>
<%@ page import = "com.spring.memberboard2.member.MemberVO" %>

<%
	if ((session.getAttribute("id")==null) || 
	  (!((String)session.getAttribute("id")).equals("admin"))) {
		out.println("<script>");
		out.println("location.href='loginform.me'");
		out.println("</script>");
	}
	
	ArrayList<MemberVO> member_list = 
			(ArrayList<MemberVO>)request.getAttribute("member_list");
	
	//List<BoardVO> boardlist=(List<BoardVO>)request.getAttribute("boardlist");
	int listcount=((Integer)request.getAttribute("listcount")).intValue();
	int nowpage=((Integer)request.getAttribute("page")).intValue();
	int maxpage=((Integer)request.getAttribute("maxpage")).intValue();
	int startpage=((Integer)request.getAttribute("startpage")).intValue();
	int endpage=((Integer)request.getAttribute("endpage")).intValue();
%>
<html>
<head>
<title>회원관리 시스템 관리자모드(회원 목록 보기)</title>
</head>
<body>
<center>
<table border=1 width=300>
	<tr align=center><td colspan=3>회원 목록</td></tr>
<%
	for (int i=0; i<member_list.size(); i++)
	{
		MemberVO vo = (MemberVO)member_list.get(i);
%>
	
	<tr align=center height=20>
		<td colspan=7 style=font-family:Tahoma;font-size:10pt;>
			<%if(nowpage<=1){ %>
			[이전]&nbsp; <!-- nowpage가 1보다 작거나 같으면 숨김 처리.  -->
			<%}else{ %>
			<a href="./boardlist.bo?page=<%=nowpage-1 %>">[이전]</a>&nbsp;
			<%} %>
			
			<%for(int a=startpage;a<=endpage;a++){
				if(a==nowpage){%>
				[<%=a %>]
				<%}else{ %>
				<a href="./boardlist.bo?page=<%=a %>">[<%=a %>]</a>
				&nbsp;
				<%} %>
			<%} %>
			
			<%if(nowpage>=maxpage){ %>
			[다음] <!-- maxpage가 1보다 작거나 같으면 텍스트만 출력.  -->
			<%}else{ %>
			<a href="./boardlist.bo?page=<%=nowpage+1 %>">[다음]</a> <!-- 링크걸기.  -->
			<%} %>
		</td>
	</tr>
	
	
	<tr align=center>
		<td>
			<a href="memberinfo.me?id=<%=vo.getId() %>"><%=vo.getId() %></a>
		</td>
		<td><a href="memberupdate.me?id=<%=vo.getId() %>">수정</a></td>
		<td><a href="memberdelete.me?id=<%=vo.getId() %>">삭제</a></td>
		
	</tr>
<%
	} 
%>
</table>
</center>
</body>
</html>