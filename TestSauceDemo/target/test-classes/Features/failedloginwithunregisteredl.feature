Feature: User failed login with unregistered
  Scenario:I want to login with unregistered
    Given I open browser
    And Open saucedemo
    And I input wrong user "gipari"
    And I input wrong password "gipari"
    And I click the login button
    Then user can't succesfully login