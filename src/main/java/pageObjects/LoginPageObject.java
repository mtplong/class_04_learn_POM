package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;
	
	// constructor
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputToEmailTextbox(String email) {
		sendKeysToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}
	
	public void inputToPasswordTextbox(String email) {
		sendKeysToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, email);
	}
	
	public void clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}
	
	public boolean isEmailErrorMessage(String value) {
		String message = getTextOfElement(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
		return message.equals(value);
	}
	
	public boolean isLoginErrorMessage(String value) {
		String message = getTextOfElement(driver, LoginPageUI.LOGIN_ERROR_MESSAGE);
		return message.contains(value);
	}
}


