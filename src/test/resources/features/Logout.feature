Feature: Logout functionality

  Scenario: User logs out from the app
    Given the user is logged in
    When the user opens the menu and selects logout
    Then the user should be redirected to the login screen
