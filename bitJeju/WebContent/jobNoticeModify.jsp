<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비트캠프 제주점</title>
<%@ include file="/template/head.jspf" %>
<style type="text/css">
		#content > h2{
		margin: 50px auto 10px auto;
	}
	#content > h2:first-letter { 
		font-size: 35px;
		border-top: 3px solid blue;
		padding-top: 2px;
	}
	h1 + div{
		widt: 830px;
	}
	#content{
		width: 830px;
		height: 900px;
		margin: 50px auto;
	}
	#title{
		width: 800px;
	}
	button{
	    width:80px;
	    background-color: royalblue;
	    border: none;
	    color: white;
	    padding: 7px 0px;
	    text-align: center;
	    text-decoration: none;
	    display: inline-block;
	    font-size: 15px;
	    cursor: pointer;
	    border-radius: 10px;
	    margin-left: 5px;
	}
	#title{
		line-height: 80px;
		padding-left: 30px;
		font-size: 22px;
		border-top: 1px solid black;
		background-color: #F0FFFF;
	}
	#title > input {
		width: 700px;
		height: 30px;
		margin-left: 40px;
		padding-top: 5px;
		font-size: 17px;		
	}
	#intro{
		width: 800px;
		line-height: 50px;
		padding-left: 30px;
		border-top: 1px solid lightgray;
		border-bottom: 1px solid lightgray;
	}
	#cont {
		width: 800px;
		height: 400px;
		padding: 30px 20px 30px 20px;
		border-bottom: 1px solid lightgray;
		margin-bottom: 10px;
	}
	#writer{
		float:left;
	}
	#date {
		margin-left: 60px;
	}
	#cnt{
		float: right;
		margin-right: 30px;
	}
	#btn{
		text-align:right;
		margin-right: 10px;
	}
	#area > textarea{
		width: 780px;
		height: 450px;
		margin: 10px 10px;
		margin-top: 30px;
		padding: 15px 15px;
	}
</style>
</head>
<body>
	<%@ include file="/template/header.jspf" %>
	<div id="content">
		<!-- content start -->
			<h2>채용공고 수정페이지</h2>
			<form action="jobNoticeModify.jb" method="post">
			<div id="title">
			 	제목<input type="text" name="title" value="${bean.title }" />
			</div>
			<div id="intro">		
				<span id="writer">작성자 | ${bean.writer }</span>
				<span id="date"></span>
				<span id="cnt">조회수   ${bean.endDay }</span>
			</div>
			<div id="area">
				<textarea name="contents" class="contents">${bean.contents }</textarea>
			</div>
			<div id="btn">	
				<button type = "submit">작성</button>
				<button type = "button" onclick ="location.href='jobNoticeList.jb'">목록</button>
			</div>
			</form>
		<!-- content end -->
	<%-- </div>
	<div id="content">
		<!-- content start -->
			<form action="jobNoticeModify.jb" method="post">
					<input type="text" name="title"	value="${bean.title }" />
					</br>
					<span>작성자</span><span>${bean.writer }</span>
					<span>마감일</span><span>${bean.endDay }</span>
				
					<textarea type="text" name="contents" class="contents" cols="" rows="" style="resize : none">${bean.contents }</textarea>
				<button type = "submit">작성</button>
				<button type = "button" onclick ="location.href='jobNoticeList.jb'">목록</button>
			</form>
		<!-- content end -->
	</div> --%>
	
	<%@include file="/template/footer.jspf" %>
	

</body>
</html>