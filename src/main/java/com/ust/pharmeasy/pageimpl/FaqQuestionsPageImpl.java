package com.ust.pharmeasy.pageimpl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FaqQuestionsPageImpl {

	WebDriver driver;

	@FindBy(className = "_2yJoZ")
	WebElement questionTitle;

	public FaqQuestionsPageImpl(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public String getQuestionTitle() {
		return questionTitle.getText();
	}

}
