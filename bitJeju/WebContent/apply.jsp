<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비트캠프 제주점</title>
<%@ include file="template/head.jspf" %>
<style rel="stylesheet" type="text/css">
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
		margin: 50px auto;
	}
	#content>table tr>th{
		height:35px;
        border: 5px solid white; 
        background-color: lightblue;
        border-radius: 20px;
	}
	#content>table tr>td{
		height: 25px;
		text-align: center;
	}
	#content>table,#content>table tr>th,#content>table tr>td{
        border-collapse: collapse; 
	}
	#no, #name, #classCode{width:100px;}
	#sysdate, #startDay, #endDay{width:130px;}
	#className{width:230px;}
</style>
</head>
<body>
	<%@ include file="template/header.jspf" %>
	
	<div id="content">
	<h1>수강신청 현황</h1>
		<!-- content start -->
		<table>
			<tr>
				<th id="no">No</th>
				<th id="sysdate">신청일자</th>
				<th id="name">학생이름</th>
				<th id="classCode">클래스 코드</th>
				<th id="className">과정명</th>
				<th id="startDay">개강일</th>
				<th id="endDay">종강일</th>
			</tr>
		
			<tr>
				<td>1</td>
				<td>sysdate</td>
				<td>오영문</td>
				<td>1</td>
				<td>NCS기반의 웹 개발자 과정</td>
				<td>20/08/01</td>
				<td>20/10/31</td>
			</tr>

		</table>
		
		
		<!-- content end -->
	</div>
	
	<%@include file="template/footer.jspf" %>
	

</body>
</html>