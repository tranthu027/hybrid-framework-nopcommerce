package pageUIs.NopCommerce.Admin;

public class AdminBasePageUI {
	public static final String HEADER_TITLE = "//div[@class='content-header clearfix']/h1";
	public static final String MENU_LINK_BY_TEXT = "//ul[@role='menu']/li/a/p[contains(string(),'%s')]";
	public static final String SUB_MENU_DISPLAYED_BY_TEXT = "//ul[@role='menu']/li/a/p[contains(string(),'%s')]/ancestor::li/ul";
	public static final String SUB_MENU_LINK_BY_TEXT = "//li[@class='nav-item']//p[string()='%s']";
	public static final String BUTTON_BY_NAME = "//button[@name='%s']";
	public static final String BUTTON_BY_ID = "//button[@id='%s']";
	public static final String BUTTON_BY_CONTAINS_TEXT = "//button[contains(text(),'%s')]";
	public static final String TOOGLE_ICON_BY_CARD_NAME = "//div[text()='%s']/following-sibling::div//i";

	
	public static final String HEADER_PAGE_ADMIN = "//div[@class='content-header clearfix']/h1";
	public static final String COMMENT_TEXTAREA = "//textarea[@id='AdminComment']";
	public static final String SUCCESS_ALERT = "//div[@class='alert alert-success alert-dismissable']";
	public static final String SUCCESS_ALERT_CLOSE_BUTTON ="//div[@class='alert alert-success alert-dismissable']/button";

	
	public static final String UPLOAD_FILE_BY_CARD_NAME =  "//div[@id='product-%s']//input[@type='file']";
	public static final String EMPTY_DATA_MSG_BY_DATA_TABLE_NAME = "//div[@class='card-title' and contains(text(),'%s')]/parent::div/following-sibling::div//td[@class='dataTables_empty']";

	public static final String SEARCH_ITEM_LIST = "//tbody//input[@class='checkboxGroups']";

}
