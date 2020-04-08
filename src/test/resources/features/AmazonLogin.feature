Feature: Amazon App Functionality Test
  As a Amazon user 
  I want to login into Amazon Android Mobile App
  and want to add 65 inch tv to my cart

  Scenario: Amazon App Login
    Given User is in Home Screen
    When user click on Already a customer link
    Then user navigate to Welcome screen
    When user enter email address
    And click continue button
    Then user navigate to Sign In page
    When user enter password
    And click Sign-In button
    Then user navigate to search screen
    
  Scenario: Add Product to Cart
    Given user in search page
    When user search "65 inch tv"
    Then user see the list of products
    When user click any product
    Then user navigate to product details page
    When user add a product to cart
    Then product should be added to cart
