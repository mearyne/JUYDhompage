package menu;

public class menuDTO {
	private int menuCode;
	private int shopCode;
	private int menuPrice;
	
	private String menuName;  
	private String menuPicture;
	private String menuContents;
	
	public menuDTO(int menuCode, int shopCode, int menuPrice, String menuName, String menuPicture,
			String menuContents) {
		this.menuCode = menuCode;
		this.shopCode = shopCode;
		this.menuPrice = menuPrice;
		this.menuName = menuName;
		this.menuPicture = menuPicture;
		this.menuContents = menuContents;
	}
	
	public int getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(int menuCode) {
		this.menuCode = menuCode;
	}
	public int getShopCode() {
		return shopCode;
	}
	public void setShopCode(int shopCode) {
		this.shopCode = shopCode;
	}
	public int getMenuPrice() {
		return menuPrice;
	}
	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuPicture() {
		return menuPicture;
	}
	public void setMenuPicture(String menuPicture) {
		this.menuPicture = menuPicture;
	}
	public String getMenuContents() {
		return menuContents;
	}
	public void setMenuContents(String menuContents) {
		this.menuContents = menuContents;
	}
	
	
	
}
