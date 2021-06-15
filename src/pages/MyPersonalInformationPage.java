package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyPersonalInformationPage extends CreateAnAccountPage {
WebElement saveButton;
WebElement currentPasswordField;
WebElement successMessage;
WebElement errorMessage;

By saveButtonLocator = By.name("submitIdentity");
By currentPasswordFieldLocator = By.id("old_passwd");
By successMessageLocator = By.cssSelector(".alert.alert-success");
By errorMessageLocator = By.cssSelector(".alert.alert-danger");

public MyPersonalInformationPage(WebDriver driver) {
	super(driver);
	// TODO Auto-generated constructor stub
}

public WebElement getSaveButton() {
	return driver.findElement(saveButtonLocator);
}

public WebElement getSuccessMessage() {
	return driver.findElement(successMessageLocator);
}

public WebElement getErrorMessage() {
	return driver.findElement(errorMessageLocator);
}

public WebElement getCurrentPasswordField() {
	return driver.findElement(currentPasswordFieldLocator);
}

public void clickOnSaveButton() {
	getSaveButton().click();
}

public void clearAllFields() {
	super.getAddressSectionFirstNameField().clear();
	super.getAddressSectionLastNameField().clear();
	super.getPersonalInfoEmailAddressField().clear();
	super.getPersonalInfoPasswordField().clear();
}

public void fillCurrentPasswordField (String currentPassword) {
	getCurrentPasswordField().sendKeys(currentPassword);
}

public String getSuccessMessageText() {
	return getSuccessMessage().getText();
}

public String getErrorMessageText() {
	return getErrorMessage().getText();
}

}
