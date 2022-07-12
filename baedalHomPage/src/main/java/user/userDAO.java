package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

	public boolean addUser() { // 유저를 데이터베이스에 추가한다
		String sql = "insert into user values(?,?,?,?,?)"; // sql은 인덱스 1부터 시작
		try {
			conn = DBManager.getConnection("booking");
			pstmt = conn.prepareStatement(sql);

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
	public boolean checkUserLogin(String userId, String userPw) {
		boolean check = false;
		String sql = "SELECT * FROM user WHERE userId=? and userPw=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPw);

			check = pstmt.execute();
			System.out.println("LOGIN CHECK SUCCESS!");

			if (check) {
				check = true; // 아이디와 비밀번호 일치
			} else {
				check = false; // 아이디와 비밀번호 불일치
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("LOGIN ERROR!");
		}
		return check;
	}
}
