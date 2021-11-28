package com.NopCommerce.Admin;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.NopCommerce.admin.AddressPageObject;
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

public class Admin_Customers extends BaseTest {
	String emaillogin, passwordlogin,
			email, password, firstname, lastname, birthday, company, roles, comment,
			month, day, editEmail, editFirstname, editLastname, editBirthday, editCompany, editComment, editMonth, editDay,
			country, state, city, address01, address02, zipCode, phoneNumber, faxNumber,
			editCountry, editState, editCity, editAddress01, editAddress02, editZipCode, editPhoneNumber, editFaxNumber;
	
  @Parameters ({"browser", "URL"})
  @BeforeClass
  public void beforeClass(String browserName, String appUrl) {
	  log.info("Pre-Condition - Step 01: Open browser '" + browserName + "' and nagivate to '" + appUrl + "'");
	  driver = getBrowserDriver(browserName, appUrl);
	  loginPage = PageGeneratorManager.getLoginPage(driver);
	  
	  fakeData = DataUtil.getData();
	  emaillogin = "admin@yourstore.com";
	  passwordlogin = "admin";
	  email = fakeData.getEmailAdress();
	  password = fakeData.getPassword();
	  firstname = fakeData.getFirstName();
	  lastname = fakeData.getLastName(); 
	  birthday = "11/24/1999";
	  month = "11";
	  day = "24";
	  company = fakeData.getCompanyName();
	  roles = "Guests";
	  comment = "Add new Customer (Guest)";
	  editEmail = fakeData.getEditEmailAdress();
	  editFirstname =  fakeData.getEditFirstName();
	  editLastname = fakeData.getEditLastName();
	  editBirthday = "12/25/1999";
	  editCompany = fakeData.getEditCompanyName();
	  editComment = "Edit Customer (Guest)";
	  editMonth = "12";
	  editDay = "25";
	  country = "Viet Nam";
	  state = "Other";
	  city = fakeData.getCityName();
	  address01 = fakeData.getfullAddress01();
	  address02 = fakeData.getfullAddress02();
	  zipCode = fakeData.getZipCode();
	  phoneNumber = fakeData.getPhoneNumber();
	  faxNumber =  fakeData.getFaxNumber();
	  editCountry = "United States";
	  editState = "California";
	  editCity = fakeData.getEditCityName();
	  editAddress01 = fakeData.getEditFullAddress01();
	  editAddress02 = fakeData.getEditFullAddress02();
	  editZipCode = fakeData.getEditZipCode();
	  editPhoneNumber = fakeData.getEditPhoneNumber();
	  editFaxNumber = fakeData.getEditFaxNumber();
	  
	  
	  log.info("Pre-Condition - Step 01: Enter email To Email textbox");
	  loginPage.enterToTextboxByID(driver, "Email", emaillogin);
	  
	  log.info("Pre-Condition - Step 02: Enter password To Password textbox");
	  loginPage.enterToTextboxByID(driver, "Password", passwordlogin);
	  
	  log.info("Pre-Condition - Step 03: Click to Log in button");
	  loginPage.clickToButtonByText(driver, "Log in");
	  dashboardPage = PageGeneratorManager.getDashboardPage(driver);
	  
	  log.info("Pre-Condition - Step 04: Open menu Customers/Customers");
	  verifyTrue(dashboardPage.areJQueryAndJSLoadedSuccess(driver));
	  dashboardPage.openSubMenuPageByName(driver, "Customers"," Customers");
	  customersPage = PageGeneratorManager.getCustomersPage(driver);
	  
	  
	  log.info("Pre-Condition - Step 05: Verify Product Search Page is displayed");
	  verifyTrue(dashboardPage.areJQueryAndJSLoadedSuccess(driver));
	  verifyTrue(customersPage.isHeaderTitleOfPageDisplayed(driver, "Customers"));
  }

