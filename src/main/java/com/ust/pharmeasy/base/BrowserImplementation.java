package com.ust.pharmeasy.base;
 
import java.time.Duration;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
 
public class BrowserImplementation {
	private static WebDriver driver;
	public static WebDriver chromeD() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-notifications");
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	public static WebDriver edgeD() {
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-notifications");
		options.addArguments("--start-maximized");
		driver = new EdgeDriver(options);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		return driver;
	}
 
}