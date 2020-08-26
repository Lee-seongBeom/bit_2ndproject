package bitJeju.model;

import java.sql.Date;

public class JobNoticeDto {
	private int jobNoticeNum;		// 글 번호
	private String writer;		// 작성자명
	private String title;		//  공고명
	private String company;		// 회사명
	private Date endDay;		// 채용 마감일
	private Date writedDate;	// 작성일
	private String contents;	// 내용
	private int cnt;	//조회수
	
	public JobNoticeDto() {
		
	}
	
	public JobNoticeDto(int jobNoticeNum, String writer, String title, String company, Date endDay, Date writedDate,
			String contents, int cnt) {
		super();
		this.jobNoticeNum = jobNoticeNum;
		this.writer = writer;
		this.title = title;
		this.company = company;
		this.endDay = endDay;
		this.writedDate = writedDate;
		this.contents = contents;
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "JobNoticeDto [jobNoticeNum=" + jobNoticeNum + ", writer=" + writer + ", title=" + title + ", company="
				+ company + ", endDay=" + endDay + ", writedDate=" + writedDate + ", contents=" + contents + ", cnt="
				+ cnt + "]";
	}
	public int getJobNoticeNum() {
		return jobNoticeNum;
	}
	public void setJobNoticeNum(int jobNoticeNum) {
		this.jobNoticeNum = jobNoticeNum;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Date getEndDay() {
		return endDay;
	}
	public void setEndDay(Date endDay) {
		this.endDay = endDay;
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
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	
}
