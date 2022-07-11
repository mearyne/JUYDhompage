package review;

public class reviewDTO {
	private int reviewCode;
	private int shopCode;
	private int userCode;
	private int oderCode;
	private int reviewStar;
	private String reviewContents;
	private String reviewPicture;
	
	
	
	public reviewDTO(int reviewCode, int shopCode, int userCode, int oderCode, int reviewStar, String reviewContents,
			String reviewPicture) {
		super();
		this.reviewCode = reviewCode;
		this.shopCode = shopCode;
		this.userCode = userCode;
		this.oderCode = oderCode;
		this.reviewStar = reviewStar;
		this.reviewContents = reviewContents;
		this.reviewPicture = reviewPicture;
	}
	public int getReviewCode() {
		return reviewCode;
	}
	public void setReviewCode(int reviewCode) {
		this.reviewCode = reviewCode;
	}
	public int getShopCode() {
		return shopCode;
	}
	public void setShopCode(int shopCode) {
		this.shopCode = shopCode;
	}
	public int getUserCode() {
		return userCode;
	}
	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}
	public int getOderCode() {
		return oderCode;
	}
	public void setOderCode(int oderCode) {
		this.oderCode = oderCode;
	}
	public int getReviewStar() {
		return reviewStar;
	}
	public void setReviewStar(int reviewStar) {
		this.reviewStar = reviewStar;
	}
	public String getReviewContents() {
		return reviewContents;
	}
	public void setReviewContents(String reviewContents) {
		this.reviewContents = reviewContents;
	}
	public String getReviewPicture() {
		return reviewPicture;
	}
	public void setReviewPicture(String reviewPicture) {
		this.reviewPicture = reviewPicture;
	}
	
	
	
}
