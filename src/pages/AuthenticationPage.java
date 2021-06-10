package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthenticationPage {
WebDriver driver;
WebElement loginEmailInputField;
WebElement loginPasswordInputField;
WebElement signInButton;
WebElement loginErrorMessage;

By loginEmailInputFieldLocator = By.id("email");
By loginPasswordInputFieldLocator = By.id("passwd");
By signInButtonLocator = By.id("SubmitLogin");
By loginErrorMessageLocator = By.cssSelector(".alert.alert-danger");

public AuthenticationPage (WebDriver driver){
	this.driver = driver;
}
public WebElement getLoginEmailInputField() {
	return driver.findElement(loginEmailInputFieldLocator);
}
public WebElement getLoginPasswordInputField() {
	return driver.findElement(loginPasswordInputFieldLocator);
}
public WebElement getSignInButton() {
	return driver.findElement(signInButtonLocator);
}

public WebElement getLoginErrorMessage() {
	return driver.findElement(loginErrorMessageLocator);
}
public void fillLoginEmailInputField (String email) {
	getLoginEmailInputField().sendKeys(email);
}

public void fillLoginPasswordInputField (String password) {
	getLoginPasswordInputField().sendKeys(password);
}

public void clickOnSignInButton () {
	getSignInButton().click();
}

public boolean visibilityOfLoginErrorMessage() {
	if (getLoginErrorMessage().isDisplayed()) {
		return true;
	} else {
		return false;
	}
}

public String getLoginErrorMessageText() {
	return getLoginErrorMessage().getText();
}

public void clearLoginInputFields() {
	getLoginEmailInputField().clear();
	getLoginPasswordInputField().clear();
}

}
