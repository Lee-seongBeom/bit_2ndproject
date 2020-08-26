<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비트캠프 제주점 로그인</title>
<%@ include file="../template/head.jspf" %>
<%@ include file="../template/header.jspf" %>

<script type="text/javascript">
	
	function idIn(){	// id input focusin
		$('#id').focusin(function(){
			if($(this).val()=='아이디를 입력하세요'){
				$(this).val('');
			}
		});
	}
	
	function idOut(){	// id input focusout
		$('#id').focusout(function(){
			if($(this).val()==''){
				$(this).val('아이디를 입력하세요');
				
			}
		});
	}
	
	function pwIn(){	// pw input focusin
		$('#pw').focusin(function(){
			if($(this).val()=='비밀번호를 입력하세요'){
				$(this).val('');
			}
		});
	}
	
	function pwOut(){	// pw input focusout
		$('#pw').focusout(function(){
			if($(this).val()==''){
				$(this).val('비밀번호를 입력하세요');
				
			}
		});
	}
	
	function nameIn(){	// name input focusin
		$('#name').focusin(function(){
			if($(this).val()=='이름을 입력하세요'){
				$(this).val('');
			}
		});
	}
	
	function nameOut(){	// name input focusout
		$('#name').focusout(function(){
			if($(this).val()==''){
				$(this).val('이름을 입력하세요');
				
			}
		});
	}
	
	function phoneNumberIn(){	// phoneNumber input focusin
		$('#phoneNumber').focusin(function(){
			if($(this).val()=='전화번호를 입력하세요'){
				$(this).val('');
			}
		});
	}
	
	function phoneNumberOut(){	// phoneNumber input focusout
		$('#phoneNumber').focusout(function(){
			if($(this).val()==''){
				$(this).val('전화번호를 입력하세요');
				
			}
		});
	}
	
	
	
	$(document).ready(function(){
		
		idIn();
		idOut();
		pwIn();
		pwOut();
		nameIn();
		nameOut();
		phoneNumberIn();
		phoneNumberOut();
		
		/* 4자이상 8자이하로 입력해주세요 */
		/* $('#id').after('<span>영문으로만 6자이상 12자이하로 입력해주세요</span>'); */
	});

</script>
<style type="text/css">
	#content > h1{
		text-align:center;
		margin: 50px auto 50px auto;
	}
	#content > h1:first-letter { 
		font-size: 45px;
		border-top: 3px solid blue;
		padding-top: 2px;
	}
	
	#content {
		text-align: center;
		margin-top: 50px;
		margin-left: -50px;
	}
	
	#logo1 {
		width: 100%;
		margin-bottom: 70px;
	}
	
	#name, #id, #pw, #phoneNumber {
		width: 350px;
		height: 30px;
		padding-left: 20px;
		color: #999;
		box-sizing: border-box;
		border: 1px solid #dadada;
		margin-bottom: 20px;
		display: inline-block;
		font-size: 15px;
		padding-top: -10px;
	}
	
	div label {
		width: 100px;
		height: 50px;
		margin-bottom: 20px;
		display: inline-block;
		text-align: center;
		font-size: 15px;
	}
	
	div button {
		width: 100px;
		height: 50px;
		font-size: 15px;
		text-transform: uppercase;
		letter-spacing: 3px;
		font-weight: 500;
		color: #000;
		background-color: white;
		border: 1px solid lightgray;
		border-radius: 10px;
		transition: all 0.3s ease 0s;
		cursor: pointer;
		outline: none;
	}
	
	div button:hover {
		background-color: gray;
		box-shadow: 0px 15px 20px rgba(100, 100, 100, 0.4);
		color: #fff;
		transform: translateY(-2px);
	}
	
	div button:nth-child(1) {
		margin-right: 30px;
	}
</style>
</head>
<body>
	
		<img id="logo1" alt="" src="<%=root%>/img/sign.PNG"/>
	<div id="content">
	<h1>회원가입</h1>
		<!-- content start -->
		<form method="post" >
			<div>
				<label for="name">이름 </label>
				<input type="text" name="name" id="name" value="이름을 입력하세요"/>
			</div>
			
			<div>
				<label for="id">아이디 </label>
				<input type="text" name="id" id="id" value="아이디를 입력하세요"/>
			</div>
			
			<div>
				<label for="pw">패스워드 </label>
				<input type="password" name="pw" id="pw" value="비밀번호를 입력하세요"/>
			</div>
			
			<div>
				<label for="phoneNumber">전화번호 </label>
				<input type="text" name="phoneNumber" id="phoneNumber" value="전화번호를 입력하세요"/>
			</div>
			
			<div>
				<button type="submit">회원가입</button>
				<button type="reset">취소</button>
			</div>
			

		</form>
		<!-- content end -->
	</div>

<%@ include file="/template/footer.jspf" %>
</body>
</html>