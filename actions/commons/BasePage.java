package commons;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageUIs.NopCommerce.Admin.AdminBasePageUI;
import pageUIs.NopCommerce.user.LoginPageUI;
import pageUIs.NopCommerce.user.UserBasePageUI;

public class BasePage {
	
	public static BasePage getBasepage() {
		return new BasePage();
	}
	public void openUrl(WebDriver driver, String pageurl) {
		driver.get(pageurl);
	}
	public String getPageTitle (WebDriver driver) {
		return driver.getTitle();
	}
	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}
	public Set<Cookie> getAllCookies(WebDriver driver) {
		return driver.manage().getCookies();
	}
	public void setAllCookies(WebDriver driver, Set<Cookie> allCookies) {
		for(Cookie cookie : allCookies) {
			driver.manage().addCookie(cookie);
		}
	}
	public Alert waitForAlertPresence(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, shortTimeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}
	public void acceptAlert(WebDriver driver) {
		alert =  waitForAlertPresence(driver);
		alert.accept();
	}
	public void cancelAlert(WebDriver driver) {
		alert =  waitForAlertPresence(driver);
		alert.dismiss();
	}
	public void sendkeyToAlert(WebDriver driver, String value) {
		alert = waitForAlertPresence(driver);
		alert.sendKeys(value);
	}
	public String getTextAlert(WebDriver driver) {
		alert = waitForAlertPresence(driver);
		return alert.getText();
	}
	
	public void switchToWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for(String id : allWindows) {
			if(!id.equals(parentID)) {
				driver.switchTo().window(id);
			}
		}
	}
	public void swithToWindowByTitle(WebDriver driver, String expectedTitle) {
		Set<String> allWindows = driver.getWindowHandles();
		for(String id : allWindows) {
			driver.switchTo().window(id);
			String windowTitle = driver.getTitle();
			System.out.println(windowTitle);
			if(windowTitle.equals(expectedTitle)) {
				break;
			}
		}
	}
	public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for(String id : allWindows) {
			if(!id.equals(parentID)) {
				driver.switchTo().window(id);
				driver.close();
			}
		}
	}
	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}
	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}
	
	public By getByXpath(String locator) {
		return By.xpath(locator);
	}
	public WebElement getElement(WebDriver driver, String locator) {
		 return driver.findElement(getByXpath(locator));
	}
	public WebElement getElement(WebDriver driver, String locator, String...params) {
		 return driver.findElement(getByXpath(getDynamicLocator(locator, params)));
	}
	public List<WebElement> getElements(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));
	}
	public String getDynamicLocator(String locator, String... params) {
		return String.format(locator, (Object[])params);
	}
	
	public void clickToElement(WebDriver driver, String locator) {
		getElement(driver, locator).click();
	}
	public void clickToElement(WebDriver driver, String locator, String... params) {
		getElement(driver, getDynamicLocator(locator, params)).click();
	}
	
	public void sendkeyToElement(WebDriver driver, String locator, String value) {
		getElement(driver, locator).clear();
		getElement(driver, locator).sendKeys(value);
	}
 	public void sendkeyToElement(WebDriver driver, String locator, String value, String...params) {
		locator = getDynamicLocator(locator,params);
		getElement(driver, locator).clear();
		getElement(driver, locator).sendKeys(value);
	}
	
	public int getElementSize(WebDriver driver, String locator) {
		return getElements(driver,locator).size();
	}
	public int getElementSize(WebDriver driver, String locator, String...params) {
		locator = getDynamicLocator(locator, params);
		return getElements(driver,locator).size();
	}
 	public void sleepInSecond(long timeOutInSecond) {
		try {
			Thread.sleep(timeOutInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void selectDropdownByText(WebDriver driver, String locator, String itemText) {
		select = new Select(getElement(driver, locator));
		select.selectByVisibleText(itemText);
	}
	public void selectDropdownByText(WebDriver driver, String locator, String itemText, String...params) {
		locator = getDynamicLocator(locator, params);
		select = new Select(getElement(driver, locator));
		select.selectByVisibleText(itemText);
	}
	
	public String getSelectedItemDropdown(WebDriver driver, String locator) {
		select = new Select(getElement(driver, locator));
		return select.getFirstSelectedOption().getText();
	}
	public String getSelectedItemDropdown(WebDriver driver, String locator, String...params) {
		locator = getDynamicLocator(locator,params);
		select = new Select(getElement(driver, locator));
		return select.getFirstSelectedOption().getText();
	}
	public boolean isDropdownMultiple(WebDriver driver, String locator) {
		select = new Select(getElement(driver, locator));
		return select.isMultiple();
	}
	
	public void selectItemInCustomDropdown(WebDriver driver, String parentXpath, String childXpath, String expectedItem) {
		getElement(driver, parentXpath).click();
		sleepInSecond(1);
		explicitWait = new WebDriverWait(driver,shortTimeout);
		List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childXpath)));
		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedItem)) {
				jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				//item.click();
				clickToElementByJS(driver, item);
				sleepInSecond(1);
					break;
				}
			} 
	}


	public String getElementAttribute(WebDriver driver, String locator, String attributeName) {
		return getElement(driver, locator).getAttribute(attributeName);
		}
	public String getElementAttribute(WebDriver driver, String locator, String attributeName, String...params) {
		locator = getDynamicLocator(locator, params);
		return getElement(driver, locator).getAttribute(attributeName);
		}
	public String getElementText(WebDriver driver, String locator) {
		return getElement(driver, locator).getText().trim();
	}
	public String getElementText(WebDriver driver, String locator, String... params) {
		return getElement(driver, getDynamicLocator(locator, params)).getText().trim();
	}
	
	public void checkToCheckboxOrRadio(WebDriver driver, String locator) {
		if(!getElement(driver,locator).isSelected()) {
			getElement(driver, locator).click();
		}
	}
	public void checkToCheckboxOrRadio(WebDriver driver, String locator, String... params) {
		locator = getDynamicLocator(locator, params);
		if(!getElement(driver,locator).isSelected()) {
			getElement(driver, locator).click();
		}
	}
	public void uncheckToCheckbox(WebDriver driver, String locator) {
		if(getElement(driver,locator).isSelected()) {
			getElement(driver, locator).click();
		}
	}
	public void uncheckToCheckbox(WebDriver driver, String locator, String... params) {
		locator = getDynamicLocator(locator, params);
		if(getElement(driver,locator).isSelected()) {
			getElement(driver, locator).click();
		}
	}
	
	public boolean isElementDisplayed(WebDriver driver, String locator) {
		try {
			// Displayed: Visible on UI + in DOM
			// Undisplayed: Invisible on UI + in DOM
		return getElement(driver, locator).isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
			// undisplayed: invisible on UI + Not In DOM
			return false;
		}
	}
	public boolean isElementUndisplayed(WebDriver driver, String locator) {
		overrideGlobalTimeout(driver, shortTimeout);
		List<WebElement> elements = getElements(driver, locator);
		overrideGlobalTimeout(driver, longTimeout); //Setup lại timeout sau khi find xong, quay lại longTimeout để chạy tiếp các lệnh khác.
		if (elements.size() == 0){
			System.out.println("Element not in DOM");
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
			System.out.println("Elements in DOM but not visible on UI");
			return true;
		} else {
			System.out.println("Element in DOM and visible on UI");
			return false;
		}
	}

	public void overrideGlobalTimeout(WebDriver driver, long timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}
	public boolean isElementDisplayed(WebDriver driver, String locator, String... params) {
		return getElement(driver,getDynamicLocator(locator, params)).isDisplayed();
	}
	public boolean isElementEnabled(WebDriver driver, String locator) {
		return getElement(driver, locator).isEnabled();
	}
	public boolean isElementSelected(WebDriver driver, String locator) {
		return getElement(driver, locator).isSelected();
	}
	public boolean isElementSelected(WebDriver driver, String locator, String...params) {
		locator = getDynamicLocator(locator, params);
		return getElement(driver, locator).isSelected();
	}
	
	public WebDriver switchToIframeByElement(WebDriver driver, String locator) {
		return driver.switchTo().frame(getElement(driver, locator));
	}
	public WebDriver switchToDefaultContent(WebDriver driver) {
		return driver.switchTo().defaultContent();
	}
	
	public void hoverToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.moveToElement(getElement(driver, locator)).perform();
	}
	public void hoverToElement(WebDriver driver, String locator, String... params) {
		locator = getDynamicLocator(locator, params);
		action = new Actions(driver);
		action.moveToElement(getElement(driver, locator)).perform();
	}
	public void doubleClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.doubleClick(getElement(driver, locator)).perform();
	}
	public void rightClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.contextClick(getElement(driver, locator)).perform();
	}
	public void dragAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
		action = new Actions(driver);
		action.dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)).perform();
	}
	public void pressKeyToElement(WebDriver driver, String locator, Keys key) {
		action = new Actions(driver);
		action.sendKeys(getElement(driver, locator), key).perform();
	}
	public void pressKeyToElement(WebDriver driver, String locator, Keys key, String... params) {
		action = new Actions(driver);
		locator = getDynamicLocator(locator, params);
		action.sendKeys(getElement(driver, locator), key).perform();
	}

	public Object executeForBrowser(WebDriver driver, String javaScript) {
		jsExecutor =(JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaScript);
	}
	public String getInnerText(WebDriver driver) {
		jsExecutor =(JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;"); 
	}
	public boolean isExpectedTextInInnerText(WebDriver driver, String textExpected) {
		jsExecutor =(JavascriptExecutor) driver;
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
		return textActual.equals(textExpected);
	}
	public void scrollToBottomPage(WebDriver driver) {
		jsExecutor =(JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	public void navigateToUrlByJS(WebDriver driver, String url) {
		jsExecutor =(JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
	}
	public void highlightElement(WebDriver driver, String locator) {
		jsExecutor =(JavascriptExecutor) driver;
		WebElement element = getElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}
	public void clickToElementByJS(WebDriver driver, String locator) {
		jsExecutor =(JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getElement(driver, locator));
	}
	public void clickToElementByJS(WebDriver driver, String locator, String...params) {
		jsExecutor =(JavascriptExecutor) driver;
		locator = getDynamicLocator(locator, params);
		jsExecutor.executeScript("arguments[0].click();", getElement(driver, locator));
	}
	private void clickToElementByJS(WebDriver driver, WebElement item) {
		jsExecutor =(JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", item);
	}
	public void scrollToElement(WebDriver driver, String locator) {
		jsExecutor =(JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
	}
	public void scrollToElement(WebDriver driver, String locator, String...params) {
		jsExecutor =(JavascriptExecutor) driver;
		locator = getDynamicLocator(locator, params);
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
	}
	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		jsExecutor =(JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locator));
	}
	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		jsExecutor =(JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, locator));
	}
	public boolean isjQueryAJAXLoadedSuccess(WebDriver driver){
		explicitWait = new WebDriverWait(driver,longTimeout);
		jsExecutor =(JavascriptExecutor) driver;
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return (Boolean) jsExecutor.executeScript("return (window.JQuery !=null) &&  (jQuery.active ===0);");
			}
		};
		return explicitWait.until(jQueryLoad);
	}
	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		explicitWait = new WebDriverWait(driver,longTimeout);
		jsExecutor =(JavascriptExecutor) driver;
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
		@Override
		public Boolean apply(WebDriver driver) {
			try {
				return ((long) jsExecutor.executeScript("return jQuery.active") == 0);
			} catch (Exception e) {
				return true;
			}
		}
		};
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>(){
		@Override
		public Boolean apply(WebDriver driver) {
			return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
		}
		};
		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}
	public String getElementValidationMessage(WebDriver driver, String locator) {
		jsExecutor =(JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
	}
	public String getElementValidationMessage(WebDriver driver, String locator, String...params) {
		jsExecutor =(JavascriptExecutor) driver;
		locator = getDynamicLocator(locator, params);
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
	}
	public boolean isImageLoaded(WebDriver driver, String locator) {
		jsExecutor =(JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getElement(driver, locator));
			if (status) {
		return true;
				} else {
		return false;
				}
			}
	public void waitForElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}
	public void waitForElementVisible(WebDriver driver, String locator, String... params) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(getDynamicLocator(locator, params))));
	}
	public void waitForAllElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(locator)));
	}
	public void waitForElementClickable(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}
	public void waitForElementClickable(WebDriver driver, String locator, String... params) {
		explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(getDynamicLocator(locator, params))));
	}
	public void waitForElementInvisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, shortTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
	}
	public void waitForElementInvisible(WebDriver driver, String locator, String params) {
		explicitWait = new WebDriverWait(driver, shortTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(getDynamicLocator(locator, params))));
	}

	// pattern object
	public void openFirstHeaderPageByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, UserBasePageUI.FIRST_PAGE_HEADER_BY_TEXT, pageName);
		clickToElement(driver, UserBasePageUI.FIRST_PAGE_HEADER_BY_TEXT, pageName);
	}
	public void openFooterPageByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, UserBasePageUI.PAGE_FOOTER, pageName);
		clickToElement(driver, UserBasePageUI.PAGE_FOOTER, pageName);
	}
	public void openSecondHeaderPageByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, UserBasePageUI.SECOND_PAGE_HEADER_BY_TEXT, pageName);
		clickToElement(driver, UserBasePageUI.SECOND_PAGE_HEADER_BY_TEXT, pageName);
	}
	public void clickToRadioButtonByLabelText(WebDriver driver, String labelText) {
		waitForElementClickable(driver, UserBasePageUI.RADIO_BY_LABEL_TEXT, labelText);
		checkToCheckboxOrRadio(driver, UserBasePageUI.RADIO_BY_LABEL_TEXT, labelText);
		sleepInSecond(3);
	}
	public void uncheckToRadioButtonByLabelText(WebDriver driver, String labelText) {
		waitForElementClickable(driver, UserBasePageUI.RADIO_BY_LABEL_TEXT, labelText);
		uncheckToCheckbox(driver, UserBasePageUI.RADIO_BY_LABEL_TEXT, labelText);
	}
	public void enterToTextboxByID(WebDriver driver, String textboxID, String value) {
		waitForElementVisible(driver, UserBasePageUI.TEXTBOX_BY_ID, textboxID);
		sendkeyToElement(driver, UserBasePageUI.TEXTBOX_BY_ID, value, textboxID);
	}
	public void selectDropdownByName(WebDriver driver, String dropdownName, String itemText) {
		selectDropdownByText(driver, UserBasePageUI.DROPDOWN_BY_NAME, itemText, dropdownName);
		sleepInSecond(2);
	}
	public void clickToButtonByText(WebDriver driver, String buttonText) {
		waitForElementClickable(driver, UserBasePageUI.BUTTON_BY_TEXT,buttonText);
		clickToElement(driver, UserBasePageUI.BUTTON_BY_TEXT,buttonText);
	}
	public void clickToRemoveProductButton(WebDriver driver, String productText) {
		waitForElementClickable(driver, UserBasePageUI.PRODUCT_REMOVE_BUTTON, productText);
		clickToElementByJS(driver, UserBasePageUI.PRODUCT_REMOVE_BUTTON, productText);
	}
	public void clickToSublistAtTopMenuByText(WebDriver driver, String menuText, String sublistText) {
		waitForElementVisible(driver, UserBasePageUI.TOP_MENU_BY_TEXT, menuText);
		hoverToElement(driver, UserBasePageUI.TOP_MENU_BY_TEXT, menuText);
		sleepInSecond(2);
		clickToElementByJS(driver,UserBasePageUI.TOP_SUB_MENU_BY_TEXT, menuText, sublistText);
	}
	public boolean isRequestedPageDisplayed(WebDriver driver, String pageText) {
		waitForElementVisible(driver, UserBasePageUI.PAGE_TITLE_BY_TEXT, pageText);
		System.out.println(getElementText(driver, UserBasePageUI.PAGE_TITLE_BY_TEXT, pageText));
		return isElementDisplayed(driver, UserBasePageUI.PAGE_TITLE_BY_TEXT, pageText);
	}
	public boolean isRadioButtonByLabelTextSelected(WebDriver driver, String labelText) {
		waitForElementVisible(driver, UserBasePageUI.RADIO_BY_LABEL_TEXT, labelText);
		return isElementSelected(driver, UserBasePageUI.RADIO_BY_LABEL_TEXT, labelText);
	}
	public boolean isProductsListEmpty(WebDriver driver) {
		return isElementUndisplayed(driver, UserBasePageUI.PRODUCT_LIST);
	}
	public boolean isCompletedOrderNumberDisplayed(WebDriver driver, String orderNumber) {
		waitForElementVisible(driver, UserBasePageUI.ORDER_NUMBER_BY_TEXT, orderNumber);
		System.out.println(getElementText(driver, UserBasePageUI.ORDER_NUMBER_BY_TEXT, orderNumber));
		return isElementDisplayed(driver, UserBasePageUI.ORDER_NUMBER_BY_TEXT, orderNumber);
	}
	public boolean requestCartOptionsDisplayed(WebDriver driver, String giftWappring) {
		waitForElementClickable(driver, UserBasePageUI.CART_OPTION);
		return getElementText(driver, UserBasePageUI.CART_OPTION).contains(giftWappring);
	}
	public Object getValueOfTextboxByID(WebDriver driver, String textboxID, String attributeName) {
		waitForElementVisible(driver, UserBasePageUI.TEXTBOX_BY_ID, textboxID);
		return getElementAttribute(driver, UserBasePageUI.TEXTBOX_BY_ID, attributeName, textboxID);
	}
	public Object getValueSelectedOfDropboxByName(WebDriver driver, String dropdownName) {
		waitForElementVisible(driver, UserBasePageUI.DROPDOWN_BY_NAME, dropdownName);
		return getSelectedItemDropdown(driver, UserBasePageUI.DROPDOWN_BY_NAME, dropdownName);
	}
	public Object getValidationErrorMSGDisplayed(WebDriver driver, String fieldName) {
		waitForElementVisible(driver, UserBasePageUI.VALIDATION_ERROR_MSG, fieldName);
		return getElementText(driver, UserBasePageUI.VALIDATION_ERROR_MSG, fieldName).trim() ;
	}
	public Object getBarNotification(WebDriver driver) {
		waitForElementVisible(driver, UserBasePageUI.BAR_NOTIFICATION);
		System.out.println(getElementText(driver, UserBasePageUI.BAR_NOTIFICATION).trim());
		return getElementText(driver, UserBasePageUI.BAR_NOTIFICATION).trim();
	}
	public Object getQuantityAtHeaderPage(WebDriver driver, String headerText) {
		waitForElementVisible(driver, UserBasePageUI.SECOND_PAGE_HEADER_QUANTITY_BY_TEXT, headerText);
		System.out.println(getElementText(driver, UserBasePageUI.SECOND_PAGE_HEADER_QUANTITY_BY_TEXT, headerText));
		return getElementText(driver, UserBasePageUI.SECOND_PAGE_HEADER_QUANTITY_BY_TEXT, headerText) ;
	}
	public Object getEmptyMsg(WebDriver driver) {
		waitForElementVisible(driver, UserBasePageUI.EMPTY_MSG);
		System.out.println(getElementText(driver, UserBasePageUI.EMPTY_MSG));
		return getElementText(driver, UserBasePageUI.EMPTY_MSG);
	}
	public Object getShippingInfoByClass(WebDriver driver, String className) {
		waitForElementVisible(driver, UserBasePageUI.SHIPPING_INFO_BY_CLASS, className);
		System.out.println(getElementText(driver, UserBasePageUI.SHIPPING_INFO_BY_CLASS, className));
		return getElementText(driver, UserBasePageUI.SHIPPING_INFO_BY_CLASS, className);
	}
	public void closeBarNotification(WebDriver driver) {
		waitForElementVisible(driver, UserBasePageUI.BAR_NOTIFICATION_CLOSE_BUTTON);
		clickToElement(driver, UserBasePageUI.BAR_NOTIFICATION_CLOSE_BUTTON);
		sleepInSecond(3);
	}
	public void openHomePage(WebDriver driver) {
		waitForElementClickable(driver, LoginPageUI.HOMEPAGE_IMG);
		clickToElement(driver, LoginPageUI.HOMEPAGE_IMG);
	}
	
	//Admin.NopCommerce	
	public void openSubMenuPageByName(WebDriver driver, String menuPage, String submenuPage) {
		//waitForElementClickable(driver, AdminBasePageUI.MENU_LINK_BY_TEXT, menuPage);
		if (!isElementDisplayed(driver, AdminBasePageUI.SUB_MENU_DISPLAYED_BY_TEXT, menuPage)) {
			clickToElementByJS(driver, AdminBasePageUI.MENU_LINK_BY_TEXT, menuPage);
		}
		clickToElementByJS(driver, AdminBasePageUI.SUB_MENU_LINK_BY_TEXT, submenuPage);
	}
	
	public void uploadFileAtCardName(WebDriver driver, String cardName, String...fileNames) {
		String filePath = GlobalConstants.UPLOAD_FOLDER_PATH;
		String fullFileName = "";
		for(String file : fileNames) {
			fullFileName = fullFileName + filePath + file + "\n";
		}
		fullFileName = fullFileName.trim();
		getElement(driver, AdminBasePageUI.UPLOAD_FILE_BY_CARD_NAME, cardName).sendKeys(fullFileName);
	}
	public void clickToButtonByName(WebDriver driver, String buttonName) {
		waitForElementVisible(driver, AdminBasePageUI.BUTTON_BY_NAME, buttonName);
		clickToElement(driver, AdminBasePageUI.BUTTON_BY_NAME, buttonName);
	}
	public void clickToButtonByID(WebDriver driver, String buttonText) {
		waitForElementClickable(driver, AdminBasePageUI.BUTTON_BY_ID,buttonText);
		clickToElement(driver, AdminBasePageUI.BUTTON_BY_ID,buttonText);
	}
	public void clickToButtonByContainsText(WebDriver driver, String buttonText) {
		scrollToElement(driver, AdminBasePageUI.BUTTON_BY_CONTAINS_TEXT,buttonText);
		waitForElementClickable(driver, AdminBasePageUI.BUTTON_BY_CONTAINS_TEXT,buttonText);
		clickToElementByJS(driver, AdminBasePageUI.BUTTON_BY_CONTAINS_TEXT,buttonText);
	}
	public Object getQuantityItemInTableDisplayed(WebDriver driver) {
		waitForAllElementVisible(driver, AdminBasePageUI.SEARCH_ITEM_LIST);
		List <WebElement> searchProductsList = getElements(driver, AdminBasePageUI.SEARCH_ITEM_LIST);
		System.out.println(searchProductsList.size());
		return searchProductsList.size();
	}
	public void addToCommentTextarea(WebDriver driver, String comment) {
		waitForElementVisible(driver, AdminBasePageUI.COMMENT_TEXTAREA);
		sendkeyToElement(driver, AdminBasePageUI.COMMENT_TEXTAREA, comment);
	}
	public void clickToExpandPanelByText(WebDriver driver, String panelName) {
		scrollToElement(driver, AdminBasePageUI.TOOGLE_ICON_BY_CARD_NAME, panelName);
		waitForElementVisible(driver, AdminBasePageUI.TOOGLE_ICON_BY_CARD_NAME, panelName);
		String toogleIconStatus = getElementAttribute(driver, AdminBasePageUI.TOOGLE_ICON_BY_CARD_NAME, "class", panelName);
		if(toogleIconStatus.contains("fa-plus")) {
			waitForElementClickable(driver, AdminBasePageUI.TOOGLE_ICON_BY_CARD_NAME, panelName);
			clickToElement(driver, AdminBasePageUI.TOOGLE_ICON_BY_CARD_NAME, panelName);
		}
	}
	public boolean isHeaderTitleOfPageDisplayed(WebDriver driver, String headerText) {
		waitForElementVisible(driver, AdminBasePageUI.HEADER_TITLE);
		System.out.println(getElementText(driver, AdminBasePageUI.HEADER_TITLE));
		return getElementText(driver, AdminBasePageUI.HEADER_TITLE).contains(headerText);
	}
	public boolean isSuccessAlertDisplayed(WebDriver driver) {
		waitForElementVisible(driver, AdminBasePageUI.SUCCESS_ALERT);
		return isElementDisplayed(driver, AdminBasePageUI.SUCCESS_ALERT);
	}
	public void closeAlertNotification(WebDriver driver) {
		waitForElementVisible(driver, AdminBasePageUI.SUCCESS_ALERT_CLOSE_BUTTON);
		clickToElement(driver, AdminBasePageUI.SUCCESS_ALERT_CLOSE_BUTTON);
	}
	
	private Alert alert;
	private Select select;
	private Actions action;
	private long shortTimeout = GlobalConstants.SHORT_TIMEOUT;
	private long longTimeout = GlobalConstants.LONG_TIMEOUT;
	private WebDriverWait explicitWait;
	private JavascriptExecutor jsExecutor;


}
