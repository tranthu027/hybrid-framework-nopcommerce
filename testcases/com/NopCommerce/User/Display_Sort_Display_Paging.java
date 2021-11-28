package com.NopCommerce.User;

import org.testng.annotations.Test;

import com.NopCommerce.common.Common_01_Login;

import commons.BaseTest;
import pageObject.NopCommerce.user.HomePageObject;
import pageObject.NopCommerce.user.LoginPageObject;
import pageObject.NopCommerce.user.MyAccountPageObject;
import pageObject.NopCommerce.user.PageGeneratorManager;
import pageObject.NopCommerce.user.ProductPageObject;
import pageObject.NopCommerce.user.RegisterPageObject;
import pageObject.NopCommerce.user.SearchPageObject;
import pageObject.NopCommerce.user.ShoppingCartPageObject;
import pageObject.NopCommerce.user.WishlistPageObject;
import utilities.DataUtil;

import org.testng.annotations.BeforeClass;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;

public class Display_Sort_Display_Paging extends BaseTest {
	String preFirstName, preLastName, preEmail, password;
	
  @Parameters ({"browser", "URL"})
  @BeforeClass
  public void beforeClass(String browserName, String appUrl) {
	  log.info("Pre-Condition - Step 01: Open browser '" + browserName + "' and nagivate to '" + appUrl + "'");
	  driver = getBrowserDriver(browserName, appUrl);
	  homePage = PageGeneratorManager.getHomePage(driver);
	  fakeData = DataUtil.getData();
	  
	  preFirstName = fakeData.getPreFirstName();
	  preLastName = fakeData.getPreLastName();
	  preEmail = fakeData.getPreEmailAdress();
	  password = fakeData.getPassword();
	  
	  log.info("Pre-Condition - Step 1: Click To Login link");
	  homePage.openFirstHeaderPageByName(driver, "Log in");
	  loginPage = PageGeneratorManager.getLoginPage(driver);
		
	  log.info("Pre-Condition - Step 2: Set login page cookie");
	  loginPage.setAllCookies(driver, Common_01_Login.loginPageCookie);
	  loginPage.sleepInSecond(5);
	  loginPage.refreshCurrentPage(driver);
			
	  log.info("Pre-Condition - Step 3: Click to HomePage img");
	  loginPage.openHomePage(driver);
	  homePage = PageGeneratorManager.getHomePage(driver);
				
	  log.info("Pre-Condition - Step 3: Verify Home page Displayed");
	  verifyTrue(homePage.isHomePageSliderDisplayed());
  }
	@Test
	public void Display_Test01_SortNameAToZ() {
		log.info("------------ SORT DISPLAYED PAGING ------------");
		log.info("------------ TC_01_Display_Sort_Name_A_To_Z ------------");
		log.info("TC_01_Display: Step 01: Click To Product Catelogies on Top Menu: Computers/Desktops");
		homePage.clickToSublistAtTopMenuByText(driver, "Computers", "Notebooks");
		productPage = PageGeneratorManager.getProductPage(driver);
		
		log.info("TC_01_Display: Step 02: Click To Product Order dropdown");
		productPage.selectDropdownByName(driver, "products-orderby", "Name: A to Z");
		
		log.info("TC_01_Display: Step 03: Click To Product Page size dropdown");
		productPage.selectDropdownByName(driver, "products-pagesize", "9");
		
		log.info("TC_01_Display: Step 04: Products names are Sorted in ascending Order");
		verifyTrue(productPage.isProductNameSortAscending());
				  
	}
	@Test
	public void Display_Test02_SortNameZToA() {
		log.info("------------ TC_02_Display_Sort_Name_Z_To_A ------------");
		log.info("TC_02_Display: Step 01: Click To Product Order dropdown");
		productPage.selectDropdownByName(driver, "products-orderby", "Name: Z to A");
		
		log.info("TC_02_Display: Step 02: Click To Product Page size dropdown");
		productPage.selectDropdownByName(driver, "products-pagesize", "9");
		
		log.info("TC_02_Display: Step 03: Products names are Sorted in Descending Order");
		verifyTrue(productPage.isProductNameSortDescending());
				  
	}	
	
