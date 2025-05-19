package pages;

import io.appium.java_client.AppiumBy;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends BasePage{
    WebDriverWait wait = setWaitTimeForElements();

    By checkout = AppiumBy.xpath("//android.widget.TextView[@text='CHECKOUT']");
    By firstName = AppiumBy.xpath("//android.widget.EditText[@content-desc='test-First Name']");
    By lastName = AppiumBy.xpath("//android.widget.EditText[@content-desc='test-Last Name']");
    By zipCode = AppiumBy.xpath("//android.widget.EditText[@content-desc='test-Zip/Postal Code']");
    By submit = AppiumBy.xpath("//android.widget.TextView[@text='CONTINUE']");
    By checkoutOverview = AppiumBy.xpath("//android.widget.TextView[@text='CHECKOUT: OVERVIEW']");
    By finishCheckout = AppiumBy.xpath("//android.widget.TextView[@text='FINISH']");
    By thankMessage = AppiumBy.xpath("//android.widget.TextView[@text='THANK YOU FOR YOU ORDER']");


    public void checkoutProcess(){
        WebElement checkoutElement = wait.until(ExpectedConditions.visibilityOfElementLocated(checkout));
        checkoutElement.click();
    }
    public void checkoutInformation(String first, String last, String zip){
        WebElement firstNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));
        WebElement lastNameElement = wait.until(ExpectedConditions.elementToBeClickable(lastName));
        WebElement zipCodeElement = wait.until(ExpectedConditions.elementToBeClickable(zipCode));
        WebElement submitElement = wait.until(ExpectedConditions.elementToBeClickable(submit));

        firstNameElement.click();
        firstNameElement.sendKeys(first);

        lastNameElement.click();
        lastNameElement.sendKeys(last);

        zipCodeElement.click();
        zipCodeElement.sendKeys(zip);
        driver.hideKeyboard();

        submitElement.click();
    }

    public void setCheckoutOverviewValidation(){
        WebElement checkoutOverviewElement = wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutOverview));
        Assert.assertTrue(checkoutOverviewElement.getText().contains("CHECKOUT: OVERVIEW"));
    }

    public void setFinishCheckout(){
        WebElement finishCheckoutElement = scrollToElementByText(driver, "FINISH");
//        WebElement finishCheckoutElement = wait.until(ExpectedConditions.visibilityOfElementLocated(finishCheckout));
        finishCheckoutElement.click();
    }
    public void placeOrder(String message){
        WebElement thankMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(thankMessage));
        Assert.assertEquals(message, thankMessageElement.getText());
    }


}
