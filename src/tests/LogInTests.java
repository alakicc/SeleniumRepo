package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
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
	authenticationPage.fillLoginEmailField(excelReader.getStringData(logInTestsSheetName, 7, 2));
	authenticationPage.fillLoginPasswordField(excelReader.getStringData(logInTestsSheetName, 8, 2));
	authenticationPage.clickOnSignInButton();
	assertEquals(mainNavigation.visibilityOfSignOutNavigationButton(), true);
	assertEquals(mainNavigation.visibilityOfMyAccountNavigationButton(), true);
	
}


@Test (priority = 5)
public void logInInvalidCredentials() {
	mainNavigation.clickOnSignInNavigationButton();
	for (int i = 3; i < 8; i++) {
		authenticationPage.clearLoginInputFields();
		authenticationPage.fillLoginEmailField(excelReader.getStringData(logInTestsSheetName, 7, i));
		authenticationPage.fillLoginPasswordField(excelReader.getStringData(logInTestsSheetName, 8, i));
		authenticationPage.clickOnSignInButton();
		assertEquals(authenticationPage.visibilityOfLoginErrorMessage(), true);
		assertEquals(authenticationPage.getLoginErrorMessageText(), excelReader.getStringData(logInTestsSheetName, 12, i));
		driver.navigate().refresh();
	}
	
}

@Test (priority = 10)
public void logInByPressingEnter() {
	mainNavigation.clickOnSignInNavigationButton();
	authenticationPage.fillLoginEmailField(excelReader.getStringData(logInTestsSheetName, 7, 2));
	authenticationPage.fillLoginPasswordField(excelReader.getStringData(logInTestsSheetName, 8, 2));
	authenticationPage.getLoginPasswordField().sendKeys(Keys.ENTER);;
	assertEquals(mainNavigation.visibilityOfSignOutNavigationButton(), true);
	assertEquals(mainNavigation.visibilityOfMyAccountNavigationButton(), true);
}

@Test (priority = 15)
public void forgotYourPasswordTests() {
	mainNavigation.clickOnSignInNavigationButton();
	authenticationPage.clickOnForgotYourPasswordLink();
	assertEquals(forgotYourPasswordPage.presenceOfRetrievePasswordButton(), true);
	for (int i = 3; i > 1; i--) {
		forgotYourPasswordPage.getEmailAddressField().clear();
		forgotYourPasswordPage.fillEmailAddressInputField(excelReader.getStringData(logInTestsSheetName, 61, i));
		forgotYourPasswordPage.clickOnRetrievePasswordButton();
		if(i == 3) {
			assertEquals(forgotYourPasswordPage.visibilityOfUnregisteredEmailMessage(), true);
			assertEquals(forgotYourPasswordPage.getUnregisteredEmailErrorMessageText(), excelReader.getStringData(logInTestsSheetName, 64, i));
		} else {
			assertEquals(forgotYourPasswordPage.visibilityOfConfirmationMessage(), true);
			assertEquals(forgotYourPasswordPage.getConfirmationMessageText(), excelReader.getStringData(logInTestsSheetName, 64, i));
		}
	}
	afterTest();
	
}
@Test (priority = 20)
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

public void logInUsingValidCredentials() {
	mainNavigation.clickOnSignInNavigationButton();
	authenticationPage.fillLoginEmailField(excelReader.getStringData(logInTestsSheetName, 7, 2));
	authenticationPage.fillLoginPasswordField(excelReader.getStringData(logInTestsSheetName, 8, 2));
	authenticationPage.clickOnSignInButton();
}
}
