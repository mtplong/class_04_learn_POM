package dataTableTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.dataTable.HomePageObject;

public class DataTable extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, "https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/");
		homePage = new HomePageObject(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
//	@Test
	public void TC_01_Paging() {
		homePage.openPageByNumber("5");
		Assert.assertTrue(homePage.isPageActivedByNumber("5"));
		sleepInSecond(3);
		homePage.openPageByNumber("10");
		Assert.assertTrue(homePage.isPageActivedByNumber("10"));
		sleepInSecond(3);
	}
	
	@Test
	public void TC_02_SearchAndVerify() {
		homePage.refeshCurrentPage(driver);
		homePage.inputToHeaderTextboxByName("Country", "AFRICA");
		Assert.assertTrue(homePage.isRowValueDisplay("12253515", "AFRICA", "12599691", "24853148"));
		sleepInSecond(3);
		homePage.refeshCurrentPage(driver);
		homePage.clickToIconByCountryName("AFRICA", "remove");
		homePage.inputToHeaderTextboxByName("Country", "AFRICA");
		Assert.assertTrue(homePage.isDataRemoved("12253515", "AFRICA", "12599691", "24853148"));
		sleepInSecond(3);
	}
}
