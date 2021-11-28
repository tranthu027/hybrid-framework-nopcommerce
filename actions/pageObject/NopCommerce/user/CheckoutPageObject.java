package pageObject.NopCommerce.user;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.NopCommerce.user.CheckoutPageUI;

public class CheckoutPageObject extends BasePage {
	private WebDriver driver;

	public CheckoutPageObject(WebDriver driver) {
		this.driver = driver;
	}

	
	public boolean isPaymentInfoDisplayed(WebDriver driver) {
		return isElementDisplayed(driver, CheckoutPageUI.PAYMENT_INFO);
	}

	public void clickToContinueButtonByID(WebDriver driver2, String idText) {
		waitForElementClickable(driver, CheckoutPageUI.CONTINUE_BUTTON_BY_ID, idText);
		clickToElement(driver, CheckoutPageUI.CONTINUE_BUTTON_BY_ID, idText);
		
	}

	public boolean isOrderProductsListDisplayed(WebDriver driver2, String...params) {
		int found = 0;
		List <String> listProductsExpected = Arrays.asList(params);
		List <WebElement> itemList = getElements(driver, CheckoutPageUI.ORDER_LIST);
			for (WebElement item :  itemList ) {
				System.out.println(item.getText());
				for (String itemExpected : listProductsExpected) {
					if(!item.getText().equals(itemExpected)) {
						continue;
					}
					else {
						found = found + 1;
					}
				}
			}	
		if(found == listProductsExpected.size()) {
			return true;
		} 
		return false;
	}

	public Object getPriceSummary(WebDriver driver) {
		waitForElementClickable(driver, CheckoutPageUI.PRICE_SUMMARY);
		return getElementText(driver, CheckoutPageUI.PRICE_SUMMARY);
	}	


}
