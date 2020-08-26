package bitJeju.AdminEndClassController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitJeju.model.ClassDto;
import bitJeju.model.Dao;
import bitJeju.model.StudyGroupDto;

@WebServlet("/endClass.jb")
public class EndClassController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Dao dao = new Dao();
			ArrayList<ClassDto> list = dao.endClass();
			System.out.println(list.toString());
			request.setAttribute("endClass", list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("endClass.jsp").forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
			ArrayList<StudyGroupDto> list = new ArrayList<StudyGroupDto>();
			int classCode = Integer.parseInt(request.getParameter("classCode").trim());
			System.out.println(classCode);
			try {
				Dao dao = new Dao();
				dao.tcodeZero(classCode);
				dao= new Dao();
				dao.classEnd(classCode);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			response.sendRedirect("endClass.jb");
	}
}
