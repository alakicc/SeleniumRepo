package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
WebDriver driver;
WebElement myAddressesButton;
WebElement myPersonalInformationButton;
WebElement myWishlistsButton;

By myAddressButtonLocator = By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[3]/a");
By myPersonalInformationButtonLocator = By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[4]/a");
By myWishlistsButtonLocator = By.className("lnk_wishlist");

public MyAccountPage(WebDriver driver) {
	super();
	this.driver = driver;
}
// Getters
public WebElement getMyAddressesButton() {
	return driver.findElement(myAddressButtonLocator);
}

public WebElement getmyPersonalInformationButton() {
	return driver.findElement(myPersonalInformationButtonLocator);
}
public WebElement getMyWishlistsButton() {
	return driver.findElement(myWishlistsButtonLocator);
}


// "Click on" methods


public void clickOnMyAddressesButton() {
	getMyAddressesButton().click();
}

public void clickOnMyPersonalInformationButton() {
	getmyPersonalInformationButton().click();
}

public void clickOnMyWishlistsButton() {
	getMyWishlistsButton().click();
}


}
