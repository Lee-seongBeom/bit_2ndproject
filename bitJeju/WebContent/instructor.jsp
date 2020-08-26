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

<style type="text/css">
	#teacherIntroImg{
		width:100%;
	}
	#content > h1{
		margin: 50px auto 70px auto;
	}
	#content > h1:first-letter { 
		font-size: 45px;
		border-top: 3px solid blue;
		padding-top: 2px;
	}
	#content {
		width: 800px;
		margin: 20px auto;
	}
	.teacher{
		width: 800px;
		height: 470px;
	}
	.intro{
		height: 270px;
	}
	.tImg{
		width:200px;
		height: 240px;
		float: left;
		margin-right: 50px;
		margin-bottom: 20px;
	}
	.name{
		padding-bottom: 15px;
		font-size: 30px;
	}
	.p2, .p3{
		line-height: 30px;
	}
	.p1{
		padding-bottom: 50px;
		font-size: 17px;
		color: gray;
	}
	.p2{
		font-size: 17px;
	}
	.p3{
		float: right;
		padding-bottom: 50px;	
		padding-top: 5px;
		border-bottom: 2px solid lightgray;
		color: gray;
 	}
</style>

<%@ include file="../template/head.jspf" %>
</head>
<body>
	<%@ include file="../template/header.jspf" %>
	<img id="teacherIntroImg" src="<%=root %>/img/teacher_intro.png"/>

	<div id="content">
		<!-- content start -->
		<h1>강사진 소개</h1>
		<div class="teacher">
		<div>
			<img class="tImg" src="<%=root %>/img/teacher_sul.png"/>
		</div>
		<div class="intro">
			<p class="name"><b>설민석</b> 강사</p>
			<p class="p1"> - If I Rest, I Rust (쉬면 녹슨다)</p>
			<p class="p2"><b>외우지 말고 [이해] 하세요. 이해하고 코딩은 [익숙]해 지세요.<br/>익숙 할 때 까지 [존버] 하세요.</b></p>
		</div>
			<div>
				<p class="p3">개발을 잘한다는 것은 무엇일까요? 특정 언어를 잘 다루는 것? 
				프로그래밍이란 프로그램 언어란 도구를 가지고 무언가를 만드는 과정입니다. 
				그러니 가장 중요한 것은 무엇을 어떻게 만들 것인가에 대한 질문입니다. 
				항상 사용자를 고민하는 개발자, 항상 보다 나은 방법을 고민하는 개발자가 되려고 노력하세요.</p>
			</div>
		</div>
		<div class="teacher">
		<div>
			<img class="tImg" src="<%=root %>/img/teacher_jung.jpeg"/>
		</div>
		<div class="intro">
			<p class="name"><b>정승제</b> 강사</p>
			<p class="p1"> - IT를 통해 인생을 변화시키세요</p>
			<p class="p2"><b>코드로 배우는 스프링<br/>
							 스타트 스프링 부트</b></p>
		</div>
			<div>
				<p class="p3">나폴레옹이 이렇게 말했다 합니다. “오늘 나의 불행은 언젠가 내가 잘못 보낸 시간의 보복이다.”
				읽을 때 마다. 소름이 오싹 돋습니다. 교육기간 동안 잘못 보낸 시간이 아닌 목표를 향해 최선을 다하는
				시간이 될 수 있도록 강의 하겠습니다. 수강생 여러분도 최선을 다해주세요.
				“미래의 나의 행복은 지금 내가 최선을 다한 시간에 보답이다.”</p>
			</div>
		</div>
		<div class="teacher">
		<div>
			<img class="tImg" src="<%=root %>/img/teacher3.jpg"/>
		</div>
		<div class="intro">
			<p class="name"><b>황현필</b> 강사</p>
			<p class="p1"> - 꾸준한 훈련 만이 전문가를 만든다!</p>
			<p class="p2"><b>개발이란 남들을 이해하는 과정입니다.</b></p>
		</div>
			<div>
				<p class="p3">누구한테나 공부는 어려울 때가 종종 있습니다. 스스로를 안심시키며 꾸준히 매일 보이지 않는 노력을 해주시길 당부 드립니다.
				이곳에서 공부하는 성실한 노력은 우리가 개발자로서 자리 잡게 해주고 혹시 우리 운명이 다른 곳으로 이끌어도
				그곳에서 성공의 자양분이 될 것을 확신합니다.</p>
			</div>
		</div>
		
		
		
		<!-- content end -->
	</div>
	<div id="right"></div>
	<%@include file="../template/footer.jspf" %>
	

</body>
</html>