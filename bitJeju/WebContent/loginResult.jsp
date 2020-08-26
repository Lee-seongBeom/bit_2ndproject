<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Jua&family=Nanum+Pen+Script&display=swap"
	rel="stylesheet">
<meta http-equiv="refresh" content="0; url=http://localhost:8080/bitJeju/index.jb">
<title>비트캠프 제주점</title>
<style type="text/css">
</style>
<%@ include file="template/head.jspf"%>
<script type="text/javascript">

	
	$(document).ready(function(){
		
		alert("로그인 성공\n"+"${sbean.name}"+"님 환영합니다");
		
	});

</script>

</head>
<body>
	<%@ include file="template/header.jspf"%>

		<div id="content">
		<!-- content start -->

		<!-- content end -->
		</div>

		<%@include file="template/footer.jspf"%>
</body>
</html>