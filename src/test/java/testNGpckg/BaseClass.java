package testNGpckg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseClass {
	
	WebDriver driver;
	
	
	
	
@BeforeClass	//will run before each class
public void windowsHand() {	
	
	
		
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.usda.gov/nutrition-security");
		
		
	}


public void waiting() throws InterruptedException {
	
	           Thread.sleep(3000);
	
}
	






 
//@AfterSuite // quit every browser after everything is done
//public void closingwind() throws InterruptedException {
//	Thread.sleep(1000*60);
//	 driver.quit();
//}
	
	
	
}
