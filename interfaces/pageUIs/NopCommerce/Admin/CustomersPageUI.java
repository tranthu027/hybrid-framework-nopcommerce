package pageUIs.NopCommerce.Admin;

public class CustomersPageUI {
	
	public static final String ADD_NEW_BUTTON = "//a[@class='btn btn-primary']";
	public static final String CUSTOMERS_ROLE = "//label[text()='Customer roles']/ancestor::div[@class='form-group row']//div[@role='listbox']";
	public static final String CUSTOMERS_ROLES_CHILD_LIST = "//ul[@id='SelectedCustomerRoleIds_listbox']/li";
	public static final String CUSTOMERS_ROLE_SELECTED = "//li[@class='k-button']";
	public static final String CUSTOMERS_ROLE_DELETE_BUTTON = "//span[@title='delete']";
	public static final String ACTIVE_RADIO_BUTTON = "//input[@id='Active']";

	
	
	public static final String TABLE_CUSTOMER_NAME = "//tr/td[3]";
	public static final String TABLE_CUSTOMER_COMPANY = "//tr/td[5]";
	public static final String HEADER_PAGE = "//div[@class='content-header clearfix']/h1";

	//Dynamic
	public static final String EDIT_BUTTON_BY_NAME = "//td[contains(text(),'%s')]/following-sibling::td/a";



}
