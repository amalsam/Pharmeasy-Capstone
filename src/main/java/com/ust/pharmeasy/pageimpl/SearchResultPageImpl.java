package com.ust.pharmeasy.pageimpl;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ust.pharmeasy.base.Setup;

public class SearchResultPageImpl {
	WebDriver driver;
	WebDriverWait wait;

	public SearchResultPageImpl(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));

	}

	@FindBy(id = "topBarInput")
	WebElement searchBar;


	
	
	
	@FindBy(className = "ProductCard_medicineUnitWrapper__eoLpy")
	WebElement productFromSearchResults;
	
	
	@FindBy(className = "ProductCard_medicineName__8Ydfq")
	public List<WebElement> allProduct;
	
	
	
	public void enterMedicineNameInSearchBar(String productName) throws InterruptedException {
		
		Setup.waitUntil(searchBar).click();
		searchBar.clear();
		searchBar.sendKeys(productName + Keys.ENTER);
	}

	
	public ProductPageImpl clickOnProductFromSearchResults() {
		Setup.waitUntil(productFromSearchResults).click();
		return new ProductPageImpl(driver);

	}
	
	
	


}
