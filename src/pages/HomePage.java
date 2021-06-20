package pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.list.FixedSizeList;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

	WebDriver driver;
	WebElement addToCartButton;
	WebElement cartButton;
	List <WebElement> productContainerList;
	WebElement continueShoppingButton;
	WebElement proceedToCheckoutButton;
	
	By addToCartButtonLocator = By.linkText("Add to cart");
	By cartButtonLocator = By.className("shopping_cart");
	By productContainerListLocator = By.cssSelector(".replace-2x.img-responsive");
	By proceedToCheckoutButtonLocator = By.xpath("//*[@title = 'Proceed to checkout']");
	By continueShoppingButtonLocator = By.xpath("//*[@title = 'Continue shopping']");
	
	public HomePage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getCartButton() {
		return driver.findElement(cartButtonLocator);
	}
	
	public WebElement getContinueShoppingButton() {
		return driver.findElement(continueShoppingButtonLocator);
	}

	public WebElement getProceedToCheckoutButton() {
		return driver.findElement(proceedToCheckoutButtonLocator);
	}

	public List<WebElement> getProductContainerList() {
		productContainerList = new ArrayList<WebElement>();
		productContainerList = driver.findElements(productContainerListLocator);
		return productContainerList;
	}
	
	public WebElement getAddToCartButton() {
		return driver.findElement(addToCartButtonLocator);
	}
	
	public void clickOnContinueShoppingButton() {
		getContinueShoppingButton().click();
	}
	
	public void clickOnProceedToCheckoutButton() {
		getProceedToCheckoutButton().click();
	}
	
	public void clickOnCartButton() {
		getCartButton().click();
	}
	
	public void clickOnAddToCartButton(int productIndex) {
		Actions action = new Actions(driver);
	WebElement hoverElement = getProductContainerList().get(productIndex);
		action.moveToElement(hoverElement).perform();
		action.moveToElement(driver.findElement(addToCartButtonLocator)).click().perform();
	}
	
	


	
	
	
	
}
