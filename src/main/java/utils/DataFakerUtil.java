package utils;

import java.util.Locale;

import com.github.javafaker.Faker;

public class DataFakerUtil {
	public Locale locale = new Locale("en");
	public Faker faker = new Faker(locale);
	
	public static DataFakerUtil getData() {
		return new DataFakerUtil();
	}
	
	public String getFirstName() {
		return faker.address().firstName();
	}
	
	public String getLastName() {
		return faker.address().lastName();
	}
	
	public String getEmail() {
		return faker.internet().emailAddress();
	}
	
	public String getCreditCard() {
		return faker.finance().creditCard();
	}
	
	public String getZipCode() {
		return faker.address().zipCode();
	}
	
	public String getImage() {
		return faker.internet().image();
	}
}
