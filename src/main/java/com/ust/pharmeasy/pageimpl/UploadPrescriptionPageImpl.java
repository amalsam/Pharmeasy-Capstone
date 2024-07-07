package com.ust.pharmeasy.pageimpl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ust.pharmeasy.base.Setup;

public class UploadPrescriptionPageImpl {
	WebDriver driver;
	
	
	@FindBy(css = "input[type='file']")public WebElement uploadFile;
	@FindBy(css = "img.viewIcon")public WebElement uploadedFile;
	@FindBy(className = "Wa_Eu")WebElement errMsg;
	public UploadPrescriptionPageImpl(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean isUploadedFileDisplayed() {
		try {
			Setup.wait(5);
			Setup.waitUntil(uploadedFile);
			return uploadedFile.isDisplayed();
			
		} catch (WebDriverException e) {
			System.out.println("NOtdissplayed");
			return false;
		}
	}
	
	public boolean isErrorMsgDisplayed() {
		try {
			return errMsg.isDisplayed();
		} catch (WebDriverException e) {
			return false;
		}
		
	}

}
