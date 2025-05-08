package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginSteps {
    LoginPage loginPage = new LoginPage();

    @When("the user logs in with username {string} and password {string}")
    public void theUserLogsInWithUsernameAndPassword(String username, String password) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.tapLoginButton();
    }

    @Then("the user should be redirected to the product listing page")
    public void theUserShouldBeRedirectedToTheProductListingPage() {
        loginPage.setHomePage();
    }

    @Then("an error message should be displayed")
    public void anErrorMessageShouldBeDisplayed() {
        loginPage.setErrorMessage();
    }
}
