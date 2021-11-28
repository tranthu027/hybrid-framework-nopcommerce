package com.NopCommerce.User;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.NopCommerce.user.ComparePageObject;
import pageObject.NopCommerce.user.HomePageObject;
import pageObject.NopCommerce.user.LoginPageObject;
import pageObject.NopCommerce.user.MyAccountPageObject;
import pageObject.NopCommerce.user.PageGeneratorManager;
import pageObject.NopCommerce.user.ProductPageObject;
import pageObject.NopCommerce.user.RecentlyViewedPageObject;
import pageObject.NopCommerce.user.RegisterPageObject;
import pageObject.NopCommerce.user.SearchPageObject;
import pageObject.NopCommerce.user.ShoppingCartPageObject;
import pageObject.NopCommerce.user.WishlistPageObject;
import utilities.DataUtil;

import org.testng.annotations.BeforeClass;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;

@Test
public class ProductsList_Wishlist_Compare_Recently_Viewed_Product extends BaseTest {
	String preFirstName, preLastName, preEmail, password, 
	       phoneProduct, desktopProduct01, desktopProduct02, viewedProductName05, viewedProductName04, viewedProductName03;

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
	  
	  phoneProduct = "HTC One M8 Android L 5.0 Lollipop";
	  desktopProduct01 = "Lenovo IdeaCentre 600 All-in-One PC";
	  desktopProduct02 = "Digital Storm VANQUISH 3 Custom Performance PC";
	  password = fakeData.getPassword();
	  
	  log.info("Pre-Condition: Step 02: Click To Register Link");
	  homePage.openFirstHeaderPageByName(driver, "Register");
	  registerPage = PageGeneratorManager.getRegisterPage(driver);
	
	  log.info("Pre-Condition: Step 03: Enter First Name with value (" + preFirstName + ")");
	  registerPage.enterToTextboxByID(driver, "FirstName", preFirstName);
		
	  log.info("Pre-Condition: Step 04: Enter Last Name with value (" + preLastName + ")");
	  registerPage.enterToTextboxByID(driver,"LastName", preLastName);
	  
	  log.info("Pre-Condition: Step 05: Enter Email Address with value (" + preEmail + ")");
	  registerPage.enterToTextboxByID(driver,"Email", preEmail);
	  
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
  public void ProductsList_Test01_AddToWishlist() {
	  log.info("------------ WISHLIST COMPARE RECENTLY VIEWED PRODUCTS ------------");
		log.info("------------ TC_01_Product_Add_To_Wishlist ------------");
		log.info("TC_01_Product: Step 01: Click To Product Catelogies on Top Menu: Electronics/Cell phones");
		homePage.clickToSublistAtTopMenuByText(driver, "Electronics", "Cell phones");
		productPage = PageGeneratorManager.getProductPage(driver);
		
		log.info("TC_01_Product: Step 02: Click to see information of product: " + phoneProduct);
		productPage.clickProductToSeeDetailByText(driver, phoneProduct);
		 
		log.info("TC_01_Product: Step 03: Click to Add To Wishlist button");
		productPage.clickToOverviewButtonByText(driver, "Add to wishlist");
		
		log.info("TC_01_Product: Step 04: Verify Product has been addedd");
		verifyEquals(productPage.getBarNotification(driver),"The product has been added to your wishlist");
		
		log.info("TC_01_Product: Step 05: Close bar notification");
		productPage.closeBarNotification(driver);
		
		log.info("TC_01_Product: Step 06: Click To Wishlist Link");
		verifyTrue(productPage.areJQueryAndJSLoadedSuccess(driver));
		productPage.openSecondHeaderPageByName(driver, "Wishlist");
		wishlistPage = PageGeneratorManager.getWishlistPage(driver);
		
		log.info("TC_01_Product: Step 07: Verify Wishlist page is displayed");
		verifyTrue(wishlistPage.areJQueryAndJSLoadedSuccess(driver));
		verifyTrue(wishlistPage.isRequestedPageDisplayed(driver, "Wishlist"));
		
		log.info("TC_01_Product: Step 08: Verify Added Product is displayed with value: " + phoneProduct);
		verifyEquals(wishlistPage.getProductInWishlist(driver), phoneProduct);
		
		log.info("TC_01_Product: Step 09: Click to Wishlist share link");
		wishlistPage.clickToWishlistShareLink(driver);
		
		log.info("TC_01_Product: Step 10: Verify Wishlist share page is displayed");
		verifyTrue(wishlistPage.areJQueryAndJSLoadedSuccess(driver));
		verifyTrue(wishlistPage.isRequestedPageDisplayed(driver, "Wishlist of "));
	}
  @Test
  public void ProductsList_Test02_AddProductsToCartFromWishlist() {
		log.info("------------ TC_02_Product_Add_Product_To_Cart_From_Wishlist ------------");
		log.info("TC_02_Product: Step 01: Click to HomePage img");
		wishlistPage.openHomePage(driver);
		homePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("TC_02_Product: Step 02: Click To Wishlist Link");
		homePage.openSecondHeaderPageByName(driver, "Wishlist");
		wishlistPage = PageGeneratorManager.getWishlistPage(driver);
		
		log.info("TC_02_Product: Step 03: Click to Add to cart checkbox");
		verifyTrue(wishlistPage.areJQueryAndJSLoadedSuccess(driver));
		wishlistPage.checkToAddToCartCheckbox(driver);
		
		log.info("TC_02_Product: Step 04: Click to Add to cart button");
		wishlistPage.clickToButtonByText(driver,"Add to cart");
		shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);
		
