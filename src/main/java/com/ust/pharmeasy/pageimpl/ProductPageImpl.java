package com.ust.pharmeasy.pageimpl;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ust.pharmeasy.base.Setup;

public class ProductPageImpl {
	WebDriver driver;
	
	
	/*************************By Amal Sam ****************************/
	
	
	@FindBy(className = "PDPDesktop_rxIconContainer__hIPxa")WebElement prescriptionRequiredIcon;
	@FindBy(id = "tippy-3")WebElement prescriptionRequiredMsg;
	@FindBy(css = "a.ClickableElement_clickable__ItKj2.Logo_container__F7rHL")
	WebElement homepageIcon;

	public ProductPageImpl(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean isPrescriptionRequired() {
		try {
			prescriptionRequiredIcon.click();
			return true;
		} catch (WebDriverException e) {
			return false;
		}
		
		
	}
	
	public HomePageImpl openHomepage() {
		homepageIcon.click();
		return new HomePageImpl(driver);
		}
	
	
	
	
	/*************************By Amal Jose ****************************/
	
	@FindBy(id = "topBarInput")
	WebElement searchBar;
	
	@FindBy(linkText = "cart")
	public WebElement addToCartIcon;
	
	@FindBy(xpath = "//li[@data-value='2']")
	public WebElement quantityadd;
	

	@FindBy(className = "styles_heading__VzA1y")
	public List<WebElement> allcart;
	

	@FindBy(linkText = "Dosage")
	public WebElement Dosage;
	
	@FindBy(linkText = "Side effects")
	public WebElement Sideeffects;
	
	@FindBy(linkText = "Interactions")
	public WebElement Interactions;
	
	
	//Hindi mem pado
	
	@FindBy(linkText = "हिंदी में पढ़ें")
	public WebElement hindibutton;
	
	
	@FindBy(xpath = "//h1[@class=\"MedicineOverviewSection_medicineName__dHDQi\"]")
	public WebElement productname;
	
	@FindBy(id = "proceed")
	public WebElement addtocartbtn;
	
	@FindBy(className = "Heading_title__gZp5c")
	public List<WebElement> headings;
	@FindBy(xpath = "//div[@class=\"Recommendations_heading__HSO2I\"]")
	public WebElement frequentlybought;
	
	@FindBy(id= "proceed")
	WebElement addToCart;
	
	@FindBy(xpath = "//div[@class=\"OverviewSection_nameContainer__VElyz\"]")
	public WebElement productnam;
	
	@FindBy(className= "Navigation_notificationCountBubble__G4f_P")
	public WebElement viewCart;


	
	public void enterMedicineNameInSearchBar(String productName) {
		
		Setup.waitUntil(searchBar).click();
		searchBar.clear();
		searchBar.sendKeys(productName + Keys.ENTER);
	}

	
	public void clickAddtoCartButton() {
		Setup.waitUntil(addToCart).click();
	}

}
