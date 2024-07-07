package com.ust.pharmeasy.pageimpl;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductImpl {

	WebDriver driver;

	public ProductImpl(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@id='book-test-btn-pdp']")
	WebElement booktest;
	@FindBy(xpath = "//h3[@id='undefined-patient-1']")
	WebElement choosePatient;
	@FindBy(id = "test-name-pdp")   WebElement testname;

	public void clickBookTest() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(d -> booktest.isDisplayed());
		booktest.click();

	}

	public ProductCartPageImpl choosePatient() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(d -> choosePatient.isDisplayed());
		choosePatient.click();
		return new ProductCartPageImpl(driver);

	}

	public String getProductName() {
		return testname.getText();
	}
}
