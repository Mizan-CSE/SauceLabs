Feature: Cart review and item validation

  Background:
    Given the user is logged in

  Scenario: View cart and verify product
    Given the user has added "Sauce Labs Backpack" to the cart
    When the user navigates to the cart
    Then the cart should display "Sauce Labs Backpack"

  Scenario: Remove item from cart
    Given the user has added "Sauce Labs Backpack" to the cart
    When the user navigates to the cart and removes the item
    Then the cart should be empty
