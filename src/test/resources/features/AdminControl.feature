Feature: Admin Side Operations

  Scenario: Add Product
    Given the user logged in with admin credentials and user landed in the dashboard page
    When the user selects the add product
    And the user enters the all necessary details of the product
    Then check whether the product is added or not

