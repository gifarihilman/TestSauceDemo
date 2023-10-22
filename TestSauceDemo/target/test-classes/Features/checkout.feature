Feature: Checkout Feature
  Scenario:I want to checkout
    Given I open browser
    And Open saucedemo
    And I input user "standard_user"
    And I input password "secret_sauce"
    And User click the login button
    And user add item
    And user click cart button
    And user click checkout button
    And user fill the form
    And user click finish button
    Then checkout complete webpage is showing
