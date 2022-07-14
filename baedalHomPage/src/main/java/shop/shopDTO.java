package shop;

public class shopDTO {
	private int shopCode;
	private int masterCode;
	private String shopName;
	private String shopCategory;
	private String shopAddress;
	private String shopPic;
	private String shopPhone;
	private String shopContents;
	private int shopStar;
	private int reviewNum;

	public shopDTO(int shopCode, String shopName, String shopCategory, String shopPic, int shopStar) {
		this.shopCode = shopCode;
		this.shopName = shopName;
		this.shopCategory = shopCategory;
		this.shopPic = shopPic;
		this.shopStar = shopStar;
	}

	public shopDTO(int shopCode, int masterCode, String shopName, String shopCategory, String shopAddress,
			String shopPic, String shopPhone, String shopContents, int shopStar, int reviewNum) {
		this.shopCode = shopCode;
		this.masterCode = masterCode;
		this.shopName = shopName;
		this.shopCategory = shopCategory;
		this.shopAddress = shopAddress;
		this.shopPic = shopPic;
		this.shopPhone = shopPhone;
		this.shopContents = shopContents;
		this.shopStar = shopStar;
		this.reviewNum = reviewNum;
	}

	public String getShopPhone() {
		return shopPhone;
	}

	public void setShopPhone(String shopPhone) {
		this.shopPhone = shopPhone;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopCategory() {
		return shopCategory;
	}

	public void setShopCategory(String shopCategory) {
		this.shopCategory = shopCategory;
	}

	public String getShopAddress() {
		return shopAddress;
	}

	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}

	public String getShopPic() {
		return shopPic;
	}

	public void setShopPic(String shopPic) {
		this.shopPic = shopPic;
	}

	public String getShopContents() {
		return shopContents;
	}

	public void setShopContents(String shopContents) {
		this.shopContents = shopContents;
	}

	public int getShopCode() {
		return shopCode;
	}

	public void setShopCode(int shopCode) {
		this.shopCode = shopCode;
	}

	public int getMasterCode() {
		return masterCode;
	}

	public void setMasterCode(int masterCode) {
		this.masterCode = masterCode;
	}

	public int getShopStar() {
		return shopStar;
	}

	public void setShopStar(int shopStar) {
		this.shopStar = shopStar;
	}

	public int getReviewNum() {
		return reviewNum;
	}

	public void setReviewNum(int reviewNum) {
		this.reviewNum = reviewNum;
	}

}