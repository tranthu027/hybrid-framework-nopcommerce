package pageObject.NopCommerce.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.NopCommerce.user.ProductPageUI;
import pageUIs.NopCommerce.user.UserBasePageUI;

public class ProductPageObject extends BasePage {
	private WebDriver driver;
	
	public ProductPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickProductToSeeDetailByText(WebDriver driver, String productName) {
		waitForElementClickable(driver, ProductPageUI.PRODUCT_BY_TEXT, productName);
		clickToElement(driver, ProductPageUI.PRODUCT_BY_TEXT, productName);
	}
	
	public void clickToOverviewButtonByText(WebDriver driver, String buttonText) {
		waitForElementClickable(driver, ProductPageUI.PRODUCT_DETAIL_ACTION_BUTTON, buttonText);
		clickToElement(driver, ProductPageUI.PRODUCT_DETAIL_ACTION_BUTTON, buttonText);
	}

	public void clickToActionButtonByText(WebDriver driver, String productName, String buttonName) {
		waitForElementClickable(driver, ProductPageUI.PRODUCT_ACTION_BUTTON_BY_TEXT, productName, buttonName);
		sleepInSecond(3);
		clickToElementByJS(driver, ProductPageUI.PRODUCT_ACTION_BUTTON_BY_TEXT, productName, buttonName);
	}

	public boolean isProductNameSortAscending() {
		List<WebElement> productNameElements = getElements(driver, UserBasePageUI.PRODUCT_LIST_NAME_TEXT);
		List<String> productNameText = new ArrayList<String>();
		for (WebElement productName : productNameElements) {
			productNameText.add(productName.getText());
		}
		List<String> productNameTextClone = new ArrayList<String>();
		for (String product : productNameText) {
			productNameTextClone.add(product);
		}
		Collections.sort(productNameTextClone);
		return productNameText.equals(productNameTextClone);
	}

	public boolean isProductNameSortDescending() {
		List<WebElement> productNameElements = getElements(driver, UserBasePageUI.PRODUCT_LIST_NAME_TEXT);
		List<String> productNameText = new ArrayList<String>();
		for (WebElement productName : productNameElements) {
			productNameText.add(productName.getText());
		}
		List<String> productNameTextClone = new ArrayList<String>();
		for (String product : productNameText) {
			productNameTextClone.add(product);
		}
		Collections.sort(productNameTextClone);
		Collections.reverse(productNameTextClone);
		return productNameText.equals(productNameTextClone);
	}

	public boolean isProductPriceSortAscending() {
		List<WebElement> productPriceElements = getElements(driver, ProductPageUI.PRODUCT_LIST_PRICE_TEXT);
		List<String> productPriceValue = new ArrayList<String>();
		for (WebElement productPrice : productPriceElements) {
			productPriceValue.add((productPrice.getText().replace("$","")));
		}
		List<String> productPriceTextClone = new ArrayList<String>();
		for (String productPrice : productPriceValue) {
			productPriceTextClone.add(productPrice);
		}
		Collections.sort(productPriceTextClone);
		return productPriceValue.equals(productPriceTextClone);
	}

	public boolean isProductPriceSortDescending() {
		List<WebElement> productPriceElements = getElements(driver, ProductPageUI.PRODUCT_LIST_PRICE_TEXT);
		List<String> productPriceValue = new ArrayList<String>();
		for (WebElement productPrice : productPriceElements) {
			productPriceValue.add((productPrice.getText().replace("$","")));
		}
		List<String> productPriceTextClone = new ArrayList<String>();
		for (String productPrice : productPriceValue) {
			productPriceTextClone.add(productPrice);
		}
		Collections.sort(productPriceTextClone);
		Collections.reverse(productPriceTextClone);
		return productPriceValue.equals(productPriceTextClone);
	}

	public boolean productPageSizeDisplayedAsExpected(WebDriver driver, int pageSizeExpected) {
		waitForAllElementVisible(driver, UserBasePageUI.PRODUCT_LIST_NAME_TEXT);
		int pageSize = getElementSize(driver, UserBasePageUI.PRODUCT_LIST_NAME_TEXT);
		if (pageSize > pageSizeExpected) {
			return false;
		}	
			return true;
	}

	public boolean isPaginationUndisplay(WebDriver driver) {
		sleepInSecond(3);
		return isElementUndisplayed(driver, ProductPageUI.PRODUCT_PAGINATION) ;
	}

	public boolean isPaginationIconDisplay(WebDriver driver, String iconName) {
		waitForElementVisible(driver, ProductPageUI.PAGINATION_ICON_BY_TEXT, iconName);
		return isElementDisplayed(driver, ProductPageUI.PAGINATION_ICON_BY_TEXT,iconName);
	}

