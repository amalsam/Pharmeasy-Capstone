package com.ust.pharmeasy.pageimpl;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlusPageImpl {
	WebDriver driver;

	public PlusPageImpl(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//table[@class='style_breakDown__SjWYg']//tr[1]/td[2]")
	WebElement credits;
	public WebElement proceed;
	@FindBy(xpath = "//table[@class='style_breakDown__SjWYg']//tr/td[2]")
	List<WebElement> breakdownmoney;

	public void chooseslider(String plan) {

		switch (plan) {
		case "2000/month":
			driver.findElement(By.xpath("(//div[@class='style_marker__P9dmf'])[1]")).click();
			break;
		case "3000/month":
			break;
		case "4000/month":
			driver.findElement(By.xpath("(//div[@class='style_marker__P9dmf'])[3]")).click();
			break;
		}

	}

	public List<String> breakdowns() {
		List<String> lis = new ArrayList<String>();
		for (WebElement e : breakdownmoney)
			lis.add(e.getText());

		return lis;
	}

}
