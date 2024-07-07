package com.ust.pharmeasy.tests;
//amaljose
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ust.pharmeasy.base.Setup;

import com.ust.pharmeasy.pageimpl.CartPageImpl;
import com.ust.pharmeasy.pageimpl.HomePageImpl;
import com.ust.pharmeasy.pageimpl.ProductPageImpl;
import com.ust.pharmeasy.pageimpl.SearchResultPageImpl;
import com.ust.pharmeasy.utilities.EventListenerClass;

@Listeners(EventListenerClass.class)
public class VerifyHindiTranslation {
	WebDriver driver;
	HomePageImpl homeP;
	SearchResultPageImpl searchResultP;
	ProductPageImpl productP;
	CartPageImpl cartP;
	
	

	@Test(priority = 1)
	public void verifywebpagewithhindi() {
		searchResultP=homeP.enterMedicineNameInSearchBar("Ecosprin 75mg Strip Of 14 Tablets");
		productP = searchResultP.clickOnProductFromSearchResults();
		productP.hindibutton.click();
		Setup.wait(3);
		// Verify that the webpage is displayed in Hindi
		String text1 = productP.productname.getText();
		// Assert that these texts are in Hindi
		assertTrue(containsHindiText(text1), "Product name is not in Hindi: " + text1);
	}

	@Test(priority = 2)
	public void verifyaddtocartbtnwithhindi(){
		searchResultP=homeP.enterMedicineNameInSearchBar("Ecosprin 75mg Strip Of 14 Tablets");
		productP = searchResultP.clickOnProductFromSearchResults();
		productP.hindibutton.click();
		// Adding a wait to ensure the page has loaded after the language change
		Setup.wait(3);
		String text2 = productP.addtocartbtn.getText();
		assertTrue(containsHindiText(text2), "Add to cart button  is not in Hindi: " + text2);
	}

	//Helper method to check if a string contains Hindi characters
	private boolean containsHindiText(String text) {
		// Regular expression for detecting Hindi characters
		String hindiPattern = ".*[\\u0900-\\u097F]+.*";
		return text.matches(hindiPattern);
	}

	@Test(priority = 3)
	public void verifywebpagenavigationwithhindi()  {
		// Verify that the webpage is displayed in Hindi
		searchResultP = homeP.enterMedicineNameInSearchBar("ईकोस्प्रिन 75एमजी 14 टैब्लेट्स की स्ट्रिप");
		productP = searchResultP.clickOnProductFromSearchResults();
		String text1 = productP.productname.getText();
		assertTrue(containsHindiText(text1), "Product name is not in Hindi: " + text1);
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get(Setup.prop.getProperty("baseurl"));
		homeP = new HomePageImpl(driver);
	}

	@BeforeClass
	public void beforeClass() {
		new Setup();

		driver = Setup.getBrowser(Setup.prop.getProperty("browser_for_testng"));
		driver = Setup.driver;
	}

	@AfterClass
	public void afterclass() {
		driver.close();
	}
}