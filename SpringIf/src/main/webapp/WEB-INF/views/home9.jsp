<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>좌표로 주소를 얻어내기</title>
	<style>
	.map_wrap {position:relative;width:100%;height:400px;}
	.title {font-weight:bold;display:block;}
	#centerAdde {display:block;margin-top:2px;font-weight:normal;}
	</style>
</head>
<body>
	<div class="map_wrap">
		<div id="map" style="width:100%;height:100%;position:relative;overflow:hidden;"></div>
	</div>
	<!-- ibraries=services를 추가로 설정해야한다. -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=4434d2cc6bcfc1d87507d4afab43bdfb"></script>
	<script>
	var mapContainer = document.getElementById('map'); // 지도를 표시할 div
	var mapOption = {center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
			level: 1 // 지도의 확대 레벨
			};
	// 지도를 생성합니다
	var map = new kakao.maps.Map(mapContainer, mapOption); 
	
	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();
	
	var marker = new kakao.maps.Marker(); // 클릭한 위치를 표시할 마커입니다
	var infowindow = new kakao.maps.InfoWindow({zindex:1}) // 클릭한 위치에 대한 주소를 표시할 인포 윈도우입니다
	
	var latlng = null;
	//지도를 클릭했을 때 클릭 위치 좌표에 대한 주소정보를 표시하도록 이벤트를 등록합니다
	kakao.maps.event.addListener(map, 'click', function(e) {
		searchDetailAddrFromCoords(e.latLng, function(result, status){
			if (status === kakao.maps.services.Status.OK){
				// 주소구조 : https://developers.kakao.com/docs/latest/ko/local/dev-guide#coord-to-address
				var detailAddr = !!result[0].road_address ? '<div>도로명 주소 : ' +
						result[0].read_address.address_name + '<div>' : '';
					detailAddr += '<div>지번 주소 : ' + result[0].address.address_name + '</div>';
					
				var content = '<div class = "bAddr">' + '<span class="tite">법정동 주소정보</span>' +
					detailAddr + '</div>';
					
				latlng = e.latLng; // e.latLng : 클릭한 위치의 위도와 경도
				// 마커를 클릭한 위치에 표시합니다.
				marker.setPosition(latlng);
				marker.setMap(map);
				map.setCenter(latlng); // 새로운 좌표를 지도의 가운데로 이동합니다.
				// 인포윈도우에 클릭한 위치에 대한 법정동 상세 주소정보를 표시합니다
				infowindow.setContent(content);
				infowindow.open(map, marker);
			}		
		});
	});
	
	function searchDetailAddrFromCoords(coords, callback_addr){
		// 좌표로 법정동 상세 주소 정보를 요청합니다
		geocoder.coord2Address(coords.getLng(), coords.getLat(), callback_addr);
	}
		// idle : 지도의 크기나 위치가 변경되었을때 발생되는 이벤트
		kakao.maps.event.addListener(map, 'idle', function(){
			map.setCenter(latlng);
		});
	</script>
</body>
</html>