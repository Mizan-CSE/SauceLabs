package pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
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

}
