package stepDefinitions;

import io.cucumber.java.en.Given;
import pages.LoginPage;

public class ReuseLogin{
    LoginPage loginPage = new LoginPage();
    @Given("the user is logged in")
    public void theUserIsLoggedIn() {
        loginPage.performLogin("standard_user", "secret_sauce");
        loginPage.setHomePage();
    }
}
