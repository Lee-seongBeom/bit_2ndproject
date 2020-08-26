<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Jua&family=Nanum+Pen+Script&display=swap"
	rel="stylesheet">
<title>비트캠프 제주점</title>
<%@ include file="../template/head.jspf" %>
<style type="text/css">
	#content > h1{
		margin: 50px auto 30px auto;
	}
	#content > h1:first-letter { 
		font-size: 45px;
		border-top: 3px solid blue;
		padding-top: 2px;
	}
	#topImgBar {
		width:100%;
	}
	#content {
		width: 702px;
		margin: 20px auto;
	}
	#con {
		height: 200px;
		margin-bottom: 50px;
	}
	#subImg {
		width: 200px;
		height: 200px;
		float: left;
		margin-right: 30px;
	}
	#sub{
		display: inline-block;
		width:450px;
	}
	#sub > h4 {
		font-size: 17px;
		margin-bottom: 5px;
		color: orange;
	}
	#sub > h3{
		margin-bottom: 10px;
	}
	#sub > p {
		margin-bottom: 5px;
	}
	#sub > button{
		margin: 10px auto;
		width: 150px;
		height: 35px;
		background-color: royalblue;
		color: white;
		font-size: 16px;
		border: 0px solid white;
		border-radius:10px;
	}
</style>
</head>
<body>
<%@ include file="../template/header.jspf" %>
<img id="topImgBar" src="img/subList.png"/>
<div id="content" >
		<!-- content start -->
			<h1>국비지원과정</h1>
			<form action="subDetail.jb" method="post">
			<c:forEach items="${classList }" var="classList">
				<div id="con">
					<img id="subImg" src="${classList.filePath }"/>
					<div id="sub">
						<h4>비트캠프 제주점</h4>
						<h3>${classList.className }</h3>
						<p><b>강사명 &nbsp;&nbsp;&nbsp;&nbsp;|</b>&nbsp;&nbsp;${classList.teacher }</p>
						<p><b>개강일 &nbsp;&nbsp;&nbsp;&nbsp;|</b>&nbsp;&nbsp;${classList.startDay }
						<p><b>교육기간  &nbsp;|</b>&nbsp;&nbsp;${classList.startDay } ~ ${classList.endDay } (월~금 09:30 ~ 18:10)</p>
						<p><b>지원자격  &nbsp;|</b>&nbsp;&nbsp;고용보험에 가입되어 있지 않은 취업 준비생 또는 실업자</p>
						
						<input type="hidden" name="classCode" value="${classList.classCode }"/>
						<input type="hidden" name="className" value="${classList.className }"/>
						<input type="hidden" name="tcode" value="${classList.tcode }"/>
						
						<button type="submit">수강신청</button>
					</div>
				</div>
				<div id="introImg">
				  <img src="<%=root%>/img/apply1.jpg">
				  <img src="<%=root %>/img/subIntro.jpg">
				</div>
			</c:forEach>
			</form>
		<!-- content end -->
		</div>
	
	
	<%@include file="../template/footer.jspf" %>
	

</body>
</html>