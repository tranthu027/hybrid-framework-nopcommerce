package com.NopCommerce.User;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.NopCommerce.user.HomePageObject;
import pageObject.NopCommerce.user.LoginPageObject;
import pageObject.NopCommerce.user.MyAccountPageObject;
import pageObject.NopCommerce.user.PageGeneratorManager;
import pageObject.NopCommerce.user.ProductPageObject;
import pageObject.NopCommerce.user.RegisterPageObject;
import utilities.DataUtil;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;

public class MyAccount_Checked extends BaseTest {
	String 	gender, password, newpassword, preFirstName, editFirstName, preLastName, preEmai, 
			editLastName, editEmailAddress, date, month, year, company, country, 
			state, city, address1, address2, zipCode, phoneNumber, faxNumber, 
			reviewProduct, reviewTitle, reviewText, reviewRating;

  @Parameters ({"browser", "URL"})
  @BeforeClass
  public void beforeClass(String browserName, String appUrl) {
	  log.info("Pre-Condition - Step 01: Open browser '" + browserName + "' and nagivate to '" + appUrl + "'");
	  driver = getBrowserDriver(browserName, appUrl);
	  homePage = PageGeneratorManager.getHomePage(driver);
	  
	  fakeData = DataUtil.getData();
	  
	  gender = "Male";
	  password = "123456";
	  newpassword = fakeData.getEditPassword();
	  preFirstName = fakeData.getFirstName();
	  editFirstName = "Automation";
	  preLastName = fakeData.getEditLastName();
	  editLastName = "FC";
	  preEmai = fakeData.getEmailAdress();
	  editEmailAddress = fakeData.getEditEmailAdress();
	  date = "1";
	  month = "January";
	  year = "1999";
	  company = "Automation FC";
	  country = "Viet Nam";
	  state = "Other";
	  city = "Da Nang";
	  address1 = "123/04 Le Lai";
	  address2 = "234/5 hai Phong";
	  zipCode = "550000";
	  phoneNumber = "0123456789";
	  faxNumber = "0987654321";
	  reviewProduct = "Apple MacBook Pro 13-inch";
	  reviewTitle = "Best product ever!!";
	  reviewText = "I like this Notebook";
	  reviewRating = "4";
	  
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
	public void MyAccount_Test01_UpdateCustomerInfo() {
		log.info("------------ TC_01_Account_Update_Customer_Info ------------");
		log.info("TC_01_Account: Step 01: Click To My Account Link");
		homePage.openFirstHeaderPageByName(driver, "My account");
		myAccountPage = PageGeneratorManager.getMyAccountPage(driver);
		
		log.info("TC_01_Account: Step 02: Update gender with value: " + gender);
		verifyTrue(myAccountPage.areJQueryAndJSLoadedSuccess(driver));
		myAccountPage.clickToRadioButtonByLabelText(driver, gender);
		
		log.info("TC_01_Account: Step 03: Update First Name with value: " + editFirstName);
		myAccountPage.enterToTextboxByID(driver, "FirstName", editFirstName);
			
		log.info("TC_01_Account: Step 04: Update Last Name with value (" + editLastName + ")");
		myAccountPage.enterToTextboxByID(driver, "LastName", editLastName);
		  
		log.info("TC_01_Account: Step 05: Update Date of birthday with value (" + date + ")");
		myAccountPage.selectDropdownByName(driver, "DateOfBirthDay", date);
		  
		log.info("TC_01_Account: Step 06: Update Month of birthmonth with value (" + month + ")");
		myAccountPage.selectDropdownByName(driver, "DateOfBirthMonth", month);
			
		log.info("TC_01_Account: Step 07: Update Year of birthyear with value (" + year + ")");
		myAccountPage.selectDropdownByName(driver, "DateOfBirthYear", year);

		log.info("TC_01_Account: Step 08: Update new email address with value (" + editEmailAddress + ")");
		myAccountPage.enterToTextboxByID(driver, "Email", editEmailAddress);
		  
		log.info("TC_01_Account: Step 09: Click to Save button");
		myAccountPage.clickToButtonByText(driver,"Save");
		
		log.info("TC_01_Account: Step 10: Verify Gender was updated with value: " + gender);
		verifyTrue(myAccountPage.isRadioButtonByLabelTextSelected(driver, gender));

		log.info("TC_01_Account: Step 11: Verify Firstname was updated with value: " + editFirstName);
		verifyEquals(myAccountPage.getValueOfTextboxByID(driver, "FirstName", "value"), editFirstName);
		
		log.info("TC_01_Account: Step 12: Verify LastName was updated with value: " + editLastName);
		verifyEquals(myAccountPage.getValueOfTextboxByID(driver, "LastName", "value"), editLastName);

		log.info("TC_01_Account: Step 13: Verify Date of birthday was updated with value: " + date);
		verifyEquals(myAccountPage.getValueSelectedOfDropboxByName(driver, "DateOfBirthDay"), date);

		log.info("TC_01_Account: Step 14: Verify Month of birthday was updated with value:" + month);
		verifyEquals(myAccountPage.getValueSelectedOfDropboxByName(driver, "DateOfBirthMonth"), month);

		log.info("TC_01_Account: Step 15: Verify Year of birthday was updated with value:" + year);
		verifyEquals(myAccountPage.getValueSelectedOfDropboxByName(driver, "DateOfBirthYear"), year);

		log.info("TC_01_Account: Step 16: Verify email was updated with value:" + editEmailAddress);
		verifyEquals(myAccountPage.getValueOfTextboxByID(driver, "Email", "value"), editEmailAddress);
		
	}
	
	@Test
	public void MyAccount_Test02_UpdateAddressInfo() {
		log.info("------------ TC_02_Account_Update_Address_Info ------------");
		log.info("TC_02_Account: Step 01: Click To Addresses At List box menu");
		myAccountPage.openListboxByText(driver, "Addresses");
		
		log.info("TC_02_Account: Step 02: Click to Add New button");
		myAccountPage.clickToButtonByText(driver,"Add new");
		
		log.info("TC_02_Account: Step 03: Add First Name with value: " + editFirstName);
		myAccountPage.enterToTextboxByID(driver, "Address_FirstName", editFirstName);
			
		log.info("TC_02_Account: Step 04: Add Last Name with value (" + editLastName + ")");
		myAccountPage.enterToTextboxByID(driver, "Address_LastName", editLastName);

		log.info("TC_02_Account: Step 05: Add email address with value (" + editEmailAddress + ")");
		myAccountPage.enterToTextboxByID(driver, "Address_Email", editEmailAddress);
		
		log.info("TC_02_Account: Step 06: Add Company name with value (" + company + ")");
		myAccountPage.enterToTextboxByID(driver, "Address_Company", company);
		
		log.info("TC_02_Account: Step 07: Select item in Country dropdown with value (" + country + ")");
		myAccountPage.selectDropdownByName(driver, "Address.CountryId", country);
		
		log.info("TC_02_Account: Step 08: Select item in State/province address dropdown with value (" + state + ")");
		myAccountPage.selectDropdownByName(driver, "Address.StateProvinceId", state);
		
		log.info("TC_02_Account: Step 09: Add City with value (" + city + ")");
		myAccountPage.enterToTextboxByID(driver, "Address_City", city);
		
		log.info("TC_02_Account: Step 10: Add first address with value (" + address1 + ")");
		myAccountPage.enterToTextboxByID(driver, "Address_Address1", address1);
		
		log.info("TC_02_Account: Step 11: Add second address with value (" + address2 + ")");
		myAccountPage.enterToTextboxByID(driver, "Address_Address2", address2);
		
		log.info("TC_02_Account: Step 12: Add zip code with value (" + zipCode + ")");
		myAccountPage.enterToTextboxByID(driver, "Address_ZipPostalCode", zipCode);
		
		log.info("TC_02_Account: Step 13: Add phone number with value (" + phoneNumber + ")");
		myAccountPage.enterToTextboxByID(driver, "Address_PhoneNumber", phoneNumber);
		
		log.info("TC_02_Account: Step 14: Add fax number with value (" + faxNumber + ")");
		myAccountPage.enterToTextboxByID(driver, "Address_FaxNumber", faxNumber);
		
		log.info("TC_02_Account: Step 15: Click to Save button");
		myAccountPage.clickToButtonByText(driver,"Save");
		
		log.info("TC_02_Account: Step 16: Verify all information was updated");
		verifyEquals(myAccountPage.getUpdatedAddressOfInforByClass(driver, "name"), editFirstName + " " + editLastName);
		verifyEquals(myAccountPage.getUpdatedAddressOfInforByClass(driver, "email"), "Email: " + editEmailAddress);	
		verifyEquals(myAccountPage.getUpdatedAddressOfInforByClass(driver, "phone"), "Phone number: " + phoneNumber);
		verifyEquals(myAccountPage.getUpdatedAddressOfInforByClass(driver, "fax"), "Fax number: " + faxNumber);
		verifyEquals(myAccountPage.getUpdatedAddressOfInforByClass(driver, "company"), company);
		verifyEquals(myAccountPage.getUpdatedAddressOfInforByClass(driver, "address1"), address1);
		verifyEquals(myAccountPage.getUpdatedAddressOfInforByClass(driver, "address2"), address2);
		verifyEquals(myAccountPage.getUpdatedAddressOfInforByClass(driver, "city-state-zip"), city + ", " + zipCode);
		verifyEquals(myAccountPage.getUpdatedAddressOfInforByClass(driver, "country"), country);
	
	}
	
	@Test
	public void MyAccount_Test03_ChangePasswordInfo() {
		log.info("------------ TC_03_Account_Change_Password_Info ------------");
		log.info("TC_03_Account: Step 01: Click To Change password At List box menu");
		myAccountPage.openListboxByText(driver, "Change password");
		
		log.info("TC_03_Account: Step 02: Enter old Password with value: " + password);
		myAccountPage.enterToTextboxByID(driver, "OldPassword", password);
		
		log.info("TC_03_Account: Step 03: Enter new Password with value: " + newpassword);
		myAccountPage.enterToTextboxByID(driver, "NewPassword", newpassword);
		
		log.info("TC_03_Account: Step 04: Enter confirm Password with value: " + newpassword);
		myAccountPage.enterToTextboxByID(driver, "ConfirmNewPassword", newpassword);
		
		log.info("TC_03_Account: Step 05: Click to Change password button");
		myAccountPage.clickToButtonByText(driver,"Change password");
		
		log.info("TC_03_Account: Step 06: Verify Change password is success");
		verifyEquals(myAccountPage.getBarNotification(driver),"Password was changed");
		
		log.info("TC_03_Account: Step 07: Close bar notification");
		myAccountPage.closeBarNotification(driver);
		
		log.info("TC_03_Account: Step 08: Click To Log out Link");
		myAccountPage.openFirstHeaderPageByName(driver, "Log out");
		homePage = PageGeneratorManager.getHomePage(driver);
		
		log.info("TC_03_Account: Step 09: Click To Log in Link");
		myAccountPage.openFirstHeaderPageByName(driver, "Log in");
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		log.info("TC_03_Account: Step 10: Enter Email with value (" + editEmailAddress + ")");
		loginPage.enterToTextboxByID(driver, "Email", editEmailAddress);
			
		log.info("TC_03_Account: Step 11: Enter old Password with value (" + password + ")");
		loginPage.enterToTextboxByID(driver,"Password", password);
		  
		log.info("TC_03_Account: Step 12: Click to Login button");
		loginPage.clickToButtonByText(driver,"Log in");
		
		log.info("TC_03_Account: Step 13: Verify Error Message");
		verifyEquals(loginPage.getAllErrorMessageDisplayed(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
		  
		log.info("TC_03_Account: Step 14: Click To Log in Link again");
		loginPage.openFirstHeaderPageByName(driver, "Log in");
		
		log.info("TC_03_Account: Step 15: Enter Email with value (" + editEmailAddress + ")");
		loginPage.enterToTextboxByID(driver, "Email", editEmailAddress);
		
		log.info("TC_03_Account: Step 16: Enter new Password with value (" + newpassword + ")");
		loginPage.enterToTextboxByID(driver,"Password", newpassword);
		  
		log.info("TC_03_Account: Step 17: Click to Login button");
		loginPage.clickToButtonByText(driver,"Log in");
		
		log.info("TC_03_Account - Step 18: Verify Home page Displayed");
		homePage = PageGeneratorManager.getHomePage(driver);
		verifyTrue(homePage.isHomePageSliderDisplayed());
	}
	
	@Test
	public void MyAccount_Test04_MyProductReview() {
		log.info("------------ TC_04_My_Product_Review ------------");
		log.info("TC_04_Account: Step 01: Click To Product Catelogies on Top Menu: Computers/Notebooks");
		homePage.clickToSublistAtTopMenuByText(driver, "Computers", "Notebooks");
		productPage = PageGeneratorManager.getProductPage(driver);
		
		log.info("TC_04_Order: Step 02: Click to see information of product: " + reviewProduct);
		productPage.clickProductToSeeDetailByText(driver, reviewProduct);
		
		log.info("TC_04_Order: Step 03: Click to see information of product: " + reviewProduct);
		productPage.clickToAddYourReviewLink();
		
		log.info("TC_04_Order: Step 04: Verify Product review page is displayed");
		verifyEquals(productPage.getProductReviewPage(), "Product reviews for " + reviewProduct);
		
		log.info("TC_04_Order: Step 05: Adding product review title");
		productPage.enterToTextboxByID(driver, "AddProductReview_Title", reviewTitle);
		
		log.info("TC_04_Order: Step 06: Adding product review text");
		productPage.enterToReviewText(driver,reviewText);
		
		log.info("TC_04_Order: Step 07: Adding product rating with value " + reviewRating);
		productPage.AddProductRatingByValue(driver, reviewRating);
		
		log.info("TC_04_Order: Step 08: Click to Submit review button");
		productPage.clickToButtonByText(driver, "Submit review");
		
		log.info("TC_04_Order: Step 09: Verify Product review is successfully added");
		verifyTrue(productPage.isSuccessMSGDisplayed());
		
		log.info("TC_04_Order: Step 10: Click To My Account Link");
		productPage.openFirstHeaderPageByName(driver, "My account");
		myAccountPage = PageGeneratorManager.getMyAccountPage(driver);
		
		log.info("TC_04_Order: Step 11: Click To My product reviews box menu");
		myAccountPage.openListboxByText(driver, "My product reviews");
		
		log.info("TC_04_Order: Step 12: Verify Product review is successfully added");
		verifyTrue(myAccountPage.isProductReviewDisplayed(driver, reviewProduct));
		
		
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
	ProductPageObject productPage;
	DataUtil fakeData;
}
	  
