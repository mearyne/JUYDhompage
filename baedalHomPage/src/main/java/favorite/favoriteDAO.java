package favorite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	
	public boolean chkfav(int shopcode, int usercode) { // 찜목록이 이미 추가되어있는지 확인
		String sql = "select * from favorite where shopCode =? and userCode=?";
		try {
			conn = DBManager.getConnection("booking");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, shopcode);
			pstmt.setInt(2, usercode);
			rs = pstmt.executeQuery();
			if(rs.next()) {
			int Scode=0;
			Scode=rs.getInt(1);
			System.out.println("Scode ="+Scode);
			if(Scode!=0) {
				System.out.println("찜 추가가능");
				return true;
			}
			}
			
//			while (rs.next()) {
//				int favoriteCode = rs.getInt(1);
//				int userCode = rs.getInt(2);
//				int shopCode = rs.getInt(3);
//				System.out.println(favoriteCode);
//				System.out.println(userCode);
//				System.out.println(shopCode);
//				
//
//				favoriteDTO favorList = new favoriteDTO(favoriteCode,userCode,shopCode);
//				return true;
//			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("이미 찜상태");
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean addfavorite(favoriteDTO fav) {
		String sql = "insert into favorite values(?,?,?)"; // sql은 인덱스 1부터 시작
		try {
			conn = DBManager.getConnection("booking");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, fav.getFavoriteCode());
			pstmt.setInt(2, fav.getUserCode());
			pstmt.setInt(3, fav.getShopCode());
			
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
	public int favoritesize() {
		String sql = "select * from favorite";
		int size =0;
		try {
			conn = DBManager.getConnection("booking");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println(rs);
			
			while (rs.next()) {
				size++;
			}
			System.out.println("찜 불러오기 성공");
			return size;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("찜 불러오기 실패");
			e.printStackTrace();
		}
		return size;
	}
	public ArrayList<favoriteDTO> getuserfavorite(int code){
		String sql = "select * from favorite where userCode=?";
		ArrayList<favoriteDTO> favoriteD = new ArrayList<favoriteDTO>();
		try {
			conn = DBManager.getConnection("booking");
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, code);
			rs=pstmt.executeQuery();
			System.out.println(rs);
			
			while(rs.next()) {
				int favoCode= rs.getInt(1);
				int userCode =rs.getInt(2);
				int shopCode= rs.getInt(3);
				
				favoriteDTO dto = new favoriteDTO(favoCode,userCode,shopCode);
				favoriteD.add(dto);			
			}
			System.out.println("성공");
			return favoriteD;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("실패");
			e.printStackTrace();
		}		
		return null;
		
	}

}
