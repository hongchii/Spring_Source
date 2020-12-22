<!-- 

 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style type="text/css">
	    form{
	    width:500px;
	    margin:10px auto;
	    }
	    ul{
	    padding: 0;
	    margin: 0;
	    list-style:none;
	    }
	    ul li{
	    padding : 0;
	    margin: 0 0 10px 0;
	    }
	    label{
	    width:150px;
	    float:left;
	    }
	    table{
	    border:1px solid gray;
	    width:500px;
	    margin:0 auto;
	    border-collapse: collapse;
	    }
	    td{
	    border: 1px solid gray;
	    }
   </style>
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script type="text/javascript">
	
	$(document).ready(function(){
	    $('#output').empty();
	    
	    $.ajax({
	    	url : '/springemp/getEmpJSON.do',
			contentType : 'application/x-www-form-urlencoded:charset=utf-8',
			success : function(data){
				$.each(data, function(index, item){
					var output='';
					output += '<tr>';
	                output += '<td width = "80px">' + item.empno + '</td>';
	                output += '<td width = "80px">' + item.ename + '</td>';
	                output += '<td width = "80px">' + item.job + '</td>';
	                output += '<td width = "80px">' + item.mgr + '</td>';
	                output += '<td width = "80px">' + item.hiredate + '</td>';
	                output += '<td width = "80px">' + item.sal + '</td>';
	                output += '<td width = "80px">' + item.comm + '</td>';
	                output += '<td width = "80px">' + item.deptno + '</td>';
	                output += '</tr>'
	                console.log("output:" + output); //F12 개발자도구에서 볼수 있음 (dom 구조로 확인가능) 동적인 내용은 소스보기에서 볼수 없음
	                $('#output').append(output); //추가
				}); //each 끝 
		      }, //success 끝
		      error:function(){
			        alert("ajax통신 실패!!!");
			}// error 끝.
	    });// ajax 끝
	});
	
	  
		
	</script>
</head>
<body>
	<table id="output"></table>
</body>
</html>
