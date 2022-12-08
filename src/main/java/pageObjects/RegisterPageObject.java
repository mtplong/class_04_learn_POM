package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	WebDriver driver;

	// constructor
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputToFirstNameTextbox(String firstname) {
		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstname);
	}
	
	public void inputToLastNameTextbox(String lastname) {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastname);
	}
	
	public void inputToEmailTextbox(String email) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
	}
	
	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
	}
	
	public void inputToConfirmPasswordTextbox(String confirmPass) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPass);
	}
	
	public void clickToRegisterButton() {
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}
	
	public boolean isRegisterSuccess(String value) {
		String message = getTextOfElement(driver, RegisterPageUI.VALID_INFORMATION_MESSAGE);
		return message.equals(value);
	}
}
