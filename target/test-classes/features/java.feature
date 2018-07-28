@java
Feature: Java Feature

  @java1
  Scenario: Java steps
    Given I write java step

  @java2
  Scenario: Java steps with argument
    Given I print "Slava" argument

  @java3
  Scenario: action with 2 variables
    Given  I create 2 variable "my var" abd "my VAR"

  @java4
  Scenario: Java steps with two argument
    Given I perform actions with  "MYVAR" and "myvar"
    Given I perform actions with  "Larissa" and "larissa"


  @java5
  Scenario: Java steps with mumvers
    Given I run operators with 3 and 5
    Given I run operators with 2 and 10


  @java6
  Scenario: Java steps with strings
    Given I compare "string1" and "string2"

  @java7
    Scenario: Java print page
    Given I print url for "site" page
    Then I print url for "google" page

    @java8
    Scenario: Java print arrays
     Given I print arrays

  @java9
  Scenario: Open site
    Given I go to the "sample" pabe
   When I submit the form











