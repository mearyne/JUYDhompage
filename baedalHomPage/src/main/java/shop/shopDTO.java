package shop;

public class shopDTO {
	private String shopName;
	private String shopCategory;
	private String shopAddress;
	private String shopPic;
	private String shopContact;
	private String shopContents;
	
	private int shopCode;
	private int masterCode;
	private int shopStar;	
	
	public shopDTO(String shopName, String shopCategory, String shopAddress, String shopPic, String shopContact,
			String shopContents, int shopCode, int masterCode, int shopStar, int reviewNum) {
		 
		this.shopName = shopName;
		this.shopCategory = shopCategory;
		this.shopAddress = shopAddress;
		this.shopPic = shopPic;
		this.shopContact = shopContact;
		this.shopContents = shopContents;
		this.shopCode = shopCode;
		this.masterCode = masterCode;
		this.shopStar = shopStar;
		this.reviewNum = reviewNum;
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
	public String getShopContact() {
		return shopContact;
	}
	public void setShopContact(String shopContact) {
		this.shopContact = shopContact;
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
	private int reviewNum;
	
	

}
