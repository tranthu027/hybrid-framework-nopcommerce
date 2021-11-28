package com.NopCommerce.User;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.NopCommerce.user.HomePageObject;
import pageObject.NopCommerce.user.LoginPageObject;
import pageObject.NopCommerce.user.MyAccountPageObject;
import pageObject.NopCommerce.user.PageGeneratorManager;
import pageObject.NopCommerce.user.RegisterPageObject;
import pageObject.NopCommerce.user.SearchPageObject;
import utilities.DataUtil;

import org.testng.annotations.BeforeClass;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;

public class Search_And_Advanced_Search extends BaseTest {
	
	String preFirstName,preLastName, preEmai, password,
		   searchKeyword, productNotExistKeyword, productBrandKeyword, specificNameProductKeyword, category, incorrectManufacturer, correctManufacturer;
	String[] listBrandProductsExpected = {"Lenovo Thinkpad X1 Carbon Laptop", "Lenovo IdeaCentre 600 All-in-One PC"};
	String[] listSpectificProductsExpected = {"Lenovo Thinkpad X1 Carbon Laptop"};
	String[] listAdvancedSearchExpected = {"Apple MacBook Pro 13-inch"};

	int numberProductBrandResultExpected = 2;
	int numberSpecificProductResultExpected = 1;
	int numberAdvancedSearchExpected = 1;

