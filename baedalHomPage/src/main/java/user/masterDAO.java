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
	public boolean checkMasterLogin(String masterId, String masterPw) {
		boolean check = false; // 기본값으로 아이디가 없을때 반환
		String sql = "SELECT * FROM master WHERE masterId=? and masterPw=?";
		conn = DBManager.getConnection("booking");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, masterId);
			pstmt.setString(2, masterPw);

			rs = pstmt.executeQuery();
			rs.next();
			System.out.println("LOGIN CHECK SUCCESS!");

			if (rs.getInt(1) > 0) {
				check = true; // 아이디와 비밀번호 일치
			} else {
				check = false; // 아이디와 비밀번호 불일치
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("LOGIN ERROR!");
		}
		return check;
	}
	
	public boolean addUser(masterDTO master) { // 유저를 데이터베이스에 추가한다
		String sql = "insert into master values(?,?,?,?,?,?)"; // sql은 인덱스 1부터 시작
		try {
			conn = DBManager.getConnection("booking");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, master.getMasterCode());
			pstmt.setString(2, master.getMasterName());
			pstmt.setString(3, master.getMasterId());
			pstmt.setString(4, master.getMasterPw());
			pstmt.setString(5, master.getMasterContact());
			pstmt.setString(6, master.getMasterAddress());
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
	
	public int chkCode() { // 랜덤 4자리코드를 생성하고 중복확인하는 메소드
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
			// TODO: handle exception
			System.out.println("중복 있음");
			pstmt=null;
			e.printStackTrace();
		}
		return -1;
	}
}
