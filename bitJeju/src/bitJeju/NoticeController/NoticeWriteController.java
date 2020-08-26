package bitJeju.NoticeController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bitJeju.model.Dao;
import bitJeju.model.NoticeDto;

@WebServlet("/noticeWrite.jb")
public class NoticeWriteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("noticeWrite.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		//req.getRequestDispatcher("noticeWrite.jsp").forward(req, resp);
		
		String title = req.getParameter("title");
		String contents = req.getParameter("contents");
		
		NoticeDto noticeDto = new NoticeDto();
		noticeDto.setTitle(title);
		noticeDto.setContents(contents);
		Dao dao;
		try {
			dao = new Dao();
			dao.noticeWrite(noticeDto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		resp.sendRedirect("noticeList.jb");
	}
}
