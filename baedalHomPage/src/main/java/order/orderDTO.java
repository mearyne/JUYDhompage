package order;

import java.security.Timestamp;



public class orderDTO {
	private int oderCode;
	private int userCode;
	private int shopCode;
	private int menuCode;
	private Timestamp bookingDate;
	

	public orderDTO(int oderCode, int userCode, int shopCode, int menuCode, Timestamp bookingDate) {
		super();
		this.oderCode = oderCode;
		this.userCode = userCode;
		this.shopCode = shopCode;
		this.menuCode = menuCode;
		this.bookingDate = bookingDate;
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
	public Timestamp getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Timestamp bookingDate) {
		this.bookingDate = bookingDate;
	}
}
