package bitJeju.AttendController;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

@WebServlet("/attendanceClassByDate.jb")
public class AttendanceClassByDateController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("attendanceClassByDate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<AttendanceDto> classByDate;
		HttpSession session = request.getSession();
		StudentDto dto = (StudentDto)session.getAttribute("sbean");
		String form = request.getParameter("dateList");
		Date date = Date.valueOf(form);
		Dao dao;
		try {
			dao = new Dao();
			classByDate = dao.attendanceByDate(dto.getTcode(), date);
			request.setAttribute("classByDate", classByDate);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("attendanceClassByDate.jsp").forward(request, response);
	}

}
