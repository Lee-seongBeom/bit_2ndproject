<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="template/head.jspf" %>
<%@ include file="template/myPageMenuOption.jspf" %>
<title>Insert title here</title>
<style type="text/css">
	#content > h1{
		margin: 50px auto;
	}
	#content > h1:first-letter { 
		font-size: 45px;
		border-top: 3px solid blue;
	}
	#name,#hakbun,#att{
		width:120px;
	}
	#clname{
		width: 380px;
	}
	#content{
		width: 75%;
		float: center;
		margin: 20px auto;
		text-align:center;
	}
	#content>table{
		width: 800px;
		margin: 15px auto;
	}
	#content>table tr>th{
		background-color: lightblue;
		height: 35px;
	    border-radius: 20px;
	}
	#content>table tr>td{
		height: 25px;
		text-align: center;
	}
	#content>table,#content>table tr>th,#content>table tr>td{
        border-collapse: collapse; 
        border: 5px solid white; 
	}
	#img>#box1{
		margin-left:40px;
	}
	#img>img{
		width: 70px;
		height: 70px;
		margin-right: 40px;
		margin-bottom: 15px;
	}
	#myBox{
		padding: 15px 20px 70px 20px;
		border-radius: 20px;
		width: 400px;
		border:1px solid gray;
		margin: 50px auto;
		margin-top: 100px;
	}
	#content>div>div>span{
		margin: 45px;
	}
	#content>div>span{
		text-align: center;
	}
</style>
<script type="text/javascript"src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">
</script>
</head>
<body>	
	<%@ include file="template/header.jspf" %>
	<img id="myLogo" alt="" src="<%=root %>/img/myPage-logo.PNG"/>
	<%@ include file="template/myPageMenu.jspf" %>
	
	<div id ="content">
		<h1>출석 현황</h1>
		<table>
			<tr>
				<th id="hakbun">학생번호</th>
				<th id="name">이름</th>
				<th id="clname">과정명</th>
				<th id="att">출결(%)</th>
			</tr>
			<c:forEach items="${myAttend }" var="attend">
				<tr>
					<td>${attend.hakbun }</td>		
					<td>${attend.name }</td>		
					<td>${attend.className}</td>		
					<td>${attend.rate }</td>	
				</tr>
			</c:forEach>
		</table>
		
		<div id="myBox">
			<div id="img">
				<img id="box1" alt="" src="img/att1.png">
				<img alt="" src="img/att0.png">
				<img alt="" src="img/att2.png">
			</div>
			<div>
			<c:forEach items="${myAttend }" var="attend">
				<span style ="font-size:2em;font-weight: bold ;">${attend.checkDay }</span>
				<span style ="font-size:2em;font-weight: bold ;">${attend.missDay }</span>
				<span style ="font-size:2em;font-weight: bold ;">${attend.tardy }</span>
			</c:forEach>
			</div>
		</div>
	</div>
	<%@include file="template/footer.jspf" %>
</body>
</html>