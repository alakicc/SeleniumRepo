package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotYourPasswordPage {
WebDriver driver;
WebElement emailAddressField;
WebElement retrievePasswordButton;
WebElement unregisteredEmailErrorMessage;
WebElement confirmationMessage;

By emailAddressFieldLocator = By.id("email");
By retrievePasswordButtonLocator = By.xpath("//*[@id=\"form_forgotpassword\"]/fieldset/p/button");
By unregisteredEmailErrorMessageLocator = By.className("alert-danger");
By confirmationMessageLocator = By.className("alert-success");

public ForgotYourPasswordPage(WebDriver driver) {
	super();
	this.driver = driver;
}
public WebElement getEmailAddressField() {
	return driver.findElement(emailAddressFieldLocator);
}
public WebElement getRetrievePasswordButton() {
	return driver.findElement(retrievePasswordButtonLocator);
}
public WebElement getUnregisteredEmailErrorMessage() {
	return driver.findElement(unregisteredEmailErrorMessageLocator);
}
public WebElement getConfirmationMessage() {
	return driver.findElement(confirmationMessageLocator);
}
public void fillEmailAddressInputField(String emailAddress) {
	getEmailAddressField().sendKeys(emailAddress);
}

public void clickOnRetrievePasswordButton () {
	getRetrievePasswordButton().click();
}

public boolean visibilityOfUnregisteredEmailMessage() {
	if (getUnregisteredEmailErrorMessage().isDisplayed()) {
		return true;
	} else {
		return false;
	}
}

public String getUnregisteredEmailErrorMessageText() {
	return getUnregisteredEmailErrorMessage().getText();
}

public boolean visibilityOfConfirmationMessage() {
	if (getConfirmationMessage().isDisplayed()) {
		return true;
	} else {
		return false;
	}
}

public String getConfirmationMessageText() {
	return getConfirmationMessage().getText();
}

public boolean presenceOfRetrievePasswordButton() {
	try {
		getRetrievePasswordButton();
		return true;
	} catch(NoSuchElementException e) {
		return false;
	}
}

}
