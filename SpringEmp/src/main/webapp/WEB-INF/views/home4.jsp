<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style type="text/css">
	
	    table{
	    border:1px solid gray;
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
	    	output += '';
	    	output += '<tr>';
	    	output += '<td width = "80px">'+'empno'+'</td>';
	    	output += '<td width = "80px">'+'ename'+'</td>';
	    	output += '<td width = "80px">'+'job'+'</td>';
	    	output += '<td width = "80px">'+'mgr'+'</td>';
	    	output += '<td width = "80px">'+'hiredate'+'</td>';
	    	output += '<td width = "80px">'+'sal'+'</td>';
	    	output += '<td width = "80px">'+'comm'+'</td>';
	    	output += '<td width = "80px">'+'deptno'+'</td>';
	    	output += '</tr>'
	   		console.log("output:" + output);
	    	$('#output').append(output);
	    	
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
	                output += '<td width = "180px">' + item.hiredate + '</td>';
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
	    
	    $('[id=check]').click(function(event){ 
		var deptno = $("input[name=deptno]:checked").val();
			alert(deptno);
	    	deptno *= 1; 
			getdeptno(deptno);
	    	
	    }); // click끝 
	    
		function getdeptno(deptno) {
			console.log(deptno);
			$.ajax({
				  url : '/springemp/getDept.do',
				  contentType : 'application/x-www-form-urlencoded:charset=utf-8',
				  data : {'deptno':deptno},
				  //type : 'post',
				  //dataType : 'json',
				  success : function(data){
					  $('#output').empty();
					  $.each(data, function(index, item){
						  
						  	if(deptno == item.deptno){
						  		var output ='';
								output += '<tr>';
				                output += '<td width = "80px">' + item.empno + '</td>';
				                output += '<td width = "80px">' + item.ename + '</td>';
				                output += '<td width = "80px">' + item.job + '</td>';
				                output += '<td width = "80px">' + item.mgr + '</td>';
				                output += '<td width = "180px">' + item.hiredate + '</td>';
				                output += '<td width = "80px">' + item.sal + '</td>';
				                output += '<td width = "80px">' + item.comm + '</td>';
				                output += '<td width = "80px">' + item.deptno + '</td>';
				                output += '</tr>';
						  	}
						  $('#output').append(output);
					  });//each끝
				  },//success끝
				  error : function(request, status, error){
				        alert("ajax 통신 실패");
				        console.log(request);
				        console.log(status);
				        console.log(error);
				  }// error끝
			  }); 
			event.preventDefault();
		
		} // getdeptno끝
		
		
			   	    
		
	}); // ready끝
	        
	
	</script>
</head>
<body>
	

	<div>
		<span><input type="checkBox" name="deptno" value="10"> 10 </span>
		<span><input type="checkBox" name="deptno" value="20"> 20 </span>
		<span><input type="checkBox" name="deptno" value="30"> 30 </span>
		<span><input type="submit" value="선택" id="check"></span>
	
	
</div>
	
	<table id="output">
		
	</table>
	
</body>
</html>
