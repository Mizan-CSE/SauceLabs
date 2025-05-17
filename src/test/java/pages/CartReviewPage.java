package pages;

import io.appium.java_client.AppiumBy;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartReviewPage extends AddingCartPage {
    WebDriverWait wait = setWaitTimeForElements();
    By removeCart = AppiumBy.xpath("//android.widget.TextView[@text='REMOVE']");
    By cartItemsPresence = AppiumBy.xpath("//android.widget.TextView[contains(@text, 'Sauce Labs Backpack')]");

    public void navToCart(){
        WebElement cartItemsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(cartItems));
        cartItemsElement.click();
        wait.until(ExpectedConditions.elementToBeClickable(removeCart));
    }

    public void backpackCartValidation(String productName) {
        By backpackCart = AppiumBy.xpath("//android.widget.TextView[@text='" + productName + "']");
        WebElement backpackCartElement = wait.until(ExpectedConditions.visibilityOfElementLocated(backpackCart));
        Assert.assertTrue(backpackCartElement.isDisplayed());
    }

    public void removeCartItem() {
        WebElement removeCartElement = wait.until(ExpectedConditions.visibilityOfElementLocated(removeCart));
        removeCartElement.click();
    }

    public void emptyCart() {
        List<WebElement> cartItemsElement = driver.findElements(cartItemsPresence);
        Assert.assertEquals(0,cartItemsElement.size());
    }
}