package extendedTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import utils.ExcelUtil;

public class TS_DataDrivenExcel extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	HomePageObject homePage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, "https://demo.nopcommerce.com/login?returnurl=%2F");
		loginPage = new LoginPageObject(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	@Test
	public void TC_01_LoginWithExcelData() throws IOException {
		ExcelUtil.setExcelFile("Auto");
		
		// Không chạy vòng lặp, chỉ duyệt 1 record cụ thể trong Sheet
//		String excelEmail = ExcelUtil.getCellData(1, 1);
//		String excelPassWord = ExcelUtil.getCellData(1, 2);
//		
//		loginPage.inputToEmailTextbox(excelEmail);
//		loginPage.inputToPasswordTextbox(excelPassWord);
//		loginPage.clickToLoginButton();
//		homePage = new HomePageObject(driver);
//		String url = homePage.getCurrentPageUrl(driver);
//		if (url.equals("https://demo.nopcommerce.com/")) {
//			ExcelUtil.setCellData("Passed", 1, 3);
//		} else {
//			ExcelUtil.setCellData("Failed", 1, 3);
//		}
		
		// Chạy vòng lặp, duyệt hết tất cả record trong Sheet
		for(int i = 1; i <= ExcelUtil.getRowCountInSheet(); i++) {
			String excelEmail = ExcelUtil.getCellData(i, 1);
			String excelPassWord = ExcelUtil.getCellData(i, 2);
			
			loginPage.inputToEmailTextbox(excelEmail);
			loginPage.inputToPasswordTextbox(excelPassWord);
			loginPage.clickToLoginButton();
			homePage = new HomePageObject(driver);
			String url = homePage.getCurrentPageUrl(driver);
			if (url.equals("https://demo.nopcommerce.com/")) {
				ExcelUtil.setCellData("Passed", i, 3);
				homePage.clickToLogout();
				homePage.clickToLogin();
			} else {
				ExcelUtil.setCellData("Failed", i, 3);
			}
		}
	}
}
