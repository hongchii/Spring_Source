<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.spring.mb2replay.board.*" %>

<%
	String id=null;
	if(session.getAttribute("id") == null){
		out.println("<script>");
		out.println("location.href='loginform.me'");
		out.println("</script>");
	} // 로그인 상태인지 아닌지 확인 해주는 코드. 그래서 제일 앞에 위치해야함. 
	id = (String)session.getAttribute("id");
	
	List<BoardVO> boardlist=(List<BoardVO>)request.getAttribute("boardlist");
	int listcount=((Integer)request.getAttribute("listcount")).intValue();
	int nowpage=((Integer)request.getAttribute("page")).intValue();
	int maxpage=((Integer)request.getAttribute("maxpage")).intValue();
	int startpage=((Integer)request.getAttribute("startpage")).intValue();
	int endpage=((Integer)request.getAttribute("endpage")).intValue();
%>

<html>
<head>
	<title>MVC 게시판</title>
</head>

<body>
<!-- 게시판 리스트 -->
<table width=570 border="0" cellpadding="0" cellspacing="0">
	<tr align="center" valign="middle">
		<td colspan="4">MVC 게시판</td>
		<td align=right>
			<font size=2>글 개수 : ${listcount }</font>
		</td>
	</tr>
	
	<tr align="center" valign="middle" bordercolor="#333333">
		<td style="font-family:Tahoma;font-size:8pt;" width="8%" height="26">
			<div align="center">번호</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;" width="50%">
			<div align="center">제목</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;" width="14%">
			<div align="center">작성자</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;" width="17%">
			<div align="center">날짜</div>
		</td>
		<td style="font-family:Tahoma;font-size:8pt;" width="11%">
			<div align="center">조회수</div>
		</td>
	</tr>
	
	<%	
		int num = listcount - ((nowpage - 1) * 10); // 글 번호 
		for(int i=0;i<boardlist.size();i++){
			BoardVO bl=(BoardVO)boardlist.get(i);
	%>
	<tr align="center" valign="middle" bordercolor="#333333"
		onmouseover="this.style.backgroundColor='F8F8F8'"
		onmouseout="this.style.backgroundColor=''">
		<td height="23" style="font-family:Tahoma;font-size:10pt;">
			<%=num%>
		</td>
		
		<td style="font-family:Tahoma;font-size:10pt;">
			<div align="left">
			<%if(bl.getRe_lev()!=0){ %> <!-- 들여쓰기.  -->
				<%for(int a=0;a<=bl.getRe_lev()*2;a++){ %>
				&nbsp; <!--  공백 넣어라.  -->
				<%} %>
				▶
			<%}else{ %>
				▶
			<%} %>
			<a href="./boarddetail.bo?num=<%=bl.getNum()%>"> <!-- 글번호 get방식으로 파라메타 전달.  -->
				<%=bl.getSubject() %> 
			</a>
			</div>
		</td>
		
		<td style="font-family:Tahoma;font-size:10pt;">
			<div align="center"><%=bl.getId() %></div>
		</td>
		<td style="font-family:Tahoma;font-size:10pt;">
			<div align="center"><%=bl.getBoarddate() %></div>
		</td>	
		<td style="font-family:Tahoma;font-size:10pt;">
			<div align="center"><%=bl.getReadcount() %></div>
		</td>
	</tr>
	<%
		num--;
		} %>
	<tr align=center height=20>
		<td colspan=7 style=font-family:Tahoma;font-size:10ptㅇ;>
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
	<tr align="right">
		<td colspan="5">
			<%if(id!=null && id.equals("admin")){%>
				<a href="./memberlist.me">[회원관리]</a> <!-- admin일때만 관리 페이지  -->
			<%}%>
	   		<a href="./boardwriteform.bo">[글쓰기]</a>
		</td>
	</tr>
</table>
</body>
</html>