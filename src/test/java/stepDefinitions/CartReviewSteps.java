package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddingCartPage;
import pages.CartReviewPage;

public class CartReviewSteps {
    AddingCartPage addingCartPage = new AddingCartPage();
    CartReviewPage cartReviewPage = new CartReviewPage();
    @Given("the user has added {string} to the cart")
    public void theUserHasAddedToTheCart(String productName) {
        addingCartPage.singleItemCart(productName);
    }

    @When("the user navigates to the cart")
    public void theUserNavigatesToTheCart(){
        cartReviewPage.navToCart();
    }

    @Then("the cart should display {string}")
    public void theCartShouldDisplay(String productName) {
        cartReviewPage.backpackCartValidation(productName);

    }

    @When("the user navigates to the cart and removes the item")
    public void theUserNavigatesToTheCartAndRemovesTheItem(){
        cartReviewPage.navToCart();
        cartReviewPage.removeCartItem();

    }

    @Then("the cart should be empty")
    public void theCartShouldBeEmpty() {
        cartReviewPage.emptyCart();
    }
}
