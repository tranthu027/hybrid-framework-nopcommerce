package com.NopCommerce.User;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.NopCommerce.user.CheckoutPageObject;
import pageObject.NopCommerce.user.ComparePageObject;
import pageObject.NopCommerce.user.CompletedOrderPageObject;
import pageObject.NopCommerce.user.HomePageObject;
import pageObject.NopCommerce.user.LoginPageObject;
import pageObject.NopCommerce.user.MyAccountPageObject;
import pageObject.NopCommerce.user.OrderInformationPageObject;
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
public class Order_Product extends BaseTest {
	String preFirstName,preLastName, preEmai, password,
	       firstOrderProduct, priceProduct, secondOrderProduct, firstName, lastName, country, city, address1, zipCode, phoneNumber,
		   giftWappring, expectedPrice, orderNumber;
	
  @Parameters ({"browser", "URL"})
  @BeforeClass
  public void beforeClass(String browserName, String appUrl) {
	  log.info("Pre-Condition - Step 01: Open browser '" + browserName + "' and nagivate to '" + appUrl + "'");
	  driver = getBrowserDriver(browserName, appUrl);
	  homePage = PageGeneratorManager.getHomePage(driver);
	  fakeData = DataUtil.getData();
	  
	  fakeData = DataUtil.getData();
	  preFirstName = fakeData.getFirstName();
	  preLastName = fakeData.getEditLastName();
	  preEmai = fakeData.getEmailAdress();
	  password = "123456";
	  
	  firstOrderProduct = "Build your own computer";
	  secondOrderProduct = "Apple MacBook Pro 13-inch";
	  firstName = fakeData.getFirstName();
	  lastName = fakeData.getLastName();
	  country = "Viet Nam";
	  city ="Da Nang";
	  address1 = fakeData.getfullAddress01();
	  zipCode = fakeData.getZipCode();
	  phoneNumber = fakeData.getPhoneNumber();
	  giftWappring = "No";
	  expectedPrice = "$3,600.00";
	    
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
	public void Oder_Test01_AddProductsToCart() {
		log.info("------------ TC_01_Oder_Add_Product_To_Cart ------------");
		log.info("TC_01_Order: Step 01: Click To Product Catelogies on Top Menu: Computers/Desktops");
		homePage.clickToSublistAtTopMenuByText(driver, "Computers", "Desktops");
		productPage = PageGeneratorManager.getProductPage(driver);
		
		log.info("TC_01_Order: Step 02: Click to see information of product: " + firstOrderProduct);
		productPage.clickProductToSeeDetailByText(driver, firstOrderProduct);
		
		log.info("TC_01_Order: Step 03: Click to Processor dropdown");
		productPage.selectDropdownByName(driver, "product_attribute_1", "2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]");
		
		log.info("TC_01_Order: Step 04: Click to RAM dropdown");
		productPage.selectDropdownByName(driver, "product_attribute_2", "8GB [+$60.00]");
		
		log.info("TC_01_Order: Step 05: Click to HDD button");
		productPage.clickToRadioButtonByLabelText(driver, "400 GB [+$100.00]");
		
		log.info("TC_01_Order: Step 06: Click to OS button");
		productPage.clickToRadioButtonByLabelText(driver, "Vista Premium [+$60.00]");
		
		log.info("TC_01_Order: Step 07: Click to Software button");
		productPage.clickToRadioButtonByLabelText(driver, "Microsoft Office [+$50.00]");
		productPage.clickToRadioButtonByLabelText(driver, "Acrobat Reader [+$10.00]");
		productPage.clickToRadioButtonByLabelText(driver, "Total Commander [+$5.00]");
		
		log.info("TC_01_Order: Step 08: Get value of price");
		priceProduct = productPage.getPriceOfProduct(driver);
		
		log.info("TC_01_Order: Step 09: Click to Add to cart button");
		productPage.clickToOverviewButtonByText(driver, "Add to cart");
		
		log.info("TC_01_Order: Step 10: Verify product has been addedd");
		verifyEquals(productPage.getBarNotification(driver),"The product has been added to your shopping cart");
		
		log.info("TC_01_Order: Step 11: Close bar notification");
		productPage.closeBarNotification(driver);
		
		log.info("TC_01_Order: Step 12: Verify Shopping cart quantity is updated (1)");
		verifyTrue(productPage.areJQueryAndJSLoadedSuccess(driver));
		verifyEquals(productPage.getQuantityAtHeaderPage(driver, "Shopping cart"), "(1)");
		
		log.info("TC_01_Order: Step 13: Open active windown of Shopping cart");
		productPage.openActiveWindownAtHeaderPage(driver, "Shopping cart");
		
		log.info("TC_01_Order: Step 14: Verify 1 item in cart");
		verifyTrue(productPage.areJQueryAndJSLoadedSuccess(driver));
		verifyEquals(productPage.getQuantityInCart(driver),"1 item(s)");
		
		log.info("TC_01_Order: Step 15: Verify product name in cart");
		verifyEquals(productPage.getProductNameInCart(driver),firstOrderProduct);
		
		log.info("TC_01_Order: Step 16: Verify Product price in cart");
		verifyEquals(productPage.getProductPriceInCart(driver),priceProduct);
	}
	@Test
	public void Oder_Test02_EditProductsInShoppingCart() {
		log.info("------------ TC_02_Oder_Edit_Product_In_Shopping_Cart ------------");
		log.info("TC_02_Order: Step 01: Click To Shopping cart");
		productPage.openSecondHeaderPageByName(driver, "Shopping cart");
		shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);
		
		log.info("TC_02_Order: Step 02: Verify Shopping cart page is displayed");
		verifyTrue(shoppingCartPage.isRequestedPageDisplayed(driver, "Shopping cart"));
		
		log.info("TC_02_Order: Step 03: Click to Edit link");
		shoppingCartPage.clickToEditLink(driver);
		productPage = PageGeneratorManager.getProductPage(driver);
		
		log.info("TC_02_Order: Step 04: Click to Processor dropdown");
		productPage.selectDropdownByName(driver, "product_attribute_1", "2.2 GHz Intel Pentium Dual-Core E2200");
		
		log.info("TC_02_Order: Step 05: Click to RAM dropdown");
		productPage.selectDropdownByName(driver, "product_attribute_2", "4GB [+$20.00]");
		
		log.info("TC_02_Order: Step 06: Click to HDD button");
		productPage.clickToRadioButtonByLabelText(driver, "320 GB");
		
		log.info("TC_02_Order: Step 07: Click to OS button");
		productPage.clickToRadioButtonByLabelText(driver, "Vista Home [+$50.00]");
		
		log.info("TC_02_Order: Step 08: Click to Software button");
		productPage.clickToRadioButtonByLabelText(driver, "Microsoft Office [+$50.00]");
		productPage.uncheckToRadioButtonByLabelText(driver, "Acrobat Reader [+$10.00]");
		productPage.uncheckToRadioButtonByLabelText(driver, "Total Commander [+$5.00]");
		
		log.info("TC_02_Order: Step 09: Enter to product quantity textbox");
		productPage.enterToQuantityProductTextbox(driver, "2");
		
		log.info("TC_02_Order: Step 10: Click to Update button");
		productPage.clickToButtonByText(driver, "Update");
		
		log.info("TC_02_Order: Step 11: Verify product has been addedd");
		verifyEquals(productPage.getBarNotification(driver),"The product has been added to your shopping cart");
		
		log.info("TC_02_Order: Step 12: Close bar notification");
		productPage.closeBarNotification(driver);
		
		log.info("TC_02_Order: Step 13: Verify Product price is updated");
		verifyTrue(productPage.areJQueryAndJSLoadedSuccess(driver));
		verifyEquals(productPage.getPriceOfProduct(driver),"$1,320.00");
		
		log.info("TC_02_Order: Step 14: Verify Shopping cart quantity is updated (2)");
		verifyEquals(productPage.getQuantityAtHeaderPage(driver, "Shopping cart"), "(2)");
		
		log.info("TC_02_Order: Step 15: Open active windown of Shopping cart");
		productPage.openActiveWindownAtHeaderPage(driver, "Shopping cart");
		
		log.info("TC_02_Order: Step 16: Verify 2 item in cart");
		verifyEquals(productPage.getQuantityInCart(driver),"2 item(s)");
		
		log.info("TC_02_Order: Step 17: Verify product name in cart");
		verifyEquals(productPage.getProductNameInCart(driver),firstOrderProduct);
		
		log.info("TC_02_Order: Step 18: Verify Product price in cart");
		verifyEquals(productPage.getProductPriceInCart(driver),"$2,640.00");
		
	}
	@Test
	public void Oder_Test03_RemoveProductsFromCart() {
		log.info("------------ TC_03_Order_Remove_From_Cart ------------");
		log.info("TC_03_Order: Step 01: Click To Shopping cart");
		productPage.openSecondHeaderPageByName(driver, "Shopping cart");
		shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);	
		
