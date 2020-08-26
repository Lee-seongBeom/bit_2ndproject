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


@WebServlet("/adminAttendAllView.jb")
public class AdminAttendAllViewController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		try {
			Dao dao=new Dao();
			ArrayList<StudyGroupDto> list = dao.adminatt();
			req.setAttribute("attend", list);
			System.out.println(list.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("adminAttendAllView.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int a = Integer.parseInt(req.getParameter("class11"));
		try {
			Dao dao = new Dao();
			ArrayList<StudyGroupDto> list = dao.attendSelectClass(a);
			req.setAttribute("classList", list);
			req.setAttribute("class11", a);
			req.getRequestDispatcher("adminAttendAllView.jsp").forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
	}

}
