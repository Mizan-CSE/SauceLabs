package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LogoutPage;

public class LogoutSteps {
    LogoutPage logoutPage = new LogoutPage();
    @When("the user opens the menu and selects logout")
    public void theUserOpensTheMenuAndSelectsLogout() {
        logoutPage.clickLogout();
    }

    @Then("the user should be redirected to the login screen")
    public void theUserShouldBeRedirectedToTheLoginScreen() {
        logoutPage.redirectLogin();
    }
}
