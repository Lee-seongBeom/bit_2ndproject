package bitJeju.NoticeController;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitJeju.model.Dao;

@WebServlet("/jobNoticeWrite.jb")
public class JobNoticeWriteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		req.getRequestDispatcher("jobNoticeWrite.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String title = req.getParameter("title");
		String contents = req.getParameter("contents");
		String company =req.getParameter("company");
		String form = req.getParameter("endDay");
		Date date = Date.valueOf(form);
		try {
			Dao dao = new Dao();
			dao.jobNoticeWrite(title,company,contents,date);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		resp.sendRedirect("jobNoticeList.jb");
		System.out.println("sending ok");
	}
	
	
	
}
