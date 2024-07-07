package com.ust.pharmeasy.pageimpl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HealthCareProductPageImpl {
	WebDriver driver;

	public HealthCareProductPageImpl(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "(//a[@data-id = 'category-landing'])[1]")
	WebElement topproductlink;

	public TopProductPageImpl clickTopProduct() {
		topproductlink.click();
		return new TopProductPageImpl(driver);
	}

}
