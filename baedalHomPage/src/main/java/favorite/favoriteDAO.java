package favorite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DBManager;

public class favoriteDAO {
	private static favoriteDAO instance = new favoriteDAO();

	public static favoriteDAO getInstance() {
		return instance;
	}

	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;

	public favoriteDTO getFavorite() { //찜목록 전체 불러오기
		String sql = "select * from favorite";
		try {
			conn = DBManager.getConnection("booking");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println(rs);
			
			while (rs.next()) {
				int favoriteCode = rs.getInt(1);
				int userCode = rs.getInt(2);
				int shopCode = rs.getInt(3);
				System.out.println(favoriteCode);
				System.out.println(userCode);
				System.out.println(shopCode);
				

				favoriteDTO favorList = new favoriteDTO(favoriteCode,userCode,shopCode);
				return favorList;
			}
			System.out.println("찜 불러오기 성공");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("찜 불러오기 실패");
			e.printStackTrace();
		}
		return null;

	}

}
