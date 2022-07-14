package order;

import java.security.Timestamp;

public class orderDTO {
	private int oderCode;
	private int userCode;
	private int shopCode;
	private int menuCode;
	private int year;
	private int month;
	private int day;

	public orderDTO(int oderCode, int userCode, int shopCode, int menuCode,int year, int month, int day) {
		super();
		this.oderCode = oderCode;
		this.userCode = userCode;
		this.shopCode = shopCode;
		this.menuCode = menuCode;
//		this.bookingDate = bookingDate;
		this.year = year;
		this.month = month;
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
	public int getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(int menuCode) {
		this.menuCode = menuCode;
	}
	public int getYear() {
		// TODO Auto-generated method stub
		return 0;
	}
	public int getMonth() {
		// TODO Auto-generated method stub
		return 0;
	}
	public int getDay() {
		// TODO Auto-generated method stub
		return 0;
	}
}
//	public Timestamp getBookingDate() {
//		return bookingDate;
//	}
//	public void setBookingDate(Timestamp bookingDate) {
//		this.bookingDate = bookingDate;
//	}
//}
