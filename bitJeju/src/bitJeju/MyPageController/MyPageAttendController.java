package bitJeju.MyPageController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bitJeju.model.Dao;
import bitJeju.model.MyAttendCountDto;
import bitJeju.model.StudentDto;
import bitJeju.model.StudyGroupDto;

@WebServlet("/myPageAttend.jb")
public class MyPageAttendController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setCharacterEncoding("utf-8");
		try {
			HttpSession session = request.getSession(false);
			StudentDto dto = (StudentDto) session.getAttribute("sbean");
			int hakbun = dto.getHakbun();
			Dao dao=new Dao();
			ArrayList<MyAttendCountDto> bean=dao.stuAttendCount(hakbun);
			request.setAttribute("myAttend", bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("myPageAttend.jsp").forward(request, response);

	}

}
