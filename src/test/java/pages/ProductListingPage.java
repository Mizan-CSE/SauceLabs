package pages;

import io.appium.java_client.AppiumBy;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductListingPage extends BasePage{
    WebDriverWait wait = setWaitTimeForElements();

    public void setScrollToOnesie(){
        WebElement oneSieProduct = scrollToElementByText(driver, "Sauce Labs Onesie");
        Assert.assertTrue(oneSieProduct.isDisplayed());
    }
    public void clickBackPack(String product){
        By productLocator = AppiumBy.xpath("//android.widget.TextView[@content-desc='test-Item title' and @text='" + product + "']");
        WebElement backPackElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productLocator));
        backPackElement.click();
    }
    public void backpackDetailsPage(String sauceDetailsTitle){
        By backpackDetails = AppiumBy.xpath("//android.widget.TextView[@text='"+sauceDetailsTitle+"']");
        WebElement sauceDetailsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(backpackDetails));
        Assert.assertTrue(sauceDetailsElement.getText().contains(sauceDetailsTitle));
    }

}
