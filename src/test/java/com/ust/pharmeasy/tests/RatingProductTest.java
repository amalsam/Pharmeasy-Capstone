package com.ust.pharmeasy.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.ust.pharmeasy.pageimpl.HomePageImpl;
import com.ust.pharmeasy.utilities.ObjectReader;

public class RatingProductTest extends BaseClass {
	@Test
	public void ratingproduct() {
		properties = ObjectReader.initProperties();
		hm = new HomePageImpl(driver);
		hcpi = hm.clickHealthProduct();
		tpi = hcpi.clickTopProduct();
		tpi.clickanProduct(properties.getProperty("product"));
		tpi.clickRating();
		System.out.println(tpi.ratingValue());
		assertEquals(tpi.ratingValue(), properties.getProperty("ratingofproduct"));
		
	}
//	@AfterClass
//	public void teardown() {
//		driver.close();
//	}

}
