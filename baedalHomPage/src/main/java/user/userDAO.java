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

	public boolean addUser() {

		// 1.
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
	

	
	public int login(String userId, String userPw) {
		int check=-1; // 기본값으로 아이디가 없을때 반환
		String sql = "SELECT * FROM user WHERE userId=?";
		
		try {
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(userPw)) {
					check = 1; // 아이디와 비밀번호 일치
				}else{
					check = 0; // 비밀번호 불일치
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("ERROR!");
		}
		return check;
	}
}

