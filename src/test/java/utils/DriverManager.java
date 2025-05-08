package utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.ResourceBundle;

public class DriverManager {
    public static AndroidDriver driver;
    public static ResourceBundle props = ResourceBundle.getBundle("config");

    public static AndroidDriver startDriver() {
        try {
            if (driver == null) {
                DesiredCapabilities caps = new DesiredCapabilities();

                // Common capabilities
                caps.setCapability("platformName", props.getString("platformName"));
                caps.setCapability("appium:platformVersion", props.getString("platformVersion"));
                caps.setCapability("appium:deviceName", props.getString("deviceName"));
                caps.setCapability("appium:automationName", props.getString("automationName"));
                caps.setCapability("appium:app", props.getString("appPath"));
                caps.setCapability("appium:appWaitActivity", props.getString("appWaitActivity"));
                caps.setCapability("appium:appWaitDuration", props.getString("appWaitDuration"));

                // Platform specific initialization
                URL url = URI.create(props.getString("appiumServerUrl")).toURL();

                driver = new AndroidDriver(url, caps);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(props.getString("wait"))));
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize Appium driver: " + e.getMessage());
        }

        return driver;
    }


    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}