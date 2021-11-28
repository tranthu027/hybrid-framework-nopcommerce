package pageUIs.NopCommerce.user;

public class CheckoutPageUI {
	
	//Dynamic Xpath
	public static final String CONTINUE_BUTTON_BY_ID = "//li[@id='%s']//button[text()='Continue']";
	
	public static final String PAYMENT_INFO = "//div[@class='section payment-info']";
	public static final String ORDER_LIST = "//a[@class='product-name']";
	public static final String PRICE_SUMMARY = "//tr[@class='order-total']/td[@class='cart-total-right']";

}
