package bitJeju.NoticeController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitJeju.model.Dao;
import bitJeju.model.StuEmployDto;

@WebServlet("/stuEmploy.jb")
public class StuEmployListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			Dao dao = new Dao();
			ArrayList<StuEmployDto> list = dao.stuEmploySelectAll();
			req.setAttribute("stuEmploy", list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("stuEmployList.jsp").forward(req, resp);
	}
	
	
	
}
