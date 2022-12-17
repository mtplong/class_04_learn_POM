package common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public WebDriverWait explicitWait;
	public Actions action;
	public long timeout = GlobalContants.explicit_timeout;

	// getter
	public static BasePage getBasePage() {
		return new BasePage();
	}
	
	/////////////////////////////////
	public void openUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}
	
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	public void refeshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	//////////////////////
	public By getByXpath(String locator) {
		return By.xpath(locator);
	}
	
	public By getByXpath(String locator, String... params) {
		return By.xpath(String.format(locator, (Object[])params));
	}
	
	public WebElement findElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}
	
	public WebElement findElement(WebDriver driver, String locator, String... params) {
		return driver.findElement(getByXpath(locator, params));
	}
	
	public List<WebElement> findElements(WebDriver driver, String locator, String... params) {
		return driver.findElements(getByXpath(locator, params));
	}
	
	public void sendKeysToElement(WebDriver driver, String locator, String valueInput) {
		findElement(driver, locator).clear();
		findElement(driver, locator).sendKeys(valueInput);
	}
	
	public void sendKeysToElement(WebDriver driver, String locator, String valueInput, String... params) {
		findElement(driver, locator, params).clear();
		findElement(driver, locator, params).sendKeys(valueInput);
	}
	
	public void clickToElement(WebDriver driver, String locator) {
		findElement(driver, locator).click();
	}
	
	public void clickToElement(WebDriver driver, String locator, String... params) {
		findElement(driver, locator, params).click();
	}
	
	public String getTextOfElement(WebDriver driver, String locator) {
		return findElement(driver, locator).getText();
	}
	
	public void pressKeyToElement(WebDriver driver, String locator, Keys key, String... params) {
		action = new Actions(driver);
		action.sendKeys(findElement(driver, locator, params), key).perform();
	}
	
	public void waitForElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}
	
	public void waitForElementVisible(WebDriver driver, String locator, String... params) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator, params)));
	}
	
	public void waitForElementClickable(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}
	
	public void waitForElementClickable(WebDriver driver, String locator, String... params) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator, params)));
	}
	
	public void waitForElementStaleness(WebDriver driver, String locator, String... params) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.stalenessOf(findElement(driver, locator, params)));
	}
	
	public boolean isElementDisplayed(WebDriver driver, String locator, String... params) {
		return findElement(driver, locator, params).isDisplayed();
	}
	
	public boolean isElementExist(WebDriver driver, String locator, String... params) {
		List<WebElement> elementList = findElements(driver, locator, params);
		if(elementList.size() == 0)
			return true;
		else 
			return false;
	}
	
	///////////////////////////////////////////////
	///////// USE FOR PAGE FACTORY ///////////////
	public void sendKeysToElement(WebDriver driver, WebElement element, String valueInput) {
		element.clear();
		element.sendKeys(valueInput);
	}
	
	public void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}
	
	public boolean isElementDisplayed(WebDriver driver, WebElement element) {
		return element.isDisplayed();
	}
}
