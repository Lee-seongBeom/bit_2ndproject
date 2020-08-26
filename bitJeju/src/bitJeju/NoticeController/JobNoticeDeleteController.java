package bitJeju.NoticeController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitJeju.model.Dao;
import bitJeju.model.NoticeDto;

/**
 * Servlet implementation class noticeDelete
 */
@WebServlet("/jobNoticeDelete.jb")
public class JobNoticeDeleteController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String jobNoticeNum = request.getParameter("jobNoticeNum");
	
	Dao dao = null;
	try {
		dao = new Dao();
		dao.jobNoticeDelete(jobNoticeNum);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	request.getRequestDispatcher("/jobNoticeList.jb").forward(request, response);
	
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
