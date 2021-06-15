package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyPersonalInformationTests extends BaseTests {
	@BeforeMethod
	public void beforeTest() {
		driver.navigate().to(homeUrl);
		driver.manage().window().maximize();
		mainNavigation.clickOnSignInNavigationButton();
		authenticationPage.fillLoginEmailField(excelReader.getStringData(logInTestsSheetName, 7, 2));
		authenticationPage.fillLoginPasswordField(excelReader.getStringData(logInTestsSheetName, 8, 2));
		authenticationPage.clickOnSignInButton();
		mainNavigation.clickOnMyAccountNavigationButton();
		
	}


@Test (priority = 0)
public void personalInformationValidData() {
	myAccountPage.clickOnMyPersonalInformationButton();
	myPersonalInformationPage.clearAllFields();
	myPersonalInformationPage.fillAddressSectionFirstNameField(excelReader.getStringData(myAccountTestsSheetName, 76, 2));
	myPersonalInformationPage.fillAddressSectionLastNameField(excelReader.getStringData(myAccountTestsSheetName, 77, 2));
	myPersonalInformationPage.fillPersonalInfoEmailField(excelReader.getStringData(myAccountTestsSheetName, 78, 2));
	myPersonalInformationPage.fillCurrentPasswordField(excelReader.getStringData(myAccountTestsSheetName, 79, 2));
	myPersonalInformationPage.clickOnSaveButton();
	assertEquals(myPersonalInformationPage.getSuccessMessageText(), excelReader.getStringData(myAccountTestsSheetName, 84, 2));
}

@Test (priority = 5)
public void personalInformationIncorrectCurrentPassword() {
	myAccountPage.clickOnMyPersonalInformationButton();
	myPersonalInformationPage.clearAllFields();
	myPersonalInformationPage.fillAddressSectionFirstNameField(excelReader.getStringData(myAccountTestsSheetName, 76, 3));
	myPersonalInformationPage.fillAddressSectionLastNameField(excelReader.getStringData(myAccountTestsSheetName, 77, 3));
	myPersonalInformationPage.fillPersonalInfoEmailField(excelReader.getStringData(myAccountTestsSheetName, 78, 3));
	myPersonalInformationPage.fillCurrentPasswordField(excelReader.getStringData(myAccountTestsSheetName, 79, 3));
	myPersonalInformationPage.fillPersonalInfoPasswordField(excelReader.getStringData(myAccountTestsSheetName, 80, 3));
	myPersonalInformationPage.clickOnSaveButton();
	assertEquals(myPersonalInformationPage.getErrorMessageText(), excelReader.getStringData(myAccountTestsSheetName, 84, 3));
}

@Test (priority = 10)
public void personalInformationIvalidNewPassword() {
	myAccountPage.clickOnMyPersonalInformationButton();
	myPersonalInformationPage.clearAllFields();
	myPersonalInformationPage.fillAddressSectionFirstNameField(excelReader.getStringData(myAccountTestsSheetName, 76, 4));
	myPersonalInformationPage.fillAddressSectionLastNameField(excelReader.getStringData(myAccountTestsSheetName, 77, 4));
	myPersonalInformationPage.fillPersonalInfoEmailField(excelReader.getStringData(myAccountTestsSheetName, 78, 4));
	myPersonalInformationPage.fillCurrentPasswordField(excelReader.getStringData(myAccountTestsSheetName, 79, 4));
	myPersonalInformationPage.fillPersonalInfoPasswordField(excelReader.getStringData(myAccountTestsSheetName, 80, 4));
	myPersonalInformationPage.clickOnSaveButton();
	assertEquals(myPersonalInformationPage.getErrorMessageText(), excelReader.getStringData(myAccountTestsSheetName, 84, 4));
}

@Test (priority = 15)
public void personalInformationIvalidEmailFormat() {
	myAccountPage.clickOnMyPersonalInformationButton();
	myPersonalInformationPage.clearAllFields();
	myPersonalInformationPage.fillAddressSectionFirstNameField(excelReader.getStringData(myAccountTestsSheetName, 76, 5));
	myPersonalInformationPage.fillAddressSectionLastNameField(excelReader.getStringData(myAccountTestsSheetName, 77, 5));
	myPersonalInformationPage.fillPersonalInfoEmailField(excelReader.getStringData(myAccountTestsSheetName, 78, 5));
	myPersonalInformationPage.fillCurrentPasswordField(excelReader.getStringData(myAccountTestsSheetName, 79, 5));
	myPersonalInformationPage.fillPersonalInfoPasswordField(excelReader.getStringData(myAccountTestsSheetName, 80, 5));
	myPersonalInformationPage.clickOnSaveButton();
	assertEquals(myPersonalInformationPage.getErrorMessageText(), excelReader.getStringData(myAccountTestsSheetName, 84, 5));
}

@Test (priority = 20)
public void personalInformationEmptyFields() {
	myAccountPage.clickOnMyPersonalInformationButton();
	myPersonalInformationPage.clearAllFields();
	myPersonalInformationPage.fillAddressSectionFirstNameField(excelReader.getStringData(myAccountTestsSheetName, 76, 6));
	myPersonalInformationPage.fillAddressSectionLastNameField(excelReader.getStringData(myAccountTestsSheetName, 77, 6));
	myPersonalInformationPage.fillPersonalInfoEmailField(excelReader.getStringData(myAccountTestsSheetName, 78, 6));
	myPersonalInformationPage.fillCurrentPasswordField(excelReader.getStringData(myAccountTestsSheetName, 79, 6));
	myPersonalInformationPage.fillPersonalInfoPasswordField(excelReader.getStringData(myAccountTestsSheetName, 80, 6));
	myPersonalInformationPage.clickOnSaveButton();
	assertEquals(myPersonalInformationPage.getErrorMessageText(), excelReader.getStringData(myAccountTestsSheetName, 84, 6));
}

@AfterMethod
public void afterTest() {
	driver.manage().deleteAllCookies();
	driver.navigate().refresh();
}
}
