package order;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import util.DBManager;

public class orderDAO {
	// orderDAO
		private static orderDAO instance = new orderDAO();

		public static orderDAO getInstance() {
			return instance;
		}

		private Connection conn = null;
		private ResultSet rs = null;
		private PreparedStatement pstmt = null;

		public boolean addUser(orderDTO oder) { // 유저를 데이터베이스에 추가한다
			Date date = new Date(oder.getYear()-1900,oder.getMonth(),oder.getDay());
			Timestamp bookingData = new Timestamp(date.getTime());
			String sql = "insert into order values(?,?,?,?,?)"; // sql은 인덱스 1부터 시작
			try {
				conn = DBManager.getConnection("booking");
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, oder.getOderCode());
				pstmt.setInt(2, oder.getUserCode());
				pstmt.setInt(3, oder.getShopCode());
				pstmt.setInt(4, oder.getMenuCode());
				pstmt.setTimestamp(5, bookingData);
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


		
	
	
	
}
