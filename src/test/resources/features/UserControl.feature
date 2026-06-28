Feature: User Control
  Scenario: Adding Product to cart
    Given the user logged in with user credentails
    When the user navigates to the products page
    And the user inspects the product and adds to cart
    Then the user should be able to see it in the cart page

  Scenario: Placing order
    Given the user logged in with user credentails1
    When the user navigates to the product page1
    And adds the products to the cart and user navigate to the cart page and increment the product from cart
    Then the user should see the difference in the updated quantity
