package testNGpckg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;



public class WindowHandles extends BaseClass {

	
	
	
	@Test
	public void handleWindow() {
		
		WebElement comntUSDAReview = driver.findElement(By.xpath("/html/body/div/main/aside/div/div/div/div/p/a"));
		comntUSDAReview.click();
		
		
	}
	

 
	
 
	
}
