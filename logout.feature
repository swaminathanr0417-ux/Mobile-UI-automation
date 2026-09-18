@smoke @regression
Feature: Mobile logout

  Scenario: Successful logout
    Given the user launches the application
    When the user enters valid username and password
    And taps the login button
    Then the user should be logged in successfully
    When the user logs out
