package testNGpckg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.*;

public class BaseClass {
	
	WebDriver driver;
	
	
	
	
@BeforeClass	//will run before each class
public void windowsHand() {
	
	
	
		
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.usda.gov/nutrition-security");
		
	}


	


 
//@AfterSuite // quit every browser after everything is done
//public void closingwind() {
//	 driver.quit();
//}
	
	
	
}
