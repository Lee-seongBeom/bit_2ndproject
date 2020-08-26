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
import bitJeju.model.StuEmployDto;

@WebServlet("/stuEmployModify.jb")
public class StuEmployModifyController extends HttpServlet {

	String stuEmployNum = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		stuEmployNum = request.getParameter("stuEmployNum");
		request.setAttribute("stuEmployNum", stuEmployNum);
		
		try {
			Dao dao =new Dao();
			StuEmployDto stuEmployDto = new StuEmployDto();
			stuEmployDto = dao.stuEmployReadByNum(stuEmployNum);
			request.setAttribute("bean", stuEmployDto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/stuEmployModify.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		
		StuEmployDto stuEmployDto = new StuEmployDto();
		stuEmployDto.setStuEmployNum(Integer.parseInt(stuEmployNum));
		System.out.println((Integer.parseInt(stuEmployNum))+100);
		stuEmployDto.setTitle(title);
		stuEmployDto.setContents(contents);
		
		Dao dao =null;
		try {
			dao = new Dao();
			dao.stuEmployModify(stuEmployDto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("stuEmployRead.jb?stuEmployNum="+stuEmployNum);
	}
}
