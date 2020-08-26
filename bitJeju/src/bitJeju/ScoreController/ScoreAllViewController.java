package bitJeju.ScoreController;

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

@WebServlet("/scoreAllView.jb")
public class ScoreAllViewController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("check");
		try {
			Dao dao = new Dao();
			ArrayList<StudyGroupDto> list = dao.scoreSelectAll();
			request.setAttribute("scoreAllView", list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("scoreAllView.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int a = Integer.parseInt(req.getParameter("class123"));
		
		try {
			Dao dao = new Dao();
			ArrayList<StudyGroupDto> list = dao.scoreSelectClass(a);
			req.setAttribute("scoreClassView", list);
			req.setAttribute("class123", a);
			req.getRequestDispatcher("scoreAllView.jsp").forward(req, resp);
			System.out.println("123123"+a);
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		
		
	}
	

}