	@Test
	public void Customers_Test01_CreatNewCustomers() {
		log.info("------------ TC_01_Creat_New_Customers ------------");	
		verifyTrue(dashboardPage.areJQueryAndJSLoadedSuccess(driver));
		log.info("TC_01_Customers: Step 02: Click To Add new Button");
		customersPage.clickToAddNewButton();
		
		log.info("TC_01_Customers: Step 03: Expand Customer info panel");
		verifyTrue(customersPage.areJQueryAndJSLoadedSuccess(driver));
		customersPage.clickToExpandPanelByText(driver, "Customer info");
		
		log.info("TC_01_Customers: Step 04: Enter customer's email with value: " + email);
		verifyTrue(customersPage.areJQueryAndJSLoadedSuccess(driver));
		customersPage.enterToTextboxByID(driver, "Email", email);
		
		log.info("TC_01_Customers: Step 05: Enter password with value: " + password);
		customersPage.enterToTextboxByID(driver, "Password", password);
		
		log.info("TC_01_Customers: Step 06: Enter customer's firstname with value: " + firstname);
		customersPage.enterToTextboxByID(driver, "FirstName", firstname);
		
		log.info("TC_01_Customers: Step 07: Enter customer's lastname with value: " + lastname);
		customersPage.enterToTextboxByID(driver, "LastName", lastname);
		
		log.info("TC_01_Customers: Step 08: Enter customer's birthday with value: " + birthday);
		customersPage.enterToTextboxByID(driver, "DateOfBirth", birthday);
		
		log.info("TC_01_Customers: Step 09: Enter customer's company with value: " + company);
		customersPage.enterToTextboxByID(driver, "Company", company);
		
		log.info("TC_01_Customers: Step 10: Add comment");
		customersPage.addToCommentTextarea(driver, comment);
		
		log.info("TC_01_Customers: Step 11: Delete item is selected in Roles dropdown");
		customersPage.deselectItemInRolesDropdown(driver);
		customersPage.sleepInSecond(2);
		
		log.info("TC_01_Customers: Step 12: Select item in Roles dropdown with value: " + roles);
		customersPage.selectItemInRolesDropdown(driver,roles);
		
		log.info("TC_01_Customers: Step 13: Click to active radio button");
		customersPage.clickToActiveRadioButton();
		
		log.info("TC_01_Customers: Step 14: Click to male gender radio button");
		customersPage.clickToRadioButtonByLabelText(driver, "Male");
		
		log.info("TC_01_Customers: Step 15: Click To Add new Button");
		customersPage.clickToButtonByName(driver, "save");
		
		log.info("TC_01_Customers: Step 16: Verify Success Alert Dispalyed");
		verifyTrue(customersPage.isSuccessAlertDisplayed(driver));
		
		log.info("TC_01_Customers: Step 17: Click To close alert bar");
		customersPage.closeAlertNotification(driver);
		
		log.info("TC_01_Customers: Step 18: Select item in Roles dropdown with value: " + roles);
		verifyTrue(customersPage.areJQueryAndJSLoadedSuccess(driver));
		customersPage.selectItemInRolesDropdown(driver,roles);
		
		log.info("TC_01_Customers: Step 19: Click to Search Button");
		customersPage.clickToButtonByID(driver, "search-customers");
		
		log.info("TC_01_Customers: Step 19: Verify recently addedd customer's information is Dispalyed");
		verifyTrue(customersPage.areJQueryAndJSLoadedSuccess(driver));
		customersPage.sleepInSecond(3);
		verifyTrue(customersPage.isNewCustomerNameDisplayed(driver, firstname + " " + lastname));
		verifyTrue(customersPage.isNewCustomerCompanyDisplayed(driver, company));

	}
	@Test
	public void Customers_Test02_SearchCustomersWithEmail() {
		log.info("------------ TC_02_Search_Customers_With_Email ------------");
		customersPage.refreshCurrentPage(driver);
		verifyTrue(customersPage.areJQueryAndJSLoadedSuccess(driver));
		
		log.info("TC_02_Customers: Step 01: Expand search panel");
		customersPage.clickToExpandPanelByText(driver, "Search");
		
		log.info("TC_02_Customers: Step 02: Enter email with value: " + email);
		customersPage.enterToTextboxByID(driver, "SearchEmail", email);
		
		log.info("TC_02_Customers: Step 03: Delete item is selected in Roles dropdown");
		customersPage.deselectItemInRolesDropdown(driver);
		
		log.info("TC_02_Customers: Step 04: Click to Search Button");
		customersPage.clickToButtonByID(driver, "search-customers");
		
		log.info("TC_02_Customers: Step 05: Verify only 1 item is displayed");
		verifyTrue(customersPage.areJQueryAndJSLoadedSuccess(driver));
		verifyEquals(customersPage.getQuantityItemInTableDisplayed(driver), 1);
		
	}
	@Test
	public void Customers_Test03_SearchCustomersWithFirstnameAndLastname() {
		log.info("------------ TC_03_Search_Customers_With_Firstname_And_Lastname ------------");
		customersPage.refreshCurrentPage(driver);
		verifyTrue(customersPage.areJQueryAndJSLoadedSuccess(driver));
		
		log.info("TC_03_Customers: Step 01: Expand search panel");
		customersPage.clickToExpandPanelByText(driver, "Search");
		
		log.info("TC_03_Customers: Step 02: Enter firstname with value: " + firstname);
		verifyTrue(customersPage.areJQueryAndJSLoadedSuccess(driver));
		customersPage.enterToTextboxByID(driver, "SearchFirstName", firstname);
		
		log.info("TC_03_Customers: Step 03: Enter lastname with value: " + lastname);
		customersPage.enterToTextboxByID(driver, "SearchLastName", lastname);
		
		log.info("TC_03_Customers: Step 04: Delete item is selected in Roles dropdown");
		customersPage.deselectItemInRolesDropdown(driver);
		verifyTrue(customersPage.areJQueryAndJSLoadedSuccess(driver));
		
		log.info("TC_03_Customers: Step 05: Click to Search Button");
		customersPage.clickToButtonByID(driver, "search-customers");
		
		log.info("TC_03_Customers: Step 06: Verify only 1 item is displayed");
		verifyTrue(customersPage.areJQueryAndJSLoadedSuccess(driver));
		verifyEquals(customersPage.getQuantityItemInTableDisplayed(driver), 1);
		
	}
	@Test
	public void Customers_Test04_SearchCustomersWithCompanyAndRole() {
		log.info("------------ TC_04_Search_Customers_With_Company_And_Role ------------");
		customersPage.refreshCurrentPage(driver);
		verifyTrue(customersPage.areJQueryAndJSLoadedSuccess(driver));
		log.info("TC_04_Customers: Step 01: Expand search panel");
		customersPage.clickToExpandPanelByText(driver, "Search");
		
		log.info("TC_04_Customers: Step 02: Enter company with value: " + company);
		customersPage.enterToTextboxByID(driver, "SearchCompany", company);
		
		log.info("TC_04_Customers: Step 03: Delete item is selected in Roles dropdown");
		customersPage.deselectItemInRolesDropdown(driver);
		
		log.info("TC_04_Customers: Step 04: Select item in Roles dropdown with value: " + roles);
		customersPage.selectItemInRolesDropdown(driver,roles);
		verifyTrue(customersPage.areJQueryAndJSLoadedSuccess(driver));
		
		log.info("TC_04_Customers: Step 05: Click to Search Button");
		customersPage.clickToButtonByID(driver, "search-customers");
		
		log.info("TC_04_Customers: Step 06: Verify only 1 item is displayed");
		verifyTrue(customersPage.areJQueryAndJSLoadedSuccess(driver));
		verifyEquals(customersPage.getQuantityItemInTableDisplayed(driver), 1);
		
	}
	@Test
	public void Customers_Test05_SearchCustomersWithFullData() {
		log.info("------------ TC_05_Search_Customers_With_Full_Data ------------");
		customersPage.refreshCurrentPage(driver);
		
		log.info("TC_05_Customers: Step 01: Expand search panel");
		customersPage.clickToExpandPanelByText(driver, "Search");
		
		log.info("TC_05_Customers: Step 02: Enter email with value: " + email);
		customersPage.enterToTextboxByID(driver, "SearchEmail", email);
		
		log.info("TC_05_Customers: Step 03: Enter firstname with value: " + firstname);
		customersPage.enterToTextboxByID(driver, "SearchFirstName", firstname);
		
		log.info("TC_05_Customers: Step 04: Enter lastname with value: " + lastname);
		customersPage.enterToTextboxByID(driver, "SearchLastName", lastname);
		
		log.info("TC_05_Customers: Step 05: Select item in month dropdown with value: " + month);
		customersPage.selectDropdownByName(driver, "SearchMonthOfBirth", month);
		
		log.info("TC_05_Customers: Step 06: Select item in day dropdown with value: " + day);
		customersPage.selectDropdownByName(driver, "SearchDayOfBirth", day);
		
		log.info("TC_05_Customers: Step 07: Delete item is selected in Roles dropdown");
		customersPage.deselectItemInRolesDropdown(driver);
		
		log.info("TC_05_Customers: Step 08: Enter company with value: " + company);
		customersPage.enterToTextboxByID(driver, "SearchCompany", company);
		
		log.info("TC_05_Customers: Step 09: Select item in Roles dropdown with value: " + roles);
		verifyTrue(customersPage.areJQueryAndJSLoadedSuccess(driver));
		customersPage.selectItemInRolesDropdown(driver,roles);
		
		log.info("TC_05_Customers: Step 10: Click to Search Button");
		customersPage.clickToButtonByID(driver, "search-customers");
		
		log.info("TC_05_Customers: Step 11: Verify only 1 item is displayed");
		verifyTrue(customersPage.areJQueryAndJSLoadedSuccess(driver));
		verifyEquals(customersPage.getQuantityItemInTableDisplayed(driver), 1);
		
	}
	
