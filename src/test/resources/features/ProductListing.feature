Feature: Product Catalog Browsing

  Background:
    Given the user is logged in

  Scenario: View available products
    When the user navigates to the product catalog page
    Then the user should see a list of available products

  Scenario: View product details
    Given the user is on the product catalog page
    When the user clicks on the product "Sauce Labs Backpack"
    Then the product details page for "Sauce Labs Backpack" should be displayed

