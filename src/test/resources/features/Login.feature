@Login
Feature: Login functionality

  Scenario: Successful login with valid credentials
    When the user logs in with username "standard_user" and password "secret_sauce"
    Then the user should be redirected to the product listing page

  Scenario: Login fails with invalid credentials
    When the user logs in with username "invalid_user" and password "secret_sauce"
    Then an error message should be displayed
