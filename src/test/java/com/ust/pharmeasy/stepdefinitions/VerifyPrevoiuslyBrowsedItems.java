package com.ust.pharmeasy.stepdefinitions;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.ust.pharmeasy.base.Setup;
import com.ust.pharmeasy.pageimpl.HomePageImpl;
import com.ust.pharmeasy.pageimpl.ProductPageImpl;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyPrevoiuslyBrowsedItems {
	WebDriver driver;
	HomePageImpl homePage;
	ProductPageImpl productPage;


@Given("User in home page")
public void user_in_home_page() {
	new Setup();
	driver = Hooks.driver;
	driver.get(Setup.prop.getProperty("baseurl"));
	homePage = new HomePageImpl(driver);
}

@When("user clicks on search bar")
public void user_clicks_on_search_bar() {
	homePage.searchBar.click();
}

@When("clicks on first item in suggession")
public void clicks_on_first_item_in_suggession() {
	productPage = homePage.clickSearchSuggessionItem(1);
}

@When("click on homepage icon")
public void click_on_homepage_icon() {
	homePage = productPage.openHomepage();
}

@Then("Validate that searched item is present under Previusly Browsed Items")
public void validate_that_searched_item_is_present_under_previusly_browsed_items() {
    assertTrue(homePage.prevoislyBrowsedProduct.isDisplayed());
}



}
