package bitJeju.AttendController;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bitJeju.model.AttendanceDto;
import bitJeju.model.Dao;
import bitJeju.model.StudentDto;

@WebServlet("/attendanceClass.jb")
public class AttendanceClassController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			HttpSession session = request.getSession(false);
			StudentDto dto = (StudentDto)session.getAttribute("sbean");
			ArrayList<AttendanceDto> classList = new ArrayList<AttendanceDto>();
			String getTcode = dto.getTcode();
			Dao dao = new Dao();
			classList = dao.attendanceClass(getTcode);
			
			dao = new Dao();
			int classCode = dao.matchClass(getTcode);
			request.setAttribute("classCode", classCode);
			request.setAttribute("classList", classList);
			System.out.println(classList);
			ArrayList<AttendanceDto> dateList = new ArrayList<AttendanceDto>();
			
			dao = new Dao();
			dateList = dao.attendanceDateSelect(classCode);
			request.setAttribute("dateList", dateList);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("attendanceClass.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
