Feature: Cart functionality

  Scenario: User adds a product to the cart
    Given User is on the homepage
    When User selects a product
    And User adds the product to the cart
    Then Product should be added successfully
