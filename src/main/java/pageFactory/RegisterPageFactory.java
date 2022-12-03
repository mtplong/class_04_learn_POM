package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.BasePage;

public class RegisterPageFactory extends BasePage {
	WebDriver driver;

	@FindBy(xpath = "//input[@id='FirstName']")
	WebElement firstNameTextbox;

	@FindBy(id = "LastName")
	@CacheLookup
	WebElement lastNameTextbox;
	
	@FindBy(id = "Email")
	WebElement emailTextbox;
	
	@FindBy(id = "Password")
	WebElement passwordTextbox;
	
	@FindBy(id = "ConfirmPassword")
	WebElement confirmPasswordTextbox;
	
	@FindBy(id = "register-button")
	WebElement registerButton;
	
	@FindBy(xpath = "//div[@class='result' and text()='Your registration completed']")
	WebElement successMessage;
	
	public RegisterPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void inputToFirstNameTextbox(String firstname) {
		sendKeysToElement(driver, firstNameTextbox, firstname);
	}
	
	public void inputToLastNameTextbox(String lastname) {
		sendKeysToElement(driver, lastNameTextbox, lastname);
	}
	
	public void inputToEmailTextbox(String email) {
		sendKeysToElement(driver, emailTextbox, email);
	}
	
	public void inputToPasswordTextbox(String password) {
		sendKeysToElement(driver, passwordTextbox, password);
	}
	
	public void inputToConfirmPasswordTextbox(String confirmPass) {
		sendKeysToElement(driver, confirmPasswordTextbox, confirmPass);
	}
	
	public void clickToRegisterButton() {
		clickToElement(driver, registerButton);
	}
	
	public boolean isRegisterSuccess() {
		return isElementDisplayed(driver, successMessage);
	}
	
}
