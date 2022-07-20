package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import util.DBManager;

public class userDAO {
	// 유저DAO
	private static userDAO instance = new userDAO();

	public static userDAO getInstance() {
		return instance;
	}

	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;

	// 유저를 데이터베이스에 추가한다
	public boolean addUser(userDTO user) {
		String sql = "insert into user values(?,?,?,?,?)"; // sql은 인덱스 1부터 시작
		try {
			conn = DBManager.getConnection("booking");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user.getUserCode());
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, user.getUserId());
			pstmt.setString(4, user.getUserPw());
			pstmt.setString(5, user.getUserContact());
			boolean suc = pstmt.execute();
			System.out.println(suc);
			// pstmt (쿼리 날릴) 준비 완료
			if (!suc) {
				System.out.println("insert 완료");
				pstmt = null;
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("insert 실패");
			pstmt = null;
			e.printStackTrace();
		}
		return false;
	}

	// MySQL에서 로그인 여부를 판단하는 메소드
	public int checkUserLogin(String userId, String userPw) {
		int check = -1;
		String sql = "SELECT * FROM user WHERE userId=? and userPw=?";
		conn = DBManager.getConnection("booking");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println("LOGIN CHECK SUCCESS!");
				check = rs.getInt(1);
			} else {
				System.out.println("LOGIN CHECK FAIL!");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("LOGIN ERROR!");
		} finally {
			conn = null;
			
		}
		System.out.println("로그인할때 logCode 값은 "+ check+"입니다");
		return check;
	}

	// 마이페이지 현재 로그인한 유저의 정보를 가져오기
	public userDTO getData(int code) {
		String sql = "select * from user where userCode =?";
		try {
			if (conn == null) {
				conn = DBManager.getConnection("booking");
			}
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, code);
			rs = pstmt.executeQuery();
			System.out.println(rs);
			while (rs.next()) {

				int no = rs.getInt(1);
				String name = rs.getString(2);
				String id = rs.getString(3);
				String pw = rs.getString(4);
				String con = rs.getString(5);
//				System.out.println(no);
//				System.out.println(name);
//				System.out.println(id);
//				System.out.println(pw);
//				System.out.println(con);
				userDTO dto = new userDTO(no, name, id, pw, con);
				conn = null;

				return dto;
			}

			System.out.println("성공");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("실패");
			e.printStackTrace();

		} finally {
			conn = null;
			pstmt = null;
		}
		return null;
	}

	// 랜덤 4자리코드를 생성하고 중복확인하는 메소드
	public int chkCode() {
		Random ran = new Random();
		int ranNum = ran.nextInt(899) + 1000;
		System.out.println(ranNum);
		try {
			conn = DBManager.getConnection("booking");
			String sql = "select userCode from user";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int code = rs.getInt(1);
				System.out.println(code);
				if (code != 1) {
					System.out.println("중복 없음");
					return ranNum;
				}
				pstmt = null;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("중복 있음");
			pstmt = null;
			e.printStackTrace();
		}
		return -1;
	}

	public boolean chkDuplId(String inputId) {
		String sql = "select * from user where userId =?";
		try {
			conn = DBManager.getConnection("booking");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inputId);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				System.out.println("중복된 아이디입니다");
				return false;
			} else {
				System.out.println("중복된 아이디가 아닙니다");
				return true;
			}

		} catch (Exception e) {
			System.out.println("실패");
			e.printStackTrace();

		}

		return false;
	}

	public boolean updatePw(int code, String pw, String chPw, String doubleChkPw) {
		// 현재 비밀번호와 바꿀 비밀번호를 비교하고 일치하지않는지 확인
		System.out.println("비밀번호 바꾸는중");

		boolean check = checkPw(pw, chPw);
		System.out.println(check);

		if (!check) {
			check = doubleCheckPw(chPw, doubleChkPw);
			System.out.println(check);
			if (check) {
				try {
					String sql = "UPDATE user SET userPw=? where userCode=?;";
					conn = DBManager.getConnection("booking");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, chPw);
					pstmt.setInt(2, code);

					int temp = pstmt.executeUpdate();
					System.out.println(temp);
					return true;
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	public boolean checkPw(String pw, String chpw) { // 현재 비밀번호와 바꿀 비밀번호 확인(일치하지 않아야함)
		if (pw.equals(chpw)) {
			System.out.println("일치합니다");
			return true;
		} else {
			System.out.println("일치하지않습니다");
		}
		return false;
	}

	public boolean doubleCheckPw(String chpw, String doubleChkPw) { // 바꿀 비밀번호와 재확인 비밀번호 확인(일치해야 함)
		if (chpw.equals(doubleChkPw)) {
			System.out.println("일치합니다");
			return true;
		} else {
			System.out.println("일치하지않습니다");
		}
		return false;

	}

}
