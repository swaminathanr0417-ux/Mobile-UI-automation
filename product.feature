@regression
Feature: Product cart

  Scenario: Add a product to cart
    Given the user launches the application
    When the user enters valid username and password
    And taps the login button
    When the user opens the first product
    And adds the product to the cart
    And opens the cart
    Then the cart page should be displayed
