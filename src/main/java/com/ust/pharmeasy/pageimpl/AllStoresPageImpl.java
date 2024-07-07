package com.ust.pharmeasy.pageimpl;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ust.pharmeasy.base.Setup;

public class AllStoresPageImpl {
	WebDriver driver;

	public AllStoresPageImpl(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath = "//div[@tabindex='0']")
	WebElement filterbutton;

	public void clickFilterbtn() {
		filterbutton.click();
		Setup.wait(2);
	}

	public void chooseoption(String opt) {
		List<WebElement> listoption = driver.findElements(By.cssSelector("ul > li"));
		int id = Setup.findValue(opt, listoption);
		listoption.get(id).click();

	}

	public void anotherchoose(String opt) {
		driver.findElement(By.xpath("//li[text()='" + opt + "']")).click();
	}

	public boolean checkFilterResult(String opt) {

		List<WebElement> result = driver.findElements(By.xpath("//p[@class='_3tsd0']"));
		for (WebElement e : result) {
			if (!(e.getText().contains(opt)))
				return false;
		}

		return true;

	}

}
