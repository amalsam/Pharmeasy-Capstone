package com.ust.pharmeasy.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ust.pharmeasy.base.Setup;
import com.ust.pharmeasy.pageimpl.HomePageImpl;
import com.ust.pharmeasy.utilities.ExcelReader;
import com.ust.pharmeasy.utilities.ObjectReader;

public class PharmecyStoreTest extends BaseClass {

	@Test(priority = 0)
	public void testStorepage() {
		properties = ObjectReader.initProperties();
		hm = new HomePageImpl(driver);
		Setup.justscroll(0, 7800);
		api = hm.clickBrowswAllStores();
		assertEquals(driver.getTitle(), properties.getProperty("storepagetitle"));
	}

	@Test(priority = 1, dataProvider = "filteroptions")
	public void testFilter(String option) {
		api.clickFilterbtn();
		properties = ObjectReader.initProperties();
		// api.chooseoption("Kolkata");
		api.anotherchoose(option);
		assertTrue(api.checkFilterResult(option));

	}

	@DataProvider
	public String[][] filteroptions() {
		return ExcelReader.getData(System.getProperty("user.dir") + "/src/test/resources/externaldata/Data.xlsx",
				"FilterOptions");
	}
//	@AfterClass
//	public void teardown() {
//		driver.close();
//	}

}
