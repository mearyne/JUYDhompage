package menu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import shop.shopDTO;

import java.sql.DriverManager;

import util.DBManager;

public class menuDAO {
	private static menuDAO instance = new menuDAO();

	public static menuDAO getInstance() {
		return instance;
	}

	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;

	public ArrayList<menuDTO> menuInfo(int inputShopCode) {
		String sql = "select * from menu where shopCode =?";
		ArrayList<menuDTO> menuArr = new ArrayList<menuDTO>();
		try {
			conn = DBManager.getConnection("booking");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, inputShopCode);

			rs = pstmt.executeQuery();
			System.out.println(rs);
			
			// shopCode를 가지고 있는 모든 menu들을 배열 안에 집어넣어서 반환시킨다
			while (rs.next()) {
				int menuCode = rs.getInt(1);
				int shopCode = rs.getInt(2);
				int menuPrice = rs.getInt(3);
				String menuName = rs.getString(4);
				String menuPicture = rs.getString(5);
				String menuContents = rs.getString(6);

				menuDTO menu = new menuDTO(menuCode, shopCode, menuPrice, menuName, menuPicture, menuContents);
				menuArr.add(menu);
			}
			System.out.println("메뉴 반환 성공");
			return menuArr;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("메뉴 반환 실패");
			e.printStackTrace();
			
		}
		return null;
	}
	public boolean deletemunu(int menucode) {
		String sql = "delete from menu where menuCode =?";
		try {
			conn=DBManager.getConnection("booking");
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,menucode);
			int chk =pstmt.executeUpdate();
			if(chk == 1) {
				System.out.println("삭제 완료");
				return true;
			}
		}catch (Exception e) {
			System.out.println("삭제 실패");
			// TODO: handle exception
		}
		return false;
	}
	
	public boolean addmenu(menuDTO dto) {
		String sql = "insert into menu values (?,?,?,?,?,?)";
		try {
			conn=DBManager.getConnection("booking");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getMenuCode());
			pstmt.setInt(2, dto.getShopCode());
			pstmt.setInt(3, dto.getMenuPrice());
			pstmt.setString(4, dto.getMenuName());
			pstmt.setString(5, dto.getMenuPicture());
			pstmt.setString(6, dto.getMenuContents());
			boolean chk = pstmt.execute();
			
			if(!chk) {
				System.out.println("메뉴 추가완료");
				pstmt = null;
				return true;
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("메뉴 추가실패");
			pstmt = null;
			e.printStackTrace();
		}
		return false;
	}
	
	public int menusize() {
		String sql = "select * from menu";
		int size = 1;
		try {
			conn = DBManager.getConnection("booking");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println(rs);

			while (rs.next()) {
				int menu =rs.getInt(1);
				if(menu!=size)
					return size;
				size++;
			}
			System.out.println("사이즈 확인 성공");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("사이즈 확인 실패");
			e.printStackTrace();
		}
		return size;
	}
}
