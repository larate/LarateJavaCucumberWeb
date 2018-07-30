@ups
Feature: USP scenarios

  @ups1
  Scenario: UPS end to end
    Given I go to the "ups" pabe
    And I open Shipping menu
    And I go to Create a Shipment
    When I fill out origin shipment fields
    And I submit the shipment form
    Then I verify origin shipment fields submitted
    And I cancel the shipment form
    Then I verify shipment form is reset