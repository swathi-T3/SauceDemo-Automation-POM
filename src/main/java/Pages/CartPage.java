package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;

    // Locators
   private  By checkoutButton = By.id("checkout");
   private  By removeButton = By.id("remove-sauce-labs-backpack");
   private  By cartItem = By.className("inventory_item_name");

   
   
    public CartPage(WebDriver driver) { 
        this.driver = driver;
    }

    public void proceedToCheckout() {
        driver.findElement(checkoutButton).click();
    }

    public void removeItemFromCart() {
        driver.findElement(removeButton).click();
    }

    public boolean isItemInCart(String expectedItemName) {
        String actualItemName = driver.findElement(cartItem).getText();
        return actualItemName.contains(expectedItemName);
    }
}












//Constructor of the LoginPage class
//It receives a WebDriver instance from the test class
//and assigns it to the local driver variable of this class.
//This allows the LoginPage methods to use the same browser session.