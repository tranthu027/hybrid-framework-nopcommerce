package pageObject.NopCommerce.user;


import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.NopCommerce.user.UserBasePageUI;


public class RecentlyViewedPageObject extends BasePage {
	private WebDriver driver;

	public RecentlyViewedPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isRecentlyViewedProductsDisplayed(WebDriver driver, String...params) {
		int found = 0;
		List <String> listProductsExpected = Arrays.asList(params);
		List <WebElement> itemList = getElements(driver, UserBasePageUI.PRODUCT_LIST_NAME_TEXT);
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

}