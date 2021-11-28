package pageObject.NopCommerce.user;


import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.NopCommerce.user.ComparePageUI;

public class ComparePageObject extends BasePage {
	private WebDriver driver;

	public ComparePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isCompareProductsListEmpty(WebDriver driver) {
		return isElementUndisplayed(driver, ComparePageUI.COMPARE_CLEAR_LIST);
	}
	public boolean isExpectedCompareProductsListDisplayed(WebDriver driver, String...params) {
		int found = 0;
		List <String> listProductsExpected = Arrays.asList(params);
		List <WebElement> itemList = getElements(driver, ComparePageUI.COMPARE_PRODUCTS_LIST);
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

	public void clickToClearListButton() {
		waitForElementClickable(driver, ComparePageUI.COMPARE_CLEAR_LIST);
		clickToElement(driver, ComparePageUI.COMPARE_CLEAR_LIST);
		sleepInSecond(3);
	}
	


}
