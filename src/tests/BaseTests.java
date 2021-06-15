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
import pages.MyAccountPage;
import pages.MyAddressesPage;
import pages.MyPersonalInformationPage;
import pages.MyWishlistsPage;
import pages.NewAddressFormularPage;

public class BaseTests {
	WebDriver driver;
	ExcelReader excelReader;
	MainNavigation mainNavigation;
	AuthenticationPage authenticationPage;
	CreateAnAccountPage createAnAccountPage;
	ForgotYourPasswordPage forgotYourPasswordPage;
	MyAccountPage myAccountPage;
	MyAddressesPage myAddressesPage;
	NewAddressFormularPage newAddressFormularPage;
	MyPersonalInformationPage myPersonalInformationPage;
	MyWishlistsPage myWishlistsPage;
	
	//URLs and sheet names
	String homeUrl;
	String logInTestsSheetName;
	String createAnAccountSheetName;
	String myAccountTestsSheetName;
	
	@BeforeClass
	public void setUp() throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		excelReader =  new ExcelReader("data/AutomationPracticeTestPlan.xlsx");
		mainNavigation = new MainNavigation(driver);
		authenticationPage = new AuthenticationPage(driver);
		createAnAccountPage = new CreateAnAccountPage(driver);
		forgotYourPasswordPage = new ForgotYourPasswordPage(driver);
		myAccountPage = new MyAccountPage(driver);
		myAddressesPage = new MyAddressesPage(driver);
		newAddressFormularPage = new NewAddressFormularPage(driver);
		myPersonalInformationPage = new MyPersonalInformationPage(driver);
		myWishlistsPage = new MyWishlistsPage(driver);
		
		homeUrl = "http://automationpractice.com/";
		logInTestsSheetName = "Login Tests";
		createAnAccountSheetName = "Create An Account Tests";
		myAccountTestsSheetName = "My Account Tests";
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}