package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthenticationPage {
	WebDriver driver;
	WebElement loginEmailField;
	WebElement loginPasswordField;
	WebElement signInButton;
	WebElement loginErrorMessage;
	WebElement createAnAccountEmailField;
	WebElement createAnAccountButton;
	WebElement createAnAccountErrorMessage;
	WebElement forgotYourPasswordLink;

	By loginEmailFieldLocator = By.id("email");
	By loginPasswordFieldLocator = By.id("passwd");
	By signInButtonLocator = By.id("SubmitLogin");
	By loginErrorMessageLocator = By.cssSelector(".alert.alert-danger");
	By createAnAccountEmailFieldLocator = By.id("email_create");
	By createAnAccountButtonLocator = By.id("SubmitCreate");
	By createAnAccountErrorMessageLocator = By.id("create_account_error");
	By forgotYourPasswordLinkLocator = By.linkText("Forgot your password?");

	public AuthenticationPage(WebDriver driver) {
		this.driver = driver;
	}

//Log in getters
	public WebElement getLoginEmailField() {
		return driver.findElement(loginEmailFieldLocator);
	}

	public WebElement getLoginPasswordField() {
		return driver.findElement(loginPasswordFieldLocator);
	}

	public WebElement getSignInButton() {
		return driver.findElement(signInButtonLocator);
	}

	public WebElement getLoginErrorMessage() {
		return driver.findElement(loginErrorMessageLocator);
	}

public WebElement getForgotYourPasswordLink() {
		return driver.findElement(forgotYourPasswordLinkLocator);
	}

	//Create an account getters
	public WebElement getCreateAnAccountEmailField() {
		return driver.findElement(createAnAccountEmailFieldLocator);
	}

	public WebElement getCreateAnAccountButton() {
		return driver.findElement(createAnAccountButtonLocator);
	}

	public WebElement getCreateAnAccountErrorMessage() {
		return driver.findElement(createAnAccountErrorMessageLocator);
	}

//Log in tests methods
	public void fillLoginEmailField(String email) {
		getLoginEmailField().sendKeys(email);
	}

	public void fillLoginPasswordField(String password) {
		getLoginPasswordField().sendKeys(password);
	}

	public void clickOnSignInButton() {
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
		getLoginEmailField().clear();
		getLoginPasswordField().clear();
	}
	
	public ForgotYourPasswordPage clickOnForgotYourPasswordLink() {
		getForgotYourPasswordLink().click();
		return new ForgotYourPasswordPage(driver);
	}
	
	public String getLoginPasswordFieldText() {
		return getLoginPasswordField().getText();
	}
//Create an account tests methods
public void fillCreateAnAccountEmailField(String emailAddress) {
	getCreateAnAccountEmailField().sendKeys(emailAddress);
}

public void clickOnCreateAnAccountButton() {
	getCreateAnAccountButton().click();
}

public boolean visibilityOfCreateAnAccountErrorMessage() {
	if(createAnAccountErrorMessage.isDisplayed()) {
		return true;
	} else {
		return false;
	}
}

public String getCreateAnAccountErrorMessageText() {
	return getCreateAnAccountErrorMessage().getText();
}
}
