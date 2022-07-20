package order;

public class orderDTO {
	private int oderCode;
	private int userCode;
	private int shopCode;
	
	private int year;
	private int month;
	private int day;

	public orderDTO(int oderCode, int userCode, int shopCode,int year, int month, int day) {
		super();
		this.oderCode = oderCode;
		this.userCode = userCode;
		this.shopCode = shopCode;
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public orderDTO(int oderCode, int userCode, int shopCode,int day) {
		super();
		this.oderCode = oderCode;
		this.userCode = userCode;
		this.shopCode = shopCode;
		this.day = day;
	}

	public int getOderCode() {
		return oderCode;
	}
	public void setOderCode(int oderCode) {
		this.oderCode = oderCode;
	}
	public int getUserCode() {
		return userCode;
	}
	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}
	public int getShopCode() {
		return shopCode;
	}
	public void setShopCode(int shopCode) {
		this.shopCode = shopCode;
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

