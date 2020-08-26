package bitJeju.model;

import java.sql.Date;

public class StuEmployDto {
	private int stuEmployNum;	//글번호
	private String title;		//글제목
	private String writer;		//작성자
	private Date writedDate;	//작성일
	private String contents;	//글내용
	
	
	@Override
	public String toString() {
		return "StuEmployDto [stuEmployNum=" + stuEmployNum + ", title="
				+ title + ", writer=" + writer + ", writedDate=" + writedDate
				+ ", contents=" + contents + "]";
	}
	public int getStuEmployNum() {
		return stuEmployNum;
	}
	public void setStuEmployNum(int stuEmployNum) {
		this.stuEmployNum = stuEmployNum;
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
	public Date getWritedDate() {
		return writedDate;
	}
	public void setWritedDate(Date writedDate) {
		this.writedDate = writedDate;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	
	
}