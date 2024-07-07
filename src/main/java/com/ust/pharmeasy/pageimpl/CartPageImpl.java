package com.ust.pharmeasy.pageimpl;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ust.pharmeasy.base.Setup;

public class CartPageImpl {
	WebDriver driver;
	public CartPageImpl(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements( driver, this);
	}
	
	@FindBy(xpath = "//div[text()='Quick Login / Register']")
	WebElement popupdiv;
	
	@FindBy(xpath= "//button[@id='cart-addPatient-Dweb']")
	WebElement proceedbtn;
	
	
	
	public void clickProceed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(d->proceedbtn.isDisplayed());
		proceedbtn.click();
		
	}
	public boolean checkpopupdiv() {
		Setup.wait(5);
		return popupdiv.isDisplayed();
	}
	

}
