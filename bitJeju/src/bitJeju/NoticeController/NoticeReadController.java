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

@WebServlet("/noticeRead.jb")
public class NoticeReadController extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String noticeNum = request.getParameter("noticeNum");
		try {
			NoticeDto noticeDto = null;
			Dao dao = new Dao();
			dao.noticeReadCountUp(noticeNum);
			dao = new Dao();
			noticeDto= dao.noticeReadByNum(noticeNum);
			request.setAttribute("notice", noticeDto);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/noticeRead.jsp").forward(request, response);
		System.out.println(request.getParameter("edit"));
		
	}
	
}
