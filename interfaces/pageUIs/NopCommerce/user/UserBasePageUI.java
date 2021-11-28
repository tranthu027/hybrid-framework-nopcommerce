package pageUIs.NopCommerce.user;

public class UserBasePageUI {
	
	//Dynamic Xpath
	public static final String FIRST_PAGE_HEADER_BY_TEXT = "//div[@class='header']//a[text()='%s']";
	public static final String SECOND_PAGE_HEADER_BY_TEXT = "//div[@class='header']//span[text()='%s']";
	public static final String SECOND_PAGE_HEADER_QUANTITY_BY_TEXT = "//div[@class='header']//span[text()='%s']/following-sibling::span";

	public static final String PAGE_TITLE_BY_TEXT = "//div[@class='page-title']/h1[contains(text(),'%s')]";
	public static final String RADIO_BY_LABEL_TEXT = "//label[contains(text(),'%s')]/preceding-sibling::input";
	public static final String TEXTBOX_BY_ID = "//input[@id='%s']";
	public static final String DROPDOWN_BY_NAME = "//select[@name='%s']";
	public static final String BUTTON_BY_TEXT = "//button[text()='%s']";
	public static final String VALIDATION_ERROR_MSG = "//span[@data-valmsg-for='%s']/span";
	
	public static final String TOP_MENU_BY_TEXT = "//ul[@class='top-menu notmobile']//a[contains(text(),'%s')]";
	public static final String TOP_SUB_MENU_BY_TEXT = "//ul[@class='top-menu notmobile']//a[contains(text(),'%s')]/parent::li//a[contains(text(),'%s')]";
	public static final String PAGE_FOOTER = "//div[@class='footer']//a[text()='%s']";
	
	
	public static final String BAR_NOTIFICATION = "//div[@class='bar-notification success']/p";
	public static final String BAR_NOTIFICATION_CLOSE_BUTTON = "//div[@class='bar-notification success']/span";
	
	public static final String PRODUCT_LIST_NAME_TEXT = "//div[@class='item-grid']//h2/a";
	public static final String PRODUCT_REMOVE_BUTTON = "//a[contains(text(),'%s')]/ancestor::tr//button[@class='remove-btn']";
	
	public static final String ORDER_NUMBER_BY_TEXT = "//strong[contains(text(),'%s')]";
	public static final String SHIPPING_INFO_BY_CLASS = "//div[@class='shipping-info-wrap']//li[@class='%s']";
	
	public static final String CART_OPTION = "//div[@class='selected-checkout-attributes']";
	public static final String EMPTY_MSG = "//div[@class='no-data']";
	public static final String PRODUCT_LIST = "//table[@class='cart']";







}