		log.info("TC_02_Product: Step 05: Verify Wishlist page is displayed");
		verifyTrue(shoppingCartPage.isRequestedPageDisplayed(driver, "Shopping cart"));
		
		log.info("TC_02_Product: Step 06: Verify Wishlist quantity is updated (0)");
		verifyEquals(shoppingCartPage.getQuantityAtHeaderPage(driver, "Wishlist"), "(0)");
		
		log.info("TC_02_Product: Step 07: Verify Shopping cart quantity is updated (1)");
		verifyTrue(shoppingCartPage.areJQueryAndJSLoadedSuccess(driver));
		verifyEquals(shoppingCartPage.getQuantityAtHeaderPage(driver, "Shopping cart"), "(1)");
		
		log.info("TC_02_Product: Step 08: Click to remove button of " + phoneProduct);
		shoppingCartPage.clickToRemoveProductButton(driver, phoneProduct);
		
		log.info("TC_02_Product: Step 09: Verify Shopping Cart is empty");
		verifyEquals(shoppingCartPage.getEmptyMsg(driver), "Your Shopping Cart is empty!");
		
		log.info("TC_02_Product: Step 10: Verify Product List is empty");
		verifyTrue(shoppingCartPage.isProductsListEmpty(driver));
		
	}
  @Test
  public void ProductsList_Test03_RemoveProductsInWishlist() {
		log.info("------------ TC_03_Product_Remove_Product_In_Wishlist ------------");
		log.info("TC_03_Product: Step 01: Click To Product Catelogies on Top Menu: Computers/Desktops");
		homePage.clickToSublistAtTopMenuByText(driver, "Computers", "Desktops");
		productPage = PageGeneratorManager.getProductPage(driver);
		
		log.info("TC_03_Product: Step 02: Click to see information of product: " + desktopProduct01);
		productPage.clickProductToSeeDetailByText(driver, desktopProduct01);
		 
		log.info("TC_03_Product: Step 03: Click to Add To Wishlist button");
		productPage.clickToOverviewButtonByText(driver, "Add to wishlist");
		
		log.info("TC_03_Product: Step 04: Verify Product has been addedd");
		verifyEquals(productPage.getBarNotification(driver),"The product has been added to your wishlist");
		
		log.info("TC_03_Product: Step 05: Close bar notification");
		productPage.closeBarNotification(driver);
		
		log.info("TC_03_Product: Step 06: Click To Wishlist Link");
		productPage.openSecondHeaderPageByName(driver, "Wishlist");
		wishlistPage = PageGeneratorManager.getWishlistPage(driver);
		
		log.info("TC_03_Product: Step 07: Verify Wishlist page is displayed");
		verifyTrue(wishlistPage.isRequestedPageDisplayed(driver, "Wishlist"));
		
		log.info("TC_03_Product: Step 08: Verify Added Product is displayed");
		verifyTrue(wishlistPage.areJQueryAndJSLoadedSuccess(driver));
		verifyEquals(wishlistPage.getProductInWishlist(driver), desktopProduct01);
		
		log.info("TC_03_Product: Step 09: Click to remove button of " + desktopProduct01);
		wishlistPage.clickToRemoveProductButton(driver, desktopProduct01);
		
		log.info("TC_03_Product: Step 10: Verify Wishlist is empty");
		verifyTrue(wishlistPage.areJQueryAndJSLoadedSuccess(driver));
		verifyEquals(wishlistPage.getEmptyMsg(driver), "The wishlist is empty!");
		
		log.info("TC_03_Product: Step 11: Verify Product List is empty");
		verifyTrue(wishlistPage.areJQueryAndJSLoadedSuccess(driver));
		verifyTrue(wishlistPage.isProductsListEmpty(driver));
		
	}
	@Test
	public void ProductsList_Test04_AddProductsToCompareList() {
		log.info("------------ TC_04_Product_Add_Product_To_Compare ------------");
		log.info("TC_04_Product: Step 01: Click To Product Catelogies on Top Menu: Computers/Desktops");
		wishlistPage.clickToSublistAtTopMenuByText(driver, "Computers", "Desktops");
		productPage = PageGeneratorManager.getProductPage(driver);
		
		log.info("TC_04_Product: Step 02: Click to Add To Compare button with product: " + desktopProduct01);
		verifyTrue(productPage.areJQueryAndJSLoadedSuccess(driver));
		productPage.clickToActionButtonByText(driver,desktopProduct01, "Add to compare list");
		
		log.info("TC_04_Product: Step 03: Verify Product has been addedd");
		verifyEquals(productPage.getBarNotification(driver),"The product has been added to your product comparison");
		
		log.info("TC_04_Product: Step 04: Close bar notification");
		productPage.closeBarNotification(driver);
		
		log.info("TC_04_Product: Step 05: Click to Add To Compare button with product: " + desktopProduct02);
		productPage.clickToActionButtonByText(driver,desktopProduct02, "Add to compare list");
		
		log.info("TC_04_Product: Step 06: Verify Product has been addedd");
		verifyEquals(productPage.getBarNotification(driver),"The product has been added to your product comparison");
		
		log.info("TC_04_Product: Step 07: Close bar notification");
		productPage.closeBarNotification(driver);
		
		log.info("TC_04_Product: Step 08: Open Compare products list");
		productPage.openFooterPageByName(driver, "Compare products list");
		comparePage = PageGeneratorManager.getComparePage(driver);
		
		log.info("TC_04_Product: Step 09: Verify Added compare Product has been displayed");
		verifyTrue(comparePage.isExpectedCompareProductsListDisplayed(driver, desktopProduct01, desktopProduct02));

		log.info("TC_04_Product: Step 10: Click To Clear List Button");
		comparePage.clickToClearListButton();
		
		log.info("TC_04_Product: Step 11: Verify Compare List is Empty");
		verifyEquals(comparePage.getEmptyMsg(driver), "You have no items to compare.");
		
		log.info("TC_04_Product: Step 12: Verify Added Compare Product is empty");
		verifyTrue(comparePage.isCompareProductsListEmpty(driver));
	
	}
	@Test
	public void ProductsList_Test05_RecentlyViewedProducts() {
		log.info("------------ TC_05_Product_Recently_Viewed_Product ------------");
		log.info("TC_05_Product: Step 01: Click To Product Catelogies on Top Menu: Computers/Notebooks");
		comparePage.clickToSublistAtTopMenuByText(driver, "Computers", "Notebooks");
		productPage = PageGeneratorManager.getProductPage(driver);
		
		log.info("TC_05_Product: Step 02: Click to see information of first product");
		productPage.clickToProductToSeeDetailByOrder(driver, "1");
		
		log.info("TC_05_Product: Step 03: Click to child submenu Notebooks");
		productPage.clickToChildSubmenulByText(driver, "Notebooks");
		
		log.info("TC_05_Product: Step 04: Click to see information of second product");
		productPage.clickToProductToSeeDetailByOrder(driver, "2");
		
		log.info("TC_05_Product: Step 05: Click to child submenu Notebooks");
		productPage.clickToChildSubmenulByText(driver, "Notebooks");
		
		log.info("TC_05_Product: Step 06: Click to see information of 3th product");
		productPage.clickToProductToSeeDetailByOrder(driver, "3");
		viewedProductName03 = productPage.getValueOfViewedProduct(driver);
		
		log.info("TC_05_Product: Step 07: Click to child submenu Notebooks");
		productPage.clickToChildSubmenulByText(driver, "Notebooks");
		
		log.info("TC_05_Product: Step 08: Click to see information of 4th product");
		productPage.clickToProductToSeeDetailByOrder(driver, "4");
		viewedProductName04 = productPage.getValueOfViewedProduct(driver);
		
		log.info("TC_05_Product: Step 09: Click to child submenu Notebooks");
		productPage.clickToChildSubmenulByText(driver, "Notebooks");
		
		log.info("TC_05_Product: Step 10: Click to see information of 5th product");
		productPage.clickToProductToSeeDetailByOrder(driver, "5");
		viewedProductName05 = productPage.getValueOfViewedProduct(driver);
		
		log.info("TC_05_Product: Step 11: Open Recently viewed products List");
		productPage.openFooterPageByName(driver, "Recently viewed products");
		recentlyViewedPage = PageGeneratorManager.getRecentlyViewedPage(driver);
		
		log.info("TC_05_Product: Step 12: Verify recently viewed products page displayed");
		verifyTrue(recentlyViewedPage.isRequestedPageDisplayed(driver, "Recently viewed products"));
		
		log.info("TC_05_Product: Step 13: Verify recently viewed products list");
		verifyTrue(recentlyViewedPage.isRecentlyViewedProductsDisplayed(driver, viewedProductName03, viewedProductName04, viewedProductName05));
		
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
	ComparePageObject comparePage;
	RecentlyViewedPageObject recentlyViewedPage;
	DataUtil fakeData;

}
	  
