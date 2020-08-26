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
	h1{
		width: 500px;
		margin: 50px auto;
		text-align: center;
	}
	#classcode, #name, #java, #web, #framework{
		width:120px;
	}
	#num{
		width: 60px;
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
	<%@ include file="template/myPageMenu.jspf" %>
	
	<!-- content start -->
	<h1>${naming } 수강생의 성적 페이지</h1>
	<div id="content">
		<table>
			<tr>
				<th id="classcode">클래스 코드</th>
				<th id="num">학번</th>
				<th id="name">이름</th>
				<th id="java">자바</th>
				<th id="web">웹</th>
				<th id="framework">프레임워크</th>
			</tr>
			<c:forEach items="${score}" var="abc">
			
				<tr>
					<td>${abc.classCode}</td>
					<td>${abc.hakbun}</td>
					<td>${abc.name}</td>
					<td>${abc.gradeJava}</td>
					<td>${abc.gradeWeb}</td>
					<td>${abc.gradeFrame}</td>
				</tr>
				
			</c:forEach>

		</table>
			
		<!-- content end -->
	</div>
	
	<%@include file="template/footer.jspf" %>
	

</body>
</html>