	public void clickToExpectedPaginationLink(WebDriver driver, String pageNumber) {
		waitForElementClickable(driver, ProductPageUI.PAGINATION_PAGE_NUMBER_BY_TEXT, pageNumber);
		clickToElement(driver, ProductPageUI.PAGINATION_PAGE_NUMBER_BY_TEXT, pageNumber);	
	}

	public void clickToProductToSeeDetailByOrder(WebDriver driver2, String productOrder) {
		waitForElementClickable(driver, ProductPageUI.PRODUCT_BY_ORDER, productOrder);
		clickToElement(driver, ProductPageUI.PRODUCT_BY_ORDER, productOrder);
	}

	public void clickToChildSubmenulByText(WebDriver driver, String ChildSubmenuText) {
		waitForElementClickable(driver, ProductPageUI.PRODUCT_CHILD_SUB_MENU_BY_TEXT, ChildSubmenuText);
		clickToElement(driver, ProductPageUI.PRODUCT_CHILD_SUB_MENU_BY_TEXT, ChildSubmenuText);	
	}

	public String getValueOfViewedProduct(WebDriver driver) {
		waitForElementVisible(driver, ProductPageUI.PRODUCT_DETAIL_NAME);
		return getElementText(driver, ProductPageUI.PRODUCT_DETAIL_NAME);
	}
	public void openActiveWindownAtHeaderPage(WebDriver driver, String menuName) {
		waitForElementClickable(driver, UserBasePageUI.SECOND_PAGE_HEADER_BY_TEXT, menuName);
		scrollToElement(driver, UserBasePageUI.SECOND_PAGE_HEADER_BY_TEXT, menuName);
		hoverToElement(driver, UserBasePageUI.SECOND_PAGE_HEADER_BY_TEXT, menuName);	
	}
	
	public Object getQuantityInCart(WebDriver driver) {
		waitForElementVisible(driver, ProductPageUI.ACT_WINDOWN_COUNT_PRODUCT);
		System.out.println(getElementText(driver, ProductPageUI.ACT_WINDOWN_COUNT_PRODUCT));
		return getElementText(driver, ProductPageUI.ACT_WINDOWN_COUNT_PRODUCT);
	}
	
	public Object getProductNameInCart(WebDriver driver) {
		waitForElementVisible(driver, ProductPageUI.ACT_WINDOWN_NAME_PRODUCT);
		return getElementText(driver, ProductPageUI.ACT_WINDOWN_NAME_PRODUCT);
	}

	public String getPriceOfProduct(WebDriver driver) {
		waitForElementVisible(driver, ProductPageUI.PRODUCT_DETAIL_PRICE);
		sleepInSecond(3);
		System.out.println(getElementText(driver, ProductPageUI.PRODUCT_DETAIL_PRICE));
		return getElementText(driver, ProductPageUI.PRODUCT_DETAIL_PRICE);
	}

	public Object getProductPriceInCart(WebDriver driver) {
		waitForElementVisible(driver, ProductPageUI.ACT_WINDOWN_PRICE_PRODUCT);
		System.out.println(getElementText(driver, ProductPageUI.ACT_WINDOWN_PRICE_PRODUCT));
		return getElementText(driver, ProductPageUI.ACT_WINDOWN_PRICE_PRODUCT);
	}

	public void enterToQuantityProductTextbox(WebDriver driver, String QtyProduct) {
		waitForElementVisible(driver, ProductPageUI.PRODUCT_DETAIL_QTY);
		sendkeyToElement(driver, ProductPageUI.PRODUCT_DETAIL_QTY, QtyProduct);
	}
	

	public Object getProductReviewPage() {
		waitForElementVisible(driver, ProductPageUI.REVIEW_PAGE_HEADER);
		return getElementText(driver, ProductPageUI.REVIEW_PAGE_HEADER);
	}

	public void clickToAddYourReviewLink() {
		waitForElementClickable(driver, ProductPageUI.ADD_REVIEW_LINK);
		clickToElement(driver, ProductPageUI.ADD_REVIEW_LINK);
	}

	public void AddProductRatingByValue(WebDriver driver, String reviewRating) {
		waitForElementClickable(driver, ProductPageUI.PRODUCT_RATING, reviewRating);
		clickToElement(driver, ProductPageUI.PRODUCT_RATING, reviewRating);
	}

	public void enterToReviewText(WebDriver driver, String reviewText) {
		waitForElementVisible(driver, ProductPageUI.REVIEW_TEXTAREA);
		sendkeyToElement(driver, ProductPageUI.REVIEW_TEXTAREA, reviewText);
	}

	public boolean isSuccessMSGDisplayed() {
		waitForElementVisible(driver, ProductPageUI.REVIEW_RESULT);
		return isElementDisplayed(driver,ProductPageUI.REVIEW_RESULT);
	}
	

	
			





	

}
