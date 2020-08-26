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


@WebServlet("/noticeModify.jb")
public class NoticeModifyController extends HttpServlet {
 
	String noticeNum = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		noticeNum = request.getParameter("noticeNum");
		request.setAttribute("noticeNum", noticeNum);
		
		try {
			Dao dao =new Dao();
			NoticeDto noticeDto = new NoticeDto();
			noticeDto = dao.noticeReadByNum(noticeNum);
			request.setAttribute("notice", noticeDto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/noticeModify.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post funcionando");
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		
		NoticeDto noticeDto = new NoticeDto();
		noticeDto.setNoticeNum(Integer.parseInt(noticeNum));
		System.out.println((Integer.parseInt(noticeNum))+100);
		noticeDto.setTitle(title);
		noticeDto.setContents(contents);
		
		Dao dao =null;
		try {
			dao = new Dao();
			dao.noticeModify(noticeDto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("noticeRead.jb?noticeNum="+noticeNum);
				//request.getRequestDispatcher("/noticeRead.jb?"+"noticeNum="+noticeNum).forward(request, response);
	}

}
