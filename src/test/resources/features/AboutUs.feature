Feature: About Us Modal

  Scenario: User views the About Us modal
    Given User is on the homepage
    When User clicks on the About Us link
    Then About Us modal should appear
    And User closes the About Us modal
