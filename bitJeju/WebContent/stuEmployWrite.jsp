<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	#content{
		width: 830px;
		height: 900px;
		margin: 50px auto;
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
		width: 800px;
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
			<h2>학생취업현황 작성</h2>
			<form action="stuEmployWrite.jb" method="post">
			<div id="title">
			 	제목<input type="text" name="title" />
			</div>
			<div id="area">
				<textarea name="contents" class="contents">${notice.contents }</textarea>
			</div>
			<div id="btn">	
				<button class="button" type="submit">작성</button>
				<button class="button" type="reset">지우기</button>
				<button class="button" onclick="location.href='noticeList.jb'">목록</button>
			</div>
			</form>
		<!-- content end -->
	</div>
	
	<%@include file="/template/footer.jspf" %>
	

</body>
</html>