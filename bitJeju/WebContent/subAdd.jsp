<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비트캠프 제주점</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<%@ include file="../template/head.jspf" %>
<style type="text/css">
div>div>div {
	float: flex;
}

#self-1 {
	width: 150px;
	height: 150px;
	float: left;
	margin-right: 10px;
	margin-bottom: 40px;
	margin-left: 200px;
}

#self-2 {
	width: 42%;
	float: left;
	margin-bottom: 40px;
	text-align: left;
}

#id {
	margin-right: 30px;
}
</style>

</head>
<body>
<%@ include file="../template/header.jspf" %>
<div id="content" >
		<!-- content start -->
			<div class="container" align="center">
				
					<h1>국비지원과정</h1>
				<img id="self-1" alt="" src="<%=root %>/img/apply2.jpg">
					<div id="self-2">
					<div><h5>비트캠프 제주지점</h5></div>
					<div>
						<label for="classCode" id="code">클래스코드&nbsp|&nbsp</label>
						<input type="number" name="classCode"/>
					</div>
					<div class="">
						<label for="className" id="code">과정명&nbsp|&nbsp</label>
						<input type="text" name="className"/>
					</div>

					<div>
						<label for="startDay" id="code">개강일&nbsp|&nbsp</label>
						<input type="date" name="startDay"/>
					</div>
					
					<div>
						<label for="endDay" id="code">종료일&nbsp|&nbsp</label>
						<input type="date" name="endDay"/>
					</div>
					
					<div>
						<label for="teacher" id="code">강사명&nbsp|&nbsp</label>
						<input type="text" name="teacher"/>
					</div>
					
					<div>
						<label for="max" id="code" id="code">클래스총원&nbsp|&nbsp</label>
						<input type="number" name="max"/>
					</div>
					
					<div>
						<label for="tcode" id="code">강사코드&nbsp|&nbsp</label>
						<input type="text" name="tcode"/>
					</div>
					
					
						<button><a href="" class="">수강신청</a></button>
					</div>
						  <img src="<%=root %>/img/apply1.jpg" alt="te" align="center">
					</div>
		<!-- content end -->
	</div>
	
	<%@include file="../template/footer.jspf" %>
	

</body>
</html>