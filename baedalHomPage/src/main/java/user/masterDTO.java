package user;

public class masterDTO {
	private int masterCode;

	private String masterName;
	private String masterId;
	private String masterPw;
	private String masterContact;
	private String masterAddress;

	public masterDTO(int masterCode, String masterName, String masterId, String masterPw, String masterContact,
			String masterAddress) {
		super();
		this.masterCode = masterCode;
		this.masterName = masterName;
		this.masterId = masterId;
		this.masterPw = masterPw;
		this.masterContact = masterContact;
		this.masterAddress = masterAddress;
	}

	public int getMasterCode() {
		return masterCode;
	}

	public void setMasterCode(int masterCode) {
		this.masterCode = masterCode;
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

	public String getMasterAddress() {
		return masterAddress;
	}

	public void setMasterAddress(String masterAddress) {
		this.masterAddress = masterAddress;
	}

}
