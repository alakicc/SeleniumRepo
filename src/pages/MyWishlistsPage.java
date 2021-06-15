package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyWishlistsPage {
WebDriver driver;
WebElement wishlistNameField;
WebElement saveWishlistButton;
List<WebElement> savedWishlistNameCells;
WebElement deleteWishlistButton;

By wishlistNameFieldLocator = By.id("name");
By saveWishlistButtonLocator = By.id("submitWishlist");
By savedWishlistNameCellsLocator = By.xpath("//td[contains(@style, 'width:200px;')]");
By deleteWishlistButtonLocator = By.xpath("//a[contains(@class, 'icon')]");

public MyWishlistsPage(WebDriver driver) {
	super();
	this.driver = driver;
}
public WebElement getWishlistNameField() {
	return driver.findElement(wishlistNameFieldLocator);
}
public WebElement getSaveWishlistButton() {
	return driver.findElement(saveWishlistButtonLocator);
}
public List<WebElement> getSavedWishlistNameCells() {
	savedWishlistNameCells = new ArrayList<WebElement>();
	savedWishlistNameCells = driver.findElements(savedWishlistNameCellsLocator);
	return savedWishlistNameCells;
}


public WebElement getDeleteWishlistButton() {
	return driver.findElement(deleteWishlistButtonLocator);
}
public int getNumberOfWishlists() {
	return getSavedWishlistNameCells().size();
}

public void fillWishlistNameField(String wishlistName) {
	getWishlistNameField().sendKeys(wishlistName);
}

public void clickOnSaveWishlistButton() {
	getSaveWishlistButton().click();
}

public void clickOnDeleteWishlistButton() {
	getDeleteWishlistButton().click();
}
public void clickOnYesPopUp() {
	Alert alert = driver.switchTo().alert();
	alert.accept();
}

}
