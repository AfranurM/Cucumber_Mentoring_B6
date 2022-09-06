Feature: Web App Security Functionalities

  Scenario Outline: Add New Payee Functionality Test
    Given User navigate to Web App Security
    And User login to Web App Security
    When User navigates to Add New Payee Section
    And User enter "<Payee Name>" and enter "<Payee Address>" and enter "<Account>" and enter "<Payee Details>"
    Then Result should be "<Result>"

    Examples:
      | Payee Name | Payee Address | Account | Payee Details | Result       |
      | Phoebe     | Chicago       | bank    | working       | successful   |
      |            | Chicago       | bank    | working       | unsuccessful |
      | Joey       |               | bank    | working       | unsuccessful |
      | Joey       | Chicago       | bank    |               | successful   |
      | Joey       | Chicago       |         |               | unsuccessful |
