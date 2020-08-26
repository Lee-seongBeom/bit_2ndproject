package bitJeju.MyPageController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitJeju.model.Dao;
import bitJeju.model.StudyGroupDto;

@WebServlet("/myPageAttend.jb")
public class MyPageAttendController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setCharacterEncoding("utf-8");
		try {
			int hakbun=Integer.parseInt(request.getParameter("idx"));
			Dao dao=new Dao();
			ArrayList<StudyGroupDto> bean=dao.stuatt(hakbun);
			request.setAttribute("myAttend", hakbun);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("myPageAttend.jsp").forward(request, response);

	}

}
