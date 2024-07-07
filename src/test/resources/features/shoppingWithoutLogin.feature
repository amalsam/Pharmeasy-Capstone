Feature: Medicine and Healthcare Products Shopping without Login


#@tests
  #Scenario Outline: Search for a product without logging in
    #Given the user is on the home page
    #When the user enters the name of the medicine product "<product_name>" in the search bar
    #Then the search results should display the relevant medicine "<product_name>" products
#
  #Examples:
    #| product_name                            |
    #| Contour Plus Glucometer Test Strips     |
    #| Softovac Constipation Powder            |
    #| Liveasy Essentials Strawberry           |
    #| Dr.Reckeweg R 27 Kidney                 |
    #
    #@tests1
  #Scenario Outline: Searching for an invalid product name
    #Given the user is on the home page
    #When the user enters an invalid product name "<invalid_product_name>" in the search bar
    #Then the application should display the most matching product with the "<invalid_product_name>" keyword
#
  #Examples:
    #| invalid_product_name |
    #| asdfghjk             |
    #| Zsdf234!@%^&*        |
    #| !@$%^&               |
    #| 123456fvbvb          |

#@tests2
  #Scenario: Add a product to the cart without logging in
    #Given the user is on the home page
    #When the user enters the name of the medicine product "Contour Plus Glucometer Test Strips" in the search bar
    #And the user clicks on the product from the search results
    #And clicks on the Add to Cart button
    #Then the medicine product should be added to the cart successfully
    
    
    
    
    

    
    

  Scenario: Check items added to the cart are maintained as the user navigates through the site without logging in
    Given the user is on the home page
    When the user enters the name of the medicine product "Contour Plus Glucometer Test Strips" in the search bar
    And the user clicks on the product from the search results
    And clicks on the Add to Cart button
    And the user navigates to different pages of the application
    Then the medicine product should be added to the cart successfully
    




  #Scenario: User can update the quantity of a product in the cart without logging in
    #Given the user is on the home page
    #When the user enters the name of the medicine product "Liveasy Essentials Strawberry" in the search bar
    #And clicks on the search button
    #And the user clicks on the product from the search results
    #And clicks on the "Add to Cart" button
    #And the user goes to the cart page
    #When the user updates the quantity of the product
    #Then the quantity of the product should be updated in the cart successfully
