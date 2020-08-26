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
import bitJeju.model.StuEmployDto;

@WebServlet("/stuEmployRead.jb")
public class StuEmployReadController extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stuEmployNum = request.getParameter("stuEmployNum");
		try {
			StuEmployDto stuEmployDto = null;
			Dao dao = new Dao();
			stuEmployDto = dao.stuEmployReadByNum(stuEmployNum);
			request.setAttribute("bean", stuEmployDto);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/stuEmployRead.jsp").forward(request, response);
		System.out.println(request.getParameter("edit"));
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);

		
	}

}
