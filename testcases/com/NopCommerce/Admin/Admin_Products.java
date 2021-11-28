package com.NopCommerce.Admin;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.NopCommerce.admin.CustomerDetailsPageObject;
import pageObject.NopCommerce.admin.CustomersPageObject;
import pageObject.NopCommerce.admin.DashboardPageObject;
import pageObject.NopCommerce.admin.LoginPageObject;
import pageObject.NopCommerce.admin.PageGeneratorManager;
import pageObject.NopCommerce.admin.ProductDetailsPageObject;
import pageObject.NopCommerce.admin.ProductSearchPageObject;
import utilities.DataUtil;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;

public class Admin_Products extends BaseTest {
	String emaillogin, passwordlogin, product01, category01, category02, category03, manufacturer, SKU;
	
  @Parameters ({"browser", "URL"})
  @BeforeClass
  public void beforeClass(String browserName, String appUrl) {
	  log.info("Pre-Condition - Step 01: Open browser '" + browserName + "' and nagivate to '" + appUrl + "'");
	  driver = getBrowserDriver(browserName, appUrl);
	  loginPage = PageGeneratorManager.getLoginPage(driver);
	  
	  emaillogin = "admin@yourstore.com";
	  passwordlogin = "admin";
	  product01 = "Lenovo IdeaCentre 600 All-in-One PC";
	  category01 = "Computers";
	  category02 = "Computers >> Desktops";
	  category03 = "All";
	  manufacturer = "Apple";
	  SKU = "LE_IC_600";
	  
	  
	  log.info("Pre-Condition - Step 01: Enter email To Email textbox");
	  loginPage.enterToTextboxByID(driver, "Email", emaillogin);
	  
	  log.info("Pre-Condition - Step 02: Enter password To Password textbox");
	  loginPage.enterToTextboxByID(driver, "Password", passwordlogin);
	  
	  log.info("Pre-Condition - Step 03: Click to Log in button");
	  loginPage.clickToButtonByText(driver, "Log in");
	  dashboardPage = PageGeneratorManager.getDashboardPage(driver);
	  
	  log.info("Pre-Condition - Step 04: Open menu Catalog/Products");
	  verifyTrue(dashboardPage.areJQueryAndJSLoadedSuccess(driver));
	  dashboardPage.openSubMenuPageByName(driver, "Catalog"," Products");
	  productSearchPage = PageGeneratorManager.getProductSearchPage(driver);

	  
	  log.info("Pre-Condition - Step 05: Verify Product Search Page is displayed");
	  verifyTrue(productSearchPage.isHeaderTitleOfPageDisplayed(driver, "Products"));
  }
 
