package com.ust.pharmeasy.tests;

import static org.testng.Assert.assertTrue;

import org.checkerframework.checker.units.qual.h;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ust.pharmeasy.base.Setup;
import com.ust.pharmeasy.pageimpl.HomePageImpl;
import com.ust.pharmeasy.pageimpl.UploadPrescriptionPageImpl;

public class VerifyPrescriptionUpload {
	WebDriver driver;
	HomePageImpl homePage;
	UploadPrescriptionPageImpl uploadPage;
	
  @Test
  public void verifyUploadPngFile() {
	  uploadPage = homePage.clickUploadNow();
	  uploadPage.uploadFile.sendKeys(System.getProperty("user.dir")+"\\src\\test\\resources\\sample inputs\\Sample.png");
	  uploadPage.isUploadedFileDisplayed();
	  assertTrue(uploadPage.isUploadedFileDisplayed());
  }
  public void verifyUploadJpgFile() {
  }
  
  public void verifyUploadInvalidFormatFile() {
	  //driver.get(Setup.prop.getProperty("baseurl"));
	  uploadPage = homePage.clickUploadNow();
	  uploadPage.uploadFile.sendKeys(System.getProperty("user.dir")+"\\src\\test\\resources\\sample inputs\\Sample.pptx");
	  uploadPage.isUploadedFileDisplayed();
	  assertTrue(uploadPage.isErrorMsgDisplayed());
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  driver.get(Setup.prop.getProperty("baseurl"));
	  homePage = new HomePageImpl(driver);
	  
  }
  
  
  @BeforeClass
  public void beforeClass() {
	  //login required
	  new Setup();
	  
	  driver = Setup.getBrowser(Setup.prop.getProperty("browser_for_testng"));
	  driver = Setup.driver;
	  driver.get(Setup.prop.getProperty("baseurl"));
	  homePage = new HomePageImpl(driver);
	  homePage.loginLink.click();
	  homePage.numberField.sendKeys("8590385200");
	  homePage.sendOTPButton.click();
	  Setup.wait(20);
	  homePage.sendOTPButton.click();
	  Setup.wait(5);
  }
}
