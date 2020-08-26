<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="template/head.jspf" %>
</head>
<style rel="stylesheet" type="text/css">
	#topImgBar{
		width: 100%;
		margin-bottom: 70px;
	}
	#content {
		margin: 20px auto;
		width: 1000px;
		height:1200px;
		text-align:cetner;
	}
	#content > h1{
		margin-bottom:30px;
	}
	#content > h1:first-letter { 
		border-top: 3px solid blue;
		font-size: 50px;
	}
	#content > .bigBox{
		float:left;
		width:300px;
		height: 380px;
		margin: 20px 15px;
		padding-top: 1px;
		padding-bottom: 5px;
		border: 1px solid lightgray;
		border-radius: 15px;
		cursor: pointer;
	}
	#content > .bigBox:hover{
		
	}
	#content > .bigBox > .imgBox img{
		width:270px;
		height: 230px;
		margin: 15px 15px;
		margin-bottom: 0px;
		background-color: lightblue;
		background-repeat: no-repeat;
		background-size:cover;
	}
	#content > .bigBox > .subBox{
		width:270px;
		height: 100px;
		margin:10px auto;
		background-color: white;
	}
	.subBox > .title {
		height:50px;
		text-align:center;
		margin-top: 15px;
		margin-bottom: 15px;
	}
	.subBox > .teacher {
		margin-bottom: 5px;
	}
	
	.subBox > div > span{
		margin-left: 5px;
	}
</style>
<script type="text/javascript" src="js/jquery-1.12.4.js"></script> 
<script type="text/javascript">
	$(document).ready(function(){
	});
</script>
<body>
<%@ include file="template/header.jspf" %>
<img id="topImgBar" src="img/subList.png"/>
<div id="content">
<!-- content start -->
<h1>국비지원과정</h1>
	<c:forEach items="${classList }" var="classList">
	<div class="bigBox" onclick="window.location.href='subDetail.jb?classCode=${classList.classCode}';">
		<div class="imgBox"><img src="${classList.filePath }"/></div>
		<div class="subBox">
			<div class="title"><h3>${classList.className }</h3></div>
			<div class="teacher"><span><b>강사명  &nbsp;&nbsp;&nbsp;&nbsp;|</b></span><span>${classList.teacher }</span></div>
			<div><span><b>교육기간  &nbsp;|</b></span><span>${classList.startDay } ~ ${classList.endDay }</span></div>
		</div>
	</div>	
	</c:forEach>
<!-- content end  --> 
</div>
<%@ include file="template/footer.jspf" %>
</body>
</html>