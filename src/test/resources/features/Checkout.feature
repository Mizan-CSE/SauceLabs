Feature: Checkout process

  Background:
    Given the user is logged in

  Scenario: Enter user information during checkout
    Given the user has items in the cart
    When the user proceeds to checkout
    And enters first name "John", last name "Doe", and zip code "12345"
    Then the checkout overview page should be displayed

  Scenario: Complete checkout
    Given the user has entered checkout information
    When the user confirms the order
    Then a success message "THANK YOU FOR YOU ORDER" should be displayed
