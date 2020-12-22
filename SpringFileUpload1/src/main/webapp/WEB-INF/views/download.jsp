<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page import="java.util.*" %>

<%
	request.setCharacterEncoding("utf-8");
	ArrayList<String> orgfile_list = (ArrayList<String>)request.getAttribute("orgfile_list");
	ArrayList<String> storedfile_list = (ArrayList<String>)request.getAttribute("storedfile_list");
	ArrayList<Long> filesize_list = (ArrayList<Long>)request.getAttribute("filesize_list");
			
%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>
	<h1>업로드 완료</h1>
	이름 : ${name } <br/><br/>
<%
	for (int i=0; i<orgfile_list.size(); i++){ // 업로드할 갯수만큼 loop 
		String downlink = "fileDownload.bo?of=" + storedfile_list.get(i) + "&of2=" + orgfile_list.get(i);
		// 다운로드 받기위한 링크를 만들어줌 downlink  i -> 실제 저장된 파일명 불러오기. 
%>
	파일명: <%=orgfile_list.get(i) %><br/>
	파일사이즈: <%=filesize_list.get(i) %><br/>
		<a href=<%=downlink %>>다운로드</a><br />
		<img src="/springfileupload1/upload/<%=storedfile_list.get(i) %>" /><br/><br/>
		<!-- 경로. server.xml 에 path에 설정한 경로를 적어줘야함. 외부경로 파일이기때문에 경로를 설정해줘야함. -->
<%
	}
%>	
	<br>	
</body>
</html>