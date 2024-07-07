package com.ust.pharmeasy.pageimpl;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ust.pharmeasy.base.Setup;
import com.ust.pharmeasy.locators.HomepageLocators;

public class HomePageImpl{
	WebDriver driver;
	
	
	
	@FindBy(linkText = HomepageLocators.MEDICINE_LINK_TEXT)
	WebElement medicineLink;
	
	@FindBy(linkText = HomepageLocators.LABTEST_LINK_TEXT)
	WebElement labTestsLink;
	
	@FindBy(linkText = HomepageLocators.HEALTHCARE_LINK_TEXT)
	WebElement healthCareLink;
	
	@FindBy(linkText = HomepageLocators.HEALTHBLOGS_LINK_TEXT)
	WebElement healthBolgsLink;
	
	@FindBy(linkText = HomepageLocators.PLUS_LINK_TEXT)
	WebElement plusLink;
	
	@FindBy(linkText = HomepageLocators.VALUESTORE_LINK_TEXT)
	WebElement valueStoreLink;
	
	@FindBy(xpath = HomepageLocators.PINCODE_XPATH)
	WebElement selectPincodeLink;
	
	@FindBy(linkText = HomepageLocators.FAQ_LINK_TEXT)
	WebElement faqLink;
	
	@FindBy(xpath = HomepageLocators.UPLOADNOWBTN_XPATH)
	WebElement uploadNowBtn;
	
	@FindBy(xpath =HomepageLocators.SEARCHSUGGESSIONLIST_XPATH)
	List<WebElement> searchSuggessionList;
	
	@FindBy(css  = HomepageLocators.SEARCHBAR_CSS)
	public WebElement searchBar;
	
	@FindBy(xpath = HomepageLocators.PREVIOUSLYBROWSED_XPATH)
	public WebElement prevoislyBrowsedProduct;
	
	@FindBy(linkText = HomepageLocators.OFFERS_LINK_TEXT)
	public WebElement offersLink;
	
	@FindBy(linkText = HomepageLocators.LOGIN_LINK_TEXT)
	public WebElement loginLink;

	@FindBy(css = HomepageLocators.NUMBERFIELD_CSS)
	public WebElement numberField;
	
