package com.ust.pharmeasy.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ust.pharmeasy.base.Setup;
import com.ust.pharmeasy.pageimpl.HomePageImpl;
import com.ust.pharmeasy.pageimpl.OffersPageImpl;
import com.ust.pharmeasy.utilities.EventListenerClass;

@Listeners(EventListenerClass.class)
public class VerifyOffersCatagory {
	WebDriver driver;
	HomePageImpl homePage;
	OffersPageImpl offerPage;


	@Test(priority = 1)
	public void verifyPaymentOffer() {
		offerPage= homePage.openOffersPage();
		offerPage.paymentBtn.click();
	    Setup.wait(1);
		assertEquals(offerPage.getFirstOfferText(), Setup.prop.getProperty("paymentoffer"));

	}

	@Test(priority = 2)
	public void verifyDiagonoticOffer() {
		offerPage.diagonosticsBtn.click();
		Setup.wait(1);
		assertEquals(offerPage.getFirstOfferText(), Setup.prop.getProperty("diagonosticoffer"));

	}

	@Test(priority = 3)
	public void verifyMedicineOffer() {
		offerPage.medicineBtn.click();
		Setup.wait(1);
		assertEquals(offerPage.getFirstOfferText(), Setup.prop.getProperty("medicineoffer"));

	}

	@Test(priority = 4)
	public void verifyHealthcareOffer() {
		offerPage.healthcareBtn.click();
		Setup.wait(1);
		assertEquals(offerPage.getFirstOfferText(), Setup.prop.getProperty("healthcareoffer"));

	}

	@BeforeClass
	public void beforeClass() {
		//login required
//		new Setup();
//		driver = Setup.getBrowser(Setup.prop.getProperty("browser_for_testng"));
		driver = Setup.driver;
		driver.get(Setup.prop.getProperty("baseurl"));
		homePage = new HomePageImpl(driver);

	}
}
