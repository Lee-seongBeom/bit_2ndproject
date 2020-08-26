package bitJeju.LoginController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bitJeju.model.Dao;
import bitJeju.model.StudentDto;

@WebServlet("/login.jb")
public class LoginController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("euc-kr");
		
		
//		hakbun,id,name,phoneNumber,lev
		String id=req.getParameter("id").trim();
		String pw=req.getParameter("pw").trim();
		System.out.println(id);
			try {
				Dao dao;
				
				if(id.equals("admin")||id.equals("adminH1")||id.equals("adminH2")||id.equals("adminH3")||id.equals("adminC1")||id.equals("adminY1")||id.equals("adminY2")||id.equals("adminT1")||id.equals("adminT2")||id.equals("adminT3")){
					dao = new Dao();
					HttpSession session=req.getSession();
					session.setAttribute("level", 10);
					StudentDto bean=dao.login(id, pw);
					
					if(bean.getId()==null||bean.getPw()==null){
						session=req.getSession();
						session.setAttribute("level", null);
//						System.out.println("아이디와 비밀번호를 확인해주세요");
						
						PrintWriter out = resp.getWriter();
						out.println("<script type=\"text/javascript\" src=\"js/jquery-1.12.4.js\"></script>");
						out.println("<script type=\"text/javascript\" >");
						out.println("$(document).ready(function(){");
						out.println("alert(\"로그인실패 \\n아이디와 비밀번호를 확인해주세요.\");");
						out.println("history.back()");
						out.println("});");
						out.println("</script>");
					}
					
					if(id.equals("adminH1")||id.equals("adminH2")||id.equals("adminH3")){ // 행정 1,2,3 
						session.setAttribute("ad", 11);
					}else if(id.equals("adminC1")){ // 취업 1
						session.setAttribute("ad", 33);
					}else if(id.equals("adminY1")||id.equals("adminY2")){ // 영업 1,2
						session.setAttribute("ad", 22);
					}else if(id.equals("adminT1")||id.equals("adminT2")||id.equals("adminT3")){  // 설민석,정승제,황현필
						session.setAttribute("ad", 44);
					}
					
					
					
					session.setAttribute("sbean",bean);
//					System.out.println("admin :: "+bean.getId());
					req.getRequestDispatcher("loginResult.jsp").forward(req, resp);
					
				}else{
					dao = new Dao();
					StudentDto bean=dao.login(id, pw);
					
					
					if(bean.getId()==null ||bean.getPw()==null){
						HttpSession session=req.getSession();
						session.setAttribute("level", null);
//						System.out.println("아이디와 비밀번호를 확인해주세요");
						
						PrintWriter out = resp.getWriter();
						out.println("<script type=\"text/javascript\" src=\"js/jquery-1.12.4.js\"></script>");
						out.println("<script type=\"text/javascript\" >");
						out.println("$(document).ready(function(){");
						out.println("alert(\"로그인실패 \\n아이디와 비밀번호를 확인해주세요.\");");
						out.println("history.back()");
						out.println("});");
						out.println("</script>");
						
					}else{
						HttpSession session=req.getSession();
						session.setAttribute("sbean",bean);
//						System.out.println("other :: "+bean.getId());
						session.setAttribute("level", 1);
						req.getRequestDispatcher("loginResult.jsp").forward(req, resp);
						
					}
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
}





