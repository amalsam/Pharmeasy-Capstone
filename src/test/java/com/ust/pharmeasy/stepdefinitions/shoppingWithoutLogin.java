package com.ust.pharmeasy.stepdefinitions;


/// by amal jose

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ust.pharmeasy.base.Setup;
import com.ust.pharmeasy.pageimpl.HomePageImpl;
import com.ust.pharmeasy.pageimpl.ProductPageImpl;
import com.ust.pharmeasy.pageimpl.SearchResultPageImpl;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class shoppingWithoutLogin{

    WebDriver driver;
    HomePageImpl homePage;
    SearchResultPageImpl searchResultp;
    ProductPageImpl productP;
    
    @Before
	public void setup() {
		driver = new ChromeDriver();
		homePage = new HomePageImpl(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.manage().window().maximize();
	}

    @After
    public void close() {
    	driver.close();
    	
    }
	
	
	
    @Given("the user is on the home page")
    public void the_user_is_on_the_home_page() {
        driver.get("https://pharmeasy.in/");
    }

    
    
    
    @When("the user enters the name of the medicine product {string} in the search bar")
    public void the_user_enters_the_name_of_the_medicine_product_in_the_search_bar(String productName)  {
        searchResultp = homePage.enterMedicineNameInSearchBar(productName);
    }

    

    
    
    @Then("the search results should display the relevant medicine {string} products")
    public void the_search_results_should_display_the_relevant_medicine_products(String string) {
//       homePage.verifySearchResults();
        
        
        assertTrue(searchResultp.allProduct.get(0).isDisplayed());

        // Fetch the text of the web element
        String productText = searchResultp.allProduct.get(0).getText();

        // Assert that the fetched text contains the invalid product name
        assertTrue(productText.contains(string));
    }
    
    
    
   
    
    

    
    
    
    @When("the user enters an invalid product name {string} in the search bar")
    public void the_user_enters_an_invalid_product_name_in_the_search_bar(String invalidProductName) {
    	
        searchResultp = homePage.enterMedicineNameInSearchBar(invalidProductName);
    }

    
    
    
    
    @Then("the application should display the most matching product with the {string} keyword")
    public void the_application_should_display_the_most_matching_product_with_the_keyword(String string)  {
        
    	Setup.wait(4); 	

          
          assertTrue(searchResultp.allProduct.get(0).isDisplayed());

          // Fetch the text of the web element
          String productText = searchResultp.allProduct.get(0).getText();

          // Assert that the fetched text contains the invalid product name
          assertTrue(productText.contains(string));
    }
    
    

    
    
    @When("the user clicks on the product from the search results")
    public void the_user_clicks_on_the_product_from_the_search_results() {
    	
       productP = searchResultp.clickOnProductFromSearchResults();
    }

    
    
    
    @When("clicks on the Add to Cart button")
    public void clicks_on_the_button() {
        productP.clickAddtoCartButton();
    }

    
    

    
    @Then("the medicine product should be added to the cart successfully")
    public void the_medicine_product_should_be_added_to_the_cart_successfully() {

        // Click on the quantity add button
        Setup.waitUntil(productP.quantityadd).click();

        // Fetch the text of the product name element
        String productText = homePage.productnam.getText();

        // Click on the view cart button
        Setup.waitUntil(productP.viewCart).click();

        // Define the expected product name
        

        // Assert that the expected product name is present in the cart
        assertTrue(isTextPresentInCartProducts(productText), 
            "The cart does not contain the expected product: " + productText);
    }

    public boolean isTextPresentInCartProducts(String expectedText) {
        for (WebElement productName : homePage.allCartProductNames) {
            if (productName.getText().equalsIgnoreCase(expectedText)) {
                return true;
            }
        }
        return false;
    }
    
    
    @When("the user navigates to different pages of the application")
    public void the_user_navigates_to_different_pages_of_the_application() {
        homePage.navigateThroughDifferentPages();
    }

    
   

    
    
    
    
    
    
    
    
    
    
    
    
    
    @When("the user goes to the cart page")
    public void the_user_goes_to_the_cart_page() {
        homePage.goToCartPage();
    }

    
    
    
    @When("the user updates the quantity of the product")
    public void the_user_updates_the_quantity_of_the_product() {
        homePage.updateProductQuantity();
    }

    
    
    
    @Then("the quantity of the product should be updated in the cart successfully")
    public void the_quantity_of_the_product_should_be_updated_in_the_cart_successfully() {
        homePage.verifyProductQuantityUpdated();
    }
    
    

}
