<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Jua&family=Nanum+Pen+Script&display=swap"
	rel="stylesheet">
<title>비트캠프 제주점</title>
<%@ include file="./template/head.jspf"%>
<style type="text/css">
	#content{
		box-sizing: border-box;
		font-family: 'Nanum Pen Script', cursive;
	}
	#content > h1{
		margin: 50px auto 30px auto;
	}
	#content > h1:first-letter { 
		font-size: 45px;
		border-top: 3px solid blue;
		padding-top: 2px;
	}
	table {
		width: 100%;
		border-top: 1px solid #444444;
		border-collapse: collapse;
		font-size: 20px;
	}
	
	th, td {
		border-bottom: 1px solid #444444;
		padding: 10px;
	}
	
	#sf-1 {
		border-top: 4px solid #444444;
	}
	
	#content {
		height: 600px;
		margin-left: 20%;
		margin-top: 50px;
		display: inline-block;
		float: left;
	}
	
	#content > h1{
		margin-bottom:20px;
	}
	
	#content > h1:first-letter { 
		font-size: 45px;
		border-top: 3px solid blue;
	}
	
	#map {
		width: 883px;
		height:600px;
		margin-top: 10px;
		margin-bottom: 10px;
	}
</style>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=2a25c7b7725e0d15c5a618bc931661e3"></script>

<script type="text/javascript">
	$(function() {
		var container = document.getElementById('map');
		var options = {
			center : new kakao.maps.LatLng(33.463507, 126.935254),
			level : 1
		};

		var map = new kakao.maps.Map(container, options);
	});
</script>
</head>
<body>
	<%@ include file="../template/header.jspf"%>


	<div id="content">
		<!-- content start -->
			<h1>찾아오시는길</h1>
			<div id="map"></div>
			<table id="sf-1">
				<tr>
					<th>주소</th>
					<td>대한민국 제주특별자치도 제주시 구좌읍 월정리</td>
				</tr>
				<tr>
					<th>대표전화</th>
					<td>064-763-8707</td>
				</tr>
				<tr>
					<th>대중교통</th>
					<td>820-1번,820-2번 제주시장 하차</td>
				</tr>
			</table>
			<!-- content end -->
		</div>


		<%@include file="./template/footer.jspf"%>
</body>
</html>