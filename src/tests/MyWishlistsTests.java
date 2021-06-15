package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyWishlistsTests extends BaseTests{
	@BeforeMethod
	public void beforeTest() {
		driver.navigate().to(homeUrl);
		driver.manage().window().maximize();
		mainNavigation.clickOnSignInNavigationButton();
		authenticationPage.fillLoginEmailField(excelReader.getStringData(logInTestsSheetName, 7, 2));
		authenticationPage.fillLoginPasswordField(excelReader.getStringData(logInTestsSheetName, 8, 2));
		authenticationPage.clickOnSignInButton();
		mainNavigation.clickOnMyAccountNavigationButton();
		myAccountPage.clickOnMyWishlistsButton();
		
	}
	@Test(priority = 0)
	public void addNewWishlistValid() {
		int wishlistsNumber = myWishlistsPage.getNumberOfWishlists();
			myWishlistsPage.fillWishlistNameField(excelReader.getStringData(myAccountTestsSheetName, 107, 2));
			myWishlistsPage.clickOnSaveWishlistButton();
		wishlistsNumber++;
		assertEquals(myWishlistsPage.getNumberOfWishlists(), wishlistsNumber);
	}
	
	@Test(priority = 5)
	public void addNewWishlistInvalid() {
		int wishlistsNumber = myWishlistsPage.getNumberOfWishlists();
		for (int i = 3; i < 5; i++) {
			myWishlistsPage.fillWishlistNameField(excelReader.getStringData(myAccountTestsSheetName, 107, i));
			myWishlistsPage.clickOnSaveWishlistButton();
		assertEquals(myWishlistsPage.getNumberOfWishlists(), wishlistsNumber);
		}
		
			
	}
	
	@Test(priority = 10)
	public void addMultipleNewWishlists() {
		int wishlistsNumber = myWishlistsPage.getNumberOfWishlists();
		for (int i = 2; i < 5; i++) {
			myWishlistsPage.fillWishlistNameField(excelReader.getStringData(myAccountTestsSheetName, 121, i));
			myWishlistsPage.clickOnSaveWishlistButton();
			wishlistsNumber++;
		assertEquals(myWishlistsPage.getNumberOfWishlists(), wishlistsNumber);
		}
		
			
	}
	
	@Test(priority = 15)
	public void deleteWishlist() throws InterruptedException {
		int wishlistsNumber = myWishlistsPage.getNumberOfWishlists();
		myWishlistsPage.clickOnDeleteWishlistButton();
		Thread.sleep(3000);
		myWishlistsPage.clickOnYesPopUp();
		wishlistsNumber--;
		assertEquals(myWishlistsPage.getNumberOfWishlists(), wishlistsNumber);
	}
	
	@AfterMethod
	public void afterTest() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}
}
