package com.NopCommerce.common;


import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import pageObject.NopCommerce.user.HomePageObject;
import pageObject.NopCommerce.user.LoginPageObject;
import pageObject.NopCommerce.user.PageGeneratorManager;
import pageObject.NopCommerce.user.RegisterPageObject;
import utilities.DataUtil;

public class Common_01_Login extends BaseTest {
	WebDriver driver;
	String emailAddress, passwordCommon, gender, firstName, lastName, date, month, year;
	public static Set<Cookie> loginPageCookie;
	
	@Parameters({"browser", "URL"})
	@BeforeTest
	public void beforeTest(String browserName, String appUrl ) {
		log.info("Pre-Condition - Step 01: Open browser '" + browserName + "' and navigate to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
		fakeData = DataUtil.getData();
		
		gender = "Female";
		firstName = "Automation";
		lastName = "Test";
		emailAddress = fakeData.getEmailAdress();
		passwordCommon = "123456";

		log.info("Common_01 - Step 01: Verify HomePage is displayed");
		homePage = PageGeneratorManager.getHomePage(driver);	
		verifyTrue(homePage.isHomePageSliderDisplayed());
		
		log.info("Common_01 - Step 02: Click To Register Link");
		homePage.openFirstHeaderPageByName(driver, "Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		  
		log.info("Common_01 - Step 03: Enter First Name");
		registerPage.enterToTextboxByID(driver, "FirstName", firstName);
			
		log.info("Common_01 - Step 04: Enter Last Name");
		registerPage.enterToTextboxByID(driver,"LastName", lastName);
		  
		log.info("Common_01 - Step 05: Enter Email Address with value (" + emailAddress + ")");
		registerPage.enterToTextboxByID(driver,"Email", emailAddress);
		  
		log.info("Common_01 - Step 06: Enter Password with value (" + passwordCommon + ")");
		registerPage.enterToTextboxByID(driver,"Password", passwordCommon);
					
		log.info("Common_01 - Step 07: Enter Confirm Password");
		registerPage.enterToTextboxByID(driver,"ConfirmPassword", passwordCommon);
		
		log.info("Common_01 - Step 08: Click to Register button");
		registerPage.clickToButtonByText(driver,"Register");
		  
		log.info("Common_01 - Step 09: Verify Success Message");
		verifyEquals(registerPage.getSuccessMessageDisplayed(), "Your registration completed");
		  
		log.info("Common_01 - Step 10: Click To Log out Link");
		registerPage.openFirstHeaderPageByName(driver, "Log out");
		
		log.info("Common_01 - Step 11: Verify HomePage is displayed");
		verifyTrue(homePage.isHomePageSliderDisplayed());
		
		log.info("Common_01 - Step 12: Click To Log in Link");
		homePage.openFirstHeaderPageByName(driver, "Log in");
		loginPage = PageGeneratorManager.getLoginPage(driver);
		  
		log.info("Common_01 - Step 13:  Enter Registered Email with value (" + emailAddress + ")");
		loginPage.enterToTextboxByID(driver, "Email", emailAddress);
			
		log.info("Common_01 - Step 14: Enter Password with value (" + passwordCommon + ")");
		loginPage.enterToTextboxByID(driver,"Password", passwordCommon);
		  
		log.info("Common_01 - Step 15: Click to Login button");
		loginPage.clickToButtonByText(driver,"Log in");
		  
		log.info("Common_01 - Step 16: Verify Home page Displayed");
		homePage = PageGeneratorManager.getHomePage(driver);
		verifyTrue(homePage.isHomePageSliderDisplayed());
		
		log.info("Common_01 - Step 17: Get all login page cookie");
		loginPageCookie = homePage.getAllCookies(driver);
		System.out.println(loginPageCookie);

		log.info("Post-Condition: Close browser '" + browserName + "'");
		cleanDriverInstance();

	}
	
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	DataUtil fakeData;

}
