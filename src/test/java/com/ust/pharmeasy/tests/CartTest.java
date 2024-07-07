package com.ust.pharmeasy.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.ust.pharmeasy.base.Setup;
import com.ust.pharmeasy.pageimpl.HomePageImpl;



public class CartTest extends BaseClass {
	@Test
	public void labTestAddtoCart() {

		hm = new HomePageImpl(driver);
		lti = hm.labTestClick();
		pi = lti.clickfullbodycheckdiv();
		String choosenProduct = pi.getProductName();
		pi.clickBookTest();
		pci = pi.choosePatient();
		pci.clickcart();
		String productincart = pci.getCartedProductName();
		assertEquals(productincart, choosenProduct);
		
	}
	@Test
	public void testproceedvalidation(){
		driver.navigate().back();
		pci.clickProceed();
		Setup.wait(5);
		assertTrue(pci.checkPopup());

	}
	
//	@AfterClass
//	public void teardown() {
//		driver.close();
//	}

}
