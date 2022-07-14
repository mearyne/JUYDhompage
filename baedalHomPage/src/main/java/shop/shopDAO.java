package shop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import menu.menuDTO;
import user.userDTO;
import util.DBManager;

public class shopDAO {
	// shopDAO

	private static shopDAO instance = new shopDAO();

	public static shopDAO getInstance() {
		return instance;
	}

	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;

	public shopDTO getshopData(int code) {
		String sql = "select * from shop where shopCode =?";
		try {
			conn = DBManager.getConnection("booking");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, code);
			rs = pstmt.executeQuery();
			System.out.println(rs);
			while (rs.next()) {

				int shopCode = rs.getInt(1);
				int masterCode = rs.getInt(2);
				String shopName = rs.getString(3);
				String shopCategory = rs.getString(4);
				String shopAddress = rs.getString(5);
				String shopPic = rs.getString(6);
				String shopPhone = rs.getString(7);
				String shopContents = rs.getString(8);
				int shopStar = rs.getInt(9);
				int reviewNum = rs.getInt(10);

				shopDTO dto = new shopDTO(shopCode, masterCode, shopName, shopCategory, shopAddress, shopPic, shopPhone,
						shopContents, shopStar, reviewNum);

				return dto;
			}

			System.out.println("성공");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("실패");
			e.printStackTrace();

		}
		return null;

	}

	public ArrayList<shopDTO> bringShopArr() {
		String sql = "select * from shop";
		ArrayList<shopDTO> shopArr = new ArrayList<shopDTO>();
		try {
			conn = DBManager.getConnection("booking");
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			System.out.println(rs);
			
			// shopCode를 가지고 있는 모든 menu들을 배열 안에 집어넣어서 반환시킨다
			while (rs.next()) {
				int shopCode = rs.getInt(1);
				String shopName = rs.getString(3);
				String shopCategory = rs.getString(4);
				String shopPic = rs.getString(6);
				int shopStar = rs.getInt(9);

				shopDTO shop = new shopDTO(shopCode, shopName, shopCategory, shopPic, shopStar);
				
				shopArr.add(shop);
			}
			System.out.println("가게 반환 성공");
			return shopArr;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("가게 반환 실패");
			e.printStackTrace();
			
		}
		return null;
	}
	
}