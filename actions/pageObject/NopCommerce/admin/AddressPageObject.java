package pageObject.NopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.NopCommerce.Admin.AddressPageUI;

public class AddressPageObject extends BasePage {
	private WebDriver driver;

	public AddressPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToBackToCustomerDetails(WebDriver driver) {
		waitForElementClickable(driver, AddressPageUI.BACK_TO_CUSTOMER_DETAILS);
		clickToElement(driver, AddressPageUI.BACK_TO_CUSTOMER_DETAILS);
	}


}
