package bitJeju.LoginController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitJeju.model.Dao;
import bitJeju.model.StudentDto;

@WebServlet("/signUp.jb")
public class SignUpController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.getRequestDispatcher("signUp.jsp").forward(req, resp);
		
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("euc-kr");
		
		String name=req.getParameter("name").trim();
		String id=req.getParameter("id").trim();
		String pw=req.getParameter("pw").trim();
		
		System.out.println("id: "+id); 
		int phoneNumber= Integer.parseInt(req.getParameter("phoneNumber").trim());
		
		try {
			Dao dao=new Dao();
			ArrayList alist=dao.idList();
			System.out.println("아이디:" +alist.toString());
			int cnt=0;
			for(int i=0;i<alist.size();i++){
				if(id.equals(alist.get(i))){
					System.out.println("아이디 중복");
					cnt--;
					
					PrintWriter out = resp.getWriter();
					out.println("<script type=\"text/javascript\" src=\"js/jquery-1.12.4.js\"></script>");
					out.println("<script type=\"text/javascript\" >");
					out.println("$(document).ready(function(){");
					out.println("alert(\"중복된 아이디 입니다.\\n다시 입력해주세요\");");
					out.println("history.back()");
					out.println("});");
					out.println("</script>");					
				}else{
					if(i==(alist.size()-1)){
						if(cnt==0){
							System.out.println("아이디 중복이 없음");
							dao=new Dao();
							dao.signUp(name, id, pw, phoneNumber);
							resp.sendRedirect("signUpFinish.jb");
						}
					}
				}
				
			}
				
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}







