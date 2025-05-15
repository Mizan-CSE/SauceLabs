Feature: Adding items to the cart

  Background:
    Given the user is logged in

  Scenario: Add a product to cart
    When the user adds "Sauce Labs Backpack" to the cart
    Then the cart icon should show "1" item

  Scenario: Add multiple products to cart
    When the user adds "Sauce Labs Backpack" and "Sauce Labs Bike Light" to the cart
    Then the cart icon should show "2" items
