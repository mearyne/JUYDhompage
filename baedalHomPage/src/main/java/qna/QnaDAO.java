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
		String sql = "insert into qna(no, userCode, title, contents) values(?,?,?,?)";

		try {
			conn = DBManager.getConnection("booking");
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, dto.getNo());
			pstmt.setInt(2, dto.getUserCode());
			pstmt.setString(3, dto.getTitle());
			pstmt.setString(4, dto.getContents());

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
						up_date);
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
	
	public QnaDTO getOneQna(int no) { //게시글 읽기
		QnaDTO dto=new QnaDTO();
		
		String sql="select * from qna where no=?";
		try {
			conn = DBManager.getConnection("booking");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				dto.setNo(rs.getInt(1));
				dto.setUserCode(rs.getInt(2));
				dto.setTitle(rs.getString(3));
				dto.setContents(rs.getString(4));
				dto.setUp_date(rs.getTimestamp(5));				
			}
			return dto;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public int delete(int no) {
		String SQL = "delete from qna WHERE no = ?";
		try {
			conn = DBManager.getConnection("booking");
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1,no);
			return pstmt.executeUpdate(); // 삭제 성공시 1반환
		}catch (Exception e) {
			e.printStackTrace();
		}
		return -1; //데이터베이스 오류, 삭제 실패
	}
}


