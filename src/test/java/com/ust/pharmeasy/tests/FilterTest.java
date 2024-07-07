package com.ust.pharmeasy.tests;

import org.testng.annotations.Test;

import com.ust.pharmeasy.base.Setup;
import com.ust.pharmeasy.pageimpl.HomePageImpl;


public class FilterTest extends BaseClass {
	

	@Test
	public void testProductFilter() {
		hm = new HomePageImpl(driver);
		hcpi = hm.clickHealthProduct();
		tpi = hcpi.clickTopProduct();
		tpi.chooseVitamin();
		Setup.justscroll(40, 600);
		tpi.chooseLiveasy();
		// tpi.filtercheckbox("Liveasy");
		tpi.choosePrice();
		// tpi.filtercheckbox("Below 99");
		Setup.wait(1);

	}
//	@AfterClass
//	public void teardown() {
//		driver.close();
//	}

}
