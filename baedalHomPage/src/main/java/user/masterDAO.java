package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import util.DBManager;

public class masterDAO {
	// masterDAO
	private static masterDAO instance = new masterDAO();

	public static masterDAO getInstance() {
		return instance;
	}

	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;

	// MySQL에서 로그인 여부를 판단하는 메소드
	public int checkMasterLogin(String masterId, String masterPw) {
		int check = -1; // 기본값으로 아이디가 없을때 반환
		String sql = "SELECT * FROM master WHERE masterId=? and masterPw=?";

		try {
			conn = DBManager.getConnection("booking");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, masterId);
			pstmt.setString(2, masterPw);

			rs = pstmt.executeQuery();
			rs.next();
			System.out.println("LOGIN CHECK SUCCESS!");

			if (rs.getInt(1) > 0) {
				check = rs.getInt(1); // 아이디와 비밀번호 일치
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("LOGIN ERROR!");
		}
		return check;
	}
	
	// 유저를 데이터베이스에 추가한다
	public boolean addUser(masterDTO master) { 
		String sql = "insert into master values(?,?,?,?,?,?)"; // sql은 인덱스 1부터 시작
		try {
			conn = DBManager.getConnection("booking");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, master.getMasterCode());
			pstmt.setInt(2, master.getMastrShopCode());
			pstmt.setString(3, master.getMasterName());
			pstmt.setString(4, master.getMasterId());
			pstmt.setString(5, master.getMasterPw());
			pstmt.setString(6, master.getMasterContact());
			boolean suc = pstmt.execute();
			System.out.println(suc);
			// pstmt (쿼리 날릴) 준비 완료
			if (!suc) {
				System.out.println("insert 완료");
				pstmt = null;
				return true;
			}
		} catch (SQLException e) {
			System.out.println("insert 실패");
			pstmt = null;
			e.printStackTrace();
		}
		return false;
	}
	
	// 마이페이지 현재 로그인한 마스터의 정보를 가져오기
	public masterDTO getData(int code) { 
		String sql ="select * from master where masterCode =?";
		try {
			conn = DBManager.getConnection("booking");
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, code);
			rs=pstmt.executeQuery();
			System.out.println(rs);
			while(rs.next()) {
				
			int no = rs.getInt(1);
			int shop = rs.getInt(2);
			String name = rs.getString(3);
			String id = rs.getString(4);
			String pw = rs.getString(5);
			String con = rs.getString(6);
			System.out.println(no);
			System.out.println(shop);
			System.out.println(name);
			System.out.println(id);
			System.out.println(pw);
			System.out.println(con);
			masterDTO dto = new masterDTO(no,shop,name,id,pw,con);
			return dto;
			}
					
			System.out.println("성공");
			
			
		} catch (Exception e) {
			System.out.println("실패");
			e.printStackTrace();
			
		}		
		return null;
	}
	
	// 랜덤 4자리코드를 생성하고 중복확인하는 메소드
	public int chkCode() { 
		Random ran=new Random();
		int ranNum=ran.nextInt(899)+1000;
		System.out.println(ranNum);
		try {
			conn = DBManager.getConnection("booking");
			String sql = "select masterCode from manager";
			pstmt = conn.prepareStatement(sql);		
			rs = pstmt.executeQuery(); 
			
			while (rs.next()) {
				int code=rs.getInt(1);
				System.out.println(code);
				if(code!=1) {
					System.out.println("중복 없음");
					return ranNum;
				}
				pstmt=null;
			}
		} catch (SQLException e) {
			System.out.println("중복 있음");
			pstmt=null;
			e.printStackTrace();
		}
		return -1;
	}
	
	//현재 비밀번호와 바꿀 비밀번호를 비교하고 일치하지 않으면 바꿀 비밀번호를 두번 입력받아서 비밀번호 변경
	public boolean updateMasterPw(String code,String pw,String chPw,String doubleChkPw) { 
		if(!pw.equals(chPw)) {
			if(chPw.equals(doubleChkPw)) {
				try {
					String sql = "UPDATE master SET masterPw=? where masterCode=?;";
					conn = DBManager.getConnection("booking");
					pstmt = conn.prepareStatement(sql);		
					pstmt.setString(1, chPw);
					pstmt.setInt(2, Integer.parseInt(code));
					
					int temp = pstmt.executeUpdate(); 
					System.out.println(temp);
					return true;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
}
