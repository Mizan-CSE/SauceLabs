package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends BasePage {

    WebDriverWait wait = setWaitTimeForElements();

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Username\"]")
    private WebElement usernameField;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Password\"]")
    private WebElement passwordField;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"LOGIN\"]")
    private WebElement loginButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"PRODUCTS\"]")
    private WebElement homePage;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Username and password do not match any user in this service.\"]")
    private WebElement errorMessage;

    public void setUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.click();
        usernameField.sendKeys(username);
    }

    public void setPassword(String password) {
        passwordField.click();
        passwordField.sendKeys(password);
        driver.hideKeyboard();
    }

    public void tapLoginButton() {
        loginButton.click();
    }

    public void setHomePage(){
        wait.until(ExpectedConditions.visibilityOf(homePage));
        Assert.assertTrue(homePage.isDisplayed());
    }
    public void setErrorMessage(){
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        Assert.assertTrue(errorMessage.isDisplayed());
    }
}