package com.nopcommerce.demo;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import common.GlobalContants;
import pageFactory.RegisterPageFactory;
import pageObjects.RegisterPageObject;
import utils.DataFakerUtil;

public class TS_00_Precondition extends BaseTest {
	WebDriver driver;

//	RegisterPageObject registerPage;
	RegisterPageFactory registerPageFactory;
	DataFakerUtil dataFaker;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, "https://demo.nopcommerce.com/register?returnUrl=%2F");

//		registerPage = new RegisterPageObject(driver);
		registerPageFactory = new RegisterPageFactory(driver);
		dataFaker = DataFakerUtil.getData();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

//	@Test
//	public void TC_01_CreateAccountForTesting() {
//		registerPage.inputToFirstNameTextbox("autoTest");
//		registerPage.inputToLastNameTextbox("auto");
//		registerPage.inputToEmailTextbox("autoTestWeb@gmail.com");
//		registerPage.inputToPasswordTextbox("123456");
//		registerPage.inputToConfirmPasswordTextbox("123456");
//		registerPage.clickToRegisterButton();
//		Assert.assertTrue(registerPage.isRegisterSuccess("Your registration completed"));
//	}

	@Test
	public void TC_01_CreateAccountForTestingUsingPageFactory() {
		System.out.println("Faker email: " + dataFaker.getEmail());
		System.out.println("Faker zip code: " + dataFaker.getZipCode());
		System.out.println("Faker credit card: " + dataFaker.getCreditCard());
		System.out.println("Faker first name: " + dataFaker.getFirstName());
		System.out.println("Faker image: " + dataFaker.getImage());

//		registerPageFactory.inputToFirstNameTextbox(dataFaker.getFirstName());
//		registerPageFactory.inputToLastNameTextbox(dataFaker.getLastName());
//		registerPageFactory.inputToEmailTextbox(GlobalContants.email);
//		registerPageFactory.inputToPasswordTextbox(GlobalContants.password);
//		registerPageFactory.inputToConfirmPasswordTextbox(GlobalContants.password);
//		registerPageFactory.clickToRegisterButton();
//		Assert.assertTrue(registerPageFactory.isRegisterSuccess());
	}

}
