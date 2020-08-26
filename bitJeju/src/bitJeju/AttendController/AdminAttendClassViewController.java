package bitJeju.AttendController;

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

@WebServlet("/adminAttendClassView.jb")
public class AdminAttendClassViewController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("adminAttendClassView.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dao dao;
		int a = Integer.parseInt(request.getParameter("class11"));
		System.out.println("class123"+a);
		try {
			dao = new Dao();
			ArrayList<StudyGroupDto> list = dao.attendSelectClass(a);
			request.setAttribute("classList", list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("adminAttendClassView.jsp").forward(request, response);
	}

}