	@FindBy(css = HomepageLocators.SEND_OTP_BTN_XPATH)
	public WebElement sendOTPButton;
	@FindBy(xpath = HomepageLocators.CLICKTOSEARCH_XPATH)
	WebElement clickToSearch;
	@FindBy(linkText = HomepageLocators.BROWSEALLSTORES_LINK_TEXT )
	WebElement browseallstore;
	@FindBy(linkText = HomepageLocators.PLUS_LINK_TEXT)
	WebElement pluslink;
	@FindBy(css = "a[href='#addAddress']")
	WebElement addnewaddress;
	@FindBy(xpath = "(//a/span)[1]")
	WebElement pinlink;
	@FindBy(xpath = "//input[@placeholder='Enter PIN Code']")
	WebElement pinfield;
	@FindBy(xpath="//button[@type='submit']")
	WebElement subbtn;
	@FindBy(xpath = "//span[text()='Enter Valid Pincode']")
	WebElement errormsg;
	
	
	
	
	
	
	public HomePageImpl(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	
	
/******************************By Amal Sam ***************************/
public UploadPrescriptionPageImpl clickUploadNow() {
		uploadNowBtn.click();
		return new UploadPrescriptionPageImpl(driver);
	}
	
	public ProductPageImpl clickSearchSuggessionItem(int itemNo) {
		Setup.wait(2);
		Setup.waitUntil(searchSuggessionList.get(itemNo-1)).click();;
		
		return new ProductPageImpl(driver);
		
	}
	
	public HealthCarePageImpl openHealthCarePage() {
		healthCareLink.click();
		return new HealthCarePageImpl(driver);
	}
	
	public FaqMainPageImpl openFaqPage() {
		faqLink.click();
		return new FaqMainPageImpl(driver);
	}
	
	public OffersPageImpl openOffersPage() {
		offersLink.click();
		return new OffersPageImpl(driver);
	}
	
	
	
	
	/****************************By Abhinav*****************************************/
	
	
	public LabTestPageImpl labTestClick() {
		labTestsLink.click();
		return new LabTestPageImpl(driver);
	}

	public HealthCareProductPageImpl clickHealthProduct() {
		healthCareLink.click();
		return new HealthCareProductPageImpl(driver);

	}

	public void scrolltoFooter() {
		Setup.justscroll(0, 7800);

	}

	public AllStoresPageImpl clickBrowswAllStores() {
		browseallstore.click();
		return new AllStoresPageImpl(driver);
	}

	public PlusPageImpl clickplus() {
		pluslink.click();
		return new PlusPageImpl(driver);

	}

	public void clickpinlink() {
		Setup.wait(4);
		pinlink.click();
		
	}

	public void sendpincode(String pincode) {
		Setup.wait(3);
		pinfield.click();
		pinfield.sendKeys(pincode);
		
	}

	public void clicksubmit() {
		
		subbtn.click();
	}
public String getpin() {
	return pinlink.getText().split(" ")[0];
}
public String getplace() {
	return pinlink.getText().split(" ")[1];
}

public String errormessagfoundornot() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			
	wait.until(d->errormsg.isDisplayed());
	
	return errormsg.getText();
}


/***************************By Amal Jose ************************/


WebDriverWait wait;


@FindBy(xpath = "//div[@class=\"c-PJLV c-bXbWpx c-bXbWpx-icOztnM-css\"]")
WebElement searchBarclick;
@FindBy(id = "cart")
WebElement cart;
@FindBy(className = "ProductCard_medicineUnitWrapper__eoLpy")
WebElement productFromSearchResults;
@FindBy(id= "proceed")
WebElement addToCart;
@FindBy(id = "proceed")
public WebElement addtocartbt;

@FindBy(xpath = "//div[@class=\"Recommendations_heading__HSO2I\"]")
public WebElement frequentlybought;

@FindBy(linkText = "Browse All Medicines")
public WebElement browseallmedicine;


//browse all medicine page

@FindBy(className = "BrowseList_medicine__cQZkc")
public List<WebElement> allmedicinelinks;
@FindBy(xpath = "//h1[@class=\"MedicineOverviewSection_medicineName__dHDQi\"]")
public WebElement ecosprinproductname;
@FindBy(xpath = "//div[@class=\"OverviewSection_nameContainer__VElyz\"]")
public WebElement productnam;
@FindBy(className = "styles_heading__VzA1y")
public List<WebElement> allCartProductNames;
@FindBy(className= "Navigation_notificationCountBubble__G4f_P")
public WebElement viewCart;



public SearchResultPageImpl enterMedicineNameInSearchBar(String productName)  {
	
	Setup.waitUntil(searchBarclick).click();
	searchBar.clear();
	searchBar.sendKeys(productName + Keys.ENTER);
	return new SearchResultPageImpl(driver);
}



public void clickOnProductFromSearchResults() {
	Setup.waitUntil(productFromSearchResults).click();

}



//public void clickAddtoCartButton() {
//	Setup.waitUntil(addToCart).click();
//}



public void verifyProductAddedToCart() {
	// Example verification logic to check if the product is added to the cart
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cart")));
	cart.click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cart-item']")));
	assertTrue(driver.findElement(By.xpath("//div[@class='cart-item']")).isDisplayed());
}

public void navigateThroughDifferentPages() {
	// Example navigation logic
	labTestsLink.click();
	wait.until(ExpectedConditions.urlContains("diagnostics"));
	healthCareLink.click();
	wait.until(ExpectedConditions.urlContains("healthcare"));
}

public void returnToCart() {
	cart.click();
}

public void verifyCartContainsProducts() {
	// Example verification logic to check if the cart contains products
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cart-item']")));
	assertTrue(driver.findElement(By.xpath("//div[@class='cart-item']")).isDisplayed());
}

public void goToCartPage() {
	cart.click();
}

public void updateProductQuantity() {
	// Example logic to update product quantity
	WebElement quantityInput = driver.findElement(By.xpath("//input[@class='cart-quantity']"));
	quantityInput.clear();
	quantityInput.sendKeys("2");
	WebElement updateButton = driver.findElement(By.xpath("//button[@class='update-cart']"));
	updateButton.click();
}

public void verifyProductQuantityUpdated() {
	// Example verification logic to check if product quantity is updated
	WebElement quantityInput = driver.findElement(By.xpath("//input[@class='cart-quantity']"));
	assertTrue(quantityInput.getAttribute("value").equals("2"));
}


	
	
	
	
	

}
