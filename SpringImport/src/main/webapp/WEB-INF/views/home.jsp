<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!doctype html>
<html>
<head>
	<meta charset="utf-8" />
	
	<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script src="http://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>
	<script>
	function pay(){
		var IMP = window.IMP;
		var code = "imp55973725"; // 가맹점 식별코드
		IMP.init(code);
		
		// 결제요청
		IMP.request_pay({
			// name과 amount만 있어도 결제 진행가능
			pg : 'kakao', // pg사 선택 (kakao, kakaopay 둘다 가능)
			pay_method : 'card',
			// merchant_uid : 'merchant_' + new Date().getTime(),
			merchant_uid : 'merchant_1', // 주문번호
			name : '결제테스트', // 상품명
			amount : 1,
			buyer_email : 'zoca01@hanmail.net',
			buyer_name : '조영태',
			buyer_addr : '010-8585-9052',
			buyer_postcode : '123-456',
		}, function(rsp){
			if (rsp.success){
				var msg = '결제가 완료되었습니다.';
				msg += '고유ID : ' + rsp.imp_uid;
				msg += '상점 거래 ID : ' + rsp.merchant_uid;
				msg += '결제 금액 : ' + rsp.paid_amount;
				msg += '카드 승인번호 : ' + rsp.apply_num;
				
			}else {
				var msg = '결제에 실패하였습니다. 에러내용 : ' + rsp.error.msg
			}
			alert(msg);
			
		});
	}
	
	function cancelPay(){
		jQuery.ajax({
			url : "/springimport/cancel.do",
			type : "post",
			//datatype: "json",
			contentType : 'application/x-www-form-urlencoded; charset=utf-8',
			data : {
				"merchant_uid" : "merchant_1" // 주문번호
				//"cancel_request_amount": 2000, // 환불금액
				//"reason" : "테스트 결제 환불", // 환불사유
				//"refund_holder": "홍길동", // [가상계좌 환불시 필수입력] 환불 가상계좌 예금주
				//"refund_bank" : "88", // [가상계좌 환불시 필수입력] 환불 가상계좌 은행코드 (ex. KG이니시스의 경우 신한은행은 88번)
				//"refund_account" : "56211105948400" // [가상계좌 환불시 필수입력] 환불 가상계좌 번호
			}
		}).done(function(result){ // 환불 성공시 로직
			alert("환불 성공 : " + result);
		}).fail(function(error){ // 환불 실패시 로직
			alert("환불 실패 : " + error);
		});
	}
	</script>
</head>

<body>
	<a href="#" onclick="pay()">일반 결제</a><br><br>
	<a href="#" onclick="cancelPay()">결제 취소</a> 
</body>
</html>
