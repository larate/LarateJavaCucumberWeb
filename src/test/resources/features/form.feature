@form
  Feature: Let's fill out all sample page fields and verify them

    @form1
    Scenario: Submit and verify the form
      Given I go to the "sample" pabe
      When I fill out all page fields
      And I submit the form
      Then I verify all filled out fields