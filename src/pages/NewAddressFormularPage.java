package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewAddressFormularPage extends CreateAnAccountPage{
WebElement saveButton;
WebElement newAddressErrorMessage;

By saveButtonLocator = By.id("submitAddress");
By newAddressErrorMessageLocator = By.cssSelector(".alert.alert-danger");

	public NewAddressFormularPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public WebElement getSaveButton() {
		return driver.findElement(saveButtonLocator);
	}
	
	public WebElement getNewAddressErrorMessage() {
		return driver.findElement(newAddressErrorMessageLocator);
	}

	public void clickOnSaveButton() {
		getSaveButton().click();
	}
	
	public void clearFields() {
		super.getAddressSectionFirstNameField().clear();
		super.getAddressSectionLastNameField().clear();
		super.getAddressSectionAliasField().clear();
	}
	
	public void clearAllFields() {
		super.getAddressSectionFirstNameField().clear();
		super.getAddressSectionLastNameField().clear();
		super.getAddressSectionAddress1Field().clear();
		super.getAddressSectionCityField().clear();
		super.getAddressSectionHomePhoneField().clear();
		super.getAddressSectionMobilePhoneField().clear();
		super.getAddressSectionZipCodeField().clear();
		super.getAddressSectionAliasField().clear();
	}
	
	public String getNewAddressErrorMessageText() {
		return getNewAddressErrorMessage().getText();
	}
	
	public boolean visibilityOfSaveButton() {
		if(getSaveButton().isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	
	
}
