package com.ust.pharmeasy.pageimpl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FaqMainPageImpl {
	WebDriver driver;

	@FindBy(partialLinkText = "Medicine & Healthcare Orders")
	public WebElement medicineAndHealthcareBtn;
	@FindBy(partialLinkText = "Delivery")
	public WebElement deliveryBtn;
	@FindBy(partialLinkText = "Payments")
	public WebElement paymentsBtn;
	@FindBy(partialLinkText = "Diagnostics")
	public WebElement diagnosticsBtn;

	public FaqMainPageImpl(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public FaqMedicineAndHealthCarePageImpl openMedicineAndHealthCare() {
		medicineAndHealthcareBtn.click();
		return new FaqMedicineAndHealthCarePageImpl(driver);

	}

	public FaqPaymentsPageImpl openPaymentFaq() {
		paymentsBtn.click();
		return new FaqPaymentsPageImpl(driver);
	}

	public FaqDiagnosticsPageImpl openDiagonosticsFaq() {
		diagnosticsBtn.click();
		return new FaqDiagnosticsPageImpl(driver);
	}

	public FaqDelivaryPageImpl openDelivaryFaq() {
		deliveryBtn.click();
		return new FaqDelivaryPageImpl(driver);
	}

}
