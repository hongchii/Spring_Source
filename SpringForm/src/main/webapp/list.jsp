<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.spring.form.EmpVO" %>
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
			<th width="80">MGR</th>
			<th width="100">HIREDATE</th>
			<th width="80">SAL</th>
			<th width="80">COMM</th>
			<th width="80">DEPTNO</th>
			<th width="80">삭제</th>
		</tr>
<%
	ArrayList<EmpVO> list = (ArrayList<EmpVO>)request.getAttribute("list");
		for (int i=0; i<list.size(); i++){
		EmpVO empvo = (EmpVO)list.get(i);
%>			
	<tr>
		<td><%=empvo.getEmpno() %></td>
		<td><%=empvo.getEname() %></td>
		<td><%=empvo.getJob() %></td>
		<%
		if (empvo.getMgr() == 0){
		%>
		<td>&nsp;</td>
		<%} else {%>
		<td><%=empvo.getMgr() %></td>
		<%} %>
		<td><%=empvo.getHiredate() %></td>
		<td><%=empvo.getSal() %></td>
		<td><%=empvo.getComm() %></td>
		<td><a href="selectDept.me?deptno=<%=empvo.getDeptno()%>">
			<%=empvo.getDeptno() %></a></td>
		<td><a href="deleteEmp.me?empno=<%=empvo.getEmpno()%>">
			<%=empvo.getEmpno() %></a></td>	
	</tr>
	<%
}	
%>
	</table>
</body>
</html>