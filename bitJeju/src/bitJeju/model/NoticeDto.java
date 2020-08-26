package bitJeju.model;

import java.sql.Date;

public class NoticeDto {

	private int noticeNum;		// 글번호
	private int cnt;			// 조회수
	private String title;		// 글 제목
	private String writer;		// 작성자
	private Date writedDate;	// 작성일
	private String contents;	// 내용
	
	
	public NoticeDto() {
	}
	public NoticeDto(int noticeNum, int cnt, String title, String writer, Date writerDate, String contents) {
		super();
		this.noticeNum = noticeNum;
		this.cnt = cnt;
		this.title = title;
		this.writer = writer;
		this.writedDate = writerDate;
		this.contents = contents;
	}
	@Override
	public String toString() {
		return "NoticeDto [noticeNum=" + noticeNum + ", cnt=" + cnt + ", title=" + title + ", writer=" + writer
				+ ", writerDate=" + writedDate + ", contents=" + contents + "]";
	}
	public int getNoticeNum() {
		return noticeNum;
	}
	public void setNoticeNum(int noticeNum) {
		this.noticeNum = noticeNum;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getWritedDate() {
		return writedDate;
	}
	public void setWritedDate(Date writedDate) {
		this.writedDate = writedDate;
	}
	
	
}
