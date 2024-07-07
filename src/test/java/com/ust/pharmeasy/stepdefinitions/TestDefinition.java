package com.ust.pharmeasy.stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.ust.pharmeasy.base.Setup;
import com.ust.pharmeasy.pageimpl.HomePageImpl;

import com.ust.pharmeasy.utilities.ObjectReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestDefinition {
	WebDriver driver = Hooks.driver;
	Properties properties;
	HomePageImpl hm;
	
	@Given("User in the home page of the site")
	public void user_in_the_home_page_of_the_site() {
		properties = ObjectReader.initProperties();
		driver.get(properties.getProperty( "baseurl"));
	    
	}
	@And("user click the pincode button")
	public void user_click_the_pincode_button() {
	    hm = new HomePageImpl(driver);
	    hm.clickpinlink();
	    
	    
	}
	@Given("Enter a valid pincode {string} to the enter pincode field")
	public void enter_a_valid_pincode_to_the_enter_pincode_field(String pincode) {
	    hm.sendpincode(pincode);
	    
	}
	@Given("User click Check button")
	public void user_click_check_button() {
	    
		hm.clicksubmit();
		Setup.wait(7);
	}
	@Then("Site should display the home page conatining the {string} and and its place {string}")
	public void site_should_display_the_home_page_conatining_the_and_and_its_place(String pincode, String place) {
	   // System.out.println("This is  "+ hm.getpin() +"  "+ hm.getplace());
	    assertEquals(hm.getpin(), pincode);
	    assertEquals(hm.getplace(),place);
	    
	}
	@When("Enter a invalid pincode {string}")
	public void enter_a_invalid_pincode(String invalidpin) {
	    
		hm.sendpincode(invalidpin);
	}
	@Then("Site should display the error message")
	public void site_should_display_the_error_message() {
		//System.out.println(erromsg);
	  assertEquals( hm.errormessagfoundornot(), "Enter Valid Pincode");
	    
	}

}
