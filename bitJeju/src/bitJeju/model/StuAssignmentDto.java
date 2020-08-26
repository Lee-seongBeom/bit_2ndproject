package bitJeju.model;

import java.sql.Date;

public class StuAssignmentDto {
	private int hakbun;
	private String name;
	private String tcode;
	private int classCode;
	private String className;
	private Date applyDate;
	private int temp;
	
	public StuAssignmentDto() {
		
	}
	public StuAssignmentDto(int hakbun, String name, String tcode, int classCode, String className, Date applyDate,
			int temp) {
		super();
		this.hakbun = hakbun;
		this.name = name;
		this.tcode = tcode;
		this.classCode = classCode;
		this.className = className;
		this.applyDate = applyDate;
		this.temp = temp;
	}
	@Override
	public String toString() {
		return "StudentAssignmentDto [hakbun=" + hakbun + ", name=" + name + ", tcode=" + tcode + ", classCode="
				+ classCode + ", className=" + className + ", applyDate=" + applyDate + ", temp=" + temp + "]";
	}
	public int getHakbun() {
		return hakbun;
	}
	public void setHakbun(int hakbun) {
		this.hakbun = hakbun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTcode() {
		return tcode;
	}
	public void setTcode(String tcode) {
		this.tcode = tcode;
	}
	public int getClassCode() {
		return classCode;
	}
	public void setClassCode(int classCode) {
		this.classCode = classCode;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Date getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	public int getTemp() {
		return temp;
	}
	public void setTemp(int temp) {
		this.temp = temp;
	}
	
	
	
}