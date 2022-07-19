package qna;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import util.DBManager;

public class QnaDAO {

	private static QnaDAO instance = new QnaDAO();

	public static QnaDAO getInstance() {
		return instance;
	}

	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;

	public boolean addQnaData(QnaDTO dto) { // qna 추가
		Date date = new Date(dto.getYear()-1900,dto.getMonth()-1,dto.getDay());
		Timestamp up_date = new Timestamp(date.getTime());
		String sql = "insert into qna values(?,?,?,?,?)";

		try {
			conn = DBManager.getConnection("booking");
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, dto.getNo());
			pstmt.setInt(2, dto.getUserCode());
			pstmt.setString(3, dto.getTitle());
			pstmt.setString(4, dto.getContents());
			pstmt.setTimestamp(5,up_date);

			boolean suc = pstmt.execute();
			System.out.println(suc);
			// pstmt (쿼리 날릴) 준비 완료
			if (!suc) {
				System.out.println("insert 완료");
				pstmt = null;
				return true;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<QnaDTO> getQnaData() { //게시판 전체 목록 불러오기
	
		String sql = "select * from qna";
		ArrayList<QnaDTO> list = new ArrayList<QnaDTO>();
		try {
			conn = DBManager.getConnection("booking");
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				int no = rs.getInt(1);
				int userCode = rs.getInt(2);
				String title = rs.getString(3);
				String contents = rs.getString(4);
				Timestamp up_date = rs.getTimestamp(5);

				QnaDTO dto = new QnaDTO(no, userCode, title,contents,
						up_date.getYear(),up_date.getMonth(),up_date.getDay());
				list.add(dto);

				System.out.println("성공");

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("실패");
		}
		return list;
	}

}
