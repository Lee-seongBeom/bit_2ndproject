<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="template/head.jspf" %>
<title>Insert title here</title>
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
	#classCode, #hakbun, #stuCheck{
		width:100px;
	}
	#name, #nalja{
		width: 150px;
	}
	#className{
		width: 300px;
	}
	#content{
		
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
	#content>div>label{
		text-align: center;	
	}
	select{
		display: inline-block;
		width: 100px;
		height: 32px;
		text-align:center;
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
	    cursor: pointer;
	    border-radius: 10px;
	    margin-left: 840px;
	}
	#back{
		text-align:center;
	}
</style>
<script type="text/javascript"src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">
	function back(){
		window.history.back();
	}
</script>
</head>
<body>
	<%@ include file="template/managerheader.jspf" %>
		<div id="content">
		<c:forEach items="${classByDate }" begin="0" end="0" var="bean">
		<h1>${bean.classCode } 반 출석현황 ( ${bean.nalja } )</h1>
		</c:forEach>
			<div id="back">
				<button type="button" onclick="back();">뒤로가기</button>
			</div>
			<table>
				<tr>
					<th id="classCode">클래스코드</th>
					<th id="className">과정명</th>
					<th id="hakbun">학생번호</th>
					<th id="name">이름</th>
					<th id="nalja">날짜</th>
					<th id="stuCheck">출결</th>
				</tr>
				
				<c:forEach items="${classByDate }" var="bean">
					<tr>
						<td>${bean.classCode }</td>		
						<td>${bean.className }</td>		
						<td>${bean.hakbun }</td>		
						<td>${bean.name }</td>	
						<td>${bean.nalja }</td>	
						<td>${bean.stuCheck }</td>	
					</tr>
				</c:forEach>
					
			</table>
		<br/><br/>
	</div>
	<%@include file="template/footer.jspf" %>
</body>
</html>