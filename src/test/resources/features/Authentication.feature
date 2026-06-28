Feature: User Login And Registration

  Scenario: User Registration
    Given the user is in register page
    When user enter the all the details and clicks register button
    Then user should land in the login page ready to login

  Scenario: User Login
    Given the user is in the login page
    When user enter the email and password
    Then user should be redirected to the home page