package com.ust.pharmeasy.pageimpl;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LabTestPageImpl {
	WebDriver driver;

	public LabTestPageImpl(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "(//div[text()='Comprehensive Full Body Checkup Test with Vitamin D & B12'])[1]/ancestor::a")
	WebElement fullbodycheckdiv;

	public ProductImpl clickfullbodycheckdiv() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(40,500)");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(d -> fullbodycheckdiv.isDisplayed());
		fullbodycheckdiv.click();
		return new ProductImpl(driver);
	}

}
