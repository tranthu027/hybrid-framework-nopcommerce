package com.NopCommerce.User;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.NopCommerce.user.HomePageObject;
import pageObject.NopCommerce.user.LoginPageObject;
import pageObject.NopCommerce.user.PageGeneratorManager;
import pageObject.NopCommerce.user.RegisterPageObject;
import utilities.DataUtil;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;

public class Registered_Login_In_The_System extends BaseTest {
	String preFirstName, preLastName, preEmail, gender, firstName, lastName, emailAddress, password, date, month, year, invalidEmail, incorrectPassword, unregisteredEmail;

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
	  gender = "Female";
	  firstName = fakeData.getFirstName();
	  lastName = fakeData.getLastName();
	  emailAddress = fakeData.getEmailAdress();
	  invalidEmail = "testing123.com";

	  unregisteredEmail = "autotest@gmail.com";
	  password = fakeData.getPassword();
	  incorrectPassword = "incorrectPW";
	  date = "22";
	  month = "March";
	  year = "1988";
	  
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
	  
	  log.info("Pre-Condition: Step 10: Click To Log out Link");
	  registerPage.openFirstHeaderPageByName(driver, "Log out");
	  homePage = PageGeneratorManager.getHomePage(driver);

  }
	  
  @Test
  public void Register_Test01_RegisterWithEmptyData() {
	  log.info("------------ TC_01_Register_With_Empty_Data ------------");
	  log.info("TC_01_Register: Step 01: Click To Register Link");
	  homePage.openFirstHeaderPageByName(driver, "Register");
	  registerPage = PageGeneratorManager.getRegisterPage(driver);
	  
	  log.info("TC_01_Register: Step 02: Verify Register page is displayed");
	  verifyTrue(registerPage.isRequestedPageDisplayed(driver, "Register"));
	  
	  log.info("TC_01_Register: Step 03: Click to Register button");
	  registerPage.clickToButtonByText(driver,"Register");
	  
	  log.info("TC_01_Register: Step 04: Verify Error Message at First Name textbox");
	  verifyEquals(registerPage.getValidationErrorMSGDisplayed(driver, "FirstName"), "First name is required.");
	  
	  log.info("TC_01_Register: Step 05: Verify Error Message at Last Name textbox");
	  verifyEquals(registerPage.getValidationErrorMSGDisplayed(driver, "LastName"), "Last name is required.");
	  
	  log.info("TC_01_Register: Step 06: Verify Error Message at Email textbox");
	  verifyEquals(registerPage.getValidationErrorMSGDisplayed(driver, "Email"), "Email is required.");
	  
	  log.info("TC_01_Register: Step 07: Verify Error Message at Password textbox");
	  verifyEquals(registerPage.getValidationErrorMSGDisplayed(driver, "Password"), "Password is required.");
	  
	  log.info("TC_01_Register: Step 08: Verify Error Message at Confirm Password textbox");
	  verifyEquals(registerPage.getValidationErrorMSGDisplayed(driver, "ConfirmPassword"), "Password is required.");
  }
  @Test
  public void Register_Test02_RegisterWithInvalidEmail() {
	  log.info("------------ TC_02_Register_With_Invalid_Email ------------");
	  homePage = PageGeneratorManager.getHomePage(driver);
	  log.info("TC_02_Register: Step 01: Click To Register Link");
	  homePage.openFirstHeaderPageByName(driver, "Register");
	  
	  log.info("TC_02_Register: Step 01: Click To Female radio button");
	  registerPage.clickToRadioButtonByLabelText(driver, gender);
	  
	  log.info("TC_02_Register: Step 02: Enter First Name with value (" + firstName + ")");
	  registerPage.enterToTextboxByID(driver, "FirstName", firstName);
		
	  log.info("TC_02_Register: Step 03: Enter Last Name with value (" + lastName + ")");
	  registerPage.enterToTextboxByID(driver,"LastName", lastName);
	  
	  log.info("TC_02_Register: Step 04: Select item in Date dropdown with value (" + date + ")");
	  registerPage.selectDropdownByName(driver, "DateOfBirthDay", date);
	  
	  log.info("TC_02_Register: Step 05: Select item in Month dropdown with value (" + month + ")");
	  registerPage.selectDropdownByName(driver, "DateOfBirthMonth", month);
		
	  log.info("TC_02_Register: Step 06: Select item in Year dropdown with value (" + year + ")");
	  registerPage.selectDropdownByName(driver, "DateOfBirthYear", year);
	  
	  log.info("TC_02_Register: Step 07: Enter invalid Email Address (" + invalidEmail + ")");
	  registerPage.enterToTextboxByID(driver,"Email", invalidEmail);
	  
	  log.info("TC_02_Register: Step 08: Enter Password with value " + password );
	  registerPage.enterToTextboxByID(driver,"Password", password);
				
	  log.info("TC_02_Register: Step 09: Enter Confirm Password");
	  registerPage.enterToTextboxByID(driver,"ConfirmPassword", password);
	
	  log.info("TC_02_Register: Step 10: Click to Register button");
	  registerPage.clickToButtonByText(driver,"Register");
	  
	  log.info("TC_02_Register: Step 11: Verify Error Message at Email textbox");
	  verifyEquals(registerPage.getValidationErrorMSGDisplayed(driver, "Email"), "Wrong email");
  }
  @Test
  public void Register_Test03_RegisterWithValidEmail() {
	  log.info("------------ TC_03_Register_With_Valid_Email ------------");
	  homePage = PageGeneratorManager.getHomePage(driver);
	  
	  log.info("TC_03_Register: Step 01: Click To Register Link");
	  homePage.openFirstHeaderPageByName(driver, "Register");
	  registerPage = PageGeneratorManager.getRegisterPage(driver);
	  
	  log.info("TC_03_Register: Step 02: Click To Female radio button");
	  registerPage.clickToRadioButtonByLabelText(driver, gender);
	  
	  log.info("TC_03_Register: Step 03: Enter First Name with value (" + firstName + ")");
	  registerPage.enterToTextboxByID(driver, "FirstName", firstName);
		
	  log.info("TC_03_Register: Step 04: Enter Last Name with value (" + lastName + ")");
	  registerPage.enterToTextboxByID(driver,"LastName", lastName);
	  
	  log.info("TC_03_Register: Step 05: Select item in Date dropdown with value (" + date + ")");
	  registerPage.selectDropdownByName(driver, "DateOfBirthDay", date);
	  
	  log.info("TC_03_Register: Step 06: Select item in Month dropdown with value (" + month + ")");
	  registerPage.selectDropdownByName(driver, "DateOfBirthMonth", month);
		
	  log.info("TC_03_Register: Step 07: Select item in Year dropdown with value (" + year + ")");
	  registerPage.selectDropdownByName(driver, "DateOfBirthYear", year);
	  
	  log.info("TC_03_Register: Step 08: Enter Email Address with value (" + emailAddress + ")");
	  registerPage.enterToTextboxByID(driver,"Email", emailAddress);
	  
	  log.info("TC_03_Register: Step 09: Enter Password with value (" + password + ")");
	  registerPage.enterToTextboxByID(driver,"Password", password);
				
	  log.info("TC_03_Register: Step 10: Enter Confirm Password with value (" + password + ")");
	  registerPage.enterToTextboxByID(driver,"ConfirmPassword", password);
	
	  log.info("TC_03_Register: Step 11: Click to Register button");
	  registerPage.clickToButtonByText(driver,"Register");
	  
	  log.info("TC_03_Register: Step 12: Verify Success Message");
	  verifyEquals(registerPage.getSuccessMessageDisplayed(), "Your registration completed");
	  
	  log.info("TC_03_Register: Step 13: Click To Log out Link");
	  registerPage.openFirstHeaderPageByName(driver, "Log out");
  }
  @Test
  public void Register_Test04_RegisterWithRegisteredEmail() {
	  log.info("------------ TC_04_Register_With_Used_Email ------------");
	  homePage = PageGeneratorManager.getHomePage(driver);
	  
	  log.info("TC_04_Register: Step 01: Click To Register Link");
	  homePage.openFirstHeaderPageByName(driver, "Register");
	  
	  log.info("TC_04_Register: Step 01: Click To Female radio button");
	  registerPage.clickToRadioButtonByLabelText(driver, gender);
	  
	  log.info("TC_04_Register: Step 02: Enter First Name with value (" + firstName + ")");
	  registerPage.enterToTextboxByID(driver, "FirstName", firstName);
		
	  log.info("TC_04_Register: Step 03: Enter Last Name with value (" + lastName + ")");
	  registerPage.enterToTextboxByID(driver,"LastName", lastName);
	  
	  log.info("TC_04_Register: Step 04: Select item in Date dropdown with value (" + date + ")");
	  registerPage.selectDropdownByName(driver, "DateOfBirthDay", date);
	  
	  log.info("TC_04_Register: Step 05: Select item in Month dropdown with value (" + month + ")");
	  registerPage.selectDropdownByName(driver, "DateOfBirthMonth", month);
		
	  log.info("TC_04_Register: Step 06: Select item in Year dropdown with value (" + year + ")");
	  registerPage.selectDropdownByName(driver, "DateOfBirthYear", year);
	  
	  log.info("TC_04_Register: Step 07: Enter Used Email Address with value (" + preEmail + ")");
	  registerPage.enterToTextboxByID(driver,"Email", preEmail);
	  
	  log.info("TC_04_Register: Step 08: Enter Password with value (" + password + ")");
	  registerPage.enterToTextboxByID(driver,"Password", password);
				
	  log.info("TC_04_Register: Step 09: Enter Confirm Password");
	  registerPage.enterToTextboxByID(driver,"ConfirmPassword", password);
	
	  log.info("TC_04_Register: Step 10: Click to Register button");
	  registerPage.clickToButtonByText(driver,"Register");
	  
	  log.info("TC_04_Register: Step 11: Verify Error Message");
	  verifyEquals(registerPage.getErrorMessageDisplayed(), "The specified email already exists");
  }
  @Test
  public void Register_Test05_RegisterWithInvalidPassword() {
	  log.info("------------ TC_05_Register_With_Invalid_Password ------------");
	  registerPage.openFirstHeaderPageByName(driver, "Register");
	  
	  log.info("TC_05_Register: Step 01: Click To Female radio button");
	  registerPage.clickToRadioButtonByLabelText(driver, gender);
	  
	  log.info("TC_05_Register: Step 02: Enter First Name with value (" + firstName + ")");
	  registerPage.enterToTextboxByID(driver, "FirstName", firstName);
		
	  log.info("TC_05_Register: Step 03: Enter Last Name with value (" + lastName + ")");
	  registerPage.enterToTextboxByID(driver,"LastName", lastName);
	  
	  log.info("TC_05_Register: Step 04: Select item in Date dropdown with value (" + date + ")");
	  registerPage.selectDropdownByName(driver, "DateOfBirthDay", date);
	  
	  log.info("TC_05_Register: Step 05: Select item in Month dropdown with value (" + month + ")");
	  registerPage.selectDropdownByName(driver, "DateOfBirthMonth", month);
		
	  log.info("TC_05_Register: Step 06: Select item in Year dropdown with value (" + year + ")");
	  registerPage.selectDropdownByName(driver, "DateOfBirthYear", year);
	  
	  log.info("TC_05_Register: Step 07: Enter Email Address with value (" + emailAddress + ")");
	  registerPage.enterToTextboxByID(driver,"Email", emailAddress);
	  
	  log.info("TC_05_Register: Step 08: Enter Password with value (111)");
	  registerPage.enterToTextboxByID(driver,"Password", "111");
				
	  log.info("TC_05_Register: Step 09: Enter Confirm Password");
	  registerPage.enterToTextboxByID(driver,"ConfirmPassword", "111");
	
	  log.info("TC_05_Register: Step 10: Click to Register button");
	  registerPage.clickToButtonByText(driver,"Register");
	  
	  log.info("TC_05_Register: Step 11: Verify Error Message");
	  verifyEquals(registerPage.getValidationErrorMSGDisplayed(driver, "Password"), "Password must meet the following rules:\nmust have at least 6 characters");
  }
  @Test
  public void Register_Test06_RegisterWithIncorrectConfirmPassword() {
	  log.info("------------ TC_06_Register_With_Incorrect_Confirm_Password ------------");
	  registerPage.openFirstHeaderPageByName(driver, "Register");
	  
	  log.info("TC_06_Register: Step 01: Click To Female radio button");
	  registerPage.clickToRadioButtonByLabelText(driver, gender);
	  
	  log.info("TC_06_Register: Step 02: Enter First Name");
	  registerPage.enterToTextboxByID(driver, "FirstName", firstName);
		
	  log.info("TC_06_Register: Step 03: Enter Last Name");
	  registerPage.enterToTextboxByID(driver,"LastName", lastName);
	  
	  log.info("TC_06_Register: Step 04: Select item in Date dropdown");
	  registerPage.selectDropdownByName(driver, "DateOfBirthDay", date);
	  
	  log.info("TC_06_Register: Step 05: Select item in Month dropdown");
	  registerPage.selectDropdownByName(driver, "DateOfBirthMonth", month);
		
	  log.info("TC_06_Register: Step 06: Select item in Year dropdown");
	  registerPage.selectDropdownByName(driver, "DateOfBirthYear", year);
	  
	  log.info("TC_06_Register: Step 07: Enter Email Address with value (" + emailAddress + ")");
	  registerPage.enterToTextboxByID(driver,"Email", emailAddress);
	  
	  log.info("TC_06_Register: Step 08: Enter Password with value (" + password + ")");
	  registerPage.enterToTextboxByID(driver,"Password", password);
				
	  log.info("TC_06_Register: Step 09: Enter Confirm Password with value (" + incorrectPassword + ")");
	  registerPage.enterToTextboxByID(driver,"ConfirmPassword", incorrectPassword);
	
	  log.info("TC_06_Register: Step 10: Click to Register button");
	  registerPage.clickToButtonByText(driver,"Register");
	  
	  log.info("TC_06_Register: Step 11: Verify Error Message");
	  verifyEquals(registerPage.getValidationErrorMSGDisplayed(driver, "ConfirmPassword"), "The password and confirmation password do not match.");
  }
  
  @Test
  public void Register_Test07_LoginWithEmptyData() {
	  log.info("------------ TC_07_Login_With_Empty_Data ------------");
	  log.info("TC_07_Login: Step 01: Click To Log In Link");
	  homePage.openFirstHeaderPageByName(driver, "Log in");
	  loginPage = PageGeneratorManager.getLoginPage(driver);
	  
	  log.info("TC_07_Login: Step 02: Verify Log In page is displayed");
	  verifyTrue(loginPage.isRequestedPageDisplayed(driver, "Welcome, Please Sign In!"));
	  
	  log.info("TC_07_Login: Step 03: Click to Login button");
	  loginPage.clickToButtonByText(driver,"Log in");

	  log.info("TC_07_Login: Step 04: Verify Error Message at Email textbox");
	  verifyEquals(loginPage.getValidationErrorMSGDisplayed(driver, "Email"), "Please enter your email");
	  
  }
  @Test
  public void Register_Test08_LoginWithInvalidEmail() {
	  log.info("------------ TC_08_Login_With_Invalid_Email ------------");
	  loginPage.openFirstHeaderPageByName(driver, "Log in");
	  loginPage = PageGeneratorManager.getLoginPage(driver);
	  
	  log.info("TC_08_Login: Step 01: Enter Invalid Email (" + invalidEmail + ")");
	  loginPage.enterToTextboxByID(driver, "Email", invalidEmail);
		
	  log.info("TC_08_Login: Step 03: Enter Password (" + password + ")");
	  loginPage.enterToTextboxByID(driver,"Password", password);
	  
	  log.info("TC_08_Login: Step 03: Click to Login button");
	  loginPage.clickToButtonByText(driver,"Log in");
	  

	  log.info("TC_08_Login: Step 04: Verify Error Message at Email textbox");
	  verifyEquals(loginPage.getValidationErrorMSGDisplayed(driver, "Email"), "Wrong email");
	  
  }
  @Test
  public void Register_Test09_LoginWithUnregisteredEmail() {
	  log.info("------------ TC_09_Login_With_Unregistered_Email ------------");
	  loginPage.openFirstHeaderPageByName(driver, "Log in");
	  loginPage = PageGeneratorManager.getLoginPage(driver);
	  
	  log.info("TC_09_Login: Step 01: Enter Unregistered Email with value (" + unregisteredEmail + ")");
	  loginPage.enterToTextboxByID(driver, "Email", unregisteredEmail);
		
	  log.info("TC_09_Login: Step 03: Enter Password with value (" + password + ")");
	  loginPage.enterToTextboxByID(driver, "Password", password);
	  
	  log.info("TC_09_Login: Step 03: Click to Login button");
	  loginPage.clickToButtonByText(driver, "Log in");
	  
	  log.info("TC_09_Login: Step 04: Verify Error Message");
	  verifyEquals(loginPage.getAllErrorMessageDisplayed(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	  
  }
  @Test
  public void Register_Test10_LoginWithRegisteredEmailAndEmptyPassword() {
	  log.info("------------ TC_10_Login_With_Registered_Email_And_Empty_Password ------------");
	  loginPage.openFirstHeaderPageByName(driver, "Log in");
	  loginPage = PageGeneratorManager.getLoginPage(driver);
	  
	  log.info("TC_10_Login: Step 01: Enter Registered Email with value (" + emailAddress + ")");
	  loginPage.enterToTextboxByID(driver, "Email", emailAddress);
		
	  log.info("TC_10_Login: Step 03: Enter Empty Password with value ( )");
	  loginPage.enterToTextboxByID(driver, "Password", "");
	  
	  log.info("TC_10_Login: Step 03: Click to Login button");
	  loginPage.clickToButtonByText(driver, "Log in");

	  log.info("TC_10_Login: Step 04: Verify Error Message");
	  verifyEquals(loginPage.getAllErrorMessageDisplayed(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	  
  }
  @Test
  public void Register_Test11_LoginWithRegisteredEmailAndIncorrectPassword() {
	  log.info("------------ TC_11_Login_With_Registered_Email_And_Incorrect_Password ------------");
	  loginPage.openFirstHeaderPageByName(driver, "Log in");
	  loginPage = PageGeneratorManager.getLoginPage(driver);
	  
	  log.info("TC_11_Login: Step 01: Enter Registered Email with value (" + emailAddress + ")");
	  loginPage.enterToTextboxByID(driver, "Email", emailAddress);
		
	  log.info("TC_11_Login: Step 03: Enter Incorrect Password with value (" + incorrectPassword + ")");
	  loginPage.enterToTextboxByID(driver, "Password", incorrectPassword);
	  
	  log.info("TC_11_Login: Step 03: Click to Login button");
	  loginPage.clickToButtonByText(driver, "Log in");

	  log.info("TC_11_Login: Step 04: Verify Error Message");
	  verifyEquals(loginPage.getAllErrorMessageDisplayed(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	  
  }  
  @Test
  public void Register_Test12_LoginWithRegisteredEmailAndCorrectPassword() {
	  log.info("------------ TC_12_Login_With_Registered_Email_And_Correct_Password ------------");
	  loginPage.openFirstHeaderPageByName(driver, "Log in");
	  loginPage = PageGeneratorManager.getLoginPage(driver);
	  
	  log.info("TC_12_Login: Step 01: Enter Registered Email with value (" + emailAddress + ")");
	  loginPage.enterToTextboxByID(driver, "Email", emailAddress);
		
	  log.info("TC_12_Login: Step 02: Enter Incorrect Password with value (" + password + ")");
	  loginPage.enterToTextboxByID(driver,"Password", password);
	  
	  log.info("TC_12_Login: Step 03: Click to Login button");
	  loginPage.clickToButtonByText(driver,"Log in");
	  
	  log.info("TC_12_Login: Step 04: Verify Home page Displayed");
	  homePage = PageGeneratorManager.getHomePage(driver);
	  verifyTrue(homePage.isHomePageSliderDisplayed());
	
  } 
  
  @Parameters({"browser"})
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-Condition: Close browser '" + browserName + "'");
		cleanDriverInstance();

	}

  WebDriver driver;
  HomePageObject homePage;
  RegisterPageObject registerPage;
  LoginPageObject loginPage;
  DataUtil fakeData;

}
