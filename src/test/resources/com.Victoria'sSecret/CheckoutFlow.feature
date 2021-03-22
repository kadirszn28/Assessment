Feature: Validation of New Order

  Scenario: Checkout flow validation
    Given User navigate Victoria's Secret home page
    When User hover overs Sport&Lounge section
    And User clicks Leggins section
    And User chooses one product
    And User clicks color, size, add to bag
    And User clicks checkout button
    And User clicks checkout as guest button
    Then User validates validates "Merchandise Subtotal" header
    And User validates merchandies subtotal amount "$69.50"
    And User validates description of merchandise subtotal