	@Test
	public void Customers_Test06_EditCustomers() {
		log.info("------------ TC_06_Edit_Customersa ------------");
		log.info("TC_06_Customers: Step 01: Click To Edit Customer button");
		customersPage.clickToEditButtonByCustomerName(driver, firstname);
		customerDetailsPage = PageGeneratorManager.getCustomerDetailsPage(driver);
		
		log.info("TC_06_Customers: Step 02: Verify requested page is displayed");
		verifyTrue(customerDetailsPage.isHeaderTitleOfPageDisplayed(driver, lastname + " " + firstname));
		
		log.info("TC_06_Customers: Step 03: Expand Customer info panel");
		customerDetailsPage.clickToExpandPanelByText(driver, "Customer info");
		
		log.info("TC_06_Customers: Step 04: Enter customer's email with value: " + editEmail);
		verifyTrue(customersPage.areJQueryAndJSLoadedSuccess(driver));
		customerDetailsPage.enterToTextboxByID(driver, "Email", editEmail);
		
		log.info("TC_06_Customers: Step 05: Enter customer's firstname with value: " + editFirstname);
		customerDetailsPage.enterToTextboxByID(driver, "FirstName", editFirstname);
		
		log.info("TC_06_Customers: Step 06: Enter customer's lastname with value: " + editLastname);
		customerDetailsPage.enterToTextboxByID(driver, "LastName", editLastname);
		
		log.info("TC_06_Customers: Step 07: Enter customer's birthday with value: " + editBirthday);
		customerDetailsPage.enterToTextboxByID(driver, "DateOfBirth", editBirthday);
		
		log.info("TC_06_Customers: Step 08: Enter customer's company with value: " + editCompany);
		customerDetailsPage.enterToTextboxByID(driver, "Company", editCompany);
		
		log.info("TC_06_Customers: Step 09: Add comment");
		customerDetailsPage.addToCommentTextarea(driver, editComment);
		
		log.info("TC_06_Customers: Step 10: Click To Add new Button");
		customerDetailsPage.clickToButtonByName(driver, "save");
		customersPage = PageGeneratorManager.getCustomersPage(driver);
		
		log.info("TC_06_Customers: Step 11: Verify Success Alert Dispalyed");
		verifyTrue(customersPage.isSuccessAlertDisplayed(driver));
		
		log.info("TC_06_Customers: Step 12: Click To close alert bar");
		customersPage.closeAlertNotification(driver);
		
		log.info("TC_06_Customers: Step 13: Enter email with value: " + editEmail);
		customersPage.enterToTextboxByID(driver, "SearchEmail", editEmail);
		
		log.info("TC_06_Customers: Step 14: Enter firstname with value: " + editFirstname);
		customersPage.enterToTextboxByID(driver, "SearchFirstName", editFirstname);
		
		log.info("TC_06_Customers: Step 15: Enter lastname with value: " + editLastname);
		customersPage.enterToTextboxByID(driver, "SearchLastName", editLastname);
		
		log.info("TC_06_Customers: Step 16: Select item in month dropdown with value: " + editMonth);
		customersPage.selectDropdownByName(driver, "SearchMonthOfBirth", editMonth);
		
		log.info("TC_06_Customers: Step 17: Select item in day dropdown with value: " + editDay);
		customersPage.selectDropdownByName(driver, "SearchDayOfBirth", editDay);
		
		log.info("TC_06_Customers: Step 18: Enter company with value: " + editCompany);
		customersPage.enterToTextboxByID(driver, "SearchCompany", editCompany);
		
		log.info("TC_06_Customers: Step 19: Delete item is selected in Roles dropdown");
		customersPage.deselectItemInRolesDropdown(driver);
		
		log.info("TC_06_Customers: Step 20: Select item in Roles dropdown with value: " + roles);
		verifyTrue(customersPage.areJQueryAndJSLoadedSuccess(driver));
		customersPage.selectItemInRolesDropdown(driver,roles);
		
		log.info("TC_06_Customers: Step 21: Click to Search Button");
		customersPage.clickToButtonByID(driver, "search-customers");
		
		log.info("TC_06_Customers: Step 22: Verify only 1 item is displayed");
		verifyTrue(customersPage.areJQueryAndJSLoadedSuccess(driver));
		verifyEquals(customersPage.getQuantityItemInTableDisplayed(driver), 1);
		
	}
	
	@Test
	public void Customers_Test07_AddNewAddressInCustomerDetail() {
		log.info("------------ TC_07_Add_New_Address_In_Customer_Detail ------------");
		log.info("TC_07_Customers: Step 01: Click To Edit Customer button");
		customersPage.clickToEditButtonByCustomerName(driver, editFirstname );
		customerDetailsPage = PageGeneratorManager.getCustomerDetailsPage(driver);
		
		log.info("TC_07_Customers: Step 02: Verify requested page is displayed");
		verifyTrue(customersPage.areJQueryAndJSLoadedSuccess(driver));
		verifyTrue(customerDetailsPage.isHeaderTitleOfPageDisplayed(driver, editLastname));
		
		log.info("TC_07_Customers: Step 03: Expand Customer info panel");
		customerDetailsPage.clickToExpandPanelByText(driver, "Addresses");
		verifyTrue(customerDetailsPage.areJQueryAndJSLoadedSuccess(driver));
		
		log.info("TC_07_Customers: Step 04: Click To Add new address button");
		customerDetailsPage.clickToButtonByContainsText(driver, "Add new address");
		addressPage = PageGeneratorManager.getAddressPage(driver);
		
		log.info("TC_07_Customers: Step 05: Enter customer's firstname with value: " + firstname);
		addressPage.sleepInSecond(2);
		addressPage.enterToTextboxByID(driver, "Address_FirstName", firstname);
		
		log.info("TC_07_Customers: Step 06: Enter customer's lastname with value: " + lastname);
		addressPage.enterToTextboxByID(driver, "Address_LastName", lastname);
		
		log.info("TC_07_Customers: Step 07: Enter customer's email with value: " + email);
		addressPage.enterToTextboxByID(driver, "Address_Email", email);
		
		log.info("TC_07_Customers: Step 08: Enter customer's company with value: " + company);
		addressPage.enterToTextboxByID(driver, "Address_Company", company);
		
		log.info("TC_07_Customers: Step 09: Select item in country dropdown with value: " + country);
		addressPage.selectDropdownByName(driver, "Address.CountryId", country);
		
		log.info("TC_07_Customers: Step 10: Select item in state dropdown with value: " + state);
		addressPage.sleepInSecond(2);
		addressPage.selectDropdownByName(driver, "Address.StateProvinceId", state);
		
		log.info("TC_07_Customers: Step 11: Enter customer's city with value: " + city);
		addressPage.enterToTextboxByID(driver, "Address_City", city);
		
		log.info("TC_07_Customers: Step 12: Enter customer's address 01 with value: " + address01);
		addressPage.enterToTextboxByID(driver, "Address_Address1", address01);
		
		log.info("TC_07_Customers: Step 13: Enter customer's address 01 with value: " + address02);
		addressPage.enterToTextboxByID(driver, "Address_Address2", address02);
		
		log.info("TC_07_Customers: Step 14: Enter customer's Zip code with value: " + zipCode);
		addressPage.enterToTextboxByID(driver, "Address_ZipPostalCode", zipCode);
		
		log.info("TC_07_Customers: Step 15: Enter customer's phone number with value: " + phoneNumber);
		addressPage.enterToTextboxByID(driver, "Address_PhoneNumber", phoneNumber);
		
		log.info("TC_07_Customers: Step 16: Enter customer's fax number with value: " + faxNumber);
		addressPage.enterToTextboxByID(driver, "Address_FaxNumber", faxNumber);

		log.info("TC_07_Customers: Step 17: Click to Save Button");
		addressPage.clickToButtonByContainsText(driver, "Save");
		
		log.info("TC_07_Customers: Step 18: Verify Success Alert Dispalyed");
		verifyTrue(addressPage.areJQueryAndJSLoadedSuccess(driver));
		verifyTrue(addressPage.isSuccessAlertDisplayed(driver));
		
		log.info("TC_07_Customers: Step 19: Click To close alert bar");
		addressPage.closeAlertNotification(driver);
		
		log.info("TC_07_Customers: Step 20: Click To back to customer details link");
		addressPage.clickToBackToCustomerDetails(driver);
		customerDetailsPage = PageGeneratorManager.getCustomerDetailsPage(driver);
		
		log.info("TC_07_Customers: Step 21: Verify requested page is displayed");
		verifyTrue(customerDetailsPage.areJQueryAndJSLoadedSuccess(driver));
		verifyTrue(customerDetailsPage.isHeaderTitleOfPageDisplayed(driver, editLastname));
		
		log.info("TC_07_Customers: Step 22: Expand Customer info panel");
		verifyTrue(customerDetailsPage.areJQueryAndJSLoadedSuccess(driver));
		customerDetailsPage.clickToExpandPanelByText(driver, "Addresses");
		
		log.info("TC_07_Customers: Step 23: Verify recently addedd customer's information is Dispalyed");
		verifyTrue(customerDetailsPage.areJQueryAndJSLoadedSuccess(driver));
		verifyTrue(customerDetailsPage.isCustomerFirstnameUpdated(driver, firstname));
		verifyTrue(customerDetailsPage.isCustomerLastnameUpdated(driver, lastname));
		verifyTrue(customerDetailsPage.isCustomerEmailUpdated(driver, email));
		verifyTrue(customerDetailsPage.isCustomerPhoneNumberUpdated(driver, phoneNumber));
		verifyTrue(customerDetailsPage.isCustomerFaxNumberUpdated(driver, faxNumber));
		verifyTrue(customerDetailsPage.isCustomerAddressUpdated(driver, company, address01, address02, zipCode, city, country));
	}
	@Test
	public void Customers_Test08_EditAddressInCustomerDetail() {
		log.info("------------ TC_08_Edit_Address_In_Customer_Detail ------------");
		log.info("TC_08_Customers - Step 01: Open menu Customers/Customers");
		verifyTrue(customerDetailsPage.areJQueryAndJSLoadedSuccess(driver));
		customerDetailsPage.openSubMenuPageByName(driver, "Customers"," Customers");
		customersPage = PageGeneratorManager.getCustomersPage(driver);
		verifyTrue(customerDetailsPage.areJQueryAndJSLoadedSuccess(driver));
		
		log.info("TC_08_Customers: Step 02: Expand search panel");
		customersPage.clickToExpandPanelByText(driver, "Search");
		
		log.info("TC_08_Customers: Step 03: Enter firstname with value: " + editFirstname);
		customersPage.enterToTextboxByID(driver, "SearchFirstName", editFirstname);
		
		log.info("TC_08_Customers: Step 04: Enter lastname with value: " + editLastname);
		customersPage.enterToTextboxByID(driver, "SearchLastName", editLastname);
		
		log.info("TC_08_Customers: Step 05: Select item in month dropdown with value: " + editMonth);
		customersPage.selectDropdownByName(driver, "SearchMonthOfBirth", editMonth);
		
		log.info("TC_08_Customers: Step 06: Select item in day dropdown with value: " + editDay);
		customersPage.selectDropdownByName(driver, "SearchDayOfBirth", editDay);
		
		log.info("TC_08_Customers: Step 07: Enter company with value: " + editCompany);
		customersPage.enterToTextboxByID(driver, "SearchCompany", editCompany);
		
		log.info("TC_08_Customers: Step 08: Delete item is selected in Roles dropdown");
		customersPage.deselectItemInRolesDropdown(driver);
		
		log.info("TC_08_Customers: Step 09: Click to Search Button");
		customersPage.clickToButtonByID(driver, "search-customers");
		
		log.info("TC_08_Customers: Step 10: Verify only 1 item is displayed");
		verifyTrue(customersPage.areJQueryAndJSLoadedSuccess(driver));
		verifyEquals(customersPage.getQuantityItemInTableDisplayed(driver), 1);
		  
		log.info("TC_08_Customers: Step 11: Click To Edit Customer button");
		customersPage.clickToEditButtonByCustomerName(driver, editFirstname);
		customerDetailsPage = PageGeneratorManager.getCustomerDetailsPage(driver);
		
		log.info("TC_08_Customers: Step 12: Verify requested page is displayed");
		verifyTrue(customersPage.areJQueryAndJSLoadedSuccess(driver));
		verifyTrue(customerDetailsPage.isHeaderTitleOfPageDisplayed(driver, editLastname));
		
		log.info("TC_08_Customers: Step 13: Expand Customer info panel");
		customerDetailsPage.clickToExpandPanelByText(driver, "Addresses");
		
		log.info("TC_08_Customers: Step 14: Click To edit button in table");
		verifyTrue(addressPage.areJQueryAndJSLoadedSuccess(driver));
		customerDetailsPage.clickToButtonInTableByText(driver, "Edit");
		addressPage = PageGeneratorManager.getAddressPage(driver);
		addressPage.sleepInSecond(2);
		
		log.info("TC_08_Customers: Step 15: Enter customer's firstname with value: " + editFirstname);
		addressPage.enterToTextboxByID(driver, "Address_FirstName", editFirstname);
		
		log.info("TC_08_Customers: Step 16: Enter customer's lastname with value: " + editLastname);
		addressPage.enterToTextboxByID(driver, "Address_LastName", editLastname);
		
		log.info("TC_08_Customers: Step 17: Enter customer's email with value: " + editEmail);
		addressPage.enterToTextboxByID(driver, "Address_Email", editEmail);
		
		log.info("TC_08_Customers: Step 18: Enter customer's company with value: " + editCompany);
		addressPage.enterToTextboxByID(driver, "Address_Company", editCompany);
		
		log.info("TC_08_Customers: Step 19: Select item in country dropdown with value: " + editCountry);
		addressPage.selectDropdownByName(driver, "Address.CountryId", editCountry);
		addressPage.sleepInSecond(3);
		
		log.info("TC_08_Customers: Step 20: Select item in state dropdown with value: " + editState);
		verifyTrue(addressPage.areJQueryAndJSLoadedSuccess(driver));
		addressPage.selectDropdownByName(driver, "Address.StateProvinceId", editState);
		
		log.info("TC_08_Customers: Step 21: Enter customer's city with value: " + editCity);
		addressPage.enterToTextboxByID(driver, "Address_City", editCity);
		
		log.info("TC_08_Customers: Step 22: Enter customer's address 01 with value: " + editAddress01);
		addressPage.enterToTextboxByID(driver, "Address_Address1", editAddress01);
		
		log.info("TC_08_Customers: Step 23: Enter customer's address 01 with value: " + editAddress02);
		addressPage.enterToTextboxByID(driver, "Address_Address2", editAddress02);
		
		log.info("TC_08_Customers: Step 24: Enter customer's Zip code with value: " + editZipCode);
		addressPage.enterToTextboxByID(driver, "Address_ZipPostalCode", editZipCode);
		
		log.info("TC_08_Customers: Step 25: Enter customer's phone number with value: " + editPhoneNumber);
		addressPage.enterToTextboxByID(driver, "Address_PhoneNumber", editPhoneNumber);
		
		log.info("TC_08_Customers: Step 26: Enter customer's fax number with value: " + editFaxNumber);
		addressPage.enterToTextboxByID(driver, "Address_FaxNumber", editFaxNumber);

		log.info("TC_08_Customers: Step 27: Click to Save Button");
		addressPage.clickToButtonByName(driver, "save");
		
		log.info("TC_08_Customers: Step 28: Verify Success Alert Dispalyed");
		verifyTrue(addressPage.isSuccessAlertDisplayed(driver));
		
		log.info("TC_08_Customers: Step 29: Click To close alert bar");
		addressPage.closeAlertNotification(driver);
		
		log.info("TC_08_Customers: Step 30: Click To back to customer details link");
		addressPage.clickToBackToCustomerDetails(driver);
		customerDetailsPage = PageGeneratorManager.getCustomerDetailsPage(driver);
		
		log.info("TC_08_Customers: Step 31: Verify requested page is displayed");
		verifyTrue(customerDetailsPage.areJQueryAndJSLoadedSuccess(driver));
		verifyTrue(customerDetailsPage.isHeaderTitleOfPageDisplayed(driver, editLastname));
		
		log.info("TC_08_Customers: Step 32: Expand Customer info panel");
		customerDetailsPage.sleepInSecond(3);
		customerDetailsPage.clickToExpandPanelByText(driver, "Addresses");
		
		log.info("TC_08_Customers: Step 33: Verify recently addedd customer's information is Dispalyed");
		verifyTrue(customerDetailsPage.areJQueryAndJSLoadedSuccess(driver));
		verifyTrue(customerDetailsPage.isCustomerFirstnameUpdated(driver, editFirstname));
		verifyTrue(customerDetailsPage.isCustomerLastnameUpdated(driver, editLastname));
		verifyTrue(customerDetailsPage.isCustomerEmailUpdated(driver, editEmail));
		verifyTrue(customerDetailsPage.isCustomerPhoneNumberUpdated(driver, editPhoneNumber));
		verifyTrue(customerDetailsPage.isCustomerFaxNumberUpdated(driver, editFaxNumber));
		verifyTrue(customerDetailsPage.isCustomerAddressUpdated(driver, editCompany, editAddress01, editAddress02, editZipCode, editCity, editCountry));
		
	}
	
