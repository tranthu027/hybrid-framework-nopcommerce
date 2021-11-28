package pageObject.NopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.NopCommerce.user.WishlistPageUI;

public class WishlistPageObject extends BasePage {
	private WebDriver driver;
	
	public WishlistPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public Object getProductInWishlist(WebDriver driver) {
		waitForElementVisible(driver, WishlistPageUI.WISHLIST_PRODUCT_NAME);
		return getElementText(driver, WishlistPageUI.WISHLIST_PRODUCT_NAME);
	}

	public void clickToWishlistShareLink(WebDriver driver) {
		waitForElementClickable(driver, WishlistPageUI.WISHLIST_SHARE_LINK);
		clickToElement(driver, WishlistPageUI.WISHLIST_SHARE_LINK);

	}

	public void checkToAddToCartCheckbox(WebDriver driver) {
		waitForElementVisible(driver, WishlistPageUI.ADD_TO_CART_CHECKBOX);	
		checkToCheckboxOrRadio(driver, WishlistPageUI.ADD_TO_CART_CHECKBOX);
	}






	

	

}
