package pageUIs.NopCommerce.Admin;

public class ProductDetailsPageUI { 
	public static final String PRODUCT_NAME = "//input[@value='%s']";
	
	public static final String UPLOADED_IMG = "//div[@class='uploaded-image']/img[contains(@src,'%s')]";
	public static final String ALT_TEXTBOX = "//input[@id='AddPictureModel_OverrideAltAttribute']";
	public static final String TITLE_TEXTBOX = "//input[@id='AddPictureModel_OverrideTitleAttribute']";
	public static final String DISPLAYED_ORDER_TEXTBOX_UP_DOWN = "//input[@id='AddPictureModel_DisplayOrder']/following-sibling::span/span[@aria-label='%s value']";
	public static final String ADD_PRODUCT_BUTTON = "//button[@id='addProductPicture']";
	public static final String ADDED_PRODUCT_INFO ="//img[contains(@src,'%s')]/ancestor::tr/td[@data-columnname='DisplayOrder' and text()='%s']/following-sibling::td[@data-columnname='OverrideAltAttribute' and text()='%s']/following-sibling::td[@data-columnname='OverrideTitleAttribute' and text()='%s']";
	public static final String SAVE_BUTTON = "//button[@name='save']";
	
	public static final String DELETE_BUTTON_BY_IMAGE_TITLE = "//td[contains(text(),'%s')]/ancestor::tr//a[contains(string(),'Delete')]";


}
