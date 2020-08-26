<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	#content {
		width: 800px;
		margin: 20px auto;
	}
	#content > h1{
		text-align: center;
		margin: 50px auto 30px auto;
	}
	#content > h1:first-letter { 
		font-size: 45px;
		border-top: 3px solid blue;
		padding-top: 2px;
	}
	#content>table{
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
	#hakbun, #classCode{
		width: 100px;
	}
	#name, #date{
		width: 130px;
	}
	#className {
		width: 350px;
	}
	#assign {
		width:70px;
	}
</style>
</head>
<body>
	<%@ include file="template/managerheader.jspf" %>

	<div id="content">
	<h1>학생배정</h1>
		<!-- content start -->
		<table>
			<tr>
				<th id="hakbun">학번</th>
				<th id="name">이름</th>
				<th id="classCode">클래스 코드</th>
				<th id="className">과정명</th>
				<th id="date">신청날짜</th>
				<th id="assign">승인</th>
			</tr>
			<c:forEach items="${list }" var="bean">
			<tr>
				<td>${bean.hakbun }</td>
				<td>${bean.name }</td>
				<td>${bean.classCode }</td>
				<td>${bean.className }</td>
				<td>${bean.applyDate }</td>
				<td><button type="submit">승인</button></td>
			</tr>
			</c:forEach>
		</table>
		<!-- content end  --> 
	</div>
	<%@include file="template/footer.jspf" %>
</body>
</html>