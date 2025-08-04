package Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.InventoryPage;
import Pages.LoginPage;

public class InventoryTest extends BaseTest {

    @Test
    public void addItemToCartTest() throws InterruptedException {
        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Thread.sleep(2000);

        // Step 2: Add item to cart
        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertTrue(inventoryPage.isInventoryDisplayed(), "Inventory page not displayed after login");

        Thread.sleep(2000);
        
        inventoryPage.addBackpackToCart();
        inventoryPage.goToCart();

        // Step 3: Assertion - verify redirection to cart
        Assert.assertTrue(driver.getCurrentUrl().contains("cart.html"), "Not navigated to cart page");
    }
    
    @Test
    public void addItemThenVerifyButtonText() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Thread.sleep(2000);

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addBackpackToCart();

        // Verify that button text changes to "Remove"
        String actualText = driver.findElement(By.id("remove-sauce-labs-backpack")).getText();
        Assert.assertEquals(actualText, "Remove", "Button did not change to 'Remove'");
    }
}
