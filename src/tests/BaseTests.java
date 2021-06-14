package tests;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.AuthenticationPage;
import pages.CreateAnAccountPage;
import pages.ForgotYourPasswordPage;
import pages.MainNavigation;

public class BaseTests {
	WebDriver driver;
	ExcelReader excelReader;
	MainNavigation mainNavigation;
	AuthenticationPage authenticationPage;
	CreateAnAccountPage createAnAccountPage;
	ForgotYourPasswordPage forgotYourPasswordPage;
	
	//URLs and sheet names
	String homeUrl;
	String logInTestsSheetName;
	String createAnAccountSheetName;
	
	@BeforeClass
	public void setUp() throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		excelReader =  new ExcelReader("data/AutomationPracticeTestPlan.xlsx");
		mainNavigation = new MainNavigation(driver);
		authenticationPage = new AuthenticationPage(driver);
		createAnAccountPage = new CreateAnAccountPage(driver);
		forgotYourPasswordPage = new ForgotYourPasswordPage(driver);
		homeUrl = "http://automationpractice.com/";
		logInTestsSheetName = "Login Tests";
		createAnAccountSheetName = "Create An Account Tests";
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}