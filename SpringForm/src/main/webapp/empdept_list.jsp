<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.spring.form.EmpDeptVO" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" align="center">
		<tr>
			<th width="80">EMPNO</th>
			<th width="80">ENAME</th>
			<th width="100">JOB</th>
			<th width="80">DEPTNO</th>
			<th width="80">DNAME</th>
			<th width="80">LOC</th>
		</tr>
<%
	ArrayList<EmpDeptVO> list = (ArrayList<EmpDeptVO>)request.getAttribute("empdept_list");
		for (int i=0; i<list.size(); i++){
		EmpDeptVO empdeptvo = (EmpDeptVO)list.get(i);
%>			
	<tr>
		<td><%=empdeptvo.getEmpno() %></td>
		<td><%=empdeptvo.getEname() %></td>
		<td><%=empdeptvo.getJob() %></td>
		<td><%=empdeptvo.getDeptno() %></td>
		<td><%=empdeptvo.getDname() %></td>
		<td><%=empdeptvo.getLoc() %></td>
		
	</tr>
	<%
}	
%>
	</table>
</body>
</html>