Feature: Login functionality

  @ExcelDriven
  Scenario: Login test using data from Excel
    Given Login test data is loaded from Excel
    When User attempts to log in with each credential set from Excel

  @ManualExamples
  Scenario Outline: User fails to log in with invalid credentials
    Given User is on the homepage
    When User clicks on the login link
    And User enters "<username>" and "<password>"
    And User clicks the login button
    Then User should see an error alert with message "<errorMessage>"

    Examples:
      | username   | password   | errorMessage    |
      | wronguser  | wrongpass  | Wrong password. |
      | samdemo    | wrongpass  | Wrong password. |
