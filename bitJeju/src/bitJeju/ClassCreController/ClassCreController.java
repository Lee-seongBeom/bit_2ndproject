package bitJeju.ClassCreController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitJeju.model.Dao;

@WebServlet("/classCre.jb")
public class ClassCreController extends HttpServlet {
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.getRequestDispatcher("classCre.jsp").forward(request, response);
   
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      response.setCharacterEncoding("euc-kr");
      
      String className = request.getParameter("className").trim();
      String teacher = request.getParameter("teacher").trim();
      String tcode = request.getParameter("tcode").trim();
      Date startDay = Date.valueOf(request.getParameter("startDay").trim());
      Date endDay = Date.valueOf(request.getParameter("endDay").trim());
      String filePath="img/"+request.getParameter("filePath");
      System.out.println("file::"+filePath);

      try {
         Dao dao = new Dao();
         dao.insertClass(className, teacher, tcode, startDay, endDay,filePath);
      } catch (SQLException e) {
         e.printStackTrace();
      }

		PrintWriter out = response.getWriter();
		out.println("<script type=\"text/javascript\" src=\"js/jquery-1.12.4.js\"></script>");
		out.println("<script type=\"text/javascript\" >");
		out.println("$(document).ready(function(){");
		out.println("alert(\"클래스 생성이 완료되었습니다!\");");
		out.println("location.href='subList.jb';");
		out.println("});");
		out.println("</script>");

   }
   

}