	@Test
	public void Admin_Test01_SearchWithProductName() {
		log.info("------------ TC_01_Search_With_Product_Name ------------");
		log.info("TC_01_Admin: Step 01: Expand Search panel");
		productSearchPage.clickToExpandSearchPanel();
		  
		log.info("TC_01_Admin: Step 02: Search product name with value: " + product01);
		verifyTrue(productSearchPage.areJQueryAndJSLoadedSuccess(driver));
		productSearchPage.enterToTextboxByID(driver, "SearchProductName", product01);
		
		log.info("TC_01_Admin: Step 03: Click to Search Button");
		productSearchPage.clickToButtonByID(driver, "search-products");
		
		log.info("TC_01_Admin: Step 04: Verify only 1 item is displayed");
		verifyTrue(productSearchPage.areJQueryAndJSLoadedSuccess(driver));
		verifyEquals(productSearchPage.getQuantityItemInTableDisplayed(driver), 1);
		
	}
	@Test
	public void Admin_Test02_SearchWithProductNameAndCategoryAndUnchecked() {
		log.info("------------ TC_02_Search_With_Product_Name_And_Category_And_Unchecked ------------");
		productSearchPage.refreshCurrentPage(driver);
		verifyTrue(productSearchPage.areJQueryAndJSLoadedSuccess(driver));
		
		log.info("TC_02_Admin: Step 01: Expand Search panel");
		productSearchPage.clickToExpandSearchPanel();
		
		log.info("TC_02_Admin: Step 02: Search product name with value: " + product01);
		productSearchPage.enterToTextboxByID(driver, "SearchProductName", product01);
		
		log.info("TC_02_Admin: Step 03: Select item in Category dropdown with value: " + category01);
		productSearchPage.selectDropdownByName(driver, "SearchCategoryId", category01);
		
		log.info("TC_02_Admin: Step 04: Click to Search subcategories radio button");
		productSearchPage.uncheckToSubCategoryRadioButton();
		
		log.info("TC_02_Admin: Step 05: Click to Search Button");
		productSearchPage.clickToButtonByID(driver, "search-products");
		
		log.info("TC_02_Admin: Step 06: Verify no data available in table");
		verifyTrue(productSearchPage.areJQueryAndJSLoadedSuccess(driver));
		verifyTrue(productSearchPage.isEmptyTableDisplayed());
		
	}
	@Test
	public void Admin_Test03_SearchWithProductNameAndCategoryAndChecked() {
		log.info("------------ TC_03_Search_With_Product_Name_And_Category_And_Checked ------------");
		productSearchPage.refreshCurrentPage(driver);
		verifyTrue(productSearchPage.areJQueryAndJSLoadedSuccess(driver));
		log.info("TC_03_Admin: Step 01: Expand Search panel");
		productSearchPage.clickToExpandSearchPanel();
		
		log.info("TC_03_Admin: Step 02: Search product name with value: " + product01);
		productSearchPage.enterToTextboxByID(driver, "SearchProductName", product01);
		
		log.info("TC_03_Admin: Step 03: Select item in Category dropdown with value: " + category01);
		productSearchPage.selectDropdownByName(driver, "SearchCategoryId", category01);
		
		log.info("TC_03_Admin: Step 04: Click to Search subcategories radio button");
		productSearchPage.checkToSubCategoryRadioButton();
		
		log.info("TC_03_Admin: Step 05: Click to Search Button");
		productSearchPage.clickToButtonByID(driver, "search-products");
		
		log.info("TC_03_Admin: Step 06: Verify only 1 item is displayed");
		verifyTrue(productSearchPage.areJQueryAndJSLoadedSuccess(driver));
		verifyEquals(productSearchPage.getQuantityItemInTableDisplayed(driver), 1);
		
	}
	@Test
	public void Admin_Test04_SearchWithProductNameAndChildCategory() {
		log.info("------------ TC_04_Search_With_Product_Name_And_Child_Category ------------");
		productSearchPage.refreshCurrentPage(driver);
		verifyTrue(productSearchPage.areJQueryAndJSLoadedSuccess(driver));
		log.info("TC_04_Admin: Step 01: Expand Search panel");
		productSearchPage.clickToExpandSearchPanel();
		
		log.info("TC_04_Admin: Step 02: Search product name with value: " + product01);
		productSearchPage.enterToTextboxByID(driver, "SearchProductName", product01);
		
		log.info("TC_04_Admin: Step 03: Select item in Category dropdown with value: " + category02);
		productSearchPage.selectDropdownByName(driver, "SearchCategoryId", category02);
		
		log.info("TC_04_Admin: Step 04: Click to Search subcategories radio button");
		productSearchPage.uncheckToSubCategoryRadioButton();
		
		log.info("TC_04_Admin: Step 05: Click to Search Button");
		productSearchPage.clickToButtonByID(driver, "search-products");
		
		log.info("TC_04_Admin: Step 06: Verify only 1 item is displayed");
		verifyTrue(productSearchPage.areJQueryAndJSLoadedSuccess(driver));
		verifyEquals(productSearchPage.getQuantityItemInTableDisplayed(driver), 1);
		
	}
	@Test
	public void Admin_Test05_SearchWithProductNameAndManufacturer() {
		log.info("------------ TC_05_Search_With_Product_Name_And_Manufacturer ------------");
		productSearchPage.refreshCurrentPage(driver);
		verifyTrue(productSearchPage.areJQueryAndJSLoadedSuccess(driver));
		log.info("TC_05_Admin: Step 01: Expand Search panel");
		productSearchPage.clickToExpandSearchPanel();
		
		log.info("TC_05_Admin: Step 02: Search product name with value: " + product01);
		productSearchPage.enterToTextboxByID(driver, "SearchProductName", product01);
		
		log.info("TC_05_Admin: Step 03: Select item in Category dropdown with value: " + category03);
		productSearchPage.selectDropdownByName(driver, "SearchCategoryId", category03);
		
		log.info("TC_05_Admin: Step 04: Click to Search subcategories radio button");
		productSearchPage.uncheckToSubCategoryRadioButton();
		
		log.info("TC_05_Admin: Step 05: Select item in Manufacturer dropdown with value: " + manufacturer);
		productSearchPage.selectDropdownByName(driver, "SearchManufacturerId", manufacturer);
		
		log.info("TC_05_Admin: Step 06: Click to Search Button");
		productSearchPage.clickToButtonByID(driver, "search-products");
		
		log.info("TC_05_Admin: Step 07: Verify no data available in table");
		verifyTrue(productSearchPage.areJQueryAndJSLoadedSuccess(driver));
		verifyTrue(productSearchPage.isEmptyTableDisplayed());
		
	}
	@Test
	public void Admin_Test06_GoDirectlyToProductBySKU() {
		log.info("------------ TC_06_Go_Directly_To_Product_By_SKU ------------");
		productSearchPage.refreshCurrentPage(driver);
		verifyTrue(productSearchPage.areJQueryAndJSLoadedSuccess(driver));
		log.info("TC_06_Admin: Step 01: Expand Search panel");
		productSearchPage.clickToExpandSearchPanel();
		
		log.info("TC_06_Admin: Step 02: Click Edit button by SKU: " + SKU);
		productSearchPage.clickToEditButtonBySkuOrName(driver, SKU);
		productDetailPage = PageGeneratorManager.getProductDetailPage(driver);
		
		log.info("TC_06_Admin: Step 03: Expand Product info panel");
		productDetailPage.clickToExpandPanelByText(driver, "Product info");
		
		log.info("TC_06_Admin: Step 04: Verify Product name is displayed");
		verifyTrue(productSearchPage.areJQueryAndJSLoadedSuccess(driver));
		verifyTrue(productDetailPage.isProductNameDisplayed(driver, product01));
	}
	
	@Parameters({"browser"})
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-Condition: Close browser '" + browserName + "'");
		cleanDriverInstance();

	}
	
	WebDriver driver;
	LoginPageObject loginPage;
	DashboardPageObject dashboardPage;
	ProductSearchPageObject productSearchPage;
	ProductDetailsPageObject productDetailPage;
	CustomersPageObject customersPage;
	CustomerDetailsPageObject customerDetailPage;
	DataUtil fakeData;
}
	  
