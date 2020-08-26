package bitJeju.AttendController;

import java.io.IOException;
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

// 최초에 출석 insert 페이지로 이동할 때 session에서 저장해둔 tcode를 불러 메서드 파라미터 전달 후 select하여 접속
@WebServlet("/attendanceInsert.jb")
public class AttendanceInsertController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Dao dao = null;
			HttpSession session = request.getSession(false);
			StudentDto dto = (StudentDto)session.getAttribute("sbean");
			String tcode = dto.getTcode();
			dao=new Dao();
			int isCheckedToday = dao.attendanceIsCheckedToday();
			ArrayList<AttendanceDto> classList = new ArrayList<AttendanceDto>();
			if(isCheckedToday==0){
				dao=new Dao();
				classList = dao.attendanceSelect(tcode);
			}else{
				dao=new Dao();
				classList = dao.attendanceClassCheckedView(tcode);
			}
			request.setAttribute("list", classList);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("attendanceInsert.jsp").forward(request, response);
		
	}

}
