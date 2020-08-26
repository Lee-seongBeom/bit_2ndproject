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
		margin: 50px auto 5px auto;
	}
	#content > h1:first-letter { 
		font-size: 45px;
		border-top: 3px solid blue;
		padding-top: 2px;
	}
	body p{
		text-align:center;
		margin-bottom: 50px;
	}
	#classCode, #hakbun{
		width:100px;
	}
	#stuCheck{
		width:250px;
	}
	#name{
		width: 150px;
	}
	#nalja{
		height: 30px;
		width: 170px;
	}
	#className{
		width: 300px;
	}
	#content{
		text-align:center;
	}
	#content table{
		margin: 15px auto;
	}
	#content table tr>th{
		background-color: lightblue;
		height: 35px;
	    border-radius: 20px;
	}
	#content table tr>td{
		height: 25px;
		text-align: center;
	}
	#content table,#content table tr>th,#content table tr>td{
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
	}
	#checkDate{
		text-align:center;
	}
	#checkDate > select{
		width:150px;
		text-align:center;
	}
	#back{
	    margin-left:570px;
		
	}
	#content>#insert{
		text-align:center;		
	}
</style>
<script type="text/javascript"src="js/jquery-1.12.4.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		// 날짜 default 값을 오늘 날짜로 설정 
        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth()+1; // 1월 = 0
        var yyyy = today.getFullYear();
 
        if(dd<10){
            dd = '0'+dd
        }
        if(mm<10){
            mm = '0'+mm
        }
        today = yyyy + '-' + mm + '-' + dd;
		
		//document.getElementById('nalja').value = new Date().toISOString().substring(0, 10);
		document.getElementById('nalja').value = today;
		
		// radio박스 모두 체크할 시에만 입력버튼 활성화하기 위한 초기 설정 (비활성화,버튼컬)
		$('#insert').prop('disabled', true);
		$('#insert').css('background-color','lightgray');
		
		
		var listSize = document.getElementById("listSize").value;//list의 size를 반환한다(즉, 학생수)
		
	$("input:radio").change(function () {//라디오 선택 작업이 이루어질 때마다 작동된다.
            var checked = $("input:radio:checked");
            var checkedNum = Number(checked.length);//체크된 항목의 총 개수를 반환
            if(listSize==checkedNum){
                $('#insert').prop('disabled', false);
                $('#insert').css('background-color','royalblue');
            }else{
            }
      });
	
	});
	function goBack(){
			window.history.back();
	}
</script>
</head>
<body>
	<%@ include file="template/managerheader.jspf" %>
		<div id="content">
		<c:forEach items="${list }" begin="0" end="0" var="bean">
			<h1>${bean.classCode } 반 출석 입력 페이지</h1>
		</c:forEach>
		<p>* 체크박스를 모두 체크할 시에 입력완료 버튼이 활성화 됩니다.</p>
		<form action="attendanceInput.jb" method="post">
			<div id="checkDate">
				<label for="nalja">&nbsp;&nbsp;입력할 날짜</label>
				<input type="date" name="nalja" id="nalja" readonly="readonly"/>
				<button id="back" type="button" onclick="goBack();">뒤로가기</button>
			</div>
		<table>
			<tr>
				<th id="classCode">클래스코드</th>
				<th id="className">과정명</th>
				<th id="hakbun">학생번호</th>
				<th id="name">이름</th>
				<th id="stuCheck">출결</th>
			</tr>
			
			<c:forEach items="${list }" var="bean" varStatus="status">
			<c:set var="listSize" value="${status.count}"/>
				<tr>
					<td><input type="hidden" name="classCode${bean.hakbun }" value="${bean.classCode }"/> ${bean.classCode }</td>		
					<td><input type="hidden" name="className${bean.hakbun }" value="${bean.className }"/> ${bean.className }</td>		
					<td><input type="hidden" name="hakbun${bean.hakbun }" value="${bean.hakbun }"/> ${bean.hakbun }</td>		
					<td><input type="hidden" name="name${bean.hakbun }" value="${bean.name }" /> ${bean.name }</td>	
					<td class="rara">
						<input type="radio" name="stuCheck${bean.hakbun }" value="출석" <c:if test="${bean.stuCheck eq '출석'}">checked</c:if> /><label> 출석</label>&nbsp;&nbsp;&nbsp;
						<input type="radio" name="stuCheck${bean.hakbun }" value="결석" <c:if test="${bean.stuCheck eq '결석'}">checked</c:if>/><label> 결석</label>&nbsp;&nbsp;&nbsp;
						<input type="radio" name="stuCheck${bean.hakbun }" value="지각" <c:if test="${bean.stuCheck eq '지각'}">checked</c:if>/><label> 지각</label>
					</td>
				</tr>
			</c:forEach>
		</table>
			<button id="insert" type="submit">입력완료</button>
			<input type="hidden"  id="listSize" value="<c:out value="${listSize }"/>">
		</form>
		<br/><br/>
	</div>
	<%@include file="template/footer.jspf" %>
</body>
</html>