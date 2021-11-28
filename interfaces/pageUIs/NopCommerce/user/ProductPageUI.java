package pageUIs.NopCommerce.user;

public class ProductPageUI {
	public static final String PRODUCT_BY_TEXT = "//div[@class='item-grid']//a[contains(text(),'%s')]";
	public static final String PRODUCT_BY_ORDER = "//div[@class='item-grid']/div[%s]";
	public static final String PRODUCT_DETAIL_ACTION_BUTTON = "//div[@class='product-essential']//button[text()='%s']";
	public static final String PRODUCT_ACTION_BUTTON_BY_TEXT = "//a[contains(text(),'%s')]/ancestor::div[@class='product-item']//button[@title='%s']";
	public static final String PRODUCT_CHILD_SUB_MENU_BY_TEXT = "//div[@class='breadcrumb']//span[text()='%s']";

	public static final String PAGINATION_ICON_BY_TEXT = "//div[@class='pager']//li/a[text()='%s']";

	
	public static final String PRODUCT_DETAIL_NAME = "//div[@class='product-name']/h1";
	public static final String PRODUCT_DETAIL_PRICE = "//div[@class='product-price']/span";
	public static final String PRODUCT_DETAIL_QTY = "//input[@data-val-required='The Qty field is required.']";
	
	public static final String WISHLIST_HEADER_LINK = "//div[@class='header']//span[text()='Wishlist']";
	
	public static final String PRODUCT_LIST_PRICE_TEXT = "//div[@class='item-grid']//span";
	
	public static final String PRODUCT_PAGINATION = "//div[@class='products-wrapper']/div[@class='pager']";
	public static final String PRODUCT_PAGINATION_CURRENT_PAGE = "//div[@class='pager']//li[@class='current-page']";
	public static final String PAGINATION_PAGE_NUMBER_BY_TEXT = "//div[@class='pager']//li/a[text()='2']";
	
	public static final String ACT_WINDOWN_COUNT_PRODUCT = "//div[@class='count']/a";
	public static final String ACT_WINDOWN_NAME_PRODUCT = "//div[@class='name']/a";
	public static final String ACT_WINDOWN_PRICE_PRODUCT = "//div[@class='totals']/strong";
	
	public static final String ADD_REVIEW_LINK = "//div[@class='product-reviews-overview']//a[text()='Add your review']";
	public static final String REVIEW_PAGE_HEADER ="//div[@class='page-title']/h1";
	public static final String REVIEW_TEXTAREA = "//textarea[@id='AddProductReview_ReviewText']";
	public static final String PRODUCT_RATING = "//div[@class='rating-options']/input[@value='%s']";
	public static final String REVIEW_RESULT = "//div[contains(text(), 'Product review is successfully added.')]";

	



}
