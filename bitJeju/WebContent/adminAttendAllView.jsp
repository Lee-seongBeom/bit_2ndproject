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
	#name, #rate,#classCode, #hakbun {
		width:120px;
	}
	#className{
		width:380px;
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
	#checkbox{
		text-align: center;
	}
	select{
		display: inline-block;
		width: 100px;
		height: 32px;
		text-align:center;
	}
	
	button{
		width:50px;
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
<script type="text/javascript"src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
	<%@ include file="template/managerheader.jspf" %>
	<div id ="content">
		<h1>학생 출결관리</h1>
		<div id="checkbox">
			<form action="adminAttendClassView.jb" method="post">
				<select name="class11">
					<option value="1">1반</option>
					<option value="2">2반</option>
					<option value="3">3반</option>
				</select>
				<button type="submit">설정</button>
			</form>
			</div>
		<table>
			<tr>
				<th id="classCode">클래스코드</th>
				<th id="className">과정명</th>
				<th id="hakbun">학생번호</th>
				<th id="name">이름</th>
				<th id="rate">출결(%)</th>
			</tr>
			
			<c:forEach items="${attend }" var="list">
		         <tr>
		            <td>${list.classCode }</td>      
		            <td>${list.className }</td>      
		            <td>${list.hakbun }</td>      
		            <td>${list.name }</td>         
		            <td>${list.rate }</td>
		         </tr>
	         </c:forEach>
		</table>
	</div>
	<%@include file="template/footer.jspf" %>
</body>
</html>