package com.ust.pharmeasy.tests;

import org.testng.annotations.Test;

import com.ust.pharmeasy.base.Setup;
import com.ust.pharmeasy.pageimpl.HomePageImpl;
import com.ust.pharmeasy.pageimpl.ProductPageImpl;
import com.ust.pharmeasy.utilities.EventListenerClass;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
@Listeners(EventListenerClass.class)
public class VerifyPrescriptionRequiredProducts {
	WebDriver driver;
	HomePageImpl homePage;
	ProductPageImpl productPage;
  @Test
  public void verifyPrescriptionRequiredIcon() {
	  homePage.searchBar.click();
	  productPage= homePage.clickSearchSuggessionItem(1);
	  assertTrue( productPage.isPrescriptionRequired());  
  }
  
  @Test
  public void verifyPrescriptionNotRequiredIcon() {
	  homePage.searchBar.click();
	  productPage= homePage.clickSearchSuggessionItem(2);
	  assertFalse( productPage.isPrescriptionRequired());  
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  driver.get(Setup.prop.getProperty("baseurl"));
	  homePage = new HomePageImpl(driver);
	  
  }
  
  
  @BeforeClass
  public void beforeClass() {
      //new Setup();
      //driver = Setup.getBrowser(Setup.prop.getProperty("browser_for_testng"));
	  driver = Setup.driver;
	  
		
  }

}