		log.info("TC_03_Order: Step 02: Click to remove button of " + firstOrderProduct);
		verifyTrue(shoppingCartPage.areJQueryAndJSLoadedSuccess(driver));
		shoppingCartPage.clickToRemoveProductButton(driver, firstOrderProduct);
		
		log.info("TC_03_Order: Step 03: Verify Shopping Cart is empty");
		verifyEquals(shoppingCartPage.getEmptyMsg(driver), "Your Shopping Cart is empty!");
		
		log.info("TC_03_Order: Step 04: Verify Product List is empty");
		verifyTrue(shoppingCartPage.isProductsListEmpty(driver));
	}
	@Test
	public void Oder_Test04_CheckoutOrder() {
		log.info("------------ TC_04_Oder_Checkout_Order ------------");
		log.info("TC_04_Order: Step 01: Click To Product Catelogies on Top Menu: Computers/Notebooks");
		homePage.clickToSublistAtTopMenuByText(driver, "Computers", "Notebooks");
		productPage = PageGeneratorManager.getProductPage(driver);
		
		log.info("TC_04_Order: Step 02: Click to see information of product: " + secondOrderProduct);
		productPage.clickProductToSeeDetailByText(driver, secondOrderProduct);
		
		log.info("TC_04_Order: Step 03: Enter to product quantity textbox");
		productPage.enterToQuantityProductTextbox(driver,"2");
		
		log.info("TC_04_Order: Step 04: Click to Add to cart button");
		productPage.clickToOverviewButtonByText(driver, "Add to cart");
		
		log.info("TC_04_Order: Step 05: Verify product has been addedd");
		verifyEquals(productPage.getBarNotification(driver),"The product has been added to your shopping cart");
		
		log.info("TC_04_Order: Step 06: Close bar notification");
		productPage.closeBarNotification(driver);
		
		log.info("TC_04_Order: Step 07: Open active windown of Shopping cart");
		productPage.openActiveWindownAtHeaderPage(driver, "Shopping cart");
		
		log.info("TC_04_Order: Step 08: Verify 2 item in cart");
		verifyTrue(productPage.areJQueryAndJSLoadedSuccess(driver));
		verifyEquals(productPage.getQuantityInCart(driver),"2 item(s)");
		
		log.info("TC_04_Order: Step 09: Verify product name in cart");
		verifyEquals(productPage.getProductNameInCart(driver),secondOrderProduct);
		
		log.info("TC_04_Order: Step 10: Verify Product price in cart");
		verifyEquals(productPage.getProductPriceInCart(driver), expectedPrice);
		
		log.info("TC_04_Order: Step 11: Click To Shopping cart");
		productPage.openSecondHeaderPageByName(driver, "Shopping cart");
		shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);	
		
		log.info("TC_04_Order: Step 12: Click To Gift wrapping dropdown");
		shoppingCartPage.selectDropdownByName(driver, "checkout_attribute_1", giftWappring);
		
		log.info("TC_04_Order: Step 13: Click To Term of service checkbox");
		shoppingCartPage.clickToTermOfServiceCheckbox(driver);
		
		log.info("TC_04_Order: Step 14: Click To Checkout Button");
		shoppingCartPage.clickToButtonByText(driver, " Checkout ");
		checkoutPage = PageGeneratorManager.getCheckoutPage(driver);
		
		log.info("TC_04_Order: Step 15: Verify Checkout page is displayed");
		verifyTrue(checkoutPage.areJQueryAndJSLoadedSuccess(driver));
		verifyTrue(checkoutPage.isRequestedPageDisplayed(driver, "Checkout"));
		
		log.info("TC_04_Order: Step 16: Updated firstname with value (" + firstName + ")");
		checkoutPage.enterToTextboxByID(driver, "BillingNewAddress_FirstName", firstName);
		
		log.info("TC_04_Order: Step 17: Updated lastname with value (" + lastName + ")");
		checkoutPage.enterToTextboxByID(driver, "BillingNewAddress_LastName", lastName);
		 
		log.info("TC_04_Order: Step 18: Select item in Country dropdown with value (" + country + ")");
		checkoutPage.selectDropdownByName(driver, "BillingNewAddress.CountryId", country);
			
		log.info("TC_04_Order: Step 19: Add City with value (" + city + ")");
		checkoutPage.enterToTextboxByID(driver, "BillingNewAddress_City", city);
			
		log.info("TC_04_Order: Step 20: Add first address with value (" + address1 + ")");
		checkoutPage.enterToTextboxByID(driver, "BillingNewAddress_Address1", address1);
		
		log.info("TC_04_Order: Step 21: Add zip code with value (" + zipCode + ")");
		checkoutPage.enterToTextboxByID(driver, "BillingNewAddress_ZipPostalCode", zipCode);
		
		log.info("TC_04_Order: Step 22: Add phone number with value (" + phoneNumber + ")");
		checkoutPage.enterToTextboxByID(driver, "BillingNewAddress_PhoneNumber", phoneNumber);
		
		log.info("TC_04_Order: Step 23: Click to Continue button");
		checkoutPage.clickToButtonByText(driver,"Continue");
		
		log.info("TC_04_Order: Step 24: Click to Shipping method button");
		checkoutPage.clickToRadioButtonByLabelText(driver, "Ground ($0.00)");
		 
		log.info("TC_04_Order: Step 25: Click to Continue button");
		checkoutPage.clickToContinueButtonByID(driver,"opc-shipping_method");
		
		log.info("TC_02_Order: Step 26: Click to Payment method button");
		checkoutPage.clickToRadioButtonByLabelText(driver, "Check / Money Order");
		 
		log.info("TC_04_Order: Step 27: Click to Continue button");
		checkoutPage.clickToContinueButtonByID(driver,"opc-payment_method");
		
		log.info("TC_04_Order: Step 28: Verify Payment info is displayed");
		verifyTrue(checkoutPage.isPaymentInfoDisplayed(driver));
		
		log.info("TC_04_Order: Step 29: Click to Continue button");
		checkoutPage.clickToContinueButtonByID(driver,"opc-payment_info");
		
		log.info("TC_04_Order: Step 30: Verify Shipping info is correct");
		verifyEquals(checkoutPage.getShippingInfoByClass(driver, "name"), firstName + " " + lastName);
		verifyEquals(checkoutPage.getShippingInfoByClass(driver, "phone"), "Phone: " + phoneNumber);
		verifyEquals(checkoutPage.getShippingInfoByClass(driver, "address1"), address1);
		verifyEquals(checkoutPage.getShippingInfoByClass(driver, "city-state-zip"), city + "," + zipCode);
		verifyEquals(checkoutPage.getShippingInfoByClass(driver, "country"), country);
		verifyEquals(checkoutPage.getPriceSummary(driver), expectedPrice);
		verifyTrue(checkoutPage.requestCartOptionsDisplayed(driver, giftWappring));

		log.info("TC_04_Order: Step 31: Verify recently viewed products list");
		verifyTrue(checkoutPage.isOrderProductsListDisplayed(driver, secondOrderProduct));
		
		log.info("TC_04_Order: Step 32: Click to Confirm button");
		checkoutPage.clickToButtonByText(driver, "Confirm");
		completedOrderPage = PageGeneratorManager.getCompletedOrderPage(driver);
		
		log.info("TC_04_Order: Step 33: Verify Checkout page is displayed");
		verifyTrue(completedOrderPage.isRequestedPageDisplayed(driver, "Thank you"));
		
		log.info("TC_04_Order: Step 34: Verify Completed Order message is displayed");
		verifyEquals(completedOrderPage.getCompletedOrderMSG(driver), "Your order has been successfully processed!");
		
		log.info("TC_04_Order: Step 35: Get Order Number");
		orderNumber = completedOrderPage.getValueOfOrderNumber(driver);
		
		log.info("TC_04_Order: Step 36: Click to Continue button");
		completedOrderPage.clickToButtonByText(driver, "Continue");
		homePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("TC_04_Order: Step 36: Verify Home page Displayed");
		verifyTrue(homePage.isHomePageSliderDisplayed());
		
		log.info("TC_04_Order: Step 37: Click To My account Link");
		homePage.openFirstHeaderPageByName(driver, "My account");
		myAccountPage = PageGeneratorManager.getMyAccountPage(driver);
		
		log.info("TC_04_Order: Step 38: Click To Orders At List box menu");
		myAccountPage.openListboxByText(driver, "Orders");
		
		log.info("TC_04_Order: Step 39: Verify Completed Order Number is displayed");
		verifyTrue(myAccountPage.isCompletedOrderNumberDisplayed(driver, orderNumber));
		
		log.info("TC_04_Order: Step 40: Click to see details Order");
		myAccountPage.clickToSeeDetailsOrder(driver, orderNumber);
		orderInfoPage = PageGeneratorManager.getOrderInformationPage(driver);
		
		log.info("TC_04_Order: Step 41: Verify Order information page is displayed");
		verifyTrue(orderInfoPage.isRequestedPageDisplayed(driver, "Order information"));
		
		log.info("TC_04_Order: Step 42: Verify order information details is correct");
		verifyTrue(orderInfoPage.isCompletedOrderNumberDisplayed(driver, orderNumber));
		verifyEquals(orderInfoPage.getShippingInfoByClass(driver, "name"), firstName + " " + lastName);
		verifyEquals(orderInfoPage.getShippingInfoByClass(driver, "phone"), "Phone: " + phoneNumber);
		verifyEquals(orderInfoPage.getShippingInfoByClass(driver, "address1"), address1);
		verifyEquals(orderInfoPage.getShippingInfoByClass(driver, "city-state-zip"), city + "," + zipCode);
		verifyEquals(orderInfoPage.getShippingInfoByClass(driver, "country"), country);
		verifyTrue(orderInfoPage.isorderedProductsDisplayed(driver, secondOrderProduct));
		verifyTrue(checkoutPage.requestCartOptionsDisplayed(driver, giftWappring));
		verifyEquals(orderInfoPage.getOrderTotalPrice(driver), expectedPrice);
		
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
	CheckoutPageObject checkoutPage;
	CompletedOrderPageObject completedOrderPage;
	OrderInformationPageObject orderInfoPage;
	
	DataUtil fakeData;

}
	  
