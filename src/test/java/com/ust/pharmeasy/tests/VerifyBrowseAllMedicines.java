package com.ust.pharmeasy.tests;

//by amal jose

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ust.pharmeasy.base.Setup;
import com.ust.pharmeasy.pageimpl.HomePageImpl;
import com.ust.pharmeasy.pageimpl.ProductPageImpl;
import com.ust.pharmeasy.utilities.EventListenerClass;

@Listeners(EventListenerClass.class)
public class VerifyBrowseAllMedicines {
	WebDriver driver;
	HomePageImpl homeP;
	ProductPageImpl productP;

 
  
  

  @Test
  public void verifyUserAbleToBrowseAllMedicines()  {
      homeP.browseallmedicine.click();
      
      List<WebElement> products = homeP.allmedicinelinks;
      for (WebElement product : products) { 
    	 product.click();
          
          // Verify the product details
          assertTrue(homeP.frequentlybought.isDisplayed(), "Dosage information is not displayed.");
//          assertTrue(homeP.Sideeffects.isDisplayed(), "Side effects information is not displayed.");
//          assertTrue(homeP.Interactions.isDisplayed(), "Interactions information is not displayed.");
          // Go back to the products list page
          driver.navigate().back();
         
      
      }
  }
  
  
  
  
  
  

	@BeforeMethod
	public void beforeMethod() {
		driver.get(Setup.prop.getProperty("baseurl"));
		homeP = new HomePageImpl(driver);
	}

	@BeforeClass
	public void beforeClass() {
		new Setup();

		driver = Setup.getBrowser(Setup.prop.getProperty("browser_for_testng"));
		driver = Setup.driver;
	}

	@AfterClass
	public void afterclass() {
		driver.close();
	}
}