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

	// 가게코드를 이용해서 가게 데이터를 가져옴
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
				double shopX = rs.getDouble(11);
				double shopY = rs.getDouble(12);

				shopDTO dto = new shopDTO(shopCode, masterCode, shopName, shopCategory, shopAddress, shopPic, shopPhone,
						shopContents, shopStar, reviewNum, shopX, shopY);

				return dto;
			}

			System.out.println("성공");

		} catch (Exception e) {
			System.out.println("실패");
			e.printStackTrace();

		}
		return null;

	}

	// 가게 데이터 전부를 가져옴
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
				double shopX = rs.getDouble(11);
				double shopY = rs.getDouble(12);
				
				System.out.println(shopX);
				System.out.println(shopY);
				
				shopDTO shop = new shopDTO(shopCode, shopName, shopCategory, shopPic, shopStar, shopX, shopY);
				
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
	
	// master코드를 이용해서 가게 데이터를 가져옴
	public shopDTO getShopOfMasterCode(int inputCode) {
		String sql = "select * from shop where masterCode =?";
		try {
			conn = DBManager.getConnection("booking");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, inputCode);
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
				double shopX = rs.getDouble(11);
				double shopY = rs.getDouble(12);

				shopDTO dto = new shopDTO(shopCode, masterCode, shopName, shopCategory, shopAddress, shopPic, shopPhone,
						shopContents, shopStar, reviewNum, shopX, shopY);

				return dto;
			}

			System.out.println("성공");

		} catch (Exception e) {
			System.out.println("실패");
			e.printStackTrace();

		}
		return null;
		
		
	}

	// 가게 정보를 업데이트 한다
	public void updateShopInfo(int shopCode, String address, double shopX, double shopY) {
		String sql = "update shop set shopAddress=?, X=?, Y=? where shopCode=?";
		try {
			conn = DBManager.getConnection("booking");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, address);
			pstmt.setDouble(2, shopX);
			pstmt.setDouble(3, shopY);
			pstmt.setInt(4, shopCode);
			
			pstmt.execute();

			System.out.println("주소 업데이트 성공");
		} catch (Exception e) {
			System.out.println("주소 업데이트 실패");
			e.printStackTrace();

		}
		
	}
}