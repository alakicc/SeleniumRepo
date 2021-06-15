package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAddressesPage {
WebDriver driver;
WebElement addNewAddressButton;
List<WebElement> addressList;
WebElement deleteAddressButton;
WebElement updateAddressButton;

By addNewAddressButtonLocator = By.xpath("//*[@id=\"center_column\"]/div[2]/a");
By addressListLocator = By.cssSelector(".col-xs-12.col-sm-6.address");
By deleteAddressButtonLocator = By.xpath("//*[contains(@title, 'Delete')]");
By updateAddressButtonLocator = By.xpath("//*[contains(@title, 'Update')]");

public MyAddressesPage(WebDriver driver) {
	super();
	this.driver = driver;
}
public WebElement getAddNewAddressButton() {
	return driver.findElement(addNewAddressButtonLocator);
}


public List<WebElement> getAddressList() {
	addressList = new ArrayList <WebElement>();
	addressList = driver.findElements(addressListLocator);
	return addressList;
}


public WebElement getDeleteAddressButton() {
	deleteAddressButton = driver.findElement(deleteAddressButtonLocator);
	return deleteAddressButton;
}

public WebElement getUpdateAddressButton() {
	updateAddressButton = driver.findElement(updateAddressButtonLocator);
	return updateAddressButton;
}

public void clickOnAddNewAddressButton() {
	getAddNewAddressButton().click();
}

public int getNumberOfAddresses() {
	return getAddressList().size();
}

public void deleteAddress() throws InterruptedException {
		deleteAddressButton.click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	}

public void clickOnUpdateAddressButton() {
	getUpdateAddressButton().click();
}

}
