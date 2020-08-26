<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비트캠프 제주점 로그인</title>
<%@ include file="../template/head.jspf"%>
<%@ include file="../template/header.jspf"%>

<script type="text/javascript">

	function idIn() { // id input focusin
		$('#id1').focusin(function() {
			if ($(this).val() == '아이디를 입력하세요') {
				$(this).val('');
			}
		});
	}

	function idOut() { // id input focusout
		$('#id1').focusout(function() {
			if ($(this).val() == '') {
				$(this).val('아이디를 입력하세요');

			}
		});
	}

	function pwIn() { // pw input focusin
		$('#pw1').focusin(function() {
			if ($(this).val() == '비밀번호를 입력하세요') {
				$(this).val('');
			}
		});
	}

	function pwOut() { // pw input focusout
		$('#pw1').focusout(function() {
			if ($(this).val() == '') {
				$(this).val('비밀번호를 입력하세요');
			}
		});
	}

	$(document).ready(function() {

		idIn();
		idOut();
		pwIn();
		pwOut();
		

		/* 4자이상 8자이하로 입력해주세요 */
		/* $('#id').after('<span>영문으로만 6자이상 12자이하로 입력해주세요</span>'); */
	});
</script>
<style type="text/css">
	
	#logo1 {
		width:100%;
		margin-bottom:70px;

	}
	
	body>div{
		text-align: center;
	}	
	.id, .pw {
		width: 100px;
		height: 50px;
		margin-bottom : 20px;
		display: inline-block;
		text-align: center;
		font-size: 20px;
	}
	
	#id1, #pw1 {
		width: 350px;
		height: 40px;
		padding-left: 20px;
		margin-left:-50px;
		color: #999;
		box-sizing: border-box;
		border: 1px solid #dadada;
		margin-bottom: 20px;
		display: inline-block;
		font-size: 20px; 
		padding-top: -10px;
	}
	
	.btn{
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
	.btn:hover {
		background-color: gray;
		box-shadow: 0px 15px 20px rgba(100, 100, 100, 0.4);
		color: #fff;
		transform: translateY(-2px);
	}
	
	.btn:nth-child(1){
		margin-top:20px;
		margin-bottom: 50px;
		margin-right: 30px;
		margin-left: 30px;
	
	}
	
	#loginimg,#pwimg{
		width: 30px;
		margin-right: 20px;
		padding-top: 10px;
	}
	
	#content div{
		text-align: center;
		margin-left: -50px;
	}
	#content > h1{
		margin-bottom:40px;
	}
	#content > h1:first-letter { 
		border-top: 3px solid blue;
		font-size: 45px;
		padding-top:2px;
	}
</style>
</head>
<body>

	<div>
		<img src="./img/ab.PNG" alt="te" id="logo1" />
	</div>
	<div id="content">
	<h1>로그인</h1>
		<!-- content start -->
		<form action="login.jb" method="post">

			<div>
				<label for="id" class="id"><div><img id="loginimg" alt="" src="<%=root%>/img/loginicon.png"/></div></label> 
				<input type="text" name="id" id="id1" value="아이디를 입력하세요" />
			</div>

			<div>
				<label for="pw" class="pw"><div><img id="pwimg" alt="" src="<%=root%>/img/passwordicon.png"/></div></label> 
				<input type="password" name="pw" id="pw1" value="비밀번호를 입력하세요" />
			</div>

			<div>
				<button type="submit" class="btn">로그인</button>
				<button type="button" class="btn" onclick="location.href='signUp.jb'">회원가입</button>
			</div>

		</form>
		<!-- content end -->
	</div>

	<%@ include file="/template/footer.jspf"%>
</body>
</html>