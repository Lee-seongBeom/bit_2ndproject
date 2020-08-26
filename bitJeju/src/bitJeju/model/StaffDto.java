package bitJeju.model;

public class StaffDto {
	
	private int mlev;		//스테프레벨
	private String mid;		//스테프아이디
	private String mpw;		//스테프비밀번호
	private String mname;	//스테프이름
	private String tcode;	//강사일 경우 강사코드 t1, t2 ,t3
	
	public StaffDto() {
	}
	public StaffDto(int mlev, String mid, String mpw, String mname, String tcode) {
		super();
		this.mlev = mlev;
		this.mid = mid;
		this.mpw = mpw;
		this.mname = mname;
		this.tcode = tcode;
	}
	@Override
	public String toString() {
		return "StaffDto [mlev=" + mlev + ", mid=" + mid + ", mpw=" + mpw + ", mname=" + mname + ", tcode=" + tcode
				+ "]";
	}
	public int getMlev() {
		return mlev;
	}
	public void setMlev(int mlev) {
		this.mlev = mlev;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getTcode() {
		return tcode;
	}
	public void setTcode(String tcode) {
		this.tcode = tcode;
	}
	
	
}
