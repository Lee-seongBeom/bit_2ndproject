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
	#content > h1{
		text-align: center;
		margin: 50px auto 30px auto;
	}
	#content > h1:first-letter { 
		font-size: 45px;
		border-top: 3px solid blue;
		padding-top: 2px;
	}
	#num, #cnt {
		width:70px;
	}
	#title{
		width:400px;
	}
	#name{
		width:120px;
	}
	#date{
		width:200px;
	}
	#content{
		text-align:center;
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
	    margin-left: 795px;
    }
    #searchBtn{
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
    }
    #searchText {
    	height: 25px;
    }
</style>
</head>
<body>
	<%@ include file="/template/header.jspf" %>
	
	<div id="content">
		<!-- content start -->
		<h1>공지사항</h1>
			<button class="button" onclick="location.href='noticeWrite.jb'">글쓰기</button>
		<table>
			<tr>
				<th id="num">글번호</th>
				<th id="title">제목</th>
				<th id="name">작성자</th>
				<th id="date">작성일</th>
				<th id="cnt">조회수</th>				
			</tr>
			<c:forEach var="noticeList" items="${noticeList }">
			<tr>
				<td>${noticeList.noticeNum }</td>
				<td><a href="noticeRead.jb?noticeNum=${noticeList.noticeNum }&pgNum=${pgNum }">${noticeList.title }</a></td>
				<td>${noticeList.writer }</td>
				<td>${noticeList.writedDate }</td>
				<td>${noticeList.cnt }</td>
			<tr>
			</c:forEach>
		</table>
			${pagelist }
	    <form action="noticeList.jb" name="action" method="get">
            <select name="searchType" size="1">
                <option value="title" <c:if test="${'title'==keyField }"> selected</c:if>> 제목 </option>
                <option value="contents" <c:if test="${'contenst'==keyField }"> selected</c:if>> 내용 </option>
                <option value="title_contents" <c:if test="${'title_contents'==keyField }"> selected</c:if>> 제목+내용 </option>
            </select>
                 <input id="searchText" type="text" size="16" name="keyWord" value="${keyWord }">
                 <input id="searchBtn" type="submit" value="검색">
                 <input type="hidden" name="pgNum" value="1">
	    </form> 
			
		<!-- content end -->
	</div>
	
	<%@include file="/template/footer.jspf" %>
	

</body>
</html>