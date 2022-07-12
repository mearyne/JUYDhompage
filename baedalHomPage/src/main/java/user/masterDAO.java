package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class masterDAO {
	// masterDAO
	private static masterDAO instance = new masterDAO();

	public static masterDAO getInstance() {
		return instance;
	}

	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;

	// MySQL에서 로그인 여부를 판단하는 메소드
	public boolean checkMasterLogin(String masterId, String masterPw) {
		boolean check = false; // 기본값으로 아이디가 없을때 반환
		String sql = "SELECT * FROM master WHERE masterId=? and masterPw=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, masterId);
			pstmt.setString(2, masterPw);

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
