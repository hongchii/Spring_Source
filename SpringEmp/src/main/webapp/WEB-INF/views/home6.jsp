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
	   
	    
		// check1 버튼 클릭시 값 배열에 저장. 
		$('[id=check1]').on("click", function(){
			if($('input[name=deptno]').is(":checked") == true){
				
				var deptno =[];
					
				$('input[name=deptno]:checked').each(function(){
					deptno.push($(this).val());
					});
					alert(deptno);
					getdeptno(deptno); 	
			}
			else{
				alert("체크를 해주세요!")
			}
		});
		
	    
		function getdeptno(deptno) {
			console.log(deptno);
			$.ajax({
				  url : '/springemp/getDept.do',
				  contentType : 'application/x-www-form-urlencoded;charset=utf-8',
				  data : {"deptno":deptno} ,
				  type : 'POST',
				  //dataType : 'json',
				  success : function(data){
					  $('#output').empty();
					 var form ='<tr><td width = "80px">empno</td><td width = "80px">ename</td><td width = "80px">job</td><td width = "80px">mgr</td><td width = "80px">hiredate</td><td width = "80px">sal</td><td width = "80px">comm</td><td width = "80px">deptno</td></tr>';
				    		$('#output').append(form);
					  $.each(data, function(index, item){
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
						  $('#output').append(output);
					  });//each끝
				  },//success끝
				  error : function(request, status, error){
				        alert("ajax 통신 실패");
				        
				  }// error끝
			  }); 
			event.preventDefault();
		
		} // getdeptno끝
		
		
		/* job 처리
		
		$('[id=check2]').on("click", function(){
			var arr2 =[];
			
			$('input[name=job]:checked').each(function(){
				arr2.push($(this).val());
			});
			alert(arr2);		
		});	
		
		function getJob(job){
			$.ajax({
				 url : ‘/springemp/getJob.do’,
				 contentType : ‘application/x-www-form-urlencoded:charset=utf-8’,
				 data : {‘job’: job},
				 success : function(data){
					 $(‘#output’).empty();
					 $.each(data, function(index, item){
						 if(job == item.job){
							 var output=‘’;
							 output += ‘<tr>‘;
				        output += ‘<td width = “80px”>’ + item.empno + ‘</td>‘;
				        output += ‘<td width = “80px”>’ + item.ename + ‘</td>‘;
				        output += ‘<td width = “80px”>’ + item.job + ‘</td>‘;
				        output += ‘<td width = “80px”>’ + item.mgr + ‘</td>‘;
				        output += ‘<td width = “180px”>’ + item.hiredate + ‘</td>‘;
				        output += ‘<td width = “80px”>’ + item.sal + ‘</td>‘;
				        output += ‘<td width = “80px”>’ + item.comm + ‘</td>‘;
				        output += ‘<td width = “80px”>’ + item.deptno + ‘</td>‘;
				        output += ‘</tr>‘;
						 }// if끝
						 $(‘#output’).append(output);
					 }); // each끝
				 }, // success끝
				 error : function(){
				    alert(“ajax 통신 실패“);
				   
				}// error끝
			}); // ajax끝
			event.preventDefault();
		} // getJob끝
*/
	}); // ready끝
	        
	</script>
</head>
<body>
	

	<div>
		<span>deptno 선택 >>>>> <input type="checkBox" name="deptno" value="10"> 10 </span>
		<span><input type="checkBox" name="deptno" value="20"> 20 </span>
		<span><input type="checkBox" name="deptno" value="30"> 30 </span>
		<span><input type="submit" value="선택" id="check1"></span>
	</div>
	
	<div>
		<span>job 선택 >>>><input type="checkBox" name="job" value="PRESIDENT">PRESIDENT</span>
		<span><input type="checkBox" name="job" value="MANAGER">MANAGER</span>
		<span><input type="checkBox" name="job" value="ANALYST">ANALYST</span>
		<span><input type="checkBox" name="job" value="CLERK">CLERK</span>
		<span><input type="checkBox" name="job" value="SALESMAN">SALESMAN</span>
		<span><input type="submit" value="선택" id="check2"></span>
	</div>
	<table id="output">
	</table>
	
</body>
</html>
