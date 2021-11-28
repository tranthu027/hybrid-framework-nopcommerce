package pageObject.NopCommerce.admin;


import org.openqa.selenium.WebDriver;


import commons.BasePage;
import pageUIs.NopCommerce.Admin.ProductSearchPageUI;

public class ProductSearchPageObject extends BasePage {
	WebDriver driver;
	public ProductSearchPageObject (WebDriver driver) {
		this.driver = driver;
	}

	public void clickToExpandSearchPanel() {
		waitForElementVisible(driver, ProductSearchPageUI.TOOGLE_ICON_SEARCH_PANEL);
		String toogleIconStatus = getElementAttribute(driver, ProductSearchPageUI.TOOGLE_ICON_SEARCH_PANEL, "class");
		if(toogleIconStatus.contains("fa-angle-down")) {
			waitForElementClickable(driver, ProductSearchPageUI.TOOGLE_ICON_SEARCH_PANEL);
			clickToElement(driver, ProductSearchPageUI.TOOGLE_ICON_SEARCH_PANEL);
		}
		}

	public void uncheckToSubCategoryRadioButton() {
		waitForElementClickable(driver, ProductSearchPageUI.SUBCATEGORY_RADIO_BUTTON);
		uncheckToCheckbox(driver, ProductSearchPageUI.SUBCATEGORY_RADIO_BUTTON);
	}
	public void checkToSubCategoryRadioButton() {
		waitForElementClickable(driver, ProductSearchPageUI.SUBCATEGORY_RADIO_BUTTON);
		checkToCheckboxOrRadio(driver, ProductSearchPageUI.SUBCATEGORY_RADIO_BUTTON);
	}

	public boolean isEmptyTableDisplayed() {
		waitForElementVisible(driver, ProductSearchPageUI.EMPTY_TABLE);
		return isElementDisplayed(driver, ProductSearchPageUI.EMPTY_TABLE);
	}
	
	public void clickToEditButtonBySkuOrName(WebDriver driver, String productNameOrSku) {
		waitForElementClickable(driver, ProductSearchPageUI.EDIT_BUTTON_BY_SKU_OR_NAME, productNameOrSku);
		clickToElement(driver, ProductSearchPageUI.EDIT_BUTTON_BY_SKU_OR_NAME, productNameOrSku);
	}

	
	
	
	
	
//	public boolean isSuccessMessageDisplayed(String alertSuccess) {
//		waitForElementVisible(driver, ProductSearchPageUI.SUCCESS_MSG, alertSuccess);
//		return isElementDisplayed(driver, ProductSearchPageUI.SUCCESS_MSG, alertSuccess);
//	}
//	public boolean isPictureImageUpdated(String productImageName, String productName) {
//		productImageName = productImageName.replace(" ", "-").toLowerCase();  
//		waitForElementVisible(driver, ProductSearchPageUI.PRODUCT_IMAGE_BY_PRODUCT_NAME, productName, productImageName);
//		return isElementDisplayed(driver, ProductSearchPageUI.PRODUCT_IMAGE_BY_PRODUCT_NAME, productName, productImageName);
//	}
//
//
//








	


}
