<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비트캠프 제주점</title>
<style type="text/css">
	#content {
		margin: 20px auto;
		width: 800px;
	}
	#content > h1{
		margin: 50px auto 30px auto;
	}
	#content > h1:first-letter { 
		font-size: 45px;
		border-top: 3px solid blue;
		padding-top: 2px;
	}
</style>
<%@ include file="../template/head.jspf" %>
</head>
<body>
	<%@ include file="../template/header.jspf" %>
	
		<div id="content">
		<!-- content start -->
			<h1>비트캠프 소개</h1>
			 	<div align="center"><img alt="summary" src="<%=root %>/img/intro1.jpg"/></div>
			 	<div align="center"><img alt="summary" src="<%=root %>/img/intro2.jpg"/></div>
			 	<div align="center"><img alt="summary" src="<%=root %>/img/intro3.jpg"/></div>	
		<!-- content end -->
		</div>
	
	<%@include file="../template/footer.jspf" %>
	

</body>
</html>