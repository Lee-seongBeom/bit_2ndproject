package bitJeju.SubController;

import java.io.IOException;
import java.io.PrintWriter;
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
import bitJeju.model.StuAssignmentDto;
import bitJeju.model.StudentDto;

@WebServlet("/subDetail.jb")
public class SubDetailController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("서브디테일 컨트롤러 겟");
		request.setCharacterEncoding("utf-8");
		int classCode = Integer.parseInt(request.getParameter("classCode").trim());
		ArrayList<ClassDto> list = new ArrayList<ClassDto>();
		
		try {
			Dao dao = new Dao();
			list = dao.subDetailSelect(classCode);
			request.setAttribute("classList", list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("subDetail.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("서브디테일 컨트롤러 포스트");
		
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("EUC-kr");
		ArrayList<StuAssignmentDto> list = new ArrayList<StuAssignmentDto>();
		HttpSession session = req.getSession();
		StudentDto dto = (StudentDto) session.getAttribute("sbean");
		int hakbun = 0;
		String name = null;
		int classCode =0;
		String className = null;
		String tcode = null;
		
		if(session.getAttribute("sbean")!=null) {
			hakbun = dto.getHakbun();
			name = dto.getName();
			System.out.println(hakbun+name);
			classCode = Integer.parseInt(req.getParameter("classCode").trim());
			className = req.getParameter("className").trim();
			tcode = req.getParameter("tcode").trim();
			System.out.println(classCode+className+tcode);
			
			try {
				Dao dao = new Dao();
				int check = dao.applyOverlap(hakbun);
				
				// 중복된 값을 찾지 못했을 떄 insert 해줌
				if(check==0) {
					dao = new Dao();
					dao.applyBySub(hakbun, name, classCode, className, tcode);
					PrintWriter out = resp.getWriter();
					out.println("<script type=\"text/javascript\" src=\"js/jquery-1.12.4.js\"></script>");
					out.println("<script type=\"text/javascript\" >");
					out.println("$(document).ready(function(){");
					out.println("alert(\"수강신청이 완료되었습니다.\");");
					out.println("location.href='subList.jb'});");
					out.println("</script>");
				}else {
					PrintWriter out = resp.getWriter();
					out.println("<script type=\"text/javascript\" src=\"js/jquery-1.12.4.js\"></script>");
					out.println("<script type=\"text/javascript\" >");
					out.println("$(document).ready(function(){");
					out.println("alert(\"이미 수강신청을 하셨습니다.\");");
					out.println("history.back()");
					out.println("});");
					out.println("</script>");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}else{
			PrintWriter out = resp.getWriter();
			out.println("<script type=\"text/javascript\" src=\"js/jquery-1.12.4.js\"></script>");
			out.println("<script type=\"text/javascript\" >");
			out.println("$(document).ready(function(){");
			out.println("alert(\"수강신청은 로그인을 하고 이용해주세요.\");");
			out.println("history.back()");
			out.println("});");
			out.println("</script>");
		}
		
	}
}