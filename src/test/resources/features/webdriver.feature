@webdriver
  Feature: Webdriver functions

    @webdriver1
    Scenario: Open the page
      Given I go the "ask portnov" page and print details
      And I go the "sample" page and print details
      And I go back and forward and refresh the fpage
      And I print the logs to the console
