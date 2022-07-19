package qna;

public class QnaDTO {

	private int no;
	private int userCode;
	private String title;
	private String contents;
	private int year,month,day;
	
	public QnaDTO(int no, int userCode, String title, String contents, int year, int month, int day) {
		super();
		this.no = no;
		this.userCode = userCode;
		this.title = title;
		this.contents = contents;
		this.year = year;
		this.month = month;
		this.day = day;
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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
	
}