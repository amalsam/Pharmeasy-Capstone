package com.ust.pharmeasy.pageimpl;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OffersPageImpl {
	WebDriver driver;

	@FindBy(xpath = "//div[text()='Payment']")
	public WebElement paymentBtn;
	@FindBy(xpath = "//div[text()='Medicine']")
	public WebElement medicineBtn;
	@FindBy(xpath = "//div[text()='Diagnostic']")
	public WebElement diagonosticsBtn;
	@FindBy(xpath = "//div[text()='Healthcare']")
	public WebElement healthcareBtn;
	@FindBy(className = "OffersCard_title__nX7J_")
	List<WebElement> offersList;
	// Toast_messageWrapper__nKIcI subscribe succesfull

	public OffersPageImpl(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getFirstOfferText() {
		return offersList.get(0).getText();
	}

}
