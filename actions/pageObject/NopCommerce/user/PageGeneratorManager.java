package pageObject.NopCommerce.user;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	private static HomePageObject homePage;
	private static RegisterPageObject registerPage;
	private static LoginPageObject loginPage;
	private static SearchPageObject searchPage;
	private static ProductPageObject productPage;
	private static ComparePageObject comparePage;
	private static RecentlyViewedPageObject recentlyViewedPage;
	private static CheckoutPageObject checkoutPage;
	private static ShoppingCartPageObject shoppingCartPage;
	private static CompletedOrderPageObject completedOrderPage;
	private static OrderInformationPageObject orderInfoPage;
	
	private PageGeneratorManager() {
		
	}
	public static HomePageObject getHomePage (WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static RegisterPageObject getRegisterPage (WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	public static LoginPageObject getLoginPage (WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static MyAccountPageObject getMyAccountPage (WebDriver driver) {
		return new MyAccountPageObject (driver);
	}
	
	public static SearchPageObject getSearchPage (WebDriver driver) {
		return new SearchPageObject (driver);
	}
	public static ProductPageObject getProductPage (WebDriver driver) {
		return new ProductPageObject (driver);
	}
	public static WishlistPageObject getWishlistPage (WebDriver driver) {
		return new WishlistPageObject (driver);
	}
	public static ShoppingCartPageObject getShoppingCartPage (WebDriver driver) {
		return new ShoppingCartPageObject (driver);
	}
	public static ComparePageObject getComparePage (WebDriver driver) {
		return new ComparePageObject (driver);
	}
	public static RecentlyViewedPageObject getRecentlyViewedPage (WebDriver driver) {
		return new RecentlyViewedPageObject (driver);
	}
	public static CheckoutPageObject getCheckoutPage (WebDriver driver) {
		return new CheckoutPageObject (driver);
	}
	public static CompletedOrderPageObject getCompletedOrderPage (WebDriver driver) {
		return new CompletedOrderPageObject (driver);
	}
	
	public static OrderInformationPageObject getOrderInformationPage (WebDriver driver) {
		return new OrderInformationPageObject (driver);
	}

	
	

}
