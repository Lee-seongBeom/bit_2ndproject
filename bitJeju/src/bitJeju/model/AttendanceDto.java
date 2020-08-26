package bitJeju.model;

import java.sql.Date;

public class AttendanceDto {
	int classCode;
	String className;
	int hakbun;
	String name;
	Date nalja;
	String stuCheck;
	
	AttendanceDto(){
	}

	public AttendanceDto(int classCode, String className, int hakbun, String name, Date nalja, String stuCheck) {
		super();
		this.classCode = classCode;
		this.className = className;
		this.hakbun = hakbun;
		this.name = name;
		this.nalja = nalja;
		this.stuCheck = stuCheck;
	}

	@Override
	public String toString() {
		return "AttendanceDto [classCode=" + classCode + ", className=" + className + ", hakbun=" + hakbun + ", name="
				+ name + ", nalja=" + nalja + ", stuCheck=" + stuCheck + "]";
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

	public Date getNalja() {
		return nalja;
	}

	public void setNalja(Date nalja) {
		this.nalja = nalja;
	}

	public String getStuCheck() {
		return stuCheck;
	}

	public void setStuCheck(String stuCheck) {
		this.stuCheck = stuCheck;
	}
	
	
}