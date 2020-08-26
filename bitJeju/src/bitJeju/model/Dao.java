package bitJeju.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Dao {

	Connection conn;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;

	java.util.logging.Logger log = Logger.getGlobal();

	public Dao() throws SQLException {
		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		conn = DriverManager.getConnection(url, user, password);
		System.out.println(conn.hashCode());
	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// 클래스 개설
	// className, teacher, tcode, startDay, endDay
	public void insertClass(String className, String teacher, String tcode,
			Date startDay, Date endDay, String filePath) throws SQLException {
		String sql = "insert into classData (classCode,className,teacher,tcode,startDay,endDay,filePath) values (classData_seq.nextval,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, className);
			pstmt.setString(2, teacher);
			pstmt.setString(3, tcode);
			pstmt.setDate(4, startDay);
			pstmt.setDate(5, endDay);
			pstmt.setString(6, filePath);
			pstmt.executeUpdate();
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// /////
	// 성적성적성적성////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// 학생들 성적 보기 selectAll
	public ArrayList<StudyGroupDto> scoreSelectAll() throws SQLException {
		ArrayList<StudyGroupDto> list = new ArrayList<StudyGroupDto>();
		String sql = "select classCode, className, hakbun, name, gradeJava, gradeWeb, gradeFrame from studyGroup order by classCode, hakbun";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				StudyGroupDto dto = new StudyGroupDto();
				dto.setClassCode(rs.getInt("classCode"));
				dto.setClassName(rs.getString("className"));
				dto.setHakbun(rs.getInt("hakbun"));
				dto.setName(rs.getString("name"));
				dto.setGradeJava(rs.getInt("gradeJava"));
				dto.setGradeWeb(rs.getInt("gradeWeb"));
				dto.setGradeFrame(rs.getInt("gradeFrame"));
				list.add(dto);
			}
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}

		return list;
	}

	// 반마다 학생 성적 보기
	public ArrayList<StudyGroupDto> scoreSelectClass(int a) throws SQLException {
		ArrayList<StudyGroupDto> list = new ArrayList<StudyGroupDto>();
		String sql = "select classCode, className, hakbun, name, gradeJava, gradeWeb, gradeFrame from studyGroup where classCode=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, a);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				StudyGroupDto dto = new StudyGroupDto();
				dto.setClassCode(rs.getInt("classCode"));
				dto.setClassName(rs.getString("className"));
				dto.setHakbun(rs.getInt("hakbun"));
				dto.setName(rs.getString("name"));
				dto.setGradeJava(rs.getInt("gradeJava"));
				dto.setGradeWeb(rs.getInt("gradeWeb"));
				dto.setGradeFrame(rs.getInt("gradeFrame"));
				list.add(dto);
			}
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return list;
	}

	// 성적 입력 (성적이 만약 -1 값이면 null로 넣는다)
	public void classScoreUpdate(int hakbun, int gradeJava, int gradeWeb,
			int gradeFrame) throws SQLException {
		String sql = "update studyGroup set gradeJava=?, gradeWeb=?, gradeFrame=? where hakbun=?";

		try {
			pstmt = conn.prepareStatement(sql);
			if (gradeJava != -1) {
				pstmt.setInt(1, gradeJava);
			} else {
				pstmt.setNull(1, Types.INTEGER);
			}
			if (gradeWeb != -1) {
				pstmt.setInt(2, gradeWeb);
			} else {
				pstmt.setNull(2, Types.INTEGER);
			}
			if (gradeFrame != -1) {
				pstmt.setInt(3, gradeFrame);
			} else {
				pstmt.setNull(3, Types.INTEGER);
			}
			pstmt.setInt(4, hakbun);
			pstmt.executeUpdate();
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}

	}

	// 강사전용 socre 관리 ////////////////////////////////////////////
	public ArrayList<StudyGroupDto> scoreClass(String tcode)
			throws SQLException {
		ArrayList<StudyGroupDto> list = new ArrayList<StudyGroupDto>();
		String sql = "select classCode, className, hakbun, name, gradeJava, gradeWeb, gradeFrame from studyGroup where tcode=? order by hakbun";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tcode);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				StudyGroupDto bean = new StudyGroupDto();
				bean.setClassCode(rs.getInt("classCode"));
				bean.setClassName(rs.getString("className"));
				bean.setHakbun(rs.getInt("hakbun"));
				bean.setName(rs.getString("name"));
				bean.setGradeJava(rs.getInt("gradeJava"));
				bean.setGradeWeb(rs.getInt("gradeWeb"));
				bean.setGradeFrame(rs.getInt("gradeFrame"));
				list.add(bean);
			}
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}

		return list;
	}

	// 로그인 세션의 tcode를 받아와서 해당 강사의 반을 select하는 메서드
	public int connectClass(String tcode) throws SQLException {
		String sql = "select classCode from StudyGroup where tcode=?";
		int classCode = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tcode);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				classCode = rs.getInt("classCode");
			}
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return classCode;
	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// 회원 정보 모두
	public ArrayList<StudentDto> selectAll() throws SQLException {

		ArrayList<StudentDto> list = new ArrayList<StudentDto>();

		String sql = "select * from stuData";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				StudentDto bean = new StudentDto();
				bean.setHakbun(rs.getInt("hakbun"));
				bean.setName(rs.getString("name"));
				bean.setId(rs.getString("id"));
				bean.setPw(rs.getString("pw"));
				bean.setPhoneNumber(rs.getString("phoneNumber"));
				bean.setLev(rs.getInt("lev"));
				bean.setClassCode(rs.getInt("classCode"));
				bean.setGradeJava(rs.getInt("gradeJava"));
				bean.setGradeWeb(rs.getInt("gradeWeb"));
				bean.setGradeFrame(rs.getInt("gradeFrame"));

				list.add(bean);

				log.info(bean.toString());

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return list;
	}

	public int selectOne(String id) throws SQLException {

		String sql = "select hakbun from stuData where id = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("hakbun");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		System.out.println("result: " + result);
		return result;

	}

	// 회원 가입시
	public void signUp(String name, String id, String pw, int phoneNumber)
			throws SQLException {
		// hakbun->seq.nextval 1.name 2.id 3.pw 4.phoneNumber int lev,int
		// classCode,int gradeJava,int gradeWeb,int gradeFrame
		String sql = "insert into stuData (hakbun,name,id,pw,phoneNumber) values (stuData_seq.nextval,?,?,?,?)";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3, pw);
			pstmt.setInt(4, phoneNumber);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
	}

	// 회원가입시 모든 아이디 가져오기
	public ArrayList<StudentDto> idList() throws SQLException {

		String sql = "select id from stuData";
		StudentDto bean = new StudentDto();
		ArrayList alist = new ArrayList();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				bean.setId(rs.getString("id"));
				alist.add(bean.getId());

				// log.info(list);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}

		return alist;
	}

	// 로그인 시
	public StudentDto login(String id, String pw) {

		String sql = "select * from stuData where id=? and pw=?";

		StudentDto bean = new StudentDto();

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				// hakbun,id,name,phoneNumber,lev
				bean.setHakbun(rs.getInt("hakbun"));
				bean.setId(rs.getString("id"));
				bean.setPw(rs.getString("pw"));
				bean.setName(rs.getString("name"));
				bean.setPhoneNumber(rs.getString("phoneNumber"));
				bean.setLev(rs.getInt("lev"));
				bean.setGradeJava(rs.getInt("gradeJava"));
				bean.setGradeWeb(rs.getInt("gradeWeb"));
				bean.setGradeFrame(rs.getInt("gradeFrame"));
				bean.setClassCode(rs.getInt("classCode"));
				bean.setTcode(rs.getString("tcode"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return bean;
	}

	// 마이페이지 - 한명의 정보만 select
	public ArrayList<StudentDto> myPageScore(int hakbun) {

		String sql = "select * from stuData where hakbun=?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StudentDto bean = new StudentDto();
		ArrayList<StudentDto> list = new ArrayList<StudentDto>();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hakbun);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				bean.setClassCode(rs.getInt("classCode"));
				bean.setHakbun(rs.getInt("hakbun"));
				bean.setName(rs.getString("name"));
				bean.setId(rs.getString("id"));
				bean.setPhoneNumber(rs.getString("phoneNumber"));
				bean.setGradeJava(rs.getInt("gradeJava"));
				bean.setGradeWeb(rs.getInt("gradeWeb"));
				bean.setGradeFrame(rs.getInt("gradeFrame"));
				bean.setPw(rs.getString("pw"));
				list.add(bean);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	// 마이페이지 정보수정
	public void myPageModify(String pw, String phoneNumber, String id) {
		String sql = "update stuData set pw=?,phoneNumber=? where id=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pw);
			pstmt.setString(2, phoneNumber);
			pstmt.setString(3, id);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 마이페이지 수강신청현황
	public ArrayList<MyStatusDto> myStatusList(int hakbun) throws SQLException {
		// String sql="select * from studyGroup where hakbun=?";
		String sql = "select sg.classCode, sg.hakbun, sg.name,sg.className,cd.startDay,cd.endDay from studyGroup sg inner join classData cd on sg.classCode=cd.classCode where sg.hakbun=?";

		ArrayList<MyStatusDto> list = new ArrayList();
		MyStatusDto bean = new MyStatusDto();

		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, hakbun);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			bean.setClassCode(rs.getInt("classCode"));
			bean.setHakbun(rs.getInt("hakbun"));
			bean.setName(rs.getString("name"));
			bean.setClassName(rs.getString("className"));
			bean.setStartDay(rs.getDate("startDay"));
			bean.setEndDay(rs.getDate("endDay"));
			// bean.상태
			list.add(bean);
		}
		return list;
	}

	// ////////////출결 출결
	// 출결////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// 학생들 출결 전부 보기 attendSelectAll
	public ArrayList<StudyGroupDto> attendSelectAll() throws SQLException {
		ArrayList<StudyGroupDto> list = new ArrayList<StudyGroupDto>();
		String sql = "select classCode, className, hakbun, name from studyGroup order by classCode, hakbun";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				StudyGroupDto bean = new StudyGroupDto();
				bean.setClassCode(rs.getInt("classCode"));
				bean.setClassName(rs.getString("className"));
				bean.setHakbun(rs.getInt("hakbun"));
				bean.setName(rs.getString("name"));
				list.add(bean);
			}
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}

		return list;
	}

	// 반마다 학생 보기 (출결)
	public ArrayList<StudyGroupDto> attendSelectClass(int a)
			throws SQLException {
		ArrayList<StudyGroupDto> list = new ArrayList<StudyGroupDto>();
		String sql = "select classCode, className, hakbun, name, rate from studyGroup where classCode=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, a);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				StudyGroupDto bean = new StudyGroupDto();
				bean.setClassCode(rs.getInt("classCode"));
				bean.setClassName(rs.getString("className"));
				bean.setHakbun(rs.getInt("hakbun"));
				bean.setName(rs.getString("name"));
				bean.setRate(rs.getDouble("rate"));

				list.add(bean);
			}
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return list;
	}

	
	
	// 마이페이지 학생 출결확인 (신)
	public ArrayList<MyAttendCountDto> stuAttendCount(int hakbun) throws SQLException{
		ArrayList<MyAttendCountDto> list = new ArrayList<MyAttendCountDto>();
		String sql = "select stuCheck from attendance where hakbun=?";
		int checkDay = 0;
		int missDay = 0;
		int tardy = 0;
		try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, hakbun);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			String check = rs.getString("stuCheck");
			if(check.equals("출석")) {
				checkDay++;
			}else if(check.equals("결석")) {
				missDay++;
			}else if(check.equals("지각")) {
				tardy++;
				if(tardy==3) {
					tardy=0;
					missDay++;
				}
			}
		}
		sql = "select totalDay from studyGroup where hakbun=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, hakbun);
		rs = pstmt.executeQuery();
		int totalDay = 0;
		if(rs.next()) {
			totalDay = rs.getInt("totalDay");
			System.out.println(totalDay);
		}
		double day = ((totalDay - missDay)/(double)totalDay)*100 ;
		double rate = (int)(day*100)/100.0;
		System.out.println("rate ::: "+rate);
