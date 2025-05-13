package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

import java.time.Duration;

public class BasePage extends DriverManager {

    public BasePage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(Integer.parseInt(props.getString("wait")))), this);
    }

    public WebDriverWait setWaitTimeForElements() {
        return new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public WebElement scrollToElementByText(AppiumDriver driver, String targetText) {
        try {
            WebElement element = driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(" +
                            "new UiSelector().text(\"" + targetText + "\"));"
            ));

            // Adding Explicit Wait to ensure visibility after scrolling
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOf(element));
            return element;
        } catch (Exception e) {
            throw new RuntimeException("Unable to scroll to the text: '" + targetText + "'. Error: " + e.getMessage(), e);
        }
    }

}
