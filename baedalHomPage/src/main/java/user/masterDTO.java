package user;

public class masterDTO {
	private int masterCode;
	private int mastrShopCode;
	private String masterName;
	private String masterId;
	private String masterPw;
	private String masterContact;
	public int getMasterCode() {
		return masterCode;
	}
	public void setMasterCode(int masterCode) {
		this.masterCode = masterCode;
	}
	public int getMastrShopCode() {
		return mastrShopCode;
	}
	public void setMastrShopCode(int mastrShopCode) {
		this.mastrShopCode = mastrShopCode;
	}
	public String getMasterName() {
		return masterName;
	}
	public void setMasterName(String masterName) {
		this.masterName = masterName;
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
	public masterDTO(int masterCode, int mastrShopCode, String masterName, String masterId, String masterPw,
			String masterContact) {
		super();
		this.masterCode = masterCode;
		this.mastrShopCode = mastrShopCode;
		this.masterName = masterName;
		this.masterId = masterId;
		this.masterPw = masterPw;
		this.masterContact = masterContact;
	}
}
