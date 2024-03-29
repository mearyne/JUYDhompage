package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
	// 데이터베이스를 연동하는데 필요한 connector 메소드가 있는 자리입니다
	// DBManager.getConnection();
	// 외부 클래스에서 db연동이 필요할때, Connection을 얻어갈수있음
	public static Connection getConnection(String database) {
		Connection conn = null;
		// jdbc:mysql://rds-booking.cnmhmmgrklba.ap-northeast-2.rds.amazonaws.com:3306/
		String url = String.format("jdbc:mysql://green-database.cnmhmmgrklba.ap-northeast-2.rds.amazonaws.com:3306/%s?serverTimezone=UTC",database);
		String user = "admin";
		String password = "1^QLkWd6s9i4";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("DB연동 성공");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DB연동 실패");
			return null;
		}
	}
}
