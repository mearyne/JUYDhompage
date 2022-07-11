package menu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

import util.DBManager;

public class menuDAO {
	private static menuDAO instance = new menuDAO();
	public static menuDAO getInstance() {
		return instance;
	}
	
	private Connection conn = null;
	private ResultSet rs =null;
	private PreparedStatement pstmt =null; 
	
	public boolean addUser() {
		
		//1.
		String sql= "insert into menu values(1,2,3,'4','5','6')"; //sql은 인덱스 1부터 시작
		try {
			conn=DBManager.getConnection("booking");
			pstmt = conn.prepareStatement(sql);
			
			
			boolean suc = pstmt.execute();
			System.out.println(suc);
			//pstmt (쿼리 날릴) 준비 완료
			if(!suc) {
				System.out.println("insert 완료");
				pstmt=null;
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("insert 실패");
			pstmt=null;
			e.printStackTrace();
		}
		return false;
	}
}
