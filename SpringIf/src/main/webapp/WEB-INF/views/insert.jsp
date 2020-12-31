<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>

	<style>
        .header {
            background-color: black;
            height: 150px;
            width: 1000px;
        }

        .container {
            margin-left: 300px;
            margin-right: 300px;
            width: 950px;
        }
        
        .item1 {
            display: flex;
            justify-content: space-between;
            border-bottom: 4px solid black;
            font-size: small;
            padding-top: 20px;
            padding-bottom: 20px;
            align-items: baseline;
        }

        /* 분실 물품 */
        .item3 {
            display: flex;
            justify-content: space-between;
            border-bottom: 1px solid black;
            padding-top: 20px;
            padding-bottom: 20px;
        }
        
        .item3 > radio_check {
        	display: flex;
            justify-content: space-between;
            border-bottom: 1px solid black;
            padding-top: 20px;
            padding-bottom: 20px;
        }

        /* 분실 날짜 */
        .item5 {
            display: flex;
            justify-content: space-between;
            border-bottom: 1px solid black;
            padding-top: 20px;
            padding-bottom: 20px;
        }

        /* 분실 위치 */
        .item6 {
            padding: 20px 0 20px 10px;
            display: flex;
            justify-content: space-between;
            align-items :center;
            border-bottom: 1px solid black;
        }

        #test{
            height : 45px;
            display : flex;
            justify-content : center;
            align-items: baseline;
            margin : 0;
        }
        
        #test p{
            width : 50px;
            margin: 0;
        }

        /* 글 제목 */
        .item7 {
            display: flex;
            border-bottom: 1px solid black;
            padding-top: 20px;
            padding-bottom: 20px; 
        }

        /* 글 내용 */
        .item8 {
            display: flex;
            justify-content: space-between;
            border-bottom: 1px solid black;
            padding-top: 20px;
            padding-bottom: 20px;
        }

        /* 파일 첨부 */
        .item9 {
            display: flex;
            justify-content: space-between;
            border-bottom: 1px solid black;
            padding-top: 20px;
            padding-bottom: 20px;
        }

        /* 사례금 */
        .item10 {
            display: flex;
            justify-content: space-between;
            border-bottom: 4px solid black;
            padding-top: 20px;
            padding-bottom: 20px;
        }

        /* 등록 취소 버튼 */
        .btn {
            display: flex;
            justify-content: center;
            margin-top: 20px;
            margin-bottom: 20px;
        }
	</style>
	
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script type="text/javascript">
	

	//사례금선택시에 직접입력 선택하면 인풋창 활성화 
	$(document).on("change", "select[name=Lost_Pay]", function(){
		var value = $(this).find("option[name=Lost_Pay]:selected").val();
		var inputText = $(this).closest('.item10').find('.form-control');
		var flag = true;
			
		if (value == 'direct') {
			flag = false;
		}
			
		$(inputText).attr("disabled", flag);
	});
	
	//사례금 입력시에 자동으로 콤마 추가
	function cmaComma(obj) {
	    var firstNum = obj.value.substring(0,1); // 첫글자 확인 변수
	    var strNum = /^[/,/,0,1,2,3,4,5,6,7,8,9,/]/; // 숫자와 , 만 가능
	    var str = "" + obj.value.replace(/,/gi,''); // 콤마 제거  
	    var regx = new RegExp(/(-?\d+)(\d{3})/);  
	    var bExists = str.indexOf(".",0);  
	    var strArr = str.split('.');  
	 
	    if (!strNum.test(obj.value)) {
	        alert("숫자만 입력하십시오.\n1,000원 이상의 금액을 입력하세요.");
	        obj.value = 1000;
	        obj.focus();
	        return false;
	    }
	 
	    if ((firstNum < "0" || "9" < firstNum)){
	        alert("숫자만 입력하십시오.");
	        obj.value = 1000;
	        obj.focus();
	        return false;
	    }
	 
	    while(regx.test(strArr[0])){  
	        strArr[0] = strArr[0].replace(regx,"$1,$2");  
	    }  
	    if (bExists > -1)  {
	        obj.value = strArr[0] + "." + strArr[1];  
	    } else  {
	        obj.value = strArr[0]; 
	    }
	}
	 
	function commaSplit(n) {// 콤마 나누는 부분
	    var txtNumber = '' + n;
	    var rxSplit = new RegExp('([0-9])([0-9][0-9][0-9][,.])');
	    var arrNumber = txtNumber.split('.');
	    arrNumber[0] += '.';
	    do {
	        arrNumber[0] = arrNumber[0].replace(rxSplit, '$1,$2');
	    }
	    while (rxSplit.test(arrNumber[0]));
	    if(arrNumber.length > 1000) {
	        return arrNumber.join('');
	    } else {
	        return arrNumber[0].split('.')[0];
	    }
	}
	
	var popupX = (document.body.offsetWidth / 2) - (430 / 2);
	//&nbsp;만들 팝업창 좌우 크기의 1/2 만큼 보정값으로 빼주었음

	var popupY= (window.screen.height / 2) - (500 / 2);
	//&nbsp;만들 팝업창 상하 크기의 1/2 만큼 보정값으로 빼주었음 
	
	
	</script>
