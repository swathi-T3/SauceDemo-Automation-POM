package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.*;

public class CheckoutTest extends BaseTest {

    @Test(groups = {"positive"})
    public void completeCheckoutFlowSuccessfully() {
        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        // Add item to cart
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addBackpackToCart();
        inventoryPage.goToCart();

        // Proceed to checkout
        CartPage cartPage = new CartPage(driver);
        cartPage.proceedToCheckout();

        // Fill checkout info and finish
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillUserDetails("Swathi", "Thoorpati", "500001");
        checkoutPage.completeOrder();

        // Assertion
        Assert.assertTrue(checkoutPage.isConfirmationVisible(), "Order confirmation not displayed.");
    }

    @Test(groups = {"negative"})
    public void checkoutWithMissingUserDetails() {
        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        // Add item
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addBackpackToCart();
        inventoryPage.goToCart();

        // Proceed to checkout
        CartPage cartPage = new CartPage(driver);
        cartPage.proceedToCheckout();

        // Try submitting with empty fields
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillUserDetails("", "", ""); // Intentionally left blank

        // Assertion - Expect to stay on same page
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-one"), "Expected to stay on step one due to missing info");
    }
}
