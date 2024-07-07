package com.ust.pharmeasy.tests;

import org.testng.annotations.Test;

import com.ust.pharmeasy.base.Setup;
import com.ust.pharmeasy.pageimpl.FaqDelivaryPageImpl;
import com.ust.pharmeasy.pageimpl.FaqDiagnosticsPageImpl;
import com.ust.pharmeasy.pageimpl.FaqMainPageImpl;
import com.ust.pharmeasy.pageimpl.FaqQuestionsPageImpl;
import com.ust.pharmeasy.pageimpl.HomePageImpl;
import com.ust.pharmeasy.utilities.EventListenerClass;
import com.ust.pharmeasy.pageimpl.FaqMedicineAndHealthCarePageImpl;
import com.ust.pharmeasy.pageimpl.FaqPaymentsPageImpl;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import static org.testng.Assert.assertEquals;



import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;


@Listeners(EventListenerClass.class)
public class VerifyFAQPage  {
	WebDriver driver;
	HomePageImpl home;
	FaqMainPageImpl faqMain;
	FaqMedicineAndHealthCarePageImpl faqHealthCarePage;
	FaqDelivaryPageImpl faqDelivaryPage;
	FaqDiagnosticsPageImpl faqDiaganosticsPage;
	FaqPaymentsPageImpl faqPaymentPage;
	FaqQuestionsPageImpl questionPage;
  @Test
  public void verifyMedicineAndHealthCareFAQ() {
	  faqHealthCarePage=faqMain.openMedicineAndHealthCare();
	  questionPage = faqHealthCarePage.openQuestion(1);
	  assertEquals(questionPage.getQuestionTitle(), "I have received damaged items"); 
  }
  
  @Test
  public void verifyPaymentFAQ() {
	  faqPaymentPage=faqMain.openPaymentFaq();
	  questionPage = faqPaymentPage.openQuestion(1);
	  assertEquals(questionPage.getQuestionTitle(), "I am facing payment related issue with my order/shipment"); 
  }
  
  
  @Test
  public void verifyDelivaryFAQ() {
	  faqDelivaryPage=faqMain.openDelivaryFaq();
	  questionPage = faqDelivaryPage.openQuestion(1);
	  assertEquals(questionPage.getQuestionTitle(), "When will I receive my order / shipment(s)?"); 
  }
  
  
  @Test
  public void verifyDiagonosticsFAQ() {
	  faqDiaganosticsPage=faqMain.openDiagonosticsFaq();
	  questionPage = faqDiaganosticsPage.openQuestion(1);
	  assertEquals(questionPage.getQuestionTitle(), "How do I get the reports for my order?"); 
  }
  
  
  
  
  
  @BeforeMethod
  public void beforeMethod() {
	  driver.get(Setup.prop.getProperty("baseurl"));
	  home = new HomePageImpl(driver);
	  faqMain=home.openFaqPage();
  }

  @BeforeClass
  public void beforeClass() {
//	  new Setup();
//	  
//	  driver = Setup.getBrowser(Setup.prop.getProperty("browser_for_testng"));
	  driver = Setup.driver;
  }

}
