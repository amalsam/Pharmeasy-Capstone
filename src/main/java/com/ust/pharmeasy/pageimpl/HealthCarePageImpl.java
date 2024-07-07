package com.ust.pharmeasy.pageimpl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HealthCarePageImpl {
	WebDriver driver;

	@FindBy(xpath = "//h2[text()='Top Products']/ancestor::a")
	WebElement topProductsButton;

	public HealthCarePageImpl(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public TopProductPageImpl clickTopProductsButton() {
		topProductsButton.click();
		return new TopProductPageImpl(driver);
	}

}
