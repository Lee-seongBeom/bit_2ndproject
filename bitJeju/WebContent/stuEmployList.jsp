<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항</title>
<%@ include file="/template/head.jspf" %>
<style type="text/css">
	#content {
		text-align:center;
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
	#content>div>label{
		text-align: center;	
	}
	#num {
		width: 100px;
	}
	#title{
		width: 300px;
	}
	#writer, #writeDate{
		width: 180px;
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
	    margin-left: 680px;
	}
</style>
</head>
<body>
	<%@ include file="/template/header.jspf" %>
	
	<div id="content">
		<!-- content start -->
		<h1>학생취업현황</h1>
		<div class="navigator">
			<button class="button" onclick="location.href='stuEmployWrite.jb'">글쓰기</button>
		</div>		
		<table>
			<tr>
				<th id="num">글번호</th>
				<th id="title">제목</th>
				<th id="writer">작성자</th>
				<th id="writeDate">작성일</th>
			</tr>
			<c:forEach var="bean" items="${stuEmploy }">
			<tr>
				<td>${bean.stuEmployNum }</td>
				<td><a href="stuEmployRead.jb?stuEmployNum=${bean.stuEmployNum }">${bean.title }</a></td>
				<td>${bean.writer }</td>
				<td>${bean.writedDate }</td>
			</tr>
			</c:forEach>
		</table>
		<%-- <p>${work }</p>
		<p>${stuEmploy }</p> --%>
		<!-- content end -->
	
	</div>
	
	<%@include file="/template/footer.jspf" %>
	

</body>
</html>