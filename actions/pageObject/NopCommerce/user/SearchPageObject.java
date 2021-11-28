package pageObject.NopCommerce.user;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.NopCommerce.user.SearchPageUI;
import pageUIs.NopCommerce.user.UserBasePageUI;


public class SearchPageObject extends BasePage {
	private WebDriver driver;

	public SearchPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickToSearchButton(WebDriver driver2) {
		waitForElementClickable(driver, SearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, SearchPageUI.SEARCH_BUTTON);

	}

	public Object getSearchResultMSG(WebDriver driver) {
		waitForElementVisible(driver, SearchPageUI.SEARCH_WARNING);
		return getElementText(driver, SearchPageUI.SEARCH_WARNING);
	}
	public boolean verifyNumberOfSearchResult(WebDriver driver, int numberSearchExpected) {
		waitForElementVisible(driver, SearchPageUI.SEARCH_ITEMS);
		int numberResult = getElementSize(driver,SearchPageUI.SEARCH_ITEMS);
		if (numberResult == numberSearchExpected) {
		
		}
		System.out.println(numberResult);
		return true;
	}


	public boolean isAllExpectedProductsDisplayed(WebDriver driver, String [] listProductsExpected) {
		int found = 0;
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
		if(found == listProductsExpected.length) {
			return true;
		} 
		return false;
	}


	
	
	
}






	



	

	


	
