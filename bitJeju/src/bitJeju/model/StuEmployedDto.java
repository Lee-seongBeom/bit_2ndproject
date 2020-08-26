package bitJeju.model;

public class StuEmployedDto {
	private int StuEmployedNum;	//글번호
	private int cnt;			//조회수
	private String title;		//글제목
	private String writer;		//작성자
	private String writedDate;	//작성일
	private String contents;	//글내용
	private String mid;			//작성자 ID
	
	public StuEmployedDto() {}
	
	public StuEmployedDto(int employedNum, int cnt, String title,
			String writer, String writedDate, String contents, String mid) {
		super();
		this.StuEmployedNum = employedNum;
		this.cnt = cnt;
		this.title = title;
		this.writer = writer;
		this.writedDate = writedDate;
		this.contents = contents;
		this.mid = mid;
	}
	
	@Override
	public String toString() {
		return "StuEmployedDto [employedNum=" + StuEmployedNum + ", cnt=" + cnt
				+ ", title=" + title + ", writer=" + writer + ", writedDate="
				+ writedDate + ", contents=" + contents + ", mid=" + mid + "]";
	}

	public int getEmployedNum() {
		return StuEmployedNum;
	}
	public void setEmployedNum(int employedNum) {
		this.StuEmployedNum = employedNum;
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
	public String getWritedDate() {
		return writedDate;
	}
	public void setWritedDate(String writedDate) {
		this.writedDate = writedDate;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	
}
