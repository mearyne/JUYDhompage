package order;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;

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

	public int addOrder(orderDTO order) { // 유저를 데이터베이스에 추가한다
		int year = order.getYear();
		int month = order.getMonth();
		int day = order.getDay();

		Date date = new Date(year - 1900, month - 1, day + 1);
		System.out.println(date);
		Timestamp bookingData = new Timestamp(date.getTime());

		String sql = "insert into orderlist values(?,?,?,?)"; // sql은 인덱스 1부터 시작
		try {
			conn = DBManager.getConnection("booking");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, order.getOderCode());
			pstmt.setInt(2, order.getUserCode());
			pstmt.setInt(3, order.getShopCode());
			pstmt.setTimestamp(4, bookingData);
			boolean suc = pstmt.execute();
			System.out.println(suc);
			// pstmt (쿼리 날릴) 준비 완료
			if (!suc) {
				System.out.println("insert 완료");
				pstmt = null;
				return 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("insert 실패");
			pstmt = null;
			e.printStackTrace();
		}
		return -1;
	}

	public int ordersize() {
		String sql = "select * from orderlist";
		int size = 0;
		try {
			conn = DBManager.getConnection("booking");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println(rs);

			while (rs.next()) {
				size++;
			}
			System.out.println("사이즈 확인 성공");
			return size;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("사이즈 확인 실패");
			e.printStackTrace();
		}
		return size;
	}

	public ArrayList<orderDTO> getuserlist(int usercode) {
		String sql = "select * from orderlist where userCode= ?";
		ArrayList<orderDTO> orderlist = new ArrayList<orderDTO>();
		try {
			conn = DBManager.getConnection("booking");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, usercode);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int ordercode = rs.getInt(1);
				int ucode = rs.getInt(2);
				int shopcode = rs.getInt(3);
				Timestamp bookingdate = rs.getTimestamp(4);
				orderDTO dto = new orderDTO(ordercode, ucode, shopcode, bookingdate.getYear(), bookingdate.getMonth(),
						bookingdate.getDate());
				orderlist.add(dto);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return orderlist;
	}

}