	@Test
	public void Display_Test03_SortWithPriceLowToHigh() {
		log.info("------------ TC_03_Display_Sort_With_Price_Low_To_High ------------");
		log.info("TC_03_Display: Step 01: Click To Product Order dropdown");
		productPage.selectDropdownByName(driver, "products-orderby", "Price: Low to High");
		
		log.info("TC_03_Display: Step 02: Click To Product Page size dropdown");
		productPage.selectDropdownByName(driver, "products-pagesize", "9");
		
		log.info("TC_03_Display: Step 03: Products price are Sorted in ascending Order");
		verifyTrue(productPage.isProductPriceSortAscending());

	}
	@Test
	public void Display_Test04_SortWithPriceHighToLow() {
		log.info("------------ TC_04_Display_Sort_With_Price_High_To_Low ------------");
		log.info("TC_04_Display: Step 01: Click To Product Order dropdown");
		productPage.selectDropdownByName(driver, "products-orderby", "Price: High to Low");
		
		log.info("TC_04_Display: Step 02: Click To Product Page size dropdown");
		productPage.selectDropdownByName(driver, "products-pagesize", "9");
		
		log.info("TC_04_Display: Step 03: Products price are Sorted in Descending Order");
		verifyTrue(productPage.areJQueryAndJSLoadedSuccess(driver));
		verifyTrue(productPage.isProductPriceSortDescending());
				  
	}
	@Test
	public void Display_Test05_PageSizeDisplayedWithValue3() {
		log.info("------------ TC_05_Display_Page_Size_Displayed_With_Value_3 ------------");
		log.info("TC_05_Display: Step 01: Click To Product Page size dropdown with value: 3");
		productPage.selectDropdownByName(driver, "products-pagesize", "3");
		
		log.info("TC_05_Display: Step 02: Verify Product page size is correct");
		verifyTrue(productPage.productPageSizeDisplayedAsExpected(driver,3));	
		
		log.info("TC_05_Display: Step 03: Verify pagination is dispalyed");
		verifyFalse(productPage.isPaginationUndisplay(driver));
		
		log.info("TC_05_Display: Step 04: Verify pagination next icon is dispalyed");
		verifyTrue(productPage.isPaginationIconDisplay(driver, "Next"));
		
		log.info("TC_05_Display: Step 05: Click To Page 2 link");
		productPage.clickToExpectedPaginationLink(driver, "2");
		
		log.info("TC_05_Display: Step 06: Verify pagination Previous icon is dispalyed");
		verifyTrue(productPage.areJQueryAndJSLoadedSuccess(driver));
		verifyTrue(productPage.isPaginationIconDisplay(driver, "Previous"));

	}	
	@Test
	public void Display_Test06_PageSizeDisplayedWithValue6() {
		log.info("------------ TC_06_Display_Page_Size_Displayed_With_Value_6 ------------");
		log.info("TC_06_Display: Step 01: Click To Product Page size dropdown with value: 6");
		productPage.selectDropdownByName(driver, "products-pagesize", "6");
		
		log.info("TC_06_Display: Step 02: Verify Product page size is correct");
		verifyTrue(productPage.productPageSizeDisplayedAsExpected(driver,6));	
		
		log.info("TC_06_Display: Step 03: Verify pagination is undispalyed");
		verifyTrue(productPage.areJQueryAndJSLoadedSuccess(driver));
		verifyTrue(productPage.isPaginationUndisplay(driver));

	}
	@Test
	public void Display_Test07_PageSizeDisplayedWithValue9() {
		log.info("------------ TC_07_Display_Page_Size_Displayed_With_Value_9 ------------");
		log.info("TC_07_Display: Step 01: Click To Product Page size dropdown with value: 6");
		productPage.selectDropdownByName(driver, "products-pagesize", "9");
		
		log.info("TC_07_Display: Step 02: Verify Product page size is correct");
		verifyTrue(productPage.productPageSizeDisplayedAsExpected(driver,9));	
		
		log.info("TC_07_Display: Step 03: Verify pagination is undispalyed");
		verifyTrue(productPage.areJQueryAndJSLoadedSuccess(driver));
		verifyTrue(productPage.isPaginationUndisplay(driver));
		
	}
	
	@Parameters({"browser"})
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-Condition: Close browser '" + browserName + "'");
		cleanDriverInstance();

	}
	
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	MyAccountPageObject myAccountPage;
	SearchPageObject searchPage;
	ProductPageObject productPage;
	WishlistPageObject wishlistPage;
	ShoppingCartPageObject shoppingCartPage;
	DataUtil fakeData;
}
	  
