package review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import shop.shopDTO;
import util.DBManager;

public class reviewDAO {
	
	private static reviewDAO instance = new reviewDAO();
	
	
	public static reviewDAO getInstance() {
		return instance;
	}
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;
	
	public ArrayList<reviewDTO> getshop(int code) {
		String sql ="select * from review where shopCode =?";
		ArrayList<reviewDTO> reviewD =new ArrayList<>();
		try {
			conn = DBManager.getConnection("booking");
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, code);
			rs=pstmt.executeQuery();
			System.out.println(rs);
			
			while(rs.next()) {
				
			int reviewCode = rs.getInt(1);
			int shopCode = rs.getInt(2);
			int userCode = rs.getInt(3);
			int orderCode = rs.getInt(4);
			int reviewStar = rs.getInt(5);
			String shopContents = rs.getString(6);
			String shopPic = rs.getString(7);
			
			reviewDTO dto = new reviewDTO(reviewCode, shopCode, userCode, orderCode, reviewStar, shopContents, shopPic);
			reviewD.add(dto);
			}
			System.out.println("성공");
			return reviewD;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("실패");
			e.printStackTrace();
		}		
		return null;
	}

}