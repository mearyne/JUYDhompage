package qna;

import java.sql.Timestamp;

public class QnaDTO {

	private int no;
	private int userCode;
	private String title;
	private String contents;
	private Timestamp up_date;
	
	public QnaDTO(int no, int userCode, String title, String contents,Timestamp up_date) {
		super();
		this.no = no;
		this.userCode = userCode;
		this.title = title;
		this.contents = contents;
		this.up_date=up_date;
	}

	public QnaDTO(int no, int userCode, String title, String contents) {
		super();
		this.no = no;
		this.userCode = userCode;
		this.title = title;
		this.contents = contents;
	}

	public QnaDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getUserCode() {
		return userCode;
	}

	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Timestamp getUp_date() {
		return up_date;
	}

	public void setUp_date(Timestamp up_date) {
		this.up_date = up_date;
	}

	
	
}