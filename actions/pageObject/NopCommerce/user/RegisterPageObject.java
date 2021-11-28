package pageObject.NopCommerce.user;



import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.NopCommerce.user.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public Object getSuccessMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.REGISTRATION_COMPLETE_MSG);
		return getElementText(driver, RegisterPageUI.REGISTRATION_COMPLETE_MSG);
	}



	public Object getErrorMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.MSG_ERROR);
		System.out.println(getElementText(driver, RegisterPageUI.MSG_ERROR));
		return getElementText(driver, RegisterPageUI.MSG_ERROR);
	}





	












	
	
	

}
