package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CreateAnAccountPage {
	WebDriver driver;
	WebElement registerButton;
//Mandatory fields web elements
	WebElement personalInfoFirstNameField;
	WebElement personalInfoLastNameField;
	WebElement personalInfoEmailAddressField;
	WebElement personalInfoPasswordField;
	WebElement addressSectionFirstNameField;
	WebElement addressSectionLastNameField;
	WebElement addressSectionAddress1Field;
	WebElement addressSectionCityField;
	WebElement addressSectionStateDropdownMenu;
	WebElement addressSectionZipCodeField;
	WebElement addressSectionCountryDropdownMenu;
	WebElement addressSectionHomePhoneField;
	WebElement addressSectionMobilePhoneField;
	WebElement addressSectionAliasField;
//Mandatory fields locators
	By registerButtonLocator = By.id("submitAccount");
	By personalInfoFirstNameFieldLocator = By.id("customer_firstname");
	By personalInfoLastNameFieldLovator = By.id("customer_lastname");
	By personalInfoEmailAddressFieldLocator = By.id("email");
	By personalInfoPasswordFieldLocator = By.id("passwd");
	By addressSectionFirstNameFieldLocator = By.id("firstname");
	By addressSectionLastNameFieldLocator = By.id("lastname");
	By addressSectionAddress1FieldLocator = By.id("address1");
	By addressSectionCityFieldLocator = By.id("city");
	By addressSectionStateDropdownMenuLocator = By.id("id_state");
	By addressSectionZipCodeFieldLocator = By.id("postcode");
	By addressSectionCountryDropdownMenuLocator = By.id("id_country");
	By addressSectionHomePhoneFieldLocator = By.id("phone");
	By addressSectionMobilePhoneFieldLocator = By.id("phone_mobile");
	By addressSectionAliasFieldLocator = By.id("alias");

	public CreateAnAccountPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

//Mandatory fields getters
	public WebElement getRegisterButton() {
		return driver.findElement(registerButtonLocator);
	}

	public WebElement getPersonalInfoFirstNameField() {
		return driver.findElement(personalInfoFirstNameFieldLocator);
	}

	public WebElement getPersonalInfoLastNameField() {
		return driver.findElement(personalInfoLastNameFieldLovator);
	}

	public WebElement getPersonalInfoEmailAddressField() {
		return driver.findElement(personalInfoEmailAddressFieldLocator);
	}

	public WebElement getPersonalInfoPasswordField() {
		return driver.findElement(personalInfoPasswordFieldLocator);
	}

	public WebElement getAddressSectionFirstNameField() {
		return driver.findElement(addressSectionFirstNameFieldLocator);
	}

	public WebElement getAddressSectionLastNameField() {
		return driver.findElement(addressSectionLastNameFieldLocator);
	}

	public WebElement getAddressSectionAddress1Field() {
		return driver.findElement(addressSectionAddress1FieldLocator);
	}

	public WebElement getAddressSectionCityField() {
		return driver.findElement(addressSectionCityFieldLocator);
	}

	public WebElement getAddressSectionStateDropdownMenu() {
		return driver.findElement(addressSectionStateDropdownMenuLocator);
	}

	public WebElement getAddressSectionZipCodeField() {
		return driver.findElement(addressSectionZipCodeFieldLocator);
	}

	public WebElement getAddressSectionCountryDropdownMenu() {
		return driver.findElement(addressSectionCountryDropdownMenuLocator);
	}

	public WebElement getAddressSectionHomePhoneField() {
		return driver.findElement(addressSectionHomePhoneFieldLocator);
	}

	public WebElement getAddressSectionMobilePhoneField() {
		return driver.findElement(addressSectionMobilePhoneFieldLocator);
	}

	public WebElement getAddressSectionAliasField() {
		return driver.findElement(addressSectionAliasFieldLocator);
	}

//Register button methods
	public boolean presenceOfRegisterButton() {
		try {
			getRegisterButton();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean visibilityOfRegisterButton() {
		if (getRegisterButton().isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public void clickOnRegisterButton() {
		getRegisterButton().click();
	}

//Dropdown menus methods
	public void selectFromStateDropdownMenu(String stateName) {
		addressSectionStateDropdownMenu = driver.findElement(addressSectionStateDropdownMenuLocator);
		Select stateDropdownMenu = new Select(addressSectionStateDropdownMenu);
		stateDropdownMenu.selectByVisibleText(stateName);
	}
	
	public void selectAddressSectionCountryDropdownMenu(String country) {
		addressSectionCountryDropdownMenu = driver.findElement(addressSectionCountryDropdownMenuLocator);
		Select stateDropdownMenu = new Select(addressSectionCountryDropdownMenu);
		stateDropdownMenu.selectByVisibleText(country);
	}

//Fill text form methods
	public void fillPersonalInfoFirstNameField(String firstName) {
		getPersonalInfoFirstNameField().sendKeys(firstName);
	}
	
	public void fillPersonalInfoLastNameField(String lastName) {
		getPersonalInfoFirstNameField().sendKeys(lastName);
	}
	
	public void fillPersonalInfoEmailField(String emailAddress) {
		getPersonalInfoEmailAddressField().sendKeys(emailAddress);
	}
	
	public void fillPersonalInfoPasswordField(String password) {
		getPersonalInfoFirstNameField().sendKeys(password);
	}
	
	public void fillAddressSectionFirstNameField(String firstName) {
		getAddressSectionFirstNameField().sendKeys(firstName);;
	}

	public void fillAddressSectionLastNameField(String lastName) {
		getAddressSectionLastNameField().sendKeys(lastName);
	}

	public void fillAddressSectionAddress1Field(String address) {
		getAddressSectionAddress1Field().sendKeys(address);
	}

	public void fillAddressSectionCityField(String city) {
		getAddressSectionCityField().sendKeys(city);
	}

	public void fillAddressSectionZipCodeField(String zipCode) {
		getAddressSectionZipCodeField().sendKeys(zipCode);
	}

	public void fillAddressSectionHomePhoneField(String homePhone) {
		getAddressSectionHomePhoneField().sendKeys(homePhone);
	}

	public void fillAddressSectionMobilePhoneField(String mobilePhone) {
		getAddressSectionMobilePhoneField().sendKeys(mobilePhone);
	}

	public void fillAddressSectionAliasField(String alias) {
		getAddressSectionAliasField().sendKeys(alias);
	}
}