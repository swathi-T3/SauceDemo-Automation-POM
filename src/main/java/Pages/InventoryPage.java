package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
	
	WebDriver driver;

    // Locators
	private  By backpackAddToCart = By.id("add-to-cart-sauce-labs-backpack");
	private  By cartIcon = By.className("shopping_cart_link");

    // Constructor
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void addBackpackToCart() {
        driver.findElement(backpackAddToCart).click();
    }

    public void goToCart() {
        driver.findElement(cartIcon).click();
    }

    public boolean isInventoryDisplayed() {
        return driver.getCurrentUrl().contains("inventory.html");
    }

}
