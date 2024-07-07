Feature: Checking that by entering the pincode it gives proper output

  Background: Setup of the test
    Given User in the home page of the site
    And user click the pincode button

  Scenario Outline: 
    And Enter a valid pincode "<pincode>" to the enter pincode field
    And User click Check button
    Then Site should display the home page conatining the "<pincode>" and and its place "<place>"

    Examples: 
      | pincode | place  |
      |  670001 | Kannur |

  # this scenario will fail with a non existing pincode( 6 digit code, for e.g 670000)
  # this scenario will pass for pin with value having less than or greater than 6 digits
  Scenario Outline: 
    When Enter a invalid pincode "<invalidpin>"
    And User click Check button
    Then Site should display the error message 
     Examples: 
      | invalidpin |
      |656 |
      |3452 |
      |670700|
