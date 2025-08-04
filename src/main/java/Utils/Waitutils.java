package Utils;

import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class Waitutils {
    WebDriver driver;
    WebDriverWait wait;

    public Waitutils(WebDriver driver, int seconds) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }

    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public boolean waitForUrlToContain(String partialUrl) {
        return wait.until(ExpectedConditions.urlContains(partialUrl));
    }

    public boolean waitForTextPresent(By locator, String text) {
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }
}
