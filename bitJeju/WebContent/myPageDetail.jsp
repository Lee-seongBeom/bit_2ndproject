<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>마이페이지</title>
<%@ include file="template/head.jspf" %>
<%@ include file="template/myPageMenuOption.jspf" %>

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
	
	#myLogo{
		width: 100%;
	}
	
	#content>div{
	}
	
	#content>div>table{
		padding:15px;
		border:1px solid black;
		float: left;
		margin-top:30px;
		margin-left:570px;
		
		border-radius:10px;
	}
	#content>div>table tr>th{
		border-right:1px solid black;
		padding-right: 10px;
		padding-bottom: 10px;
	}
	#content>div>table tr td{
		padding-left: 10px;
	}
	#formTag{
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
	}
</style>
</head>
<body>
	<%@ include file="template/header.jspf" %>
	<img id="myLogo" alt="" src="<%=root %>/img/myPage-logo.PNG"/>

	<%@ include file="template/myPageMenu.jspf" %>
	
	<div id="content">
	<h1>마이페이지</h1>
		<!-- content start -->
		<div>
			<table>
				<form action="myPageDetailChange.jb" method="post">
					<c:forEach var="my" items="${jeongbo}">
						<tr>
							<th>학번</th>
							<td>${my.hakbun }</td>
						</tr>
						<tr>
							<th>이름</th>
							<td>${my.name }</td>
						</tr>

						<tr>
							<th>아이디</th>
							<td>${my.id }</td>
						</tr>

						<tr>
							<th>전화번호</th>
							<td><input type="text" name="phoneNumber" value="${my.phoneNumber }" /></td>
						</tr>

						<tr>
							<th>비밀번호</th>
							<td><input type="password" name="pw" value="${my.pw }" /></td>
						</tr>

						<tr>
							<th>클래스코드</th>
							<td>${my.classCode }</td>
						</tr>

						<tr>
							<th>클래스이름</th>
							<td>클래스이름</td>
						</tr>
					</c:forEach>

					<button type="submit">수정</button>
				</form>
			</table>


		</div>

		<!-- content end -->
	</div>
	
	
	
	<%@include file="template/footer.jspf" %>

</body>
</html>