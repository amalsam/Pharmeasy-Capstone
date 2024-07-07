package com.ust.pharmeasy.stepdefinitions;
 
import java.util.Properties;
 
import org.openqa.selenium.WebDriver;
 
import com.ust.pharmeasy.base.Setup;
import com.ust.pharmeasy.utilities.ObjectReader;
 
import io.cucumber.java.Before;
 
public class Hooks {
	
	Properties properties;
	
	public static WebDriver driver;
@Before
public void beforemethod() {
	properties = ObjectReader.initProperties();
	driver = Setup.getBrowser( properties.getProperty("browser_for_cucumber"));
	
	
}
 
}
 