<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항</title>
<%@ include file="/template/head.jspf"%>
<style type="text/css">
#content {
	text-align: center;
}

#content>h1 {
	text-align: center;
	margin: 50px auto 30px auto;
}

#content>h1:first-letter {
	font-size: 45px;
	border-top: 3px solid blue;
	padding-top: 2px;
}

#content>table {
	margin: 15px auto;
}

#content>table tr>th {
	background-color: lightblue;
	height: 35px;
	border-radius: 20px;
}

#content>table tr>td {
	height: 25px;
	text-align: center;
}

#content>table, #content>table tr>th, #content>table tr>td {
	border-collapse: collapse;
	border: 5px solid white;
}

#content>div>label {
	text-align: center;
}

#num {
	width: 100px;
}

#title {
	width: 300px;
}

#writer, #compony, #endDay {
	width: 150px;
}

button {
	width: 100px;
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
	margin-left: 720px;
}
</style>
</head>
<body>
	<%@ include file="/template/header.jspf"%>

	<div id="content">
		<!-- content start -->
		<h1>채용공고</h1>
		<button onclick="location.href='jobNoticeWrite.jb'">글쓰기</button>
		<table>
			<tr>
				<th id="jobNoticeNum">글번호</th>
				<th id="title">공고명</th>
				<th id="writer">작성자</th>
				<th id="compony">업체명</th>
				<th id="endDay">마감일</th>
			</tr>
			<c:forEach var="bean" items="${jobNotice }">
				<tr>
					<td>${bean.jobNoticeNum}</td>
					<td><a
						href="jobNoticeRead.jb?jobNoticeNum=${bean.jobNoticeNum }">${bean.title }</a></td>
					<td>${bean.writer }</td>
					<td>${bean.company }</td>
					<td>${bean.endDay }</td>
				</tr>
			</c:forEach>
		</table>
		${pagelist }
		<form action="jobNoticeList.jb" name="action" method="get">
			<select name="searchType" size="1">
				<option value="title"
					<c:if test="${'title'==keyField }"> selected</c:if>>제목</option>
				<option value="contents"
					<c:if test="${'contenst'==keyField }"> selected</c:if>>내용
				</option>
				<option value="title_contents"
					<c:if test="${'title_contents'==keyField }"> selected</c:if>>
					제목+내용</option>
			</select> <input id="searchText" type="text" size="16" name="keyWord"
				value="${keyWord }"> <input id="searchBtn" type="submit"
				value="검색"> <input type="hidden" name="pgNum" value="1">
		</form>
		<!-- content end -->
	</div>

	<%@include file="/template/footer.jspf"%>


</body>
</html>