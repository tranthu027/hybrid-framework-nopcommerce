package pageUIs.NopCommerce.Admin;

public class ProductSearchPageUI {

	
	public static final String SUBCATEGORY_RADIO_BUTTON = "//input[@id='SearchIncludeSubCategories']";
	public static final String EMPTY_TABLE = "//td[@class='dataTables_empty']";
	public static final String TOOGLE_ICON_SEARCH_PANEL = "//div[@class='icon-collapse']/i";
	
	public static final String EDIT_BUTTON_BY_SKU_OR_NAME = "//td[text()='%s']/following-sibling::td/a[contains(string(),'Edit')]";
	
	public static final String SUCCESS_MSG = "//div[contains(@class,'alert-success') and contains(string(),'%s')]";
	public static final String PRODUCT_IMAGE_BY_PRODUCT_NAME ="//td[text()='%s']/preceding-sibling::td/img[contains(@src,'%s')]";

	
}
