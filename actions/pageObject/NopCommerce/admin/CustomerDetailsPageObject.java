package pageObject.NopCommerce.admin;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.NopCommerce.Admin.CustomersDetailPageUI;

public class CustomerDetailsPageObject extends BasePage {
	private WebDriver driver;

	public CustomerDetailsPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isCustomerFirstnameUpdated(WebDriver driver, String firstname) {
		waitForElementVisible(driver, CustomersDetailPageUI.TABLE_FIRSTNAME);
		System.out.println(getElementText(driver, CustomersDetailPageUI.TABLE_FIRSTNAME));
		return getElementText(driver, CustomersDetailPageUI.TABLE_FIRSTNAME).contains(firstname);
	}

	public boolean isCustomerLastnameUpdated(WebDriver driver, String lastname) {
		waitForElementVisible(driver, CustomersDetailPageUI.TABLE_LASTNAME);
		System.out.println(getElementText(driver, CustomersDetailPageUI.TABLE_LASTNAME));
		return getElementText(driver, CustomersDetailPageUI.TABLE_LASTNAME).contains(lastname);
	}

	public boolean isCustomerEmailUpdated(WebDriver driver2, String email) {
		waitForElementVisible(driver, CustomersDetailPageUI.TABLE_EMAIL);
		System.out.println(getElementText(driver, CustomersDetailPageUI.TABLE_EMAIL));
		return getElementText(driver, CustomersDetailPageUI.TABLE_EMAIL).contains(email);
	}

	public boolean isCustomerPhoneNumberUpdated(WebDriver driver, String phoneNumber) {
		waitForElementVisible(driver, CustomersDetailPageUI.TABLE_PHONE_NUMBER);
		System.out.println(getElementText(driver, CustomersDetailPageUI.TABLE_PHONE_NUMBER));
		return getElementText(driver, CustomersDetailPageUI.TABLE_PHONE_NUMBER).contains(phoneNumber);
	}

	public boolean isCustomerFaxNumberUpdated(WebDriver driver, String faxNumber) {
		waitForElementVisible(driver, CustomersDetailPageUI.TABLE_FAX_NUMBER);
		System.out.println(getElementText(driver, CustomersDetailPageUI.TABLE_FAX_NUMBER));
		return getElementText(driver, CustomersDetailPageUI.TABLE_FAX_NUMBER).contains(faxNumber);
	}

	public boolean isCustomerAddressUpdated(WebDriver driver, String...params) {
		waitForElementVisible(driver, CustomersDetailPageUI.TABLE_ADDRESS);
		List <String> expectedList = Arrays.asList(params);
		String actual = getElementText(driver, CustomersDetailPageUI.TABLE_ADDRESS);
		for (String expectedItem : expectedList) {
			if(actual.contains(expectedItem)) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	public void clickToButtonInTableByText(WebDriver driver, String textButton) {
		waitForElementClickable(driver, CustomersDetailPageUI.TABLE_BUTTON, textButton);
		clickToElement(driver, CustomersDetailPageUI.TABLE_BUTTON, textButton);
	}

	public boolean isEmptyAddressTableDisplayed() {
		waitForElementVisible(driver, CustomersDetailPageUI.TABLE_ADDRESS_EMPTY);
		return isElementDisplayed(driver, CustomersDetailPageUI.TABLE_ADDRESS_EMPTY);
	}






}
