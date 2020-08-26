package bitJeju.ScoreController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitJeju.model.Dao;
import bitJeju.model.StudyGroupDto;

@WebServlet("/score.jb")
public class ScoreUpdateController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Enumeration<String> enu = request.getParameterNames();
		ArrayList<StudyGroupDto> list = new ArrayList<StudyGroupDto>();
		while(enu.hasMoreElements()) {
			int hakbun = Integer.parseInt(request.getParameter(enu.nextElement().trim()));
			int gradeJava = Integer.parseInt(request.getParameter(enu.nextElement().trim()));
			int gradeWeb = Integer.parseInt(request.getParameter(enu.nextElement().trim()));
			int gradeFrame = Integer.parseInt(request.getParameter(enu.nextElement().trim()));
			try {
				Dao dao = new Dao();
				dao.classScoreUpdate(hakbun, gradeJava, gradeWeb, gradeFrame);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		response.sendRedirect("scoreClassView.jb");
	}
}
