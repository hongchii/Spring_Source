<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page import="com.spring.springemp.EmpVO" %>
<%@ page import="java.util.*" %>
<%
	List<EmpVO> list = (List<EmpVO>)request.getAttribute("list");
%>

<html>
<head>
	
</head>
<body>
	<table border="1" align=center>
		<tr>
			<td width="40" align=center>empno</td>
			<td width="40" align=center>ename</td>
			<td width="40" align=center>job</td>
			<td width="40" align=center>mgr</td>
			<td width="40" align=center>hiredate</td>
			<td width="40" align=center>sal</td>
			<td width="40" align=center>comm</td>
			<td width="40" align=center>deptno</td>
		</tr>
		<% 
		
		for (int i=0; i < list.size(); i++){
			EmpVO vo = (EmpVO)list.get(i);
		%>
		<tr>
			<td><%=vo.getEmpno() %></td>
			<td><%=vo.getEname() %></td>
			<td><%=vo.getJob() %></td>
			<td><%=vo.getMgr() %></td>
			<td><%=vo.getHiredate() %></td>
			<td><%=vo.getSal() %></td>
			<td><%=vo.getComm() %></td>
			<td><%=vo.getDeptno() %></td>	
		</tr>
		<%} %> 
	</table>
</body>
</html>
