Feature: Previously Browsed Items Feature
  verify user can view Previusly Browsed Items

  @tag1
  Scenario: verify user can view Previusly Browsed Items
    Given User in home page
    When user clicks on search bar
    And clicks on first item in suggession
    And click on homepage icon
    Then Validate that searched item is present under Previusly Browsed Items
