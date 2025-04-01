Feature: User Registration

  Scenario Outline: User registers with valid details
    Given User is on the homepage
    When User clicks on the signup link
    And User enters "<username>" and "<password>" in the signup form
    And User clicks the signup button
    Then A signup confirmation alert should appear

    Examples:
      | username     | password   |
      | samregister1 | pass1234   |
