package bitJeju.NoticeController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitJeju.model.Dao;
import bitJeju.model.NoticeDto;
import bitJeju.model.PagingDto;
import bitJeju.model.PagingDao;

@WebServlet("/noticeList.jb")
public class NoticeListController extends HttpServlet {
	private String url = "noticeList.jsp";
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String action = request.getParameter("searchType");
		System.out.println("@@@@@@@action:"+action);
		String param = request.getParameter("pgNum");
		int count = 0;
		String linkStr = "";
		int pgNum = param == null ? 1 : Integer.parseInt(param);
		System.out.println("################");
		System.out.println(pgNum);
		Dao dao = null;
		PagingDao pagingDao =null;
		PagingDto pagingDto = null;
		ArrayList<NoticeDto> list = null;
		try {
			dao = new Dao();
			pagingDao = new PagingDao();
			int postCnt = pagingDao.getCount();
			System.out.println(postCnt + "postCnt");
			list = dao.noticeSelectAll(postCnt , pgNum);
			if(action == null){
				System.out.println("공지사항 모든 게시글을 표시합니다.");
				request.setAttribute("noticeList", list);
				count = pagingDao.getCount();
			}else if(action != null){
				System.out.println("엑션 타입이 널이 아닙니다 검색을 진행합니다.");
				String searchType = request.getParameter("searchType");
				String keyWord = request.getParameter("keyWord");
				Integer curPage = Integer.parseInt(request.getParameter("pgNum"));
				System.out.println(searchType + "$$$$" + keyWord);
				list = pagingDao.search(keyWord, searchType, curPage);
				System.out.println("공지사항 중 필터된 게시글을 표시합니다.");
				request.setAttribute("noticeList", list);
				count = pagingDao.getCount(keyWord, searchType);
				linkStr = "&searchType="+searchType+"&keyWord="+keyWord;
			}
			
			pagingDao = new PagingDao();
			request.setAttribute("pagelist", new PagingDao().getPageLinkList(pgNum, linkStr, count));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		

	}
}
