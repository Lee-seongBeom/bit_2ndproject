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
import bitJeju.model.JobNoticeDto;

@WebServlet("/jobNoticeList.jb")
public class JobNoticeListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			Dao dao = new Dao();
			ArrayList<JobNoticeDto> list = dao.jobNoticeSelectAll();
			req.setAttribute("jobNotice", list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("jobNoticeList.jsp").forward(req, resp);
	}
}
