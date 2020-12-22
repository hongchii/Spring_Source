<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	id : ${id}<br>
	pw : ${pw}<br><br>
	jumin1 : ${jumin1}<br><br>
	jumin2 : ${jumin2}<br><br>
	gender : ${gender}<br><br>
	tel1 : ${tel1}<br><br>
	tel2 : ${tel2}<br><br>
	tel3 : ${tel3}<br><br>
	email : ${email}<br><br>
	hobby : ${hobby}<br><br>
	intro : ${intro}<br><br>
	
	id : <%=request.getAttribute("id") %><br>
	pw : <%=request.getAttribute("pw") %><br>
	jumin1 : <%=request.getAttribute("jumin1") %><br>
	jumin2 : <%=request.getAttribute("jumin2") %><br>
	gender : <%=request.getAttribute("gender") %><br>
	tel1 : <%=request.getAttribute("tel1") %><br>
	tel2 : <%=request.getAttribute("tel2") %><br>
	tel3 : <%=request.getAttribute("tel3") %><br>
	email : <%=request.getAttribute("email") %><br>
	hobby : <%=request.getAttribute("hobby") %><br>
	intro : <%=request.getAttribute("intro") %><br>
</body>
</html>