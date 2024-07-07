package com.ust.pharmeasy.pageimpl;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ust.pharmeasy.base.Setup;

public class TopProductPageImpl {
	WebDriver driver;

	public TopProductPageImpl(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@value='9195']")
	WebElement vitamin;
	@FindBy(xpath = "//div[text() = 'Vitamin']")
	WebElement vitaminwait;
	@FindBy(xpath = "//input[@value='71972']")
	WebElement liveasy;
	@FindBy(xpath = "(//input[@class='jss4' and @type='checkbox' and @value='undefined'])[1]")
	WebElement belowninenine;
	@FindBy(xpath = "//div[@class='ProductCard_productName__5Z65V']")
	List<WebElement> topprodcutlist;
	@FindBy(xpath = "//div[@class='Ratings_averageRating__RGGlG']")
	WebElement productRating;
	@FindBy(xpath = "//div[text()='Ratings and Reviews']")
	WebElement ratinghead;
	@FindBy(xpath = "//div[@class='OverviewSection_starsDiv___fLfB']")
	WebElement stars;
	@FindBy(xpath = "//div[@class='FilterItem_filterTitle__n7zYh']")
	List<WebElement> filopt;
	
	
	
	@FindBy(xpath = "//input[@aria-hidden = 'true']/../../..")WebElement sortButton;
	@FindBy(xpath = "//li[text()='Price high to low']")public WebElement sortByPriceHighToLow;
	@FindBy(xpath = "//li[text()='Price low to high']")public WebElement sortByPriceLowToHigh;
	@FindBy(className =  "ProductCard_salePrice__iLWF7") List<WebElement> allProductsPrice;
	@FindBy(xpath = "//li[text()='Discount']")public WebElement sortByDiscount;
	@FindBy(className = "ProductCard_discountPercent__hcWbO") List<WebElement> allProductsDiscount;

	//*****************************By Abhinav*********************************//
	public void chooseVitamin() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(d -> vitaminwait.isDisplayed());
		vitamin.click();
	}

	public void chooseLiveasy() {
		liveasy.click();
	}

	public void filtercheckbox(String opt) {
		int id = Setup.findValue(opt, topprodcutlist);
		filopt.get(id).click();

	}

	public void choosePrice() {
		belowninenine.click();
	}

	public ProductCartPageImpl clickanProduct(String productname) {
		int id = Setup.findValue(productname, topprodcutlist);
		topprodcutlist.get(id).click();
		return new ProductCartPageImpl(driver);

	}

	public void clickRating() {
		stars.click();

	}

	public String ratingValue() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(d -> ratinghead.isDisplayed());
		return productRating.getText();
	}
	
	
	
	//*****************************By AmalSam*********************************//
	
	
	public void clickSort() {
		sortButton.click();
	}
	
	public boolean isProductsSortedByPriceHighToLow() {
		int n = allProductsPrice.size();
		
		for (int i = 0; i< n-1;i++) {
			
				WebElement e1 = allProductsPrice.get(i);
				WebElement e2 = allProductsPrice.get(i+1);
				Double price1 = convertPriceToDouble(e1.getText());
				Double price2 = convertPriceToDouble(e2.getText());
				
				if(price1<price2)return false;	
			
		}
		return true;
	}
	
	public boolean isProductsSortedByPriceLowToHigh() {
		int n = allProductsPrice.size();
		
		for (int i = 0; i< n-1;i++) {
			
				WebElement e1 = allProductsPrice.get(i);
				WebElement e2 = allProductsPrice.get(i+1);
				Double price1 = convertPriceToDouble(e1.getText());
				Double price2 = convertPriceToDouble(e2.getText());
				
				if(price1>price2)return false;	
			
		}
		return true;
	}
	
	public boolean isProductsSortedByDiscount() {
		int n = allProductsDiscount.size();
		System.out.println("products:"+n);
		for (int i = 0; i< n-1;i++) {
			
				WebElement e1 = allProductsDiscount.get(i);
				WebElement e2 = allProductsDiscount.get(i+1);
				int discountOfe1 = convertDiscountToInt(e1.getText());
				int discountOfe2 = convertDiscountToInt(e2.getText());
				
				if(discountOfe2>discountOfe1)return false;	
			
		}
		return true;
	}
	
	private Double convertPriceToDouble(String s) {
		s=s.replace("₹", "");
		return Double.parseDouble(s);
		
	}
	
	private int convertDiscountToInt(String s) {
		s=s.replace("% OFF", "");
		return Integer.parseInt(s);
		
	}
	

}
