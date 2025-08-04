package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(groups = {"positive"})
    public void loginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        // Assertion - Inventory page URL after login
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Login failed or not redirected to inventory.");
    }
    
    @Test(groups = {"invalidCreds"})
    public void invalidUsernameTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("invalid_user", "secret_sauce");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Epic sadface"));
    }

    @Test(groups = {"invalidCreds"})
    public void invalidPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "wrong_password");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Epic sadface"));
    }

    @Test(groups = {"inputValidation"})
    public void emptyUsernameTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "secret_sauce");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");
    }

    @Test(groups = {"inputValidation"})
    public void emptyPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required");
    }

    @Test(groups = {"inputValidation"})
    public void emptyUsernameAndPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");
    }

    @Test(groups = {"security"})
    public void sqlInjectionAttemptTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("' OR 1=1 --", "' OR 1=1 --");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Epic sadface"));
    }

    @Test(groups = {"security"})
    public void lockedOutUserTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("locked_out_user", "secret_sauce");
        Assert.assertEquals(loginPage.getErrorMessage(), 
            "Epic sadface: Sorry, this user has been locked out.");
    }
    
    @Test(groups = {"security"})
    public void longUsernamePasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
        String longInput = "a".repeat(200); // 200 characters
        loginPage.login(longInput, longInput);
        Assert.assertTrue(loginPage.getErrorMessage().contains("Epic sadface"));
    }

    
    @Test(groups = {"security"})
    public void whitespaceInUsernamePasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("  standard_user  ", "  secret_sauce  ");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Epic sadface")); 
        // It should fail because whitespaces aren't trimmed
    }
}

































//test strategy, mention:
//
//Boundary cases: Empty fields
//
//Negative cases: Wrong creds, SQL Injection
//
//Known edge case: Locked out user
//
//Security: Injection attack not accepted (good backend behavior)




//| Case                           | Category                 | Included? |
//| ------------------------------ | ------------------------ | --------- |
//| Valid login                    | Positive Test            | ✅ Yes     |
//| Invalid username/password      | Equivalence Partitioning | ✅ Yes     |
//| Empty username, password, both | Boundary Value Analysis  | ✅ Yes     |
//| Locked out user                | Edge Case                | ✅ Yes     |
//| SQL Injection attempt          | Edge/Security            | ✅ Yes     |

