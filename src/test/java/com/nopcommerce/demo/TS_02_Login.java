package com.nopcommerce.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import common.BaseTest;
import pageObjects.LoginPageObject;
import reportConfigV5.ExtentTestManager;

public class TS_02_Login extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	
	String email = "abcd";
	String email2 = "abcd@gmail.com";
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, "https://demo.nopcommerce.com/login?returnUrl=%2F");
		loginPage = new LoginPageObject(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	@Test
	public void TC_01_LoginWithEmptyData() {
		// Use for Extent Report v5
		ExtentTestManager.startTest("TC_01_LoginWithEmptyData", "");
		ExtentTestManager.getTest().log(Status.INFO, "Step 1: click register button without input anything");
		loginPage.clickToLoginButton();
		ExtentTestManager.getTest().log(Status.INFO, "Step 2: verify error message");
		Assert.assertTrue(loginPage.isEmailErrorMessage("Please enter your email"));
	}
	
	@Test
	public void TC_02_LoginWithInvalidData() {
		ExtentTestManager.startTest("TC_02_LoginWithInvalidData", "");
		loginPage.refeshCurrentPage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "input email: " + email);
		loginPage.inputToEmailTextbox(email);
		
		ExtentTestManager.getTest().log(Status.INFO, "click login");
		loginPage.clickToLoginButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "verify error message");
		// Assert failed to take screenshot
		Assert.assertTrue(loginPage.isEmailErrorMessage("Wrong email..."));
	}
	
	@Test
	public void TC_03_LoginWithUnregisteredEmail() {
		ExtentTestManager.startTest("TC_03_LoginWithUnregisteredEmail", "");
		loginPage.refeshCurrentPage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "input email: " + email2);
		loginPage.inputToEmailTextbox(email2);
		
		ExtentTestManager.getTest().log(Status.INFO, "click login");
		loginPage.clickToLoginButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "verify error message");
		Assert.assertTrue(loginPage.isLoginErrorMessage("Login was unsuccessful. Please correct the errors and try again."));
		Assert.assertTrue(loginPage.isLoginErrorMessage("No customer account found"));
	}
}

