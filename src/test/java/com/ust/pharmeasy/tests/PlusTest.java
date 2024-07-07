package com.ust.pharmeasy.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ust.pharmeasy.base.Setup;
import com.ust.pharmeasy.pageimpl.HomePageImpl;
import com.ust.pharmeasy.utilities.ExcelReader;
import com.ust.pharmeasy.utilities.ObjectReader;

public class PlusTest extends BaseClass {

	@Test(priority = 0)
	public void openpluspage() {
		hm = new HomePageImpl(driver);
		properties = ObjectReader.initProperties();
		pp = hm.clickplus();
		Setup.justscroll(0, 600);
		Setup.wait(3);
		assertEquals(pp.proceed.getText(), properties.getProperty("pluspagevalidation"));
	}

	@Test(dataProvider = "breakdowndata", priority = 1)
	public void slider(String plan, String medcred, String labtest, String convcharge, String saving) {

		pp.chooseslider(plan);
		Setup.wait(2);
		assertEquals(pp.breakdowns().get(0), medcred);
		assertEquals(pp.breakdowns().get(1), labtest);
		assertEquals(pp.breakdowns().get(2), convcharge);
		assertEquals(pp.breakdowns().get(3), saving);
	}

	@DataProvider
	public String[][] breakdowndata() {
		return ExcelReader.getData(System.getProperty("user.dir") + "/src/test/resources/externaldata/Data.xlsx",
				"BreakDownDetails");
	}
//	@AfterClass
//	public void teardown() {
//		driver.close();
//	}
}
