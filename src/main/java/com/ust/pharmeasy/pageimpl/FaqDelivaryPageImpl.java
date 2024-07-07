package com.ust.pharmeasy.pageimpl;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FaqDelivaryPageImpl {
	WebDriver driver;

	@FindBy(xpath = "(//a[@class='d22JE'])")
	List<WebElement> questionslink;

	public FaqDelivaryPageImpl(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public FaqQuestionsPageImpl openQuestion(int questionNo) {
		questionslink.get(questionNo - 1).click();
		return new FaqQuestionsPageImpl(driver);
	}

}
