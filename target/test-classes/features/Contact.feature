Feature: Contact form functionality

  Scenario: User submits a contact form
    Given User is on the homepage
    When User clicks on the contact link
    And User fills in the contact form with "test@example.com", "John", and "This is a test message."
    And User submits the contact form
    Then A confirmation alert should appear
