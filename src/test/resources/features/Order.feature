Feature: Order Placement

  Scenario: User places an order successfully
    Given User is on the homepage
    When User selects a product
    And User adds the product to the cart
    And User places the order with valid details
    Then Order should be placed successfully
