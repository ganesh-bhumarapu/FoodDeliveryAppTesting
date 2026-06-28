Feature: End to End
  Scenario: user login to delivery page
    Given user enters the login page with valid credentials
    When the user adds the product to the cart and places order
    Then the user should be able to see the order status


