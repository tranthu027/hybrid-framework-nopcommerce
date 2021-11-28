package pageObject.NopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.NopCommerce.user.RegisterPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public Object isErrorMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.MSG_ERROR);
		System.out.println(getElementText(driver, RegisterPageUI.MSG_ERROR));
		return getElementText(driver, RegisterPageUI.MSG_ERROR);
	}
	public Object getAllErrorMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.MSG_ALL_ERROR);
		System.out.println(getElementText(driver, RegisterPageUI.MSG_ALL_ERROR));
		return getElementText(driver, RegisterPageUI.MSG_ALL_ERROR);
	}


}
