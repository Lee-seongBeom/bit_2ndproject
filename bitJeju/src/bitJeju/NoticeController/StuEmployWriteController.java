package bitJeju.NoticeController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitJeju.model.Dao;
import bitJeju.model.StuEmployDto;

@WebServlet("/stuEmployWrite.jb")
public class StuEmployWriteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.getRequestDispatcher("stuEmployWrite.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String title = req.getParameter("title");
		String contents = req.getParameter("contents");
		
		try {
			Dao dao = new Dao();
			dao.stuEmployWrite(title, contents);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		resp.sendRedirect("stuEmployList.jb");
	}
}
