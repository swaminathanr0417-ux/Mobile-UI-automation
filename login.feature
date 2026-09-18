@smoke @regression
Feature: Mobile login

  Scenario: Successful login
    Given the user launches the application
    When the user enters valid username and password
    And taps the login button
    Then the user should be logged in successfully

  @regression
  Scenario: Unsuccessful login
    Given the user launches the application
    When the user enters invalid username and password
    And taps the login button
    Then an error message should be displayed
