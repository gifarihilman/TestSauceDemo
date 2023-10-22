Feature: Add to basket feature
  Scenario:I want to add item to basket
    Given I open browser
    And Open saucedemo
    And I input user "standard_user"
    And I input password "secret_sauce"
    And User click the login button
    And user add item
    Then user can see item in basket
