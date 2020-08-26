<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자페이지</title>
<%@ include file="template/head.jspf" %>
<script type="text/javascript">
	
	$(document).ready(function(){
		
	});

</script>
<style type="text/css">
	
	#content > h1{
		text-align: center;
		margin: 50px auto 30px auto;
	}
	#content > h1:first-letter { 
		font-size: 45px;
		border-top: 3px solid blue;
		padding-top: 2px;
	}
</style>
</head>
<body>
	<%@ include file="template/managerheader.jspf" %>

	<div id="content">
	<h1>관리자 페이지</h1>
		<!-- content start -->
		<!-- content end -->
	</div>
	
	<%@include file="template/footer.jspf" %>

</body>
</html>