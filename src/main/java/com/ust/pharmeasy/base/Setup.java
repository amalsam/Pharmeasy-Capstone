package com.ust.pharmeasy.base;
 
 
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
 
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ust.pharmeasy.utilities.ObjectReader;import dev.failsafe.function.CheckedRunnable;
 
 
public class Setup {
	public static WebDriver driver;
	public static Properties prop;

 
	public Setup() {
		prop = ObjectReader.initProperties();
	}
 
	public static WebDriver getBrowser(String browser_choice) {
       
        try {
            if (browser_choice.equalsIgnoreCase("chrome")) {
                driver = BrowserImplementation.chromeD();
            } else if (browser_choice.equalsIgnoreCase("edge")) {
                driver = BrowserImplementation.edgeD();
            } else {
                throw new Exception("Invalid Browser Name in property file");
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return driver;
    }
//	public static void takescreenshot()  {
//		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		String path = System.getProperty("user.dir")+"/src/test/resources/screenshots/error on"+System.nanoTime()+".png";
//		File file = new File(path);
//		try {
//			FileUtils.copyFile(screenshotFile, file);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	public static void takescreenshot(String filpath) {
		TakesScreenshot takescreenshot = (TakesScreenshot) driver;
		File ssfile = takescreenshot.getScreenshotAs(OutputType.FILE);
		File destfile = new File(filpath);
		try {
			FileUtils.copyFile(ssfile, destfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

public static String getTimeStamb() {
	return new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
}
 
public static String geturlOf(WebDriver driver) {
	return driver.getCurrentUrl();
}
public static void wait(int seconds) {
	try {
		Thread.sleep(seconds*1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public static WebElement waitUntil(WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	return wait.until(ExpectedConditions.visibilityOf(element));
}

public static void scrollto(WebElement element) {
	 JavascriptExecutor js = (JavascriptExecutor) driver;
    //js.executeScript("window.scrollBy(40,500)"); 
	 js.executeScript("arguments[0].scrollIntoView();",element );
	
}

public static void justscroll(int x, int y) {
	 JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy("+x+","+y+")"); 
	
}

public static int findValue(String opt, List<WebElement> listoption) {
	int i=0;
	for(WebElement e: listoption) {
		if(e.getText().contains(opt))
			break;
		i++;
	}
	return i;
}

public static float getDiscount(String discount) {
	float num = Integer.valueOf(discount.split("%")[0]);
	num = num/100;
	return num;
}

public static float strtoint(String mmrp) {
	String res = mmrp.split("₹")[1];
	
	return Float.valueOf(res);
}

public static float afterdiscount(float mrp, float disc) {
	return mrp - (mrp*disc);
}

}