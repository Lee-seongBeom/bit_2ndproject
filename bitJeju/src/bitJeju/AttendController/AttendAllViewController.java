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


@WebServlet("/attendAllView.jb")
public class AttendAllViewController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("check");
		try {
			Dao dao = new Dao();
			ArrayList<StudyGroupDto> list = dao.attendSelectAll();
			request.setAttribute("attendSelectAll", list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("attendAllView.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int a = Integer.parseInt(req.getParameter("class123"));
		
		try {
			Dao dao = new Dao();
			ArrayList<StudyGroupDto> list = dao.attendSelectAll();
			req.setAttribute("attendSelectAll", list);
			req.setAttribute("class123", a);
			System.out.println("123123"+a);
		}catch (SQLException e){
			e.printStackTrace();
		}
		req.getRequestDispatcher("attendAllView.jsp").forward(req, resp);
		
		
		
	}
	

}
