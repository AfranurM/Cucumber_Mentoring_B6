Feature: Web App Security Functionalities

  Scenario Outline: Purchase Foreign Currency Functionality Test
    Given User navigate to Web App Security
    And User login to Web App Security
    When User navigates to Purchase Foreign Currency Section
    And User select "<currency>" and select "<amount>" and select USD radio button
    Then User should successfully purchase foreign currency

    Examples:
      | currency        | amount |
      | China           | 500    |
      | Norway          | 200    |
      | Thailand (baht) | 300    |