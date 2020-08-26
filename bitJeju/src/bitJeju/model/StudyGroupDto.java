package bitJeju.model;

public class StudyGroupDto {

	private int classCode;		
	private int hakbun;			
	private int gradeJava;		
	private int gradeWeb;		
	private int gradeFrame;		
	private int totalDay;		
	private int checkDay;		
	private int missDay;		
	private int tardy;	
	private double rate;
	private String name;	
	private String className;
	private String tcode;		
	
	public StudyGroupDto() {
	}

	public StudyGroupDto(int classCode, int hakbun, int gradeJava, int gradeWeb, int gradeFrame, int totalDay,
			int checkDay, int missDay, int tardy, double rate, String name, String className, String tcode) {
		super();
		this.classCode = classCode;
		this.hakbun = hakbun;
		this.gradeJava = gradeJava;
		this.gradeWeb = gradeWeb;
		this.gradeFrame = gradeFrame;
		this.totalDay = totalDay;
		this.checkDay = checkDay;
		this.missDay = missDay;
		this.tardy = tardy;
		this.rate = rate;
		this.name = name;
		this.className = className;
		this.tcode = tcode;
	}

	@Override
	public String toString() {
		return "StudyGroupDto [classCode=" + classCode + ", hakbun=" + hakbun + ", gradeJava=" + gradeJava
				+ ", gradeWeb=" + gradeWeb + ", gradeFrame=" + gradeFrame + ", totalDay=" + totalDay + ", checkDay="
				+ checkDay + ", missDay=" + missDay + ", tardy=" + tardy + ", rate=" + rate + ", name=" + name
				+ ", className=" + className + ", tcode=" + tcode + "]";
	}

	public int getClassCode() {
		return classCode;
	}

	public void setClassCode(int classCode) {
		this.classCode = classCode;
	}

	public int getHakbun() {
		return hakbun;
	}

	public void setHakbun(int hakbun) {
		this.hakbun = hakbun;
	}

	public int getGradeJava() {
		return gradeJava;
	}

	public void setGradeJava(int gradeJava) {
		this.gradeJava = gradeJava;
	}

	public int getGradeWeb() {
		return gradeWeb;
	}

	public void setGradeWeb(int gradeWeb) {
		this.gradeWeb = gradeWeb;
	}

	public int getGradeFrame() {
		return gradeFrame;
	}

	public void setGradeFrame(int gradeFrame) {
		this.gradeFrame = gradeFrame;
	}

	public int getTotalDay() {
		return totalDay;
	}

	public void setTotalDay(int totalDay) {
		this.totalDay = totalDay;
	}

	public int getCheckDay() {
		return checkDay;
	}

	public void setCheckDay(int checkDay) {
		this.checkDay = checkDay;
	}

	public int getMissDay() {
		return missDay;
	}

	public void setMissDay(int missDay) {
		this.missDay = missDay;
	}

	public int getTardy() {
		return tardy;
	}

	public void setTardy(int tardy) {
		this.tardy = tardy;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
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

	public String getTcode() {
		return tcode;
	}

	public void setTcode(String tcode) {
		this.tcode = tcode;
	}
	
}