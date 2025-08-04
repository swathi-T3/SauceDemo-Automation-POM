package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    WebDriver driver;

    // Step One - Info form
    private  By firstName = By.id("first-name");
    private  By lastName = By.id("last-name");
    private  By postalCode = By.id("postal-code");
    private  By continueBtn = By.id("continue");

    // Step Two - Overview & finish
    By finishBtn = By.id("finish");
    By confirmationHeader = By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillUserDetails(String fname, String lname, String zip) {
        driver.findElement(firstName).sendKeys(fname);
        driver.findElement(lastName).sendKeys(lname);
        driver.findElement(postalCode).sendKeys(zip);
        driver.findElement(continueBtn).click();
    }

    public void completeOrder() {
        driver.findElement(finishBtn).click();
    }

    public boolean isConfirmationVisible() {
        return driver.findElement(confirmationHeader).isDisplayed();
    }
}
