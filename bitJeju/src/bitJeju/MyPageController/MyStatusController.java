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

import bitJeju.model.ClassDto;
import bitJeju.model.Dao;
import bitJeju.model.MyStatusDto;
import bitJeju.model.StudentDto;
import bitJeju.model.StudyGroupDto;

@WebServlet("/myStatus.jb")
public class MyStatusController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		StudentDto bean = (StudentDto) session.getAttribute("sbean");
		System.out.println("학번은?:"+bean.getHakbun());
		try {
			Dao dao=new Dao();
			ArrayList<MyStatusDto> sglist=dao.myStatusList(bean.getHakbun());
			
			req.setAttribute("sg",sglist);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		req.getRequestDispatcher("myStatus.jsp").forward(req, resp);
		
	}
}
