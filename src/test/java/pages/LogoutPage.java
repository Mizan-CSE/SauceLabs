package pages;

import io.appium.java_client.AppiumBy;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage extends BasePage{
    WebDriverWait wait = setWaitTimeForElements();
    By options = AppiumBy.xpath("//android.view.ViewGroup[@content-desc='test-Menu']/android.view.ViewGroup/android.widget.ImageView");
    By logout = AppiumBy.xpath("//android.widget.TextView[@text='LOGOUT']");
    By loginButton = AppiumBy.xpath("//android.widget.TextView[@text='LOGIN']");

    public void clickLogout(){
        WebElement optionsElement = wait.until(ExpectedConditions.elementToBeClickable(options));
        optionsElement.click();

        WebElement logoutElement = wait.until(ExpectedConditions.visibilityOfElementLocated(logout));
        logoutElement.click();
    }
    public void redirectLogin(){
        WebElement loginElement = wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        Assert.assertEquals("LOGIN",loginElement.getText());
    }

}
