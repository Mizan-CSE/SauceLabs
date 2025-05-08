package stepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverManager;

public class Hooks{
    static AndroidDriver driver;
    @Before
    public void setup() {
       driver = DriverManager.startDriver();
    }

    @After
    public static void tearDown() {
        DriverManager.quitDriver();
    }
}
