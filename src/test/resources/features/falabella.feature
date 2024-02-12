Feature: buy at falabella

  @testFalabella
  Scenario: I make a purchase at Falabella
    Given i enter to falabella
    And close the popups
    When I am looking for a producty
    And valid shopping cart
    Then I complete the purchase




