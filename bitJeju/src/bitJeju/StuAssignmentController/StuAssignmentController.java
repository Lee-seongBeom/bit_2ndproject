package bitJeju.StuAssignmentController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitJeju.model.Dao;
import bitJeju.model.StuAssignmentDto;

@WebServlet("/stuAssignment.jb")
public class StuAssignmentController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		try {
			Dao dao = new Dao();
			ArrayList<StuAssignmentDto> list = dao.stuAssignmentSelect();
			request.setAttribute("list", list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("stuAssignment.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}