@regression
Feature: API validation

  Scenario: Get users
    When I send a GET request for users
    Then the API response status should be 200

  Scenario: Create user
    When I create a test user
    Then the API response status should be 201
