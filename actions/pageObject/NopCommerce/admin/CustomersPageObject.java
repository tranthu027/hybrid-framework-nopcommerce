package pageObject.NopCommerce.admin;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.NopCommerce.Admin.CustomersPageUI;

public class CustomersPageObject extends BasePage {
	private WebDriver driver;

	public CustomersPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToAddNewButton() {
		waitForElementVisible(driver, CustomersPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, CustomersPageUI.ADD_NEW_BUTTON);
	}

	public void selectItemInRolesDropdown(WebDriver driver, String roles) {
		waitForElementVisible(driver, CustomersPageUI.CUSTOMERS_ROLE);
		selectItemInCustomDropdown(driver, CustomersPageUI.CUSTOMERS_ROLE, CustomersPageUI.CUSTOMERS_ROLES_CHILD_LIST, roles);
	}

	public void clickToActiveRadioButton() {
		waitForElementVisible(driver, CustomersPageUI.ACTIVE_RADIO_BUTTON);
		checkToCheckboxOrRadio(driver, CustomersPageUI.ACTIVE_RADIO_BUTTON);	
	}

	public boolean isNewCustomerNameDisplayed(WebDriver driver, String expextedName) {
		List <WebElement> itemList = getElements(driver, CustomersPageUI.TABLE_CUSTOMER_NAME);
		for (WebElement item : itemList ) {
			if(!item.getText().equals(expextedName)) {
				continue;
			} else if(item.getText().equals(expextedName))
			return true;
		}
		return true;
	}

	public boolean isNewCustomerCompanyDisplayed(WebDriver driver, String expextedCompany) {
		List <WebElement> itemList = getElements(driver, CustomersPageUI.TABLE_CUSTOMER_COMPANY);
		for (WebElement item : itemList ) {
			if(!item.getText().equals(expextedCompany)) {
				continue;
			} else if(item.getText().equals(expextedCompany))
			return true;
		}
		return true;
	}

	public void deselectItemInRolesDropdown(WebDriver driver) {
		waitForElementVisible(driver, CustomersPageUI.CUSTOMERS_ROLE);
		if(isElementDisplayed(driver, CustomersPageUI.CUSTOMERS_ROLE_SELECTED)){
			clickToElement(driver, CustomersPageUI.CUSTOMERS_ROLE_DELETE_BUTTON);
		}	
	}

	public void clickToEditButtonByCustomerName(WebDriver driver, String customerName) {
		waitForElementClickable(driver, CustomersPageUI.EDIT_BUTTON_BY_NAME, customerName);
		clickToElement(driver, CustomersPageUI.EDIT_BUTTON_BY_NAME, customerName);	
	}







}
