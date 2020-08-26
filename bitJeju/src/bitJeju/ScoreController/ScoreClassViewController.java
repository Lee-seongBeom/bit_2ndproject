package bitJeju.ScoreController;

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
import bitJeju.model.StudentDto;
import bitJeju.model.StudyGroupDto;

@WebServlet("/scoreClassView.jb")
public class ScoreClassViewController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Dao dao = new Dao();
			HttpSession session = request.getSession(false);
			StudentDto dto = (StudentDto)session.getAttribute("sbean");
			ArrayList<StudyGroupDto> clList = new ArrayList<StudyGroupDto>();
			String getTcode = dto.getTcode();
			clList = dao.scoreClass(getTcode);
			
			dao = new Dao();
			int classCode = dao.connectClass(getTcode);
			System.out.print(getTcode);
			request.setAttribute("classCode", classCode);
			request.setAttribute("clList", clList);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("scoreClassView.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

}
