package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTests extends BaseTests{
@BeforeMethod
public void beforeTest() {
	driver.navigate().to(homeUrl);
	driver.manage().window().maximize();
}

@Test (priority = 0)
public void logInValidCredentials() {
	mainNavigation.clickOnSignInNavigationButton();
	authenticationPage.fillLoginEmailInputField(excelReader.getStringData(logInTestsSheetName, 7, 2));
	authenticationPage.fillLoginPasswordInputField(excelReader.getStringData(logInTestsSheetName, 8, 2));
	authenticationPage.clickOnSignInButton();
	assertEquals(mainNavigation.visibilityOfSignOutNavigationButton(), true);
	assertEquals(mainNavigation.visibilityOfMyAccountNavigationButton(), true);
	
}


@Test (priority = 5)
public void logInInvalidCredentials() {
	mainNavigation.clickOnSignInNavigationButton();
	for (int i = 3; i < 8; i++) {
		authenticationPage.clearLoginInputFields();
		authenticationPage.fillLoginEmailInputField(excelReader.getStringData(logInTestsSheetName, 7, i));
		authenticationPage.fillLoginPasswordInputField(excelReader.getStringData(logInTestsSheetName, 8, i));
		authenticationPage.clickOnSignInButton();
		assertEquals(authenticationPage.visibilityOfLoginErrorMessage(), true);
		assertEquals(authenticationPage.getLoginErrorMessageText(), excelReader.getStringData(logInTestsSheetName, 12, i));
		driver.navigate().refresh();
	}
	
}

@Test (priority = 10)
public void logOutTest() {
	logInValidCredentials();
	mainNavigation.clickOnSignOutNavigationButton();
	assertEquals(mainNavigation.visibilityOfSignInNavigationButton(), true);
}

@AfterMethod
public void afterTest() {
	driver.manage().deleteAllCookies();
	driver.navigate().refresh();
}
}
