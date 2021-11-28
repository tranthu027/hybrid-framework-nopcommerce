package pageUIs.NopCommerce.user;

public class MyAccountPageUI {
	public static final String LISTBOX_BY_TEXT = "//div[@class='listbox']//a[text()='%s']";
	public static final String ADDRESS_LIST_BY_NAME = "//div[@class='address-list']//li[@class='%s']";
	
	public static final String ORDER_DETAILS_BUTTON_BY_NUMBER = "//strong[contains(text(),'%s')]/ancestor::div[@class='section order-item']//button";

	public static final String REVIEW_PRODUCT_NAME = "//span[@class='user']/a[text()='%s']";


}
