@form
  Feature: Let's fill out all sample page fields and verify them

    @form1
    Scenario: Submit and verify the form
      Given I go to the "sample" pabe
      When I fill out all page fields
      And I submit the form
      Then I verify all filled out fields


    @form2
    Scenario: Submit and verify page object form
      Given I open sample page
      When I fill out all page object fields
      And I submit page object form
      Then I verify all page object fields