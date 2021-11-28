package pageObject.NopCommerce.admin;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	private static LoginPageObject loginPage;
	private static DashboardPageObject dashboardPage;
	private static ProductDetailsPageObject productdetailPage;
	private static ProductSearchPageObject productSearchPage;
	private static CustomersPageObject customersPage;
	private static CustomerDetailsPageObject customerDetailPage;
	private static AddressPageObject addressPage;
	
	private PageGeneratorManager() {
		
	}
	public static LoginPageObject getLoginPage (WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static DashboardPageObject getDashboardPage (WebDriver driver) {
		return new DashboardPageObject(driver);
	}
	
	public static ProductDetailsPageObject getProductDetailPage (WebDriver driver) {
		return new ProductDetailsPageObject(driver);
	}
	
	public static ProductSearchPageObject getProductSearchPage (WebDriver driver) {
		return new ProductSearchPageObject(driver);
	}
	public static CustomersPageObject getCustomersPage (WebDriver driver) {
		return new CustomersPageObject(driver);
	}
	public static CustomerDetailsPageObject getCustomerDetailsPage (WebDriver driver) {
		return new CustomerDetailsPageObject(driver);
	}
	public static AddressPageObject getAddressPage (WebDriver driver) {
		return new AddressPageObject(driver);
	}
}
