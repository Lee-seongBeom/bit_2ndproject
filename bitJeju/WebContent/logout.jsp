<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Jua&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<meta http-equiv="refresh" content="2; url=http://localhost:8080/bitJeju/index.jb">
<title>비트캠프 제주점</title>
<style type="text/css">


.login>h2{
margin-top: 10%;
font-size: 35px;
text-align: center;
}
.login>h3{

font-size: 25px;
margin-top:50px;
text-align: center;
}
</style>
<%@ include file="template/head.jspf" %>
</head>
<body>
	<%@ include file="template/header.jspf" %>
	
	<div id="content">
		<!-- content start -->
		<div class="login">
		<h2>로그아웃 되었습니다</h2>
					
		<h3>이용해주셔서 감사합니다.</h3>
		</div>
		<!-- content end -->
	</div>
	<%@include file="template/footer.jspf" %>
	

</body>
</html>