package bitJeju.model;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PagingDao {

	// 페이징, 게시판 테이블에 저장된 전체 글의 개수를 리턴
	public int  getCount() throws SQLException {
		Dao dao = new Dao();
		int totalCount = 0;
		try {
			dao.stmt = dao.conn.createStatement();
			dao.rs = dao.stmt.executeQuery("select count(*) from notice");
			dao.rs.next();
			totalCount = dao.rs.getInt(1);			
			System.out.println("DB 게시글 수 : " + totalCount);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(dao.rs!=null)dao.rs.close();
			if(dao.stmt!=null)dao.stmt.close();
			if(dao.conn!=null)dao.conn.close();
		}
		return totalCount;
	}
	
   //페이징, 게시판 테이블에서 key 매개 변수에 전달된 키 값이 searchType 조건에 맞춰서 저장된 글의 개수를 리턴
	public int  getCount(String keyWord, String searchType) throws SQLException {
		Dao dao = null;
		int totalCount = 0;
		String searchExpr;
		try {
			dao = new Dao();
			dao.stmt = dao.conn.createStatement();
			if (searchType.equals("contents")) {
				searchExpr = " contents like '%" + keyWord + "%'";
			} else if (searchType.equals("title")) {
				searchExpr = " title like '%" + keyWord + "%'";
			} else {
				searchExpr = " title like '%" + keyWord + "%'" + " OR contents like '%" + keyWord + "%'";
			}
			dao.rs = dao.stmt.executeQuery("select count(*) from notice where " + searchExpr);
			dao.rs.next();
			totalCount = dao.rs.getInt(1);			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(dao.rs!=null)dao.rs.close();
			if(dao.pstmt!=null)dao.pstmt.close();
			if(dao.conn!=null)dao.conn.close();
		}
		return totalCount;
	}
	
	public String getPageLinkList(int curPage, String linkStr, int size) {
		
		PagingDto pagingDto = new PagingDto(10, 5,size, curPage);
		StringBuilder buffer = new StringBuilder();
		if(pagingDto.isPreData()) {
			buffer.append("<a href='noticeList.jb?pgNum=");
			buffer.append((pagingDto.getPageStart()-1)+linkStr+"'>");
			buffer.append("<img src='img/left.png' width='15'></a> ");
		}
		for(int i = pagingDto.getPageStart(); i <= pagingDto.getPageEnd();i++) {
			if(i == curPage)
				buffer.append("<a href='noticeList.jb?pgNum="+i+linkStr+"'"+" style='font-weight:bold;'>"+i+"</a> ");
			else
				buffer.append("<a href='noticeList.jb?pgNum="+i+linkStr+"'"+">"+i+"</a> ");
		}
		if(pagingDto.isNextData()) {
			buffer.append("<a href='noticeList.jb?pgNum=");
			buffer.append((pagingDto.getPageEnd()+1)+linkStr+"'>");
			buffer.append(" <img src='img/right.png' width='15'></a>");
		}
		return buffer.toString();		
	}
	
	//페이징, key로 전달된 값으로 search조건에 맞춰서 저장된 글에서
	public ArrayList<NoticeDto> search(String keyWord, String searchType, int curPage) throws SQLException {
		//key= 검색어, searchType = 검색 유형, curPage = 현재 페이지
		System.out.println("페이징 다오 서치 실행 중....");
		ArrayList<NoticeDto> list = new ArrayList<NoticeDto>();
		String searchTarget = "";
		if (searchType.equals("contents")) {
			searchTarget = " contents like '%" + keyWord + "%'";
		} else if (searchType.equals("title")) {
			searchTarget = " title like '%" + keyWord + "%'";
		} else {
			
			searchTarget = " title like '%" + keyWord + "%'" + " OR contents like '%" + keyWord + "%'";
		}
		System.out.println("------------------");
		System.out.println(keyWord);
		System.out.println(searchType);
		System.out.println("------------------");
		Dao dao= null;
		int count =0;
		try {
			dao = new Dao();
			String sql = "select count(*) from notice where "
					+ searchTarget;
			dao.stmt = dao.conn.createStatement();
			dao.rs = dao.stmt.executeQuery(sql);
			dao.rs.next();
			count = dao.rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(dao.rs!=null)dao.rs.close();
			if(dao.stmt!=null)dao.stmt.close();
			if(dao.conn!=null)dao.conn.close();
		}// 검색 필터된 게시글 총 개수
			System.out.println("&*&*&*&*&&**&");
		if (count > 0) {
			dao = new Dao();
			try {
				PagingDto page = new PagingDto(10, 5, count, curPage);
				System.out.println(curPage + "현재 페이지");
				String sql = "select noticeNum, title, writer, writedDate, cnt, contents, rum from"
						+ "(select noticeNum, title, writer, writedDate, cnt, contents, rownum rum from"
						+ "(select noticeNum, title, writer, writedDate, cnt, contents from "
						+ "(select noticeNum, title, writer, writedDate, cnt, contents, rownum rnum from notice where  "
						+ searchTarget
						+ "order by writedDate desc))) where rum between "
						+ page.getWritingStart()
						+ " and "
						+ page.getWritingEnd()
						+ "";
				System.out.println("검색을 위해 DB 작업 중..."+sql);
				dao.stmt = dao.conn.createStatement();
				dao.rs = dao.stmt.executeQuery(sql);
				while (dao.rs.next()) {
					NoticeDto bean = new NoticeDto();
					bean.setNoticeNum(dao.rs.getInt("noticeNum"));
					bean.setTitle(dao.rs.getString("title"));
					bean.setWriter(dao.rs.getString("writer"));
					bean.setWritedDate(dao.rs.getDate("writedDate"));
					bean.setCnt(dao.rs.getInt("cnt"));
					bean.setContents(dao.rs.getString("contents"));
					list.add(bean);
				} //while end
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(dao.rs!=null)dao.rs.close();
				if(dao.stmt!=null)dao.stmt.close();
				if(dao.conn!=null)dao.conn.close();
			}
		} // if end
		return list;
	}
	
}
