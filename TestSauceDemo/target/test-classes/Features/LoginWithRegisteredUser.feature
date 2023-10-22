Feature:Login With Registered User
  Scenario:I want to login with registered user
    Given I open browser
    And Open saucedemo
    And I input user "standard_user"
    And I input password "secret_sauce"
    And User click the login button
    Then user succesfully login