@usps
Feature: Usps functions

  @usps1
  Scenario: Validate ZIP code for Portnov Computer School address
    Given I go to "usps" page
    When I go to Lookup ZIP page by address
    And I fill out "4970 El Camino Real" street, "Los Altos" city, "CA" state
    Then I validate "94022" zip code exists in the result

  @usps2
  Scenario: Validate ZIP code for company address
    Given I go to "usps" page
    When I go to Lookup ZIP page by address
    And I fill out "5805 Owens Dr" street, "Pleasanton" city, "CA" state
    Then I validate "94588" zip code exists in the result

  @usps3
  Scenario: Calculate price logic
    Given I go to "usps" page
    When I go to Calculate Price Page
    And I select "United Kingdom" with "Postcard" shape And I define "2" quantity
    Then I calculate the price and validate cost is "$2.30"

  @usps3
  Scenario: Wrong store id does not match
    Given I go to "usps" page
    When I go to "Postal Store" tab
    And I enter "12345" into store search
    Then I search and validate no products found

  @usps4
  Scenario: One item found
    Given I go to "usps" page
    When I go to Stamps and Supplies page
    And I open Stamps
    And choose category Priority Mail
    Then I verify 1 item found in result

  @usps5
  Scenario: Verify color
    Given I go to "usps" page
    When I go to "Stamps & Supplies" menu item
    And I open Stamps
    When I unselect Stamps checkbox
    And select size "18 Months"
    And I click "pink" color
    Then I verify "Pink" and "18 Month" filters
    Then I verify "Pink Just Arrived Onesie" text


  @usps6
  Scenario: Verify location
    Given I go to "usps" page
    When I initiate Passports search
    And I go to "Post Office Hours" results
    And I select "Passports" location, "94568" zip code within "10 miles"
    And I initiate search
    Then I verify "PLEASANTON" present in search results
    When I open "PLEASANTON" search results
    Then I verify "4300 BLACK AVE" address, "9:30am - 1:00pm" walk-in hours, "2:00pm - 3:30pm" photo hours
    When I go back to list
    Then I verify I'm on Find Locations search page

  @usps7
  Scenario: Validate ZIP code page object
    Given I go to usps page object
    When I go to Lookup ZIP page object by address
    And I fill out "4970 El Camino Real" street, "Los Altos" city, "CA" state page object
    Then I validate "94022" zip code exists in the result page object

  @usps8
  Scenario: Validate ZIP code for company address page object
    Given I go to usps page object
    When I go to Lookup ZIP page by address
    And I fill out "5805 Owens Dr" street, "Pleasanton" city, "CA" state page object
    Then I validate "94588" zip code exists in the result page object

  @usps9
  Scenario: Calculate price logic page object
    Given I go to usps page object
    When I go to Calculate Price page object
    And I select "United Kingdom" with "Postcard" shape And I define "2" quantity page object
    Then I calculate the price and validate cost is "$2.30" page object


  @usps10
  Scenario: Wrong store id does not match page object
    Given I go to usps page object
    When I go to Postal Store tab
    And I enter "12345" into store search page object
    Then I search and validate no products found page object