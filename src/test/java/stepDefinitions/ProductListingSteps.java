package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.ProductListingPage;

public class ProductListingSteps {
    LoginPage loginPage = new LoginPage();
    ProductListingPage productListingPage = new ProductListingPage();

    @When("the user navigates to the product catalog page")
    public void theUserNavigatesToTheProductCatalogPage() {
        loginPage.setHomePage();
    }

    @Then("the user should see a list of available products")
    public void theUserShouldSeeAListOfAvailableProducts(){
        productListingPage.setScrollToOnesie();

    }

    @Given("the user is on the product catalog page")
    public void theUserIsOnTheProductCatalogPage() {
        loginPage.setHomePage();
    }

    @When("the user clicks on the product {string}")
    public void theUserClicksOnTheProduct(String product) {
        productListingPage.clickBackPack(product);
    }

    @Then("the product details page for {string} should be displayed")
    public void theProductDetailsPageForShouldBeDisplayed(String sauceDetailsTitle) {
        productListingPage.backpackDetailsPage(sauceDetailsTitle);
    }
}