	public void Customers_Test09_DeleteAddressInCustomerDetail() {
		log.info("------------ TC_09_Delete_Address_In_Customer_Detail ------------");
		log.info("TC_09_Customers - Step 01: Open menu Customers/Customers");
		customerDetailsPage.openSubMenuPageByName(driver, "Customers"," Customers");
		customersPage = PageGeneratorManager.getCustomersPage(driver);
		verifyTrue(customerDetailsPage.areJQueryAndJSLoadedSuccess(driver));
		
		log.info("TC_09_Customers: Step 02: Expand search panel");
		customersPage.clickToExpandPanelByText(driver, "Search");
		
		log.info("TC_09_Customers: Step 02: Enter firstname with value: " + editFirstname);
		customersPage.enterToTextboxByID(driver, "SearchFirstName", editFirstname);
		
		log.info("TC_09_Customers: Step 03: Enter lastname with value: " + editLastname);
		customersPage.enterToTextboxByID(driver, "SearchLastName", editLastname);
		
		log.info("TC_09_Customers: Step 16: Select item in month dropdown with value: " + editMonth);
		customersPage.selectDropdownByName(driver, "SearchMonthOfBirth", editMonth);
		
		log.info("TC_09_Customers: Step 17: Select item in day dropdown with value: " + editDay);
		customersPage.selectDropdownByName(driver, "SearchDayOfBirth", editDay);
		
		log.info("TC_09_Customers: Step 18: Enter company with value: " + editCompany);
		customersPage.enterToTextboxByID(driver, "SearchCompany", editCompany);
		
		log.info("TC_09_Customers: Step 04: Delete item is selected in Roles dropdown");
		customersPage.deselectItemInRolesDropdown(driver);
		
		log.info("TC_09_Customers: Step 05: Click to Search Button");
		customersPage.clickToButtonByID(driver, "search-customers");
		
		log.info("TC_09_Customers: Step 06: Verify only 1 item is displayed");
		verifyTrue(customersPage.areJQueryAndJSLoadedSuccess(driver));
		verifyEquals(customersPage.getQuantityItemInTableDisplayed(driver), 1);
		  
		log.info("TC_09_Customers: Step 01: Click To Edit Customer button");
		customersPage.clickToEditButtonByCustomerName(driver, editFirstname + " " + editLastname );
		customerDetailsPage = PageGeneratorManager.getCustomerDetailsPage(driver);
		
		log.info("TC_08_Customers: Step 12: Verify requested page is displayed");
		verifyTrue(customersPage.areJQueryAndJSLoadedSuccess(driver));
		verifyTrue(customerDetailsPage.isHeaderTitleOfPageDisplayed(driver, editLastname));
		
		log.info("TC_08_Customers: Step 13: Expand Customer info panel");
		customerDetailsPage.clickToExpandPanelByText(driver, "Addresses");
		
		log.info("TC_08_Customers: Step 14: Click To Delete button in table");
		customerDetailsPage.clickToButtonInTableByText(driver, "Delete");
		
		log.info("TC_08_Customers: Step 14: Click To Accept Alert");
		customerDetailsPage.acceptAlert(driver);
		verifyTrue(customerDetailsPage.areJQueryAndJSLoadedSuccess(driver));
		
		log.info("TC_02_Admin: Step 06: Verify no data available in address table");
		verifyTrue(customerDetailsPage.isEmptyAddressTableDisplayed());
		
		
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
	CustomerDetailsPageObject customerDetailsPage;
	AddressPageObject addressPage;
	DataUtil fakeData;
}
	  
