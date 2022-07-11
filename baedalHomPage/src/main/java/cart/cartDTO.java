package cart;

public class cartDTO {
	private int cardCode;
	private int userCode;
	private int shopCode;
	private int menuCode;
	private int cartNum;
	
	
	public cartDTO(int cardCode, int userCode, int shopCode, int menuCode, int cartNum) {
		super();
		this.cardCode = cardCode;
		this.userCode = userCode;
		this.shopCode = shopCode;
		this.menuCode = menuCode;
		this.cartNum = cartNum;
	}
	public int getCardCode() {
		return cardCode;
	}
	public void setCardCode(int cardCode) {
		this.cardCode = cardCode;
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
	public int getCartNum() {
		return cartNum;
	}
	public void setCartNum(int cartNum) {
		this.cartNum = cartNum;
	}
}
