package pageObject.NopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

import pageUIs.NopCommerce.user.ShoppingCartPageUI;


public class ShoppingCartPageObject extends BasePage {
	private WebDriver driver;
	
	public ShoppingCartPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void clickToEditLink(WebDriver driver) {
		waitForElementClickable(driver, ShoppingCartPageUI.EDIT_LINK);
		clickToElementByJS(driver, ShoppingCartPageUI.EDIT_LINK);
		
	}
	public void clickToTermOfServiceCheckbox(WebDriver driver) {
		waitForElementClickable(driver, ShoppingCartPageUI.TERM_OF_SERVICE_BUTTON);
		clickToElementByJS(driver, ShoppingCartPageUI.TERM_OF_SERVICE_BUTTON);
		
	}




}
