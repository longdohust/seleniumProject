@tag
  Feature: Purchase a product from Ecommerce website
    Background:
      Given I landed on Ecommerce page

      @Valid
      Scenario Outline: Positive test for submitting order
        Given Logged in with the username <name> and password <password>
        When Adding product <productName> to Cart
        And Checkout <productName> and submit the order
        Then "THANKYOU FOR THE ORDER." message is displayed

        Examples:
          |name                     | password    | productName |
          |longdo.hust@gmail.com    | @Long1010   | ZARA COAT 3 |