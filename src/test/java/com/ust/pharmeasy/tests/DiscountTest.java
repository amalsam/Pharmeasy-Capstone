package com.ust.pharmeasy.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ust.pharmeasy.pageimpl.HomePageImpl;
import com.ust.pharmeasy.utilities.EventListenerClass;
import com.ust.pharmeasy.utilities.ObjectReader;
@Listeners(EventListenerClass.class)
public class DiscountTest extends BaseClass{
	@Test
	public void discountTest() {
		
		properties = ObjectReader.initProperties();
		hm = new HomePageImpl(driver);
		hcpi = hm.clickHealthProduct();
		tpi = hcpi.clickTopProduct();
		pci = tpi.clickanProduct(properties.getProperty("product"));
		float exp = pci.findexpectedproductprice();
		float actual = pci.findactualproductprice();
		
		
		assertEquals(actual, exp);
	}
//	@AfterClass
//	public void teardown() {
//		driver.close();
//	}

}
