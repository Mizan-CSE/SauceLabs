package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;


public class LoginPage extends BasePage {
    WebDriverWait wait = setWaitTimeForElements();

    By usernameField = AppiumBy.xpath("//android.widget.EditText[@content-desc='test-Username']");
    By passwordField = AppiumBy.xpath("//android.widget.EditText[@content-desc='test-Password']");
    By loginButton = AppiumBy.xpath("//android.widget.TextView[@text='LOGIN']");
    By homePage = AppiumBy.xpath("//android.widget.TextView[@text='PRODUCTS']");
    By errorMessage = AppiumBy.xpath("//android.view.ViewGroup[@content-desc='test-Error message']//android.widget.TextView");

    public void setUsername(String username) {
        WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        usernameElement.click();
        usernameElement.sendKeys(username);
    }

    public void setPassword(String password) {
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passwordElement.click();
        passwordElement.sendKeys(password);
        driver.hideKeyboard();
    }

    public void tapLoginButton() {
        WebElement loginElement = wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        loginElement.click();
    }

    public void setHomePage() {
        WebElement homepageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(homePage));
        Assert.assertEquals("PRODUCTS", homepageElement.getText());
    }

    public void setErrorMessage() {
        WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        Assert.assertEquals("Username and password do not match any user in this service.", errorMessageElement.getText());
    }

    public void performLogin(String user, String pass) {
        if (driver == null) {
            driver = DriverManager.startDriver();// Ensure WebDriver is initialized
        }
        setUsername(user);
        setPassword(pass);
        tapLoginButton();

    }
}