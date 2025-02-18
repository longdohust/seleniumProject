@tag
  Feature: Error validation

      @InValid
      Scenario Outline: Error validation when users login with incorrect information
        Given I landed on Ecommerce page
        When Logged in with the username <name> and password <password>
        Then "Incorrect email or password." error message is displayed

        Examples:
          |name                     | password    |
          |longdo.hust@gmail.com    | long1010    |
