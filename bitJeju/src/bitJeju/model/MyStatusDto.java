package bitJeju.model;

import java.sql.Date;

public class MyStatusDto {
	private int classCode;
	private String name;
	private String className;
	private int hakbun;
	private Date startDay;
	private Date endDay;
	
	public MyStatusDto() {}
	
	@Override
	public String toString() {
		return "MyStatusDto [classCode=" + classCode + ", name=" + name + ", className=" + className + ", hakbun="
				+ hakbun + ", startDay=" + startDay + ", endDay=" + endDay + "]";
	}
	public int getClassCode() {
		return classCode;
	}
	public void setClassCode(int classCode) {
		this.classCode = classCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public int getHakbun() {
		return hakbun;
	}
	public void setHakbun(int hakbun) {
		this.hakbun = hakbun;
	}
	public Date getStartDay() {
		return startDay;
	}
	public void setStartDay(Date startDay) {
		this.startDay = startDay;
	}
	public Date getEndDay() {
		return endDay;
	}
	public void setEndDay(Date endDay) {
		this.endDay = endDay;
	}

}
