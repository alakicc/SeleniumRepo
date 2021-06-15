package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainNavigation {
WebDriver driver;
WebElement signInNavigationButton;
WebElement signOutNavigationButton;
WebElement myAccountNavigationButton;

By signInNavigationButtonLocator = By.className("login");
By singOutNavigationButtonLocator = By.className("logout");
By myAccountNavigationButtonLocator = By.className("account");

public MainNavigation(WebDriver driver) {
	super();
	this.driver = driver;
}

public WebElement getSignInNavigationButton() {
	return driver.findElement(signInNavigationButtonLocator);
}

public WebElement getSignOutNavigationButton() {
	return driver.findElement(singOutNavigationButtonLocator);
}

public WebElement getMyAccountNavigationButton() {
	return driver.findElement(myAccountNavigationButtonLocator);
}

public void clickOnSignInNavigationButton() {
	getSignInNavigationButton().click();
}

public void clickOnSignOutNavigationButton() {
	getSignOutNavigationButton().click();
}

public boolean visibilityOfMyAccountNavigationButton() {
	if (getMyAccountNavigationButton().isDisplayed()) {
		return true;
	} else {
		return false;
	}
}

public boolean visibilityOfSignOutNavigationButton() {
	if (getSignOutNavigationButton().isDisplayed()) {
		return true;
	} else {
		return false;
	}
}
	public boolean visibilityOfSignInNavigationButton() {
		if (getSignInNavigationButton().isDisplayed()) {
			return true;
		} else {
			return false;
		}
}

	public void clickOnMyAccountNavigationButton() {
		getMyAccountNavigationButton().click();
	}


}
