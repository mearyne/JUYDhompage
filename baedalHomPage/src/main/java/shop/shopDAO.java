package shop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

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

	// 랜덤 shopCode 반환함
	public int rCode() {
		Random rand = new Random();
		int rCode = -1;
		try {
			String sql = "select * from shop where shopCode = ?";
			while (true) {
				rCode = rand.nextInt(8999) + 1000;
				conn = DBManager.getConnection("booking");
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, rCode);
				
				rs = pstmt.executeQuery();
				if (!rs.next()) {
					System.out.println("shop랜덤코드 반환 성공");
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("shop랜덤코드 반환 실패");
		}

		return rCode;
	}

	public void updateShopInfo(shopDTO shopDTO) {
		String sql = "update shop set shopName=?, shopCategory=?, shopPic=?, shopPhone=?, shopContents=?, shopAddress=?, X=?, Y=?  where shopCode=?";
		try {
			
			conn = DBManager.getConnection("booking");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, shopDTO.getShopName());
			pstmt.setString(2, shopDTO.getShopCategory());
			pstmt.setString(3, shopDTO.getShopPic());
			pstmt.setString(4, shopDTO.getShopPhone());
			pstmt.setString(5, shopDTO.getShopContents());
			pstmt.setString(6, shopDTO.getShopAddress());
			pstmt.setDouble(7, shopDTO.getShopX());
			pstmt.setDouble(8, shopDTO.getShopY());
			pstmt.setInt(9, shopDTO.getShopCode());

			pstmt.execute();

			System.out.println("주소 업데이트 성공");
		} catch (Exception e) {
			System.out.println("주소 업데이트 실패");
			e.printStackTrace();

		}

	}

	public void createShopDTO(shopDTO shopDTO) {
		String sql = "insert into shop values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			
			conn = DBManager.getConnection("booking");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, shopDTO.getShopCode());
			pstmt.setInt(2, shopDTO.getMasterCode());
			pstmt.setString(3, shopDTO.getShopName());
			pstmt.setString(4, shopDTO.getShopCategory());
			pstmt.setString(5, shopDTO.getShopAddress());
			pstmt.setString(6, shopDTO.getShopPic());
			pstmt.setString(7, shopDTO.getShopPhone());
			pstmt.setString(8, shopDTO.getShopContents());
			pstmt.setInt(9, 0);
			pstmt.setInt(10, 0);
			pstmt.setDouble(11, shopDTO.getShopX());
			pstmt.setDouble(12, shopDTO.getShopY());
			
			pstmt.execute();
			
			System.out.println("주소 업데이트 성공");
		} catch (Exception e) {
			System.out.println("주소 업데이트 실패");
			e.printStackTrace();
			
		}
		
	}
}