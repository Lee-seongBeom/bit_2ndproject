<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비트캠프 제주점</title>
<%@ include file="template/head.jspf" %>
<style rel="stylesheet" type="text/css">
   #content > h1{
      text-align: center;
      margin: 50px auto 30px auto;
   }
   #content > h1:first-letter { 
      font-size: 45px;
      border-top: 3px solid blue;
      padding-top: 2px;
   }
   #content{
      text-align: center;
   }
   #classCode, #className, #teacher, #max, #startDay, #endDay, #totalDay, #tcode{
      margin-top : 15px;
      font-size:15px;
   }
   label{
      display: inline-block;
      width: 150px;
      background-color: lightblue;
      padding: 5px;
      margin-right: 30px;
      border: 5px solid white;
      border-radius: 10px;
   }
   input{
      width: 150px;
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
       margin-top:30px;
       cursor: pointer;
       border-radius: 10px;
       text-align: center;
    }
</style>

<script type="text/javascript">

   $(document).ready(function(){
      
   });
</script>
</head>
<body>
   <%@ include file="template/managerheader.jspf" %>
   
   <div id="content">
   <h1>클래스 생성 페이지</h1>
      <!-- content start -->
      <form method="post">
         <div>
            <input type="file" value="파일 선택" name="filePath"/>
         </div>
         <div>
            <label for="className">과정명</label>
            <input type="text" name="className" id="className"/>
         </div>
         <div>
            <label for="teacher">강사명</label>
            <input type="text" name="teacher" id="teacher"/>
         </div>
         <div>
            <label for="tcode">강사코드</label>
            <input type="text" name="tcode" id="tcode"/>
         </div>
         <div>
            <label for="startDay">개강일</label>
            <input type="date" name="startDay" id="startDay"/>
         </div>
         <div>
            <label for="endDay">종강일</label>
            <input type="date" name="endDay" id="endDay"/>
         </div>
         <div>
            <button type="submit">class 생성</button>
         </div>
      </form>
      <!-- content end -->
   </div>
   <%@include file="template/footer.jspf" %>
</body>
</html>