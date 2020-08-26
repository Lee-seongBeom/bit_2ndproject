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
import bitJeju.model.StudentDto;
import bitJeju.model.StudyGroupDto;

@WebServlet("/attendClassView.jb")
public class AttendClassViewController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("checkget");
		request.getRequestDispatcher("attendClassView.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("checkpost");
		Dao dao;
		int a = Integer.parseInt(req.getParameter("class123"));
		System.out.println("class123"+a);
		try {
			dao = new Dao();
			ArrayList<StudyGroupDto> list = dao.attendSelectClass(a);
			req.setAttribute("attendSelectClass", list);
			req.setAttribute("class123", a);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("attendClassView.jsp").forward(req, resp);
		
	}

}
