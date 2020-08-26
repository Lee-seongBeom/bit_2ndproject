package bitJeju.MyPageController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bitJeju.model.Dao;
import bitJeju.model.StudentDto;

@WebServlet("/myPageDetailChange.jb")
public class MyPageDetailChangeController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("euc-kr");
		
		String pw=req.getParameter("pw").trim();
		String phoneNumber=req.getParameter("phoneNumber").trim();
		
		HttpSession session= req.getSession(false);
		StudentDto bean=(StudentDto)session.getAttribute("sbean");
		String id=bean.getId();
		try {
			Dao dao=new Dao();
			dao.myPageModify(pw, phoneNumber, id);
			System.out.println(id);
			PrintWriter out = resp.getWriter();
			out.println("<script type=\"text/javascript\" src=\"js/jquery-1.12.4.js\"></script>");
			out.println("<script type=\"text/javascript\" >");
			out.println("$(document).ready(function(){");
			out.println("alert(\"정보가 수정되었습니다. \\n다시 로그인해주세요. \");");
			out.println("location.href='login.jb';");
			out.println("});");
			out.println("</script>");
			req.getSession().invalidate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
