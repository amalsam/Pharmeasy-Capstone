package com.ust.pharmeasy.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.ust.pharmeasy.base.Setup;

public class Tests {
	
	
	
	@BeforeTest
	public void beforeTest() {
		Setup.getBrowser(Setup.prop.getProperty("browser_for_testng")); 
	}
	
	@AfterTest
	public void afterTest() {
		Setup.driver.quit();
		
	}

}
