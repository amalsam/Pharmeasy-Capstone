package com.ust.pharmeasy.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import com.ust.pharmeasy.base.Setup;
import com.ust.pharmeasy.pageimpl.AllStoresPageImpl;
import com.ust.pharmeasy.pageimpl.HealthCareProductPageImpl;
import com.ust.pharmeasy.pageimpl.HomePageImpl;

import com.ust.pharmeasy.pageimpl.LabTestPageImpl;
import com.ust.pharmeasy.pageimpl.PlusPageImpl;
import com.ust.pharmeasy.pageimpl.ProductCartPageImpl;
import com.ust.pharmeasy.pageimpl.ProductImpl;
import com.ust.pharmeasy.pageimpl.TopProductPageImpl;
import com.ust.pharmeasy.utilities.ObjectReader;

public class BaseClass {
	HomePageImpl hm;
	Properties properties;
	LabTestPageImpl lti;
	ProductImpl pi;
	ProductCartPageImpl pci;
	HealthCareProductPageImpl hcpi;
	TopProductPageImpl tpi;
	AllStoresPageImpl api;
	PlusPageImpl pp;
	WebDriver driver;

	@BeforeClass
	public void beforetest() {
		properties = ObjectReader.initProperties();
		driver = Setup.getBrowser(properties.getProperty("browser_for_testng"));
		driver.get(properties.getProperty("baseurl"));
	}
	@AfterTest()
	public void aftertest(){
		driver.quit();
	}
//	@AfterSuite
//	public void aftersuite() {
//		
//	}
	
	

	

}
