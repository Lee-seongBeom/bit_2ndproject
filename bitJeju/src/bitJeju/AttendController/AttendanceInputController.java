package bitJeju.AttendController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitJeju.model.Dao;

@WebServlet("/attendanceInput.jb")
public class AttendanceInputController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("EUC-kr");
		
		Enumeration<String> enu = request.getParameterNames();
		int cnt = 0;
		Date nalja = null;
		int classCode = 0;
		int hakbun = 0;
		String className=null;
		String name = null;
		String stuCheck = null;
		Dao dao = null;
		String task="";
		try {
			//오늘 처음으로 작성하는지 여부를 따져서 삽입or 수정
			dao = new Dao();
			int temp = dao.attendanceIsCheckedToday();
			if(temp==0){
				task ="insert";
			}else{
				task ="edit";
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		while(enu.hasMoreElements()) {
			if(cnt==0) {
				nalja = Date.valueOf(request.getParameter(enu.nextElement().trim()));
				classCode = Integer.parseInt(request.getParameter(enu.nextElement().trim()));
				className = request.getParameter(enu.nextElement().trim());
				hakbun = Integer.parseInt(request.getParameter(enu.nextElement().trim()));
				name = request.getParameter(enu.nextElement().trim());
				stuCheck = request.getParameter(enu.nextElement().trim());
				cnt++;
			}else if(cnt>0){
				classCode = Integer.parseInt(request.getParameter(enu.nextElement().trim()));
				className = request.getParameter(enu.nextElement().trim());
				hakbun = Integer.parseInt(request.getParameter(enu.nextElement().trim()));
				name = request.getParameter(enu.nextElement().trim());
				stuCheck = request.getParameter(enu.nextElement().trim());
			}
			try {
				dao = new Dao();
				dao.attendanceInsert(nalja,classCode,className,hakbun,name,stuCheck, task);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		response.sendRedirect("attendanceClass.jb");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

	}
}