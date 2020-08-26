<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비트캠프 제주점</title>
<script type="text/javascript">

</script>
	
<%@ include file="template/head.jspf" %>
<style type="text/css">
	#content > h1{
		margin: 50px auto 70px auto;
		}
	#content > h1:first-letter { 
		font-size: 45px;
		border-top: 3px solid blue;
		padding-top: 2px;
	}
	#classcode, #teacher,#tcode{
		width:120px;
	}
	#startdate,#enddate{
		width: 200px;
	}
	#classname{
		width: 380px;
		}
	#content{
		text-align: center;
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
	    cursor: pointer;
	    border-radius: 10px;
	    margin-left: 1100px;
	}
</style>
<script type="text/javascript">
</script>
</head>
<body>
<%@ include file="template/managerheader.jspf" %>
	
	<!-- content start -->
	<div id="content">
	<h1>종강</h1>
	<table>
	<tr>
		<th id="set">선택</th>
		<th id="classcode">클래스코드</th>
		<th id="classname">과정명</th>
		<th id="teacher">강사명</th>
		<th id="tcode">강사코드</th>
		<th id="startdate">개강일</th>
		<th id="enddate">종강일</th>
	</tr>
	<form action="endClass.jb" method="post">
	<c:forEach items="${endClass }" var="list">
	<tr>
		<td>
			<input type="radio" name="classCode" value="${list.classCode }"/>
		</td>
		<td>${list.classCode }</td>
		<td>${list.className }</td>
		<td>${list.teacher }</td>
		<td>${list.tcode }</td>
		<td>${list.startDay }</td>
		<td>${list.endDay }</td>
	</tr>
	</c:forEach>
	<button type="submit">종 강</button>
	</form>
	</table>
	<!-- content end -->
	</div>
</body>
<%@include file="template/footer.jspf" %>
</html>