<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=age" />
	<meta name="viewport" content="user-scalable=no, inital-scale=1.0, maximum-scale=1.0, minimum-scale=1.0
			width-device-width">
	<title>Kakao JavaScript SDK</title>
	<script type="text/javascript" src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>	 
	<!-- 카카오의 라이브러리를 사용하기 위한 방법.  -->		
	<script type="text/javascript">
			//이벤트 등록
		document.addEventListener("DOMContentLoaded", function(){ 
			// 카카오톡 Developer API 사이트에서 발급받은 JavaScript Key
			Kakao.init("64dff38e65c6fcf704d0e1f38655087c"); // 카카오개발자페이지에서 내애플리케이션. 자바스크립트발급키 갖다붙이기. 
			// 카카오 로그인 버튼을 생성합니다.
			Kakao.Auth.createLoginButton({ // login-btn을 만들어줌. 
				container : "#kakao-login-btn"
			   ,success : function(authObj){ // 잘만들어지면 이 함수를 수행해라. 
				   console.log(authObj);
				   Kakao.API.request({ // 사용자 정보요청. 
					   url : "/v2/user/me" // /v1/user/me API는 종료 사용자 정보를 요청하는 내용
				   	  ,success : function(res){ //아이디를 비롯한 정보들이 저장. 
				   		  console.log(res);
				   		  //개발자 페이지에서 해당 앱의 제품설정 ->카카오 로그인을 on으로 하고 
				   		  //제품성정 -> 동의항목에서 개인정보 보호항목에서 프로필정보 설정에서 필수동의로 설정한다.
				   		  
				   		  //아이디
				   		  document.getElementById("kakaoIdentity").innerHTML = res.id; //res.id 아이디전달
				   		  //닉네임
				   		  document.getElementById("kakaoNickName").innerHTML = res.properties.nickname;
				   		  //프로필 이미지
				   		  document.getElementById("kakaoProfileImg").src = res.properties.profile_image;
				   		  //썸네일 이미지
				   		  document.getElementById("kakaoThumbnailImg").src = res.properties.thumbnail_image; 
				   	 },	  fail : function(error){
				   		  alert(JSON.stringify(error)); // 경고창 뿌려줌
				   		  }
				   });
			   }
				, fail : function(error){
					alert(JSON.stringify(error)); // 버튼 생성 실패시
				}
			});
		});
	</script>
</head>
<body>
	<div>카카오 아이디 : <span id="kakaoIdentity"></span></div>
	<div>닉네임 : <span id="kakaoNickName"></span></div>
	<div>프로필 이미지 : <img id="kakaoProfileImg" src="" /></div>
	<div>썸네일 이미지 : <img id="kakaoThumbnailImg" src="" /></div>
	
	<br/>
	<a id="kakao-login-btn"></a>
</body>
</html>
