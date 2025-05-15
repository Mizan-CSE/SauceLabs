package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddingCartPage;

public class AddingCartSteps {
    AddingCartPage addingCartPage = new AddingCartPage();

    @When("the user adds {string} to the cart")
    public void theUserAddsToTheCart(String productName) {
        addingCartPage.singleItemCart(productName);
    }

    @Then("the cart icon should show {string} item")
    public void theCartIconShouldShowItem(String totalItems) {
        addingCartPage.cartTotalItems(totalItems);
    }

    @When("the user adds {string} and {string} to the cart")
    public void theUserAddsAndToTheCart(String product1, String product2) {
        addingCartPage.multipleItemsCart(product1,product2);
    }

    @Then("the cart icon should show {string} items")
    public void theCartIconShouldShowItems(String totalItems) {
        addingCartPage.cartTotalItems(totalItems);
    }
}
