package tests;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.AuthenticationPage;
import pages.MainNavigation;

public class BaseTests {
	WebDriver driver;
	ExcelReader excelReader;
	MainNavigation mainNavigation;
	AuthenticationPage authenticationPage;
	String homeUrl;
	String logInTestsSheetName;
	
	@BeforeClass
	public void preSihTestova() throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		excelReader =  new ExcelReader("data/AutomationPracticeTestPlan.xlsx");
		mainNavigation = new MainNavigation(driver);
		authenticationPage = new AuthenticationPage(driver);
		homeUrl = "http://automationpractice.com/";
		logInTestsSheetName = "Login Test";
	}
	@AfterClass
	public void posleSihTestova() {
		driver.close();
	}
}