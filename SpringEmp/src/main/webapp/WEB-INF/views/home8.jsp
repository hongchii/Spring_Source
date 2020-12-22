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
		$("#itemSubmit").on("click", function(){
			var saveBuyerItem = [];
			
			$("input[name=buyerItem]:checked").each(function(){
				saveBuyerItem.push($(this).val());
			});
			alert(saveBuyerItem);
		});
	});
 
</script>
<body>
    <tr>
        <td>
           <br><input type="checkbox" name="buyerItem" value="java">자바</br>
           <br><input type="checkbox" name="buyerItem" value="servlet">서블릿</br>
           <br><input type="checkbox" name="buyerItem" value="jsp">jsp</br>
           <br><input type="checkbox" name="buyerItem" value="javascript">자바스크립트</br>
           <br><input type="checkbox" name="buyerItem" value="jquery">제이쿼리</br>
          	<input type="submit" id="itemSubmit" value="입력완료">
        </td>
        <td>
            <input type="button" name="btn" id="btn" onclick="fnGetdata();"/>
        </td>
    </tr>
</body>
</html>
