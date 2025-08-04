package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utils.Waitutils;

public class LoginPage {
    WebDriver driver;
    Waitutils wait;

    // Locators
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    
    //Add a method to fetch the error message.
    By errorMessage = By.cssSelector("h3[data-test='error']");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new Waitutils(driver, 10);
    }

    // Methods
    public void enterUsername(String username) {
        wait.waitForVisibility(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        wait.waitForVisibility(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        wait.waitForClickable(loginButton).click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public String getErrorMessage() {
        return wait.waitForVisibility(errorMessage).getText();
    }
    
    
    
    
    
    
}
