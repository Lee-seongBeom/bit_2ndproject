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
<%@ include file="template/head.jspf"%>
<style type="text/css">
	#content {
		text-align: center;
	}
/* 	.name{
		text-align: center;
		margin: 20px auto 20px auto;
	}
	.name:first-letter { 
		font-size: 27px;
		border-top: 2px solid blue;
		padding-top: 2px;
	}
 */	h2 {
		margin: 20px auto;
	}
	
	p {
		margin: 10px auto;
	}
	
	#box3 Strong span {
		height: 40px;
	}
	
	#box2img {
		width: 150px;
	}
	
	#class1 {
		text-align: center;
		padding: 0px auto;
		height: 100px;
	}
	
	#box1, #box2, #box3 {
		text-align: center;
		width: 350px;
		height: 250px;
		display: inline-block;
		overflow: hidden;
		margin: 50px auto;
	}
	
	#box1, #box2 {
		border-right: 1px groove #e4e4e4;
	}
	
	#se22 {
		display: inline-block;
		text-align: center;
		margin-bottom: 200px;
	}
	
	#right {
		top: 500px;
		position: fixed;
		left: 1500px;
		z-index: 99999;
		padding: 15px;
		border-left: 2px solid black;
		border-radius: 15px;
		width: 100px;
	}
	
	#right>p {
		text-align: center;
		padding-bottom: 10px;
		font-size: 20px;
		border-bottom: 2px solid black;
	}
	
	#video {
		max-width: 330px;
		display: none;
		margin: 20px auto;
	}
	
	#right>p>img {
		width: 15px;
	}
</style>
<script type="text/javascript">
	
	var img;
	var cnt = 0;
	function next() {
		cnt++;
		if (cnt == 4)
			cnt = 1;
		img.attr('src', 'img/main0' + cnt + '.jpg');
		/* img.css('width','1024px'); */
		setTimeout(next, 1000);
	}
	$(function() {
		img = $('<img/>').appendTo('#img');
		next();
	});
	
	$(document).ready(function(){
		$('#right').mouseover(function(){
			$(this).find('#video').stop().slideDown(300).css("display","block");
			$(this).find('#video').css("autoplay","true");
			
		});
		
		$('#right').mouseleave(function(){
			$(this).find('#video').stop().slideUp(300).css("autoplay","false");
		});
	});
	
	
</script>
</head>
<body>
	<%@ include file="template/header.jspf"%>
	<div class="img1" id="img"></div>

	<div id="content">
		<!-- content start -->
		<div id="box1">
			<h2 class="name">교육과정 모집공고</h2>
			<p>디지털 컨버젼 자바취업반</p>
			<p>디지털 컨버젼 자바취업반</p>
			<p>디지털 컨버젼 자바취업반</p>
			<p>디지털 컨버젼 자바취업반</p>
		</div>

		<div id="box2">
			<h2 class="name">취업지원센터</h2>
			<a href="#"> <img src="./img/btn1.png" alt="" id="box2img" /></a>
		</div>

		<div id="box3">
			<h2 class="name">고객센터</h2>
			<p>063-123-1234</p>
			<p>평일 09:00 ~ 21:00</p>
			<p>주말/공휴일 10:00 ~ 18:00</p>
		</div>

		<div id="se22">
			<img src="./img/down.png" alt="te" />
		</div>

		<!-- content end  -->
	</div>

	<div id="right">
		<p>
			<img alt="" src="<%=root %>/img/play-button.png"> 홍보&nbsp;영상
		</p>
		
		<video id="video" muted autoplay loop>
			<source src="<%=root %>/video/video.mp4" type="video/mp4">
		</video>
	</div>


		<%@include file="template/footer.jspf"%>
</body>
</html>