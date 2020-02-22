Feature: Create user address

  Scenario: Log in and Account details
    Given Navigate to shop page
    When Log in
    And go to customers account
    And add first addres
    And fill details
    And Submit it
    Then Assert that it has been created properly



