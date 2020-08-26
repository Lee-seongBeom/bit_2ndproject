<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비트캠프 제주점</title>
<%@ include file="template/head.jspf" %>
<style rel="stylesheet" type="text/css">
	#content > h1{
		text-align:center;
		margin: 50px auto 30px auto;
	}
	#content > h1:first-letter { 
		font-size: 45px;
		border-top: 3px solid blue;
		padding-top: 2px;
	}
	#className{
		width: 230px;
	}
	#classCode, #name, #java, #web, #framework{
		width:120px;
	}
	#num{
		width: 60px;
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
	    margin-left:930px;
	}
</style>
<script type="text/javascript"src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	//var text = document.getElementById("input:text").value;
	//console.log(text);
	var listSize = document.getElementById("listSize").value;
	listSize=Number(listSize);
	//listSize++;
	var tmpStr = "";
	var test;
	var j;
	for(var i=1; i<listSize+1;i++){
		tmpStr = "java"+i;
		$("input[name="+tmpStr+"]").on("keyup", function() {
		    $(this).val($(this).val().replace(/[^0-9]/g,""));
		});
		test = $("input[name="+tmpStr+"]").val();
		if(test == "0" || test == "-1"){
			$("input[name="+tmpStr+"]").val("");
		}

		tmpStr = "web"+i;
		$("input[name="+tmpStr+"]").on("keyup", function() {
		    $(this).val($(this).val().replace(/[^0-9]/g,""));
		});
		test = $("input[name="+tmpStr+"]").val();
		if(test == "0" || test == "-1"){
			$("input[name="+tmpStr+"]").val("");
		}
		tmpStr = "frame"+i;
		$("input[name="+tmpStr+"]").on("keyup", function() {
		    $(this).val($(this).val().replace(/[^0-9]/g,""));
		});
		test = $("input[name="+tmpStr+"]").val();
		if(test == "0" || test == "-1"){
			$("input[name="+tmpStr+"]").val("");
		}

	}//main for
	 $(':button:submit').click(function() {
	   	for(var i=1; i<listSize+1;i++){
			tmpStr = "java"+i;
			test = $("input[name="+tmpStr+"]").val();
			if(test == ""){
				$("input[name="+tmpStr+"]").val("-1");
				$("input[name="+tmpStr+"]").prop('type', 'hidden');
			}
	
			tmpStr = "web"+i;
			test = $("input[name="+tmpStr+"]").val();
			if(test == ""){
				$("input[name="+tmpStr+"]").val("-1");
				$("input[name="+tmpStr+"]").prop('type', 'hidden');
			}
			tmpStr = "frame"+i;
			test = $("input[name="+tmpStr+"]").val();
			if(test == ""){
				$("input[name="+tmpStr+"]").val("-1");
				$("input[name="+tmpStr+"]").prop('type', 'hidden');
			}
		}
	 });
});


</script>
</head>
<body>
	<%@ include file="template/managerheader.jspf" %>
	
	<!-- content start -->
	<div id="content">
	<h1>${classCode }반 학생 성적입력</h1>
		<table>
			<tr>
				<th id="classCode">클래스 코드</th>
				<th id="className">과정명</th>
				<th id="num">학번</th>
				<th id="name">이름</th>
				<th id="java">자바</th>
				<th id="web">웹</th>
				<th id="framework">프레임워크</th>
			</tr>
			
			<form name="frm" action="score.jb" method="post">
				<c:forEach items="${clList}" var="bean" varStatus="status">
				<c:set var="listSize" value="${status.count}"/>
					<tr id="student">
						<td>${bean.classCode}</td>
						<td>${bean.className}</td>
						<td><input type="hidden" name="hakbun${bean.hakbun }" value="${bean.hakbun }"/>${bean.hakbun}</td>
						<td>${bean.name}</td>
						<td><input type="text"  name="java${bean.hakbun }" id="gradeJava" value="${bean.gradeJava }"/></td>
						<td><input type="text"  name="web${bean.hakbun }" id="gradeWeb" value="${bean.gradeWeb }"/></td>
						<td><input type="text"  name="frame${bean.hakbun }" id="gradeFrame" value="${bean.gradeFrame }"/></td>
					</tr>
				</c:forEach>
				<input type="hidden"  id="listSize" value="<c:out value='${listSize }'/>">
				<button type="submit">입력완료</button>
			</form>
		</table>
			
		<!-- content end -->
	</div>
	
	<%@include file="template/footer.jspf" %>
	

</body>
</html>