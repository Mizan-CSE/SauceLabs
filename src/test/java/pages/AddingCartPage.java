package pages;

import io.appium.java_client.AppiumBy;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddingCartPage extends BasePage{
    WebDriverWait wait = setWaitTimeForElements();
    public By cartItems  =AppiumBy.xpath("//android.view.ViewGroup[@content-desc='test-Cart']//android.widget.TextView");

    public WebElement addCart(String productName){
        By selectCartProduct = AppiumBy.xpath("//android.widget.TextView[@content-desc='test-Item title' and @text='"+productName+"']/following-sibling::android.view.ViewGroup[@content-desc='test-ADD TO CART']");
        return wait.until(ExpectedConditions.elementToBeClickable(selectCartProduct));
    }

    public void singleItemCart(String productName){
        addCart(productName).click();
    }
    public void cartTotalItems(String totalItem){
        WebElement cartItemsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(cartItems));
        Assert.assertTrue(cartItemsElement.getText().contains(totalItem));
    }
    public void multipleItemsCart(String product1, String product2){
        addCart(product1).click();
        addCart(product2).click();
    }

}
