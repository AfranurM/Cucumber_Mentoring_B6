Feature: Web App Security Functionalities

  Scenario Outline: Add New Payee Functionality Test
    Given User navigate to Web App Security
    And User login to Web App Security
    When User navigates to Add New Payee Section
    And User enter "<Payee Name>" and enter "<Payee Address>" and enter "<Account>" and enter "<Payee Details>"
    Then Result should be "<Result>"

    Examples:
      | Payee Name | Payee Address | Account | Payee Details | Result |
      | Phoebe     | Chicago       | bank    | working       | Pass   |
      |            | Chicago       | bank    | working       | Fail   |
      | Joey       |               | bank    | working       | Fail   |
      | Joey       | Chicago       | bank    |               | Pass   |
      | Joey       | Chicago       |         |               | Fail   |
