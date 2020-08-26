package bitJeju.NoticeController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitJeju.model.Dao;
import bitJeju.model.JobNoticeDto;
import bitJeju.model.NoticeDto;

@WebServlet("/jobNoticeRead.jb")
public class JobNoticeReadController extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jobNoticeNum = request.getParameter("jobNoticeNum");
		try {
			Dao dao = new Dao();
			JobNoticeDto jobNoticeDto = null;
			jobNoticeDto = dao.jobNoticeReadByNum(jobNoticeNum);
			request.setAttribute("bean", jobNoticeDto);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/jobNoticeRead.jsp").forward(request, response);
		System.out.println(request.getParameter("edit"));
		
	}

}
