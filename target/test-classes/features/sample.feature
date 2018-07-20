@sample
Feature: Predefined steps for Sample steps

  @sample1
  Scenario: Responsive UI test
    Given I open url "http://skryabin.com/webdriver/html/sample.html"
    And I resize window to 1280 and 1024
    And I wait for 2 sec
    Then element with xpath "//b[@id='currentDate']" should be displayed
    And I resize window to 300 and 1024
    Then element with xpath "//b[@id='currentDate']" should not be displayed
    
   
   
    @sample2
    Scenario: Fill	out	and	validate “Username”	field
      Given I open url "http://skryabin.com/webdriver/html/sample.html"
      When I type "a" into element with xpath "//input[@name='username']"
      When  I click on element with xpath "//button[@id='formSubmit']"
      When I wait for 3 sec
      Then element with xpath "//label[@id='username-error']" should be displayed
      Then element with xpath "//label[@id='username-error']" should contain text "Please enter at least 2 characters."

      When  I clear element with xpath "//input[@name='username']"
      When  I type "aa" into element with xpath "//input[@name='username']"
      When I scroll to the element with xpath "//button[@id='formSubmit']" with offset 50
      When  I click on element with xpath "//button[@id='formSubmit']"
      When I wait for 3 sec
      Then element with xpath "//label[@id='username-error']" should not be displayed



      

  @sample3
  Scenario: Validate	that	email	field	accepts	only	valid	email addresses
    Given I open url "http://skryabin.com/webdriver/html/sample.html"
    Then I wait for element with xpath "//input[@name='email']" to be present
    When I type "aaaaaaaa" into element with xpath "//input[@name='email']"
    When  I click on element with xpath "//button[@id='formSubmit']"
    When I wait for 3 sec
    Then element with xpath "//label[@id='email-error']" should be displayed
    Then element with xpath "//label[@id='email-error']" should contain text "Please enter a valid email address."

    When  I clear element with xpath "//input[@name='email']"
    When I type "larisa@portnov.com" into element with xpath "//input[@name='email']"
    When I wait for 3 sec
    Then element with xpath "//label[@id='email-error']" should not be displayed

    @sample4
    Scenario: Validate that Confirm	Password is	disabled if	Password field is empty
      Given I open url "http://skryabin.com/webdriver/html/sample.html"
      Then I wait for element with xpath "//label[@class='required'][contains(text(),'Confirm Password')]" to be present
      When I type "" into element with xpath "//input[@id='confirmPassword']"
      






