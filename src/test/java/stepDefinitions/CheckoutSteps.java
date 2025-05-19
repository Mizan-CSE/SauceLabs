package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddingCartPage;
import pages.CartReviewPage;
import pages.CheckoutPage;

public class CheckoutSteps {
    AddingCartPage addingCartPage = new AddingCartPage();
    CartReviewPage cartReviewPage = new CartReviewPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    String productName = "Sauce Labs Backpack";
    @Given("the user has items in the cart")
    public void theUserHasItemsInTheCart() {
        addingCartPage.singleItemCart(productName);
        cartReviewPage.navToCart();
        cartReviewPage.backpackCartValidation(productName);
    }

    @When("the user proceeds to checkout")
    public void theUserProceedsToCheckout() {
        checkoutPage.checkoutProcess();
    }

    @And("enters first name {string}, last name {string}, and zip code {string}")
    public void entersFirstNameLastNameAndZipCode(String firstName, String lastName, String zipCode) {
        checkoutPage.checkoutInformation(firstName,lastName, zipCode);
    }

    @Then("the checkout overview page should be displayed")
    public void theCheckoutOverviewPageShouldBeDisplayed() {
        checkoutPage.setCheckoutOverviewValidation();
    }

    @Given("the user has entered checkout information")
    public void theUserHasEnteredCheckoutInformation() {
        theUserHasItemsInTheCart();
        checkoutPage.checkoutProcess();
        checkoutPage.checkoutInformation("John","Doe", "12345");
    }

    @When("the user confirms the order")
    public void theUserConfirmsTheOrder() {
        checkoutPage.setFinishCheckout();
    }

    @Then("a success message {string} should be displayed")
    public void aSuccessMessageShouldBeDisplayed(String confirmationMassage) {
        checkoutPage.placeOrder(confirmationMassage);
    }
}