</head>
<body>
   
	<div class="header"></div>
	
	    <div class="container">
			
			<form name="boardform" action="./boardinsert" method="post" enctype="multipart/form-data">
			<!-- 타이틀  -->
	        <div class="item1">
	            <h8>분실글 등록하기(물품)</h8>
	            <h8>* 필수입력사항</h8>
	        </div>
			
			<!-- 필수입력사항  -->
	        <div class="item3">
	            <h6>* 분실 물품</h6>
	                <label><input type="radio" name="Lost_Item" onClick="this.form.textbox.disabled=true" checked="checked">  핸드폰</label>
	                <label><input type="radio" name="Lost_Item" onClick="this.form.textbox.disabled=true">  지갑</label>
	                <label><input type="radio" name="Lost_Item" onClick="this.form.textbox.disabled=true">  가방</label>
	                <label><input type="radio" name="Lost_Item" onClick="this.form.textbox.disabled=true">  책</label>
	                <label><input type="radio" name="Lost_Item" onClick="this.form.textbox.disabled=true">  화장품</label>
	                <label><input type="radio" name="Lost_Item" onClick="this.form.textbox.disabled=false">  기타</label>
	                <label><input type="text" name="Lost_Item" id="textbox" class="form-control" placeholder="직접입력" disabled></label> 
	        </div>
	
			<!-- 필수입력사항 -->
	        <div class="item5">
	            <h6>* 분실 날짜 </h6>
	            <span><input type="date"></span>
	 
	        </div>
			
	        <div class="item6">
	            <h6>분실 위치</h6>   
	                <div id="test">
	                    <input type="text" class="form-control" disabled>
	                    <p>인근</p>
	                </div>
	                <div class="item6_1">
	                    <!--<button onclick="window.open('map.html','startpop',
	                    'width=430,height=500,location=no,status=no,scrollbars=yes');">button</button>  -->
	                	<button onclick="window.open('map.html', 'startpop', 'status=no, height=500, width=430, left='+ popupX + ', top='+ popupY);">button</button>
	                </div>        
	        </div>
			
			<!-- 필수입력사항 -->
	        <div class="item7">
	            <div class="col-sm-3">
	                <h6>* 제  목</h6>
	                <div class="item7_box"><input type="text" class="form-control" name="Lost_Title" required></div> 
	            </div>
	        </div>
	        
	     	<!-- 필수입력사항 -->   
	        <div class="item8">
	            <div class="row-lg-10">
	                <h6>* 내  용</h6>
	                <textarea rows="5" class="form-control" name="Lost_Content" required></textarea>            
	            </div>
	        </div>
	      
	    
	        <div class="item9">
	            <h6>파일 첨부</h6>
	            <span><input type="file" name="Lost_Or_File"></span>
	        </div>
	
	
	        <div class="item10">
	            <h6>사례금</h6>
	            <label><input type="radio" name="Lost_Pay" onClick="this.form.selbox.disabled=true" checked="checked">무료글등록</label>
	            <label><input type="radio" name="Lost_Pay" onClick="this.form.selbox.disabled=false">사례금등록</label>
	                <select id="selbox" name="Lost_Pay" disabled>
	                    <option value="" >선택</option>
	                    <option value="1">10,000원</option>
	                    <option value="1">30,000원</option>
	                    <option value="1">50,000원</option>
	                    <option value="1">100,000원</option>
	                    <option value="direct" name="Lost_Pay">직접입력</option>
	                </select>
	             <input type="text" size="10" class="form-control" 
	             name="Lost_Pay" onkeyup="cmaComma(this);" onchange="cmaComma(this);" 
	             oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" 
	             pattern='\d*' placeholder="직접입력" minlength="4" disabled>원
	           	
	            
	            <!-- name="cma_test" -->
	        </div>
	        
	        <div class="btn">
	        	<a href="javascript:boardform.submit()">등록</a>&nbsp;&nbsp;
				<a href="./boardlist">취소</a></td>
	         <!-- 
	            <button type="button" class="btn btn-primary btn-sm">등록</button>&nbsp;&nbsp;  
	            <button type="button" class="btn btn-primary btn-sm">취소</button>
	         -->
	        </div>    
	    </form>
	    </div>
     
</body>
</html>