  @Parameters ({"browser", "URL"})
  @BeforeClass
  public void beforeClass(String browserName, String appUrl) {
	  log.info("Pre-Condition - Step 01: Open browser '" + browserName + "' and nagivate to '" + appUrl + "'");
	  driver = getBrowserDriver(browserName, appUrl);
	  homePage = PageGeneratorManager.getHomePage(driver);
	  
	  fakeData = DataUtil.getData();
	  preFirstName = fakeData.getFirstName();
	  preLastName = fakeData.getEditLastName();
	  preEmai = fakeData.getEmailAdress();
	  password = "123456";
	  
	  searchKeyword = "Apple Macbook Pro";
	  productNotExistKeyword = "Macbook Pro 2050";
	  productBrandKeyword = "Lenovo";
	  specificNameProductKeyword = "ThinkPad X1 Carbon";
	  category = "Computers";
	  incorrectManufacturer = "HP";
	  correctManufacturer = "Apple";
	  
	  log.info("Pre-Condition: Step 02: Click To Register Link");
	  homePage.openFirstHeaderPageByName(driver, "Register");
	  registerPage = PageGeneratorManager.getRegisterPage(driver);
	
	  log.info("Pre-Condition: Step 03: Enter First Name with value (" + preFirstName + ")");
	  registerPage.enterToTextboxByID(driver, "FirstName", preFirstName);
		
	  log.info("Pre-Condition: Step 04: Enter Last Name with value (" + preLastName + ")");
	  registerPage.enterToTextboxByID(driver,"LastName", preLastName);
	  
	  log.info("Pre-Condition: Step 05: Enter Email Address with value (" + preEmai + ")");
	  registerPage.enterToTextboxByID(driver,"Email", preEmai);
	  
	  log.info("Pre-Condition: Step 06: Enter Password with value (" + password + ")");
	  registerPage.enterToTextboxByID(driver,"Password", password);
				
	  log.info("Pre-Condition: Step 07: Enter Confirm Password with value (" + password + ")");
	  registerPage.enterToTextboxByID(driver,"ConfirmPassword", password);
	
	  log.info("Pre-Condition: Step 08: Click to Register button");
	  registerPage.clickToButtonByText(driver,"Register");
	  
	  log.info("Pre-Condition: Step 09: Verify Success Message");
	  verifyEquals(registerPage.getSuccessMessageDisplayed(), "Your registration completed");
	  
	  log.info("Pre-Condition - Step 10: Click to HomePage img");
	  registerPage.openHomePage(driver);
	  homePage = PageGeneratorManager.getHomePage(driver);
				
	  log.info("Pre-Condition - Step 11: Verify Home page displayed");
	  verifyTrue(homePage.isHomePageSliderDisplayed());
			  
  }
	@Test
	public void Search_Test01_SearchWithEmptyData() {
		log.info("------------ TC_01_Search_With_Empty_Data ------------");
		log.info("TC_01_Search: Step 01: Click To Search Link");
		homePage.openFooterPageByName(driver, "Search");
		searchPage = PageGeneratorManager.getSearchPage(driver);
		
		log.info("TC_01_Search: Step 02: Search with empty data");
		searchPage.enterToTextboxByID(driver, "q", "");
		
		log.info("TC_01_Search: Step 03: Click to Search button");
		searchPage.clickToSearchButton(driver);
		
		log.info("TC_01_Search: Step 04: Verify Error Message at Search page");
		verifyEquals(searchPage.getSearchResultMSG(driver), "Search term minimum length is 3 characters");
	}
	@Test
	public void Search_Test02_SearchWithNotExistData() {
		log.info("------------ TC_02_Search_With_Product_Not_Exist_Data ------------");
		searchPage.refreshCurrentPage(driver);
		
		log.info("TC_02_Search: Step 01: Search with keyword: " + productNotExistKeyword);
		searchPage.enterToTextboxByID(driver, "q", productNotExistKeyword);
		
		log.info("TC_02_Search: Step 02: Click to Search button");
		searchPage.clickToSearchButton(driver);
		
		log.info("TC_02_Search: Step 03: Verify Error Message at Search page");
		verifyEquals(searchPage.getSearchResultMSG(driver), "No products were found that matched your criteria.");
	}
	@Test
	public void Search_Test03_SearchWithBrandKeyword() {
		log.info("------------ TC_03_Search_With_Brand_Keyword ------------");
		searchPage.refreshCurrentPage(driver);
		
		log.info("TC_03_Search: Step 01: Search with keyword: " + productBrandKeyword);
		searchPage.enterToTextboxByID(driver, "q", productBrandKeyword);
		
		log.info("TC_03_Search: Step 02: Click to Search button");
		searchPage.clickToSearchButton(driver);
		
		log.info("TC_03_Search: Step 03: Verify the number of products is displayed with expected value: "+ numberProductBrandResultExpected);
		verifyTrue(searchPage.verifyNumberOfSearchResult(driver, numberProductBrandResultExpected));
		
		log.info("TC_03_Search: Step 04: Verify products is displayed");
		verifyTrue(searchPage.isAllExpectedProductsDisplayed(driver, listBrandProductsExpected));
	}
	@Test
	public void Search_Test04_SearchWithSpecificNameProductKeyword() {
		log.info("------------ TC_04_Search_With_Specific_Name_Product_Keyword ------------");
		searchPage.refreshCurrentPage(driver);
		
		log.info("TC_04_Search: Step 01: Search with keyword: " + specificNameProductKeyword);
		searchPage.enterToTextboxByID(driver, "q", specificNameProductKeyword);
		
		log.info("TC_04_Search: Step 02: Click to Search button");
		searchPage.clickToSearchButton(driver);
		
		log.info("TC_04_Search: Step 03: Verify the number of products is displayed with expected value: " + numberSpecificProductResultExpected);
		verifyTrue(searchPage.verifyNumberOfSearchResult(driver, numberSpecificProductResultExpected));
		
		log.info("TC_04_Search: Step 04: Verify products is displayed with list: " + listSpectificProductsExpected);
		verifyTrue(searchPage.isAllExpectedProductsDisplayed(driver, listSpectificProductsExpected));
		
	}
	@Test
	public void Search_Test05_AdvancedSearchWithParentCategories() {
		log.info("------------ TC_05_Search_Advanced_Search_With_Parent_Categories ------------");
		log.info("TC_05_Search: Step 01: Click To Search Link");
		searchPage.openFooterPageByName(driver, "Search");
		searchPage = PageGeneratorManager.getSearchPage(driver);
		
		log.info("TC_05_Search: Step 02: Search with keyword: " + searchKeyword);
		searchPage.enterToTextboxByID(driver, "q", searchKeyword);
		
		log.info("TC_05_Search: Step 03: Click to Advanced search radio button");
		searchPage.clickToRadioButtonByLabelText(driver, "Advanced search");
		
		log.info("TC_05_Search: Step 04: Select item in Category dropdown with value: " + category);
		searchPage.selectDropdownByName(driver, "cid", category);
		
		log.info("TC_05_Search: Step 05: Uncheck to Automatically search sub categories radio button");
		searchPage.uncheckToRadioButtonByLabelText(driver, "Automatically search sub categories");
		
		log.info("TC_05_Search: Step 06: Click to Search button");
		searchPage.clickToSearchButton(driver);
		
		log.info("TC_05_Search: Step 07: Verify Error Message at Search page");
		verifyTrue(searchPage.areJQueryAndJSLoadedSuccess(driver));
		verifyEquals(searchPage.getSearchResultMSG(driver), "No products were found that matched your criteria.");
		
	}
	@Test
	public void Search_Test06_AdvancedSearchWithSubCategories() {
		log.info("------------ TC_06_Search_Advanced_Search_With_Sub_Categories ------------");
		log.info("TC_06_Search: Step 01: Click To Search Link");
		searchPage.openFooterPageByName(driver, "Search");
		searchPage = PageGeneratorManager.getSearchPage(driver);
		
		log.info("TC_06_Search: Step 02: Search with keyword: " + searchKeyword);
		searchPage.enterToTextboxByID(driver, "q", searchKeyword);
		
		log.info("TC_06_Search: Step 03: Click to Advanced search radio button");
		searchPage.clickToRadioButtonByLabelText(driver, "Advanced search");
		
		log.info("TC_06_Search: Step 04: Select item in Category dropdown with value: " + category);
		searchPage.selectDropdownByName(driver, "cid", category);
		
		log.info("TC_06_Search: Step 05: Click to to Automatically search sub categories radio button");
		searchPage.clickToRadioButtonByLabelText(driver, "Automatically search sub categories");
		
		log.info("TC_06_Search: Step 06: Click to Search button");
		searchPage.clickToSearchButton(driver);
		
		log.info("TC_06_Search: Step 07: Verify the number of products is displayed with expected value: " + numberAdvancedSearchExpected);
		verifyTrue(searchPage.verifyNumberOfSearchResult(driver, numberAdvancedSearchExpected));
		
		log.info("TC_06_Search: Step 08: Verify products is displayed");
		verifyTrue(searchPage.isAllExpectedProductsDisplayed(driver, listAdvancedSearchExpected));
	
	}
	@Test
	public void Search_Test07_AdvancedSearchWithIncorrectManufacturer() {
		log.info("------------ TC_06_Search_Advanced_Search_With_Incorrect_Manufacturer ------------");
		log.info("TC_07_Search: Step 01: Click To Search Link");
		searchPage.openFooterPageByName(driver, "Search");
		searchPage = PageGeneratorManager.getSearchPage(driver);
		
		log.info("TC_07_Search: Step 02: Search with keyword: " + searchKeyword);
		searchPage.enterToTextboxByID(driver, "q", searchKeyword);
		
		log.info("TC_07_Search: Step 03: Click to Advanced search radio button");
		searchPage.clickToRadioButtonByLabelText(driver, "Advanced search");
		
		log.info("TC_07_Search: Step 04: Select item in Category dropdown with value: " + category);
		searchPage.selectDropdownByName(driver, "cid", category);
		
		log.info("TC_07_Search: Step 05: Click to to Automatically search sub categories radio button");
		searchPage.clickToRadioButtonByLabelText(driver, "Automatically search sub categories");
		
		log.info("TC_07_Search: Step 04: Select item in Manufacturer dropdown with value: " + incorrectManufacturer);
		searchPage.selectDropdownByName(driver, "mid", incorrectManufacturer);
		
		log.info("TC_07_Search: Step 06: Click to Search button");
		searchPage.clickToSearchButton(driver);
		
		log.info("TC_07_Search: Step 07: Verify Error Message at Search page");
		verifyTrue(searchPage.areJQueryAndJSLoadedSuccess(driver));
		verifyEquals(searchPage.getSearchResultMSG(driver), "No products were found that matched your criteria.");
	
	}
	@Test
	public void Search_Test08_AdvancedSearchWithCorrectManufacturer() {
		log.info("------------ TC_08_Search_Advanced_Search_With_Correct_Manufacturer ------------");
		log.info("TC_08_Search: Step 01: Click To Search Link");
		searchPage.openFooterPageByName(driver, "Search");
		searchPage = PageGeneratorManager.getSearchPage(driver);
		
		log.info("TC_08_Search: Step 02: Search with keyword: " + searchKeyword);
		searchPage.enterToTextboxByID(driver, "q", searchKeyword);
		
		log.info("TC_08_Search: Step 03: Click to Advanced search radio button");
		searchPage.clickToRadioButtonByLabelText(driver, "Advanced search");
		
		log.info("TC_08_Search: Step 04: Select item in Category dropdown with value: " + category);
		searchPage.selectDropdownByName(driver, "cid", category);
		
		log.info("TC_08_Search: Step 05: Click to to Automatically search sub categories radio button");
		searchPage.clickToRadioButtonByLabelText(driver, "Automatically search sub categories");
		
		log.info("TC_08_Search: Step 06: Select item in Manufacturer dropdown with value: " + correctManufacturer);
		searchPage.selectDropdownByName(driver, "mid", correctManufacturer);
		
		log.info("TC_08_Search: Step 07: Click to Search button");
		searchPage.clickToSearchButton(driver);
		
		log.info("TC_08_Search: Step 08: Verify the number of products is displayed with expected value: " + numberAdvancedSearchExpected);
		verifyTrue(searchPage.verifyNumberOfSearchResult(driver, numberAdvancedSearchExpected));
		
		log.info("TC_08_Search: Step 09: Verify products is displayed");
		verifyTrue(searchPage.isAllExpectedProductsDisplayed(driver, listAdvancedSearchExpected));
		
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
	DataUtil fakeData;
}
	  
