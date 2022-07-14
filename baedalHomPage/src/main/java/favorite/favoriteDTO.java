package favorite;

public class favoriteDTO {
	private int favoriteCode;
	private int userCode;
	private int shopCode;
	
	public favoriteDTO(int favoriteCode, int userCode, int shopCode) {
		super();
		this.favoriteCode = favoriteCode;
		this.userCode = userCode;
		this.shopCode = shopCode;
	}
	
	public int getFavoriteCode() {
		return favoriteCode;
	}
	public void setFavoriteCode(int favoriteCode) {
		this.favoriteCode = favoriteCode;
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
	
	
	

}