//		System.out.println("-----------------------");
//		System.out.println("checkDay::"+checkDay);
//		System.out.println("missDay::"+missDay);
//		System.out.println("tardy::"+tardy);
		MyAttendCountDto dto = new MyAttendCountDto();
		dto.setHakbun(hakbun);
		dto.setCheckDay(checkDay);
		dto.setMissDay(missDay);
		dto.setTardy(tardy);
		dto.setRate(rate);
		
		list.add(dto);
		System.out.println(list.toString());
		}finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return list;
	}
	
	// 마이페이지 학생 출결확인 (1인) (구)
	public ArrayList<StudyGroupDto> stuatt(int hakbun) throws SQLException {
		ArrayList<StudyGroupDto> list = new ArrayList<StudyGroupDto>();
		String sql = "select hakbun,name,className,checkDay,missDay,tardy from StudyGroup where hakbun=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hakbun);
			rs = pstmt.executeQuery();
			StudyGroupDto bean = new StudyGroupDto();
			if (rs.next()) {
				bean.setHakbun(rs.getInt("hakbun"));
				bean.setName(rs.getString("name"));
				bean.setClassName(rs.getString("className"));
				bean.setCheckDay(rs.getInt("checkDay"));
				bean.setMissDay(rs.getInt("missDay"));
				bean.setTardy(rs.getInt("tardy"));

				list.add(bean);
			}

		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return list;
	}

	// 행정팀에서 출석 확인
	public ArrayList<StudyGroupDto> adminatt() throws SQLException {
		ArrayList<StudyGroupDto> list = new ArrayList<StudyGroupDto>();
		String sql = "select classCode,className,hakbun,name,rate from StudyGroup order by classCode,hakbun";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				StudyGroupDto bean = new StudyGroupDto();

				bean.setClassCode(rs.getInt("classCode"));
				bean.setClassName(rs.getString("className"));
				bean.setHakbun(rs.getInt("hakbun"));
				bean.setName(rs.getString("name"));
				bean.setRate(rs.getDouble("rate"));
				list.add(bean);
			}

		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return list;
	}

	// 강사전용 출석 관리 ////////////////////////////////////////////
	public ArrayList<AttendanceDto> attendanceClass(String tcode)
			throws SQLException {
		ArrayList<AttendanceDto> list = new ArrayList<AttendanceDto>();
		String sql = "select A.classCode, A.className, A.hakbun, A.name, B.nalja, B.stuCheck from studyGroup A inner join attendance B On A.hakbun=B.hakbun where A.tcode=? order by B.nalja desc, A.classCode, A.hakbun";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tcode);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				AttendanceDto bean = new AttendanceDto();
				bean.setClassCode(rs.getInt("classCode"));
				bean.setClassName(rs.getString("className"));
				bean.setHakbun(rs.getInt("hakbun"));
				bean.setName(rs.getString("name"));
				bean.setNalja(rs.getDate("nalja"));
				bean.setStuCheck(rs.getString("stuCheck"));
				list.add(bean);
			}
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}

		return list;
	}

	// 출결 Update에서 처음에 select 하여 가져올 값 (해당반의 리스트 출력)
	public ArrayList<AttendanceDto> attendanceSelect(String tcode)
			throws SQLException {
		ArrayList<AttendanceDto> list = new ArrayList<AttendanceDto>();
		String sql = "select classCode, className, hakbun, name from studyGroup where tcode=? order by hakbun";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tcode);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				AttendanceDto bean = new AttendanceDto();
				bean.setClassCode(rs.getInt("classCode"));
				bean.setClassName(rs.getString("className"));
				bean.setHakbun(rs.getInt("hakbun"));
				bean.setName(rs.getString("name"));
				list.add(bean);
			}
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}

		return list;
	}

	// 강사 - 출결에서 select option을 입력된 날짜들만 select하여 option으로 출력한다
	// 후에 이 값들을 form태그 post로 쏘아 해당 날짜들의 값들만 출력할 수 있게 할 것임
	public ArrayList<AttendanceDto> attendanceDateSelect(int classCode)
			throws SQLException {
		ArrayList<AttendanceDto> list = new ArrayList<AttendanceDto>();
		String sql = "select distinct nalja from attendance where classCode=? order by nalja desc";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, classCode);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				AttendanceDto bean = new AttendanceDto();
				bean.setNalja(rs.getDate("nalja"));
				list.add(bean);
			}
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return list;
	}

	public ArrayList<AttendanceDto> attendanceByDate(String tcode, Date date)
			throws SQLException {
		ArrayList<AttendanceDto> list = new ArrayList<AttendanceDto>();
		String sql = "select A.classCode, A.className, A.hakbun, A.name, B.nalja, B.stuCheck from studyGroup A inner join attendance B On A.hakbun=B.hakbun where A.tcode=? and B.nalja=? order by A.classCode, A.hakbun";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tcode);
			pstmt.setDate(2, date);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				AttendanceDto bean = new AttendanceDto();
				bean.setClassCode(rs.getInt("classCode"));
				bean.setClassName(rs.getString("className"));
				bean.setHakbun(rs.getInt("hakbun"));
				bean.setName(rs.getString("name"));
				bean.setNalja(rs.getDate("nalja"));
				bean.setStuCheck(rs.getString("stuCheck"));
				list.add(bean);
			}
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return list;
	}

	// 로그인 세션의 tcode를 받아와서 해당 강사의 반을 select하는 메서
	public int matchClass(String tcode) throws SQLException {
		String sql = "select classCode from classData where tcode=?";
		int classCode = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tcode);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				classCode = rs.getInt("classCode");
			}
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return classCode;
	}

	// 강사가 오늘 출결 확인을 한번이라도 진행했는지 결과를 반환한다. 0이면 한번도 진행X
	public int attendanceIsCheckedToday() throws SQLException {
		int cnt = 0;
		String sql = "select count(*) cnt from attendance where nalja=TO_DATE(SYSDATE, 'RRRR-MM-DD')";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			cnt = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
		System.out.println("강사출석체크유무:" + cnt);
		return cnt;
	}

	// 강사가 출석을 수정할 때 미리 폼을 잡아줌.
	public ArrayList<AttendanceDto> attendanceClassCheckedView(String tcode)
			throws SQLException {
		ArrayList<AttendanceDto> list = new ArrayList<AttendanceDto>();
		String sql = "select A.classCode, A.className, A.hakbun, A.name, B.nalja, B.stuCheck from studyGroup A inner join attendance B On A.hakbun=B.hakbun where A.tcode=? and B.nalja=TO_DATE(SYSDATE, 'RRRR-MM-DD')";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tcode);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				AttendanceDto bean = new AttendanceDto();
				bean.setClassCode(rs.getInt("classCode"));
				bean.setClassName(rs.getString("className"));
				bean.setHakbun(rs.getInt("hakbun"));
				bean.setName(rs.getString("name"));
				bean.setNalja(rs.getDate("nalja"));
				bean.setStuCheck(rs.getString("stuCheck"));
				list.add(bean);
			}
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}

		return list;
	}
	
	// 스터디그룹에 출석/결석/지각 별로 카운트
	public void rateCheck(int hakbun,String stuCheck) throws SQLException {
		String sql = null;
		if(stuCheck.equals("출석")) {
			System.out.println(hakbun+"::::"+stuCheck);
			sql = "update studyGroup set checkDay=checkDay+1 where hakbun=?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, hakbun);
				pstmt.executeUpdate();
			}finally {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			}
			
		}else if(stuCheck.equals("결석")) {
			System.out.println(hakbun+"::::"+stuCheck);
			sql = "update studyGroup set missDay=missDay+1 where hakbun=?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, hakbun);
				pstmt.executeUpdate();
			}finally {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			}
		}else if(stuCheck.equals("지각")) {
			System.out.println(hakbun+"::::"+stuCheck);
			sql = "update studyGroup set tardy=tardy+1 where hakbun=?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, hakbun);
				pstmt.executeUpdate();
			}finally {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			}
		}
	}
	
	
	// attendanceInsert 페이지에서 입력 값 insert or update해주는 메서드
	public ArrayList<AttendanceDto> attendanceInsert(Date nalja, int classCode,
			String className, int hakbun, String name, String stuCheck,
			String task) throws SQLException {
		ArrayList<AttendanceDto> list = new ArrayList<AttendanceDto>();
		String sql = "";
		// 컨트롤러에서 받아온 값에 따라 사용 쿼리문이 바뀐다
		if (task == "insert") {
			Dao dao = new Dao();
			dao.rateCheck(hakbun, stuCheck);
			sql = "insert into attendance values (?,?,?,?,?,?)";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, classCode);
				pstmt.setString(2, className);
				pstmt.setInt(3, hakbun);
				pstmt.setString(4, name);
				pstmt.setDate(5, nalja);
				pstmt.setString(6, stuCheck);
				pstmt.executeUpdate();
			} finally {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			}
		} else {
			sql = "update attendance set stuCheck=? where hakbun =? and nalja=?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, stuCheck);
				pstmt.setInt(2, hakbun);
				pstmt.setDate(3, nalja);
				pstmt.executeUpdate();

			} finally {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			}
		}
		return list;
	}

	// 공지사항 ///////////////////////////////////////////////////////////
	// 공지사항 게시판을 표시한다..
	public ArrayList<NoticeDto> noticeSelectAll(int postCnt, int curPage)
			throws SQLException {
		// String sql = "select * from notice order by noticeNum desc";
		PagingDto pagingDto = null;
		pagingDto = new PagingDto(10, 5, postCnt, curPage);
		// PagingControl(한 화면에 보여질 총 게시글 수, 페이지 수, DB의 총 게시글 수, 현재 페이지)
		String sql = "select * from ("
				+ "select noticeNum, title, writer, writedDate, cnt, contents, rownum rnum from ("
				+ "select * from notice order by noticeNum desc)) "
				+ "where rnum between " + pagingDto.getWritingStart() + " and "
				+ pagingDto.getWritingEnd();
		ArrayList<NoticeDto> list = new ArrayList<NoticeDto>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				NoticeDto bean = new NoticeDto();
				bean.setNoticeNum(rs.getInt("noticeNum"));
				bean.setTitle(rs.getString("title"));
				bean.setWriter(rs.getString("writer"));
				bean.setWritedDate(rs.getDate("writedDate"));
				bean.setCnt(rs.getInt("cnt"));
				bean.setContents(rs.getString("contents"));
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return list;
	}

	// 공지사항을 등록한다.
	public void noticeWrite(NoticeDto noticeDto) throws SQLException {
		String sql = "insert into notice "
				+ "(noticeNum, writedDate, cnt, title,  contents) "
				+ "values(notice_seq.nextval, TO_DATE(SYSDATE, 'RRRR-MM-DD'), 1, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, noticeDto.getTitle());
			pstmt.setString(2, noticeDto.getContents());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
	}

	// 게시판 조회수 1씩 증가시킨다.
	public void noticeReadCountUp(String noticeNum) throws SQLException {
		String sql = "update notice set cnt=cnt+1 where noticeNum=?";
		int num = Integer.parseInt(noticeNum);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
	}

	// noticeNum을 가져와 게시판 글 상세 내용을 볼 수 있다.
	public NoticeDto noticeReadByNum(String noticeNum) throws SQLException {
		String sql = "select * from notice where noticeNum = ?";
		int num = Integer.parseInt(noticeNum);
		NoticeDto noticeDto = new NoticeDto();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				noticeDto.setNoticeNum(rs.getInt("noticeNum"));
				noticeDto.setTitle(rs.getString("title"));
				noticeDto.setWriter(rs.getString("writer"));
				noticeDto.setWritedDate(rs.getDate("writedDate"));
				noticeDto.setCnt(rs.getInt("cnt"));
				noticeDto.setContents(rs.getString("contents"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return noticeDto;
	}

	// 공지사항을 삭제한다.
	public void noticeDelete(String noticeNum) throws SQLException {
		String sql = "delete notice where noticeNum=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, noticeNum);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}

	}

	// 공지사항 수정
	public void noticeModify(NoticeDto noticeDto) throws SQLException {
		String sql = "update notice set title=?, contents=? where noticeNum=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, noticeDto.getTitle());
			pstmt.setString(2, noticeDto.getContents());
			pstmt.setInt(3, noticeDto.getNoticeNum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
	}

	// ////////////////////////////////////////////////////////
	// 취업현황 게시판을 표시한다.
	public ArrayList<StuEmployDto> stuEmploySelectAll(int postCnt, int curPage)
			throws SQLException {
		PagingDto pagingDto = null;
		pagingDto = new PagingDto(10, 5, postCnt, curPage);
		String sql = "select * from ("
				+ "select stuEmployNum, title, writer, writedDate, contents, rownum rnum from ("
				+ "select * from stuEmploy order by stuEmployNum desc)) "
				+ "where rnum between " + pagingDto.getWritingStart() + " and "
				+ pagingDto.getWritingEnd();
		ArrayList<StuEmployDto> list = new ArrayList<StuEmployDto>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				StuEmployDto bean = new StuEmployDto();
				bean.setStuEmployNum(rs.getInt("stuEmployNum"));
				bean.setTitle(rs.getString("title"));
				bean.setWriter(rs.getString("writer"));
				bean.setWritedDate(rs.getDate("writedDate"));
				bean.setContents(rs.getString("contents"));
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return list;
	}

	// 취업현황정보을 등록한다.
	public void stuEmployWrite(String title, String contents)
			throws SQLException {
		String sql = "insert into stuEmploy "
				+ "(stuEmployNum,writedDate, title,  contents)"
				+ "values(stuEmploy_seq.nextval, TO_DATE(SYSDATE, 'RRRR-MM-DD'), ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, contents);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
	}

	// stuEmployNum을 가져와 게시판 글 상세 내용을 볼 수 있다.
	public StuEmployDto stuEmployReadByNum(String stuEmployNum)
			throws SQLException {
		String sql = "select * from stuEmploy where stuEmployNum = ?";
		int num = Integer.parseInt(stuEmployNum);
		StuEmployDto stuEmployDto = new StuEmployDto();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				stuEmployDto.setStuEmployNum(rs.getInt("stuEmployNum"));
				stuEmployDto.setTitle(rs.getString("title"));
				stuEmployDto.setWriter(rs.getString("writer"));
				stuEmployDto.setWritedDate(rs.getDate("writedDate"));
				stuEmployDto.setContents(rs.getString("contents"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return stuEmployDto;
	}

	// 취업현황 삭제한다.
	public void stuEmployDelete(String stuEmployNum) throws SQLException {
		String sql = "delete stuEmploy where stuEmployNum=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stuEmployNum);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}

	}

	// 취업현황 수정
	public void stuEmployModify(StuEmployDto stuEmployDto) throws SQLException {
		String sql = "update stuEmploy set title=?, contents=? where stuEmployNum=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stuEmployDto.getTitle());
			pstmt.setString(2, stuEmployDto.getContents());
			pstmt.setInt(3, stuEmployDto.getStuEmployNum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
	}

	// ///////////////////////////////////////////////////// 채용공고
	// 채용공고 게시판을 표시한다.
	public ArrayList<JobNoticeDto> jobNoticeSelectAll(int postCnt, int curPage)
			throws SQLException {
		// String sql = "select * from jobNotice order by jobNoticeNum desc";
		PagingDto pagingDto = null;
		pagingDto = new PagingDto(10, 5, postCnt, curPage);
		String sql = "select * from ("
				+ "select jobNoticeNum, title, writer, company, endDay, contents, rownum rnum from ("
				+ "select * from jobNotice order by jobNoticeNum desc)) "
				+ "where rnum between " + pagingDto.getWritingStart() + " and "
				+ pagingDto.getWritingEnd();
		ArrayList<JobNoticeDto> list = new ArrayList<JobNoticeDto>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				JobNoticeDto bean = new JobNoticeDto();
				bean.setJobNoticeNum(rs.getInt("jobNoticeNum"));
				bean.setTitle(rs.getString("title"));
				bean.setWriter(rs.getString("writer"));
				bean.setCompany(rs.getString("company"));
				bean.setEndDay(rs.getDate("endDay"));
				list.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return list;
	}

	// 채용공고을 등록한다.
	public void jobNoticeWrite(String title, String company, String contents,
			Date date) throws SQLException {
		String sql = "insert into jobNotice "
				+ "(jobNoticeNum, endDay, title, company, contents) "
				+ "values(jobNotice_seq.nextval,? ,? ,? ,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, date);
			pstmt.setString(2, title);
			pstmt.setString(3, company);
			pstmt.setString(4, contents);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
	}

	// jobNoticeNum을 가져와 게시판 글 상세 내용을 볼 수 있다.
	public JobNoticeDto jobNoticeReadByNum(String jobNoticeNum)
			throws SQLException {
		String sql = "select * from jobNotice where jobNoticeNum = ?";
		int num = Integer.parseInt(jobNoticeNum);
		JobNoticeDto jobNoticeDto = new JobNoticeDto();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				jobNoticeDto.setJobNoticeNum(rs.getInt("jobNoticeNum"));
				jobNoticeDto.setTitle(rs.getString("title"));
				jobNoticeDto.setWriter(rs.getString("writer"));
				jobNoticeDto.setCompany(rs.getString("company"));
				jobNoticeDto.setEndDay(rs.getDate("endDay"));
				jobNoticeDto.setContents(rs.getString("contents"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return jobNoticeDto;
	}

	// 채용공고를 삭제한다.
	public void jobNoticeDelete(String jobNoticeNum) throws SQLException {
		String sql = "delete jobNotice where jobNoticeNum=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jobNoticeNum);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}

	}

	// 채용공고 수정
	public void jobNoticeModify(JobNoticeDto jobNoticeDto) throws SQLException {
		String sql = "update jobNotice set title=?, contents=? where jobNoticeNum=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, jobNoticeDto.getTitle());
			pstmt.setString(2, jobNoticeDto.getContents());
			pstmt.setInt(3, jobNoticeDto.getJobNoticeNum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
	}

	// //////////////////////////////////////////////////종강////////////////////////////////////////////////////

	// 과목 리스트 불러오기
	public ArrayList<ClassDto> endClass() throws SQLException {
		ArrayList<ClassDto> list = new ArrayList<ClassDto>();
		String sql = "select classCode, className, teacher, tcode, startDay,endDay from classData where not tcode='0'";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ClassDto bean = new ClassDto();
				bean.setClassCode(rs.getInt("classCode"));
				bean.setClassName(rs.getString("className"));
				bean.setTeacher(rs.getString("teacher"));
				bean.setTcode(rs.getString("tcode"));
				bean.setStartDay(rs.getDate("startDay"));
				bean.setEndDay(rs.getDate("endDay"));
				list.add(bean);
			}
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}

		return list;
	}

	// 종강 버튼 누르고 tcode 0으로 변화
	public void tcodeZero(int classCode) throws SQLException {
		String sql = "update classData set tcode='0' where classCode=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, classCode);
			pstmt.executeUpdate();
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
	}

	// class 종강
	public void classEnd(int classCode) throws SQLException {
		String sql = "delete from studyGroup where classCode=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, classCode);
			pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
	}

	// 국비지원과정 목록 select
	public ArrayList<ClassDto> subListSelect() throws SQLException {
		ArrayList<ClassDto> list = new ArrayList<ClassDto>();
		String sql = "select classCode, className, teacher, tcode, startDay, endDay, TO_DATE(endDay)-TO_DATE(startDay) as totalDay, filePath from classData where not tcode='0'";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ClassDto bean = new ClassDto();
				bean.setClassCode(rs.getInt("classCode"));
				bean.setClassName(rs.getString("className"));
				bean.setTeacher(rs.getString("teacher"));
				bean.setTcode(rs.getString("tcode"));
				bean.setStartDay(rs.getDate("startDay"));
				bean.setEndDay(rs.getDate("endDay"));
				bean.setTotalDay(rs.getInt("totalDay"));
				bean.setFilePath(rs.getString("filePath"));
				list.add(bean);
				System.out.println(list.toString());
			}
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return list;
	}

	public ArrayList<ClassDto> subDetailSelect(int classCode)
			throws SQLException {
		ArrayList<ClassDto> list = new ArrayList<ClassDto>();
		String sql = "select classCode, className, teacher, tcode, startDay, endDay, TO_DATE(endDay)-TO_DATE(startDay) as totalDay, filePath from classData where classCode=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, classCode);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ClassDto bean = new ClassDto();
				bean.setClassCode(classCode);
				bean.setClassName(rs.getString("className"));
				bean.setTeacher(rs.getString("teacher"));
				bean.setTcode(rs.getString("tcode"));
				bean.setStartDay(rs.getDate("startDay"));
				bean.setEndDay(rs.getDate("endDay"));
				bean.setTotalDay(rs.getInt("totalDay"));
				bean.setFilePath(rs.getString("filePath"));
				list.add(bean);
			}
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return list;
	}

	// ------------------------------------- 수강신청
	// --------------------------------------------//
	// 최초 수강신청
	public int applyBySub(int hakbun, String name, int classCode,
			String className, String tcode) throws SQLException {
		String sql = "insert into stuAssignment values (?,?,?,?,?,sysdate,1)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hakbun);
			pstmt.setString(2, name);
			pstmt.setString(3, tcode);
			pstmt.setInt(4, classCode);
			pstmt.setString(5, className);
			pstmt.executeUpdate();
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return 1;
	}

	// 중복 수강신청을 방지하기 위해 stuAssignment테이블에 있는지 확인
	// 0이면 중복되지 않음 0이 아니면 중복
	public int applyOverlap(int hakbun) throws SQLException {
		String sql = "select * from stuAssignment where hakbun=?";
		int check = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hakbun);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				check = rs.getInt("hakbun");
			}
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return check;
	}

	// -----------------------------------------------------------------------------------------//
	// ------------------------------------- 학생배정
	// --------------------------------------------//
	public ArrayList<StuAssignmentDto> stuAssignmentSelect()
			throws SQLException {
		ArrayList<StuAssignmentDto> list = new ArrayList<StuAssignmentDto>();
		String sql = "select hakbun, name, tcode, classCode, className, applyDate, temp from stuAssignment where temp=1";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				StuAssignmentDto bean = new StuAssignmentDto();
				bean.setHakbun(rs.getInt("hakbun"));
				bean.setName(rs.getString("name"));
				bean.setTcode(rs.getString("tcode"));
				bean.setClassCode(rs.getInt("classCode"));
				bean.setClassName(rs.getString("className"));
				bean.setApplyDate(rs.getDate("applyDate"));
				bean.setTemp(rs.getInt("temp"));
				list.add(bean);
			}
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return list;
	}

	// ————————————————————————————————————————————//

}