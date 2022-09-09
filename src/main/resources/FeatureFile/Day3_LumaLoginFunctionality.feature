Feature: Luma Login Functionality

  Scenario: Login Functionality with valid credentials
    Given User navigates to Luma website
    And User click to sign in button
    And User fill email input as "techno33@gmail.com"
    And User fill password input as "Techno123"
    And User click sign in button
    Then User should be successfully signed in