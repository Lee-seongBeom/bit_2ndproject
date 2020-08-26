<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비트캠프 제주점</title>
<%@ include file="template/head.jspf" %>
<%@ include file="template/myPageMenuOption.jspf" %>

<style rel="stylesheet" type="text/css">
	#content > h1{
		margin: 50px auto 30px auto;
	}
	#content > h1:first-letter { 
		font-size: 45px;
		border-top: 3px solid blue;
		padding-top: 2px;
	}
	#name, #mark{
		width:120px;
	}
	#num{
		width: 80px;
	}
	#classCode{
		width: 100px;
	}
	
	#className{
		width: 250px;
	}
	.term{
		width: 180px;
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
</style>
</head>
<body>
	<%@ include file="template/header.jspf" %>
	<img id="myLogo" alt="" src="<%=root %>/img/myPage-logo.PNG"/>
	<%@ include file="template/myPageMenu.jspf" %>

	<div id="content">
		<c:forEach items="${sg}" var="sg">
			<h1>${sg.name} 회원님의수강신청현황</h1>
		<!-- content start -->

		<table>
			<tr>
				<th id="classCode">클래스 코드</th>
				<th id="num">학번</th>
				<th id="className">과정명</th>
				<th class="term">강의시작</th>
				<th class="term">강의종료</th>
				<th id="mark">상태</th>
			</tr>
			<tr id="student">
				<td>${sg.classCode}</td>
				<td>${sg.hakbun}</td>
				<td>${sg.className}</td>
				<td>${sg.startDay }</td>
				<td>${sg.endDay }</td>
				<td>수강신청 완료</td>
			</tr>
		</table>

		</c:forEach>
		<!-- content end -->
	</div>

	<%@include file="template/footer.jspf" %>
	

</body>
</html>