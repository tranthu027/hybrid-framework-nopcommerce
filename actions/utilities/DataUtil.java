package utilities;

import com.github.javafaker.Faker;

public class DataUtil {
	private Faker faker;
	
	public static DataUtil getData() {
		return new DataUtil();
	}
	public DataUtil() {
		faker = new Faker();
	}
	public String getPreFirstName() {
		return faker.address().firstName();
	}
	public String getFirstName() {
		return faker.address().firstName();
	}
	public String getEditFirstName() {
		return faker.address().firstName();
	}
	
	public String getLastName() {
		return faker.address().lastName();
	}
	public String getPreLastName() {
		return faker.address().lastName();
	}	public String getEditLastName() {
		return faker.address().lastName();
	}
	
	public String getEmailAdress() {
		return faker.internet().emailAddress();
	}
	public String getEditEmailAdress() {
		return faker.internet().emailAddress();
	}
	public String getPreEmailAdress() {
		return faker.internet().emailAddress();
	}
	
	public String getPassword() {
		return faker.internet().password();
	}
	public String getEditPassword() {
		return faker.internet().password();
	}
	
	public String getUsername() {
		return faker.name().username();
	}
	public String getEditUsername() {
		return faker.name().username();
	}
	
	public String getCountryName() {
		return faker.address().country();
	}
	
	public String getZipCode() {
		return faker.address().countryCode();
	}
	public String getEditZipCode() {
		return faker.address().countryCode();
	}
	public String getCityName() {
		return faker.address().city();
	}
	public String getEditCityName() {
		return faker.address().city();
	}
	public String getPhoneNumber() {
		return faker.phoneNumber().cellPhone();
	}
	public String getEditPhoneNumber() {
		return faker.phoneNumber().cellPhone();
	}
	public String getFaxNumber() {
		return faker.phoneNumber().phoneNumber();
	}
	public String getEditFaxNumber() {
		return faker.phoneNumber().phoneNumber();
	}
	public String getfullAddress01() {
		return faker.address().fullAddress();
	}
	public String getEditFullAddress01() {
		return faker.address().fullAddress();
	}
	public String getfullAddress02() {
		return faker.address().fullAddress();
	}
	public String getEditFullAddress02() {
		return faker.address().fullAddress();
	}
	public String getCardCode() {
		return faker.finance().creditCard();
	}
	
	public String getCompanyName() {
		return faker.company().name();
	}
	public String getEditCompanyName() {
		return faker.company().name();
	}
}
