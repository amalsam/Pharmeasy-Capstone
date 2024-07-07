package com.ust.pharmeasy.pageimpl;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ust.pharmeasy.base.Setup;

public class ProductCartPageImpl {
	WebDriver driver;

	public ProductCartPageImpl(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[text()='Quick Login / Register']")
	WebElement popup;
	@FindBy(xpath = "//button[@id='cart-addPatient-Dweb']")
	WebElement proceed;
	@FindBy(className = "ProductPriceContainer_discountContainer___vEl5")
	WebElement discount;
	@FindBy(className = "ProductPriceContainer_striked__hkuDD")
	WebElement mrp;
	@FindBy(className = "ProductPriceContainer_mrp__mDowM")
	WebElement price;
	@FindBy(linkText = "Cart") WebElement cartlink;
	@FindBy(id = "cart-card-0-title") WebElement productN;

	public void clickProceed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(d -> driver.findElement(By.xpath("//button[@id='cart-addPatient-Dweb']")).isDisplayed());

		driver.findElement(By.xpath("//button[@id='cart-addPatient-Dweb']")).click();

	}

	public boolean checkPopup() {
		Setup.wait(1);
		return popup.isDisplayed();
	}

	public float findexpectedproductprice() {
		String disco = discount.getText();
		String mmrpp = mrp.getText();
		return Setup.afterdiscount(Setup.strtoint(mmrpp), Setup.getDiscount(disco));

	}

	public float findactualproductprice() {
		String prz = price.getText();
		return Setup.strtoint(prz);

	}

	public void clickcart() {
		cartlink.click();
		
	}

	public String getCartedProductName() {
		return productN.getText();
	}

}
