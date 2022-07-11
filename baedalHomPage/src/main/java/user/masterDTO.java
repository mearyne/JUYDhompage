package user;

public class masterDTO {
	private int masterCode;
	private int shopCode; 
	
	private String masterId;  
	private String masterPw;
	private String masterContact;
	
	public masterDTO(int masterCode, int shopCode, String masterId, String masterPw, String masterContact) {
		
		this.masterCode = masterCode;
		this.shopCode = shopCode;
		this.masterId = masterId;
		this.masterPw = masterPw;
		this.masterContact = masterContact;
	}
	public int getMasterCode() {
		return masterCode;
	}
	public void setMasterCode(int masterCode) {
		this.masterCode = masterCode;
	}
	public int getShopCode() {
		return shopCode;
	}
	public void setShopCode(int shopCode) {
		this.shopCode = shopCode;
	}
	public String getMasterId() {
		return masterId;
	}
	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}
	public String getMasterPw() {
		return masterPw;
	}
	public void setMasterPw(String masterPw) {
		this.masterPw = masterPw;
	}
	public String getMasterContact() {
		return masterContact;
	}
	public void setMasterContact(String masterContact) {
		this.masterContact = masterContact;
	}
	
	
}
