package pageObject.NopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.NopCommerce.user.CompletedOrderPageUI;


public class CompletedOrderPageObject extends BasePage {
	private WebDriver driver;

	public CompletedOrderPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public Object getCompletedOrderMSG(WebDriver driver) {
		waitForElementVisible(driver, CompletedOrderPageUI.ORDER_COMPLETED_MSG);
		return getElementText(driver, CompletedOrderPageUI.ORDER_COMPLETED_MSG);
	}
	public String getValueOfOrderNumber(WebDriver driver) {
		waitForElementVisible(driver, CompletedOrderPageUI.ORDER_NUMBER);
		return getElementText(driver, CompletedOrderPageUI.ORDER_NUMBER).replace("ORDER NUMBER: ", "");
		
	}
	


}
