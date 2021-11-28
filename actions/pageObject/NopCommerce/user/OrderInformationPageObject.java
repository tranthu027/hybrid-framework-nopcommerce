package pageObject.NopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.NopCommerce.user.OrderInformationPageUI;

public class OrderInformationPageObject extends BasePage {
	private WebDriver driver;

	public OrderInformationPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isorderedProductsDisplayed(WebDriver driver, String productName) {
		waitForElementVisible(driver, OrderInformationPageUI.ORDER_PRODUCT);
		return getElementText(driver, OrderInformationPageUI.ORDER_PRODUCT).contains(productName);
	}

	public Object getOrderTotalPrice(WebDriver driver) {
		waitForElementVisible(driver, OrderInformationPageUI.ORDER_TOTAL);
		return getElementText(driver, OrderInformationPageUI.ORDER_TOTAL);
	}

	
	


}
