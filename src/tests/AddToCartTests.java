package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartTests extends BaseTests {
	@BeforeMethod
	public void beforeTest() {
		driver.navigate().to(homeUrl);
		driver.manage().window().maximize();
	}
	
	@Test (priority = 0)
	public void addOneProductToCart() throws InterruptedException  {
		homePage.clickOnAddToCartButton(excelReader.getIntegerData(addToCartTestsSheetName, 6, 2));
		homePage.clickOnProceedToCheckoutButton();
		assertEquals(cartPage.getNumberOfCartProductsText(), excelReader.getStringData(addToCartTestsSheetName, 10, 2));
		
	}
	
	@Test (priority = 5)
	public void increaseQuantityByClickingPlus() throws InterruptedException  {
		homePage.clickOnAddToCartButton(excelReader.getIntegerData(addToCartTestsSheetName, 6, 2));
		homePage.clickOnProceedToCheckoutButton();
		int quantity = cartPage.getQuantityInputFieldValue();
		cartPage.clickOnIncreaseQuantityButton();
		Thread.sleep(2000);
		assertEquals(cartPage.getQuantityInputFieldValue(), (quantity+1));
		
	}
	
	@Test (priority = 10)
	public void decreaseQuantityByClickingMinus() throws InterruptedException  {
		increaseQuantityByClickingPlus();
		int quantity = cartPage.getQuantityInputFieldValue();
		cartPage.clickOnDecreaseQuantityButton();
		Thread.sleep(2000);
		assertEquals(cartPage.getQuantityInputFieldValue(), (quantity-1));
		
		
	}
	
	@Test (priority = 10)
	public void decreaseQuantityToZero() throws InterruptedException  {
		addOneProductToCart();
		cartPage.clickOnDecreaseQuantityButton();
		Thread.sleep(2000);
		assertEquals(cartPage.getEmptyCartMessageText(), excelReader.getStringData(addToCartTestsSheetName, 31, 3));
		
		
	}
	
	@Test (priority = 15)
	public void changeQuantityByKeyboard() throws InterruptedException  {
		addOneProductToCart();
		cartPage.fillQuantityInputField(excelReader.getIntegerData(addToCartTestsSheetName, 39, 2));
		cartPage.moveFocus();
		Thread.sleep(2000);
		assertEquals(cartPage.getQuantityInputFieldValue(), excelReader.getIntegerData(addToCartTestsSheetName, 39, 2));
		
	}
	
	@Test (priority = 20)
	public void changeQuantityToNegativeByKeyboard() throws InterruptedException  {
		addOneProductToCart();
		int quantity = cartPage.getQuantityInputFieldValue();
		cartPage.fillQuantityInputField(excelReader.getIntegerData(addToCartTestsSheetName, 39, 4));
		cartPage.moveFocus();
		Thread.sleep(2000);
		assertEquals(cartPage.getQuantityInputFieldValue(), quantity);
		
	}
	
	@Test (priority = 25)
	public void removeItemFromTheCart() throws InterruptedException  {
		addOneProductToCart();
		cartPage.clickOnRemoveCartItemButton();
		Thread.sleep(2000);
		String emptyCartMessage = cartPage.getEmptyCartMessageText();
		assertEquals(emptyCartMessage, excelReader.getStringData(addToCartTestsSheetName, 42, 3));
		
	}
	
@AfterMethod
public void afterTest() {
	driver.manage().deleteAllCookies();
	driver.navigate().refresh();
}
}
