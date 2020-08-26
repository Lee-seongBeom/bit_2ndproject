package bitJeju.NoticeController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitJeju.model.Dao;


/**
 * Servlet implementation class noticeDelete
 */
@WebServlet("/stuEmployDelete.jb")
public class StuEmployDeleteController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String stuEmployNum = request.getParameter("stuEmployNum");
	
	Dao dao = null;
	try {
		dao = new Dao();
		dao.stuEmployDelete(stuEmployNum);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	request.getRequestDispatcher("/stuEmployList.jb").forward(request, response);
	
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
