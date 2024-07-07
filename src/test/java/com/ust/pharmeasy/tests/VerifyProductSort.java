package com.ust.pharmeasy.tests;

import org.testng.annotations.Test;

import com.ust.pharmeasy.base.Setup;
import com.ust.pharmeasy.pageimpl.HealthCarePageImpl;
import com.ust.pharmeasy.pageimpl.HomePageImpl;
import com.ust.pharmeasy.pageimpl.TopProductPageImpl;
import com.ust.pharmeasy.utilities.EventListenerClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

@Listeners(EventListenerClass.class)
public class VerifyProductSort  extends Setup{
	WebDriver driver;
	HomePageImpl home;
	HealthCarePageImpl healthCarePage;
	TopProductPageImpl topProducts;
	
  @Test(priority = 1)
  public void verifyPriceHighToLowSort() {
	  driver.get(prop.getProperty("baseurl"));
	  home = new HomePageImpl(driver);
	  healthCarePage = home.openHealthCarePage();
	  topProducts = healthCarePage.clickTopProductsButton();
	  topProducts.clickSort();
	  topProducts.sortByPriceHighToLow.click();
	  Setup.wait(2);
	  assertTrue(topProducts.isProductsSortedByPriceHighToLow());
   
  }
  
  
  @Test(priority = 2)
  	public void verifyPriceLowToHighSort() {
  	 topProducts.clickSort();
  	 topProducts.sortByPriceLowToHigh.click();
  	 Setup.wait(2);
  	 assertTrue(topProducts.isProductsSortedByPriceLowToHigh());	
  	}
  
 
  @Test(priority = 3)
	public void verifyDiscountSort() {
	 topProducts.clickSort();
	 topProducts.sortByDiscount.click();
	 Setup.wait(2);
	 assertTrue(topProducts.isProductsSortedByDiscount());	
	}
  
  
  @BeforeClass
  public void beforeClass() {
//	new Setup();
//	driver = Setup.getBrowser(Setup.prop.getProperty("browser_for_testng"));
	  driver = Setup.driver;
	  
  }

  @AfterClass
  public void afterClass() {
	  
  }

}
