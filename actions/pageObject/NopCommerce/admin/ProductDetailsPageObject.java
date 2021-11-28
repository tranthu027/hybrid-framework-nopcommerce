package pageObject.NopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.NopCommerce.Admin.ProductDetailsPageUI;

public class ProductDetailsPageObject extends BasePage {
	
	WebDriver driver;
	public ProductDetailsPageObject (WebDriver driver) {
		this.driver = driver;
	}
	public boolean isProductNameDisplayed(WebDriver driver, String productName) {
		waitForElementVisible(driver, ProductDetailsPageUI.PRODUCT_NAME, productName);
		return isElementDisplayed(driver, ProductDetailsPageUI.PRODUCT_NAME, productName);
	}
	

	
	
	public boolean isPictureUploadedSuccessByFileName(String productImgName) {
		productImgName = productImgName.split("\\.")[0];
		waitForElementVisible(driver, ProductDetailsPageUI.UPLOADED_IMG, productImgName);
		return isElementDisplayed(driver, ProductDetailsPageUI.UPLOADED_IMG, productImgName);
	}
	public void enterToAltTextbox(String altText) {
		waitForElementVisible(driver, ProductDetailsPageUI.ALT_TEXTBOX);
		sendkeyToElement(driver, ProductDetailsPageUI.ALT_TEXTBOX, altText);
	}
	public void enterToTitleTextbox(String titleText) {
		waitForAllElementVisible(driver, ProductDetailsPageUI.TITLE_TEXTBOX);
		sendkeyToElement(driver, ProductDetailsPageUI.TITLE_TEXTBOX, titleText);
	}
	public void clickToUpDownInDisplayedOrderTextbox(String selectValue) {
		waitForElementClickable(driver, ProductDetailsPageUI.DISPLAYED_ORDER_TEXTBOX_UP_DOWN, selectValue);
		clickToElement(driver, ProductDetailsPageUI.DISPLAYED_ORDER_TEXTBOX_UP_DOWN, selectValue);
	}
	public void clickToAddProductPictureButton() {
		waitForElementClickable(driver, ProductDetailsPageUI.ADD_PRODUCT_BUTTON);
		clickToElement(driver, ProductDetailsPageUI.ADD_PRODUCT_BUTTON);
	}
	public boolean isPictureImageDisplayed(String imageName, String displayedOrderNumber, String altText, String titleText) {
		imageName = imageName.replace(" ", "-").toLowerCase();
		waitForElementVisible(driver, ProductDetailsPageUI.ADDED_PRODUCT_INFO, imageName, displayedOrderNumber , altText, titleText);
		return isElementDisplayed(driver, ProductDetailsPageUI.ADDED_PRODUCT_INFO, imageName, displayedOrderNumber , altText, titleText);
	}
	public ProductSearchPageObject clickToSaveButton() {
		waitForElementClickable(driver, ProductDetailsPageUI.SAVE_BUTTON);
		clickToElement(driver, ProductDetailsPageUI.SAVE_BUTTON);
		return PageGeneratorManager.getProductSearchPage(driver);
	}
	public void clickToDeletedButtonAtPictureName(String productTitle) {
		waitForElementClickable(driver, ProductDetailsPageUI.DELETE_BUTTON_BY_IMAGE_TITLE, productTitle);
		clickToElement(driver, ProductDetailsPageUI.DELETE_BUTTON_BY_IMAGE_TITLE, productTitle);
		acceptAlert(driver);
	}



}
