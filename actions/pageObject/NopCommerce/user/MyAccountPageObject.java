package pageObject.NopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.NopCommerce.user.MyAccountPageUI;


public class MyAccountPageObject extends BasePage {
	private WebDriver driver;

	public MyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openListboxByText(WebDriver driver, String listboxName) {
		waitForElementClickable(driver, MyAccountPageUI.LISTBOX_BY_TEXT, listboxName);
		clickToElement(driver, MyAccountPageUI.LISTBOX_BY_TEXT, listboxName);
		
	}

	public Object getUpdatedAddressOfInforByClass(WebDriver driver, String textName) {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_LIST_BY_NAME, textName);
		System.out.println(getElementText(driver, MyAccountPageUI.ADDRESS_LIST_BY_NAME, textName).trim());
		return getElementText(driver, MyAccountPageUI.ADDRESS_LIST_BY_NAME, textName).trim();
	}

	public void clickToSeeDetailsOrder(WebDriver driver, String orderNumber) {
		waitForElementClickable(driver, MyAccountPageUI.ORDER_DETAILS_BUTTON_BY_NUMBER, orderNumber);
		clickToElement(driver, MyAccountPageUI.ORDER_DETAILS_BUTTON_BY_NUMBER, orderNumber);
		
	}

	public boolean isProductReviewDisplayed(WebDriver driver, String reviewProductText) {
		waitForElementVisible(driver, MyAccountPageUI.REVIEW_PRODUCT_NAME, reviewProductText);
		return isElementDisplayed(driver, MyAccountPageUI.REVIEW_PRODUCT_NAME, reviewProductText);
	}





	

	


	

	
}
