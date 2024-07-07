package com.ust.pharmeasy.tests;
//by amaljose


import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.ust.pharmeasy.base.Setup;
import com.ust.pharmeasy.pageimpl.HomePageImpl;
import com.ust.pharmeasy.pageimpl.ProductPageImpl;
import com.ust.pharmeasy.pageimpl.SearchResultPageImpl;
import com.ust.pharmeasy.utilities.EventListenerClass;

@Listeners(EventListenerClass.class)
public class VerifyMedicineInfo {
	WebDriver driver;
	HomePageImpl homeP;
	ProductPageImpl productP;
	SearchResultPageImpl searchResultP;

  @Test
  public void verifymedicineinformation() {	  
	  searchResultP = homeP.enterMedicineNameInSearchBar("Ecosprin 75mg Strip Of 14 Tablets");
	  productP = searchResultP.clickOnProductFromSearchResults();
	  assertTrue(productP.Dosage.isDisplayed());
	  assertTrue(productP.Sideeffects.isDisplayed());
	  assertTrue(productP.Interactions.isDisplayed());
  }
  
  
  @Test
  public void verifyfrequentlyboughttogether(){ 
	  searchResultP = homeP.enterMedicineNameInSearchBar("Contour Plus Glucometer Test Strips");
	  productP = searchResultP.clickOnProductFromSearchResults(); 
	  assertTrue(productP.frequentlybought.isDisplayed());
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