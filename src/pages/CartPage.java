package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CartPage {
WebDriver driver;
WebElement increaseQuantityButton;
WebElement decreaseQuantityButton;
WebElement quantityInputField;
WebElement removeCartItemButton;
WebElement emptyCartMessage;
WebElement numberOfCartProducts;

By increaseQuantityButtonLocator = By.cssSelector("[title = 'Add']");
By decreaseQuantityButtonLocator = By.cssSelector(".cart_quantity_down.btn.btn-default.button-minus");
By quantityInputFieldLocator = By.cssSelector(".cart_quantity_input.form-control.grey");
By removeCartItemButtonLocator = By.className("cart_quantity_delete");
By emptyCartMessageLocator = By.cssSelector(".alert.alert-warning");
By numberOfCartProductsLocator = By.className("heading-counter");

public CartPage(WebDriver driver) {
	super();
	this.driver = driver;
}
public WebElement getIncreaseQuantityButton() {
	return driver.findElement(increaseQuantityButtonLocator);
}
public WebElement getDecreaseQuantityButton() {
	return driver.findElement(decreaseQuantityButtonLocator);
}
public WebElement getQuantityInputField() {
	return driver.findElement(quantityInputFieldLocator);
}
public WebElement getRemoveCartItemButton() {
	return driver.findElement(removeCartItemButtonLocator);
}
public WebElement getEmptyCartMessage() {
	return driver.findElement(emptyCartMessageLocator);
}

public WebElement getNumberOfCartProducts() {
	return driver.findElement(numberOfCartProductsLocator);
}
public String getEmptyCartMessageText() {
	return getEmptyCartMessage().getText();
}

public void clickOnIncreaseQuantityButton() {
	getIncreaseQuantityButton().click();
}

public void clickOnDecreaseQuantityButton() {
	getDecreaseQuantityButton().click();
}

public void fillQuantityInputField(int quantity) {
	getQuantityInputField().clear();
	getQuantityInputField().sendKeys(String.valueOf(quantity));
}

public int getQuantityInputFieldValue() {
	return Integer.parseInt(getQuantityInputField().getAttribute("value"));
}

public String getNumberOfCartProductsText() {
	return getNumberOfCartProducts().getText();
}

public void moveFocus() {
	Actions action = new Actions(driver);
	action.moveToElement(driver.findElement(By.className("cart_total_price"))).perform();
}

public void clickOnRemoveCartItemButton() {
	getRemoveCartItemButton().click();
}


}
