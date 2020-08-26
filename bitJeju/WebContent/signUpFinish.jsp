<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="refresh" content="2; url=http://192.168.0.188:8080/bitJeju/login.jb">
<title>비트캠프 제주점 회원가입</title>
<%@ include file="../template/head.jspf" %>
<%@ include file="../template/header.jspf" %>

<script type="text/javascript">
	
	
	
</script>
<style type="text/css">
	#content > h1{
		text-align:center;
		margin: 50px auto 30px auto;
	}
	#content > h1:first-letter { 
		font-size: 45px;
		border-top: 3px solid blue;
		padding-top: 2px;
	}
	
	#content{
		text-align:center;
		margin-top: 50px;
	}

	#content input{
		width:150px;
	}
	button{
		width:100px;
	    background-color: royalblue;
	    border: none;
	    color: white;
	    padding: 7px 0;
	    text-align: center;
	    text-decoration: none;
	    display: inline-block;
	    font-size: 15px;
	    margin: 4px;
	    margin-top:30px;
	    cursor: pointer;
	    border-radius: 10px;
	    text-align: center;
    }
</style>
</head>
<body>
		
	
	<div id="content">
	<h1>회원가입이 완료되었습니다!</h1>
		<!-- content start -->
		
		<form action="<%=root%>/index.jb">
			<button type="submit">메인 화면으로</button>
			
		</form>
		
		<!-- content end -->
	</div>

<%@ include file="/template/footer.jspf" %>
</body>
</html>