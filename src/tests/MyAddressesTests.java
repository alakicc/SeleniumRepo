package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAddressesTests extends BaseTests {
	@BeforeMethod
	public void beforeTest() {
		driver.navigate().to(homeUrl);
		driver.manage().window().maximize();
		mainNavigation.clickOnSignInNavigationButton();
		authenticationPage.fillLoginEmailField(excelReader.getStringData(logInTestsSheetName, 7, 2));
		authenticationPage.fillLoginPasswordField(excelReader.getStringData(logInTestsSheetName, 8, 2));
		authenticationPage.clickOnSignInButton();
		mainNavigation.clickOnMyAccountNavigationButton();
		myAccountPage.clickOnMyAddressesButton();
	}
//Address tests
	@Test(priority = 0)
	public void addNewAddressValidData() {
		
		int numberOfAddresses = 1;
		for (int j = 2; j < 5; j++) {
			myAddressesPage.clickOnAddNewAddressButton();
			newAddressFormularPage.clearFields();
			int i = 31;

			while (i < 41) {
				newAddressFormularPage
						.fillAddressSectionFirstNameField(excelReader.getStringData(myAccountTestsSheetName, i, j));
				i++;
				newAddressFormularPage
						.fillAddressSectionLastNameField(excelReader.getStringData(myAccountTestsSheetName, i, j));
				i++;
				newAddressFormularPage
						.fillAddressSectionAddress1Field(excelReader.getStringData(myAccountTestsSheetName, i, j));
				i++;
				newAddressFormularPage
						.fillAddressSectionCityField(excelReader.getStringData(myAccountTestsSheetName, i, j));
				i++;
				newAddressFormularPage
						.selectFromStateDropdownMenu(excelReader.getStringData(myAccountTestsSheetName, i, j));
				i++;
				newAddressFormularPage
						.fillAddressSectionZipCodeField(excelReader.getStringData(myAccountTestsSheetName, i, j));
				i++;
				newAddressFormularPage.selectAddressSectionCountryDropdownMenu(
						excelReader.getStringData(myAccountTestsSheetName, i, j));
				i++;
				newAddressFormularPage
						.fillAddressSectionHomePhoneField(excelReader.getStringData(myAccountTestsSheetName, i, j));
				i++;
				newAddressFormularPage
						.fillAddressSectionMobilePhoneField(excelReader.getStringData(myAccountTestsSheetName, i, j));
				i++;
				newAddressFormularPage
						.fillAddressSectionAliasField(excelReader.getStringData(myAccountTestsSheetName, i, j));
				i++;
				newAddressFormularPage.clickOnSaveButton();
			}
			numberOfAddresses++;
			assertEquals(myAddressesPage.getNumberOfAddresses(), numberOfAddresses);
		}

	}

	@Test(priority = 5)
	public void addNewAddressInvalidData() {
	
		myAddressesPage.clickOnAddNewAddressButton();
		for (int j = 5; j < 10; j++) {
			newAddressFormularPage.clearAllFields();
			int i = 31;

			while (i < 41) {
				newAddressFormularPage
						.fillAddressSectionFirstNameField(excelReader.getStringData(myAccountTestsSheetName, i, j));
				i++;
				newAddressFormularPage
						.fillAddressSectionLastNameField(excelReader.getStringData(myAccountTestsSheetName, i, j));
				i++;
				newAddressFormularPage
						.fillAddressSectionAddress1Field(excelReader.getStringData(myAccountTestsSheetName, i, j));
				i++;
				newAddressFormularPage
						.fillAddressSectionCityField(excelReader.getStringData(myAccountTestsSheetName, i, j));
				i++;
				newAddressFormularPage
						.selectFromStateDropdownMenu(excelReader.getStringData(myAccountTestsSheetName, i, j));
				i++;
				newAddressFormularPage
						.fillAddressSectionZipCodeField(excelReader.getStringData(myAccountTestsSheetName, i, j));
				i++;
				newAddressFormularPage.selectAddressSectionCountryDropdownMenu(
						excelReader.getStringData(myAccountTestsSheetName, i, j));
				i++;
				newAddressFormularPage
						.fillAddressSectionHomePhoneField(excelReader.getStringData(myAccountTestsSheetName, i, j));
				i++;
				newAddressFormularPage
						.fillAddressSectionMobilePhoneField(excelReader.getStringData(myAccountTestsSheetName, i, j));
				i++;
				newAddressFormularPage
						.fillAddressSectionAliasField(excelReader.getStringData(myAccountTestsSheetName, i, j));
				i++;
				newAddressFormularPage.clickOnSaveButton();

				assertEquals(newAddressFormularPage.getNewAddressErrorMessageText(),
						excelReader.getStringData(myAccountTestsSheetName, 44, j));
			}

		}

	}
	
	@Test (priority = 10)
	public void deleteAddressTest() throws InterruptedException {
		
		int numberOfAddresses = myAddressesPage.getNumberOfAddresses();
		myAddressesPage.deleteAddress();
		assertEquals(myAddressesPage.getNumberOfAddresses(), (numberOfAddresses-1));
	}
	
	@Test (priority = 15)
	public void updateAddressTest() {
		
		myAddressesPage.clickOnUpdateAddressButton();
		assertEquals(newAddressFormularPage.visibilityOfSaveButton(), true);
	}

	
	
	@AfterMethod
	public void afterTest() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
}
