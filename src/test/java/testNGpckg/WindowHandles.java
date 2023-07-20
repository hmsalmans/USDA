package testNGpckg;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;



public class WindowHandles extends BaseClass {

	
	
	
	@Test
	public void handleWindow() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		
		
		
		
		WebElement subscribeUsda = driver.findElement(By.xpath("/html/body/div/footer/div[2]/div[2]/div/div/div/div/a"));
		subscribeUsda.click();
		driver.switchTo().alert().accept();// alert handling here
		Thread.sleep(4000); //this need to be replaced with implicit wait i think
		
		
		
		//The new window needs to be opened before the code below should run
		String parent = driver.getWindowHandle(); // getting parent window as a string...
		Set <String> setOfWindows = driver.getWindowHandles(); // getting all other windows
		Iterator <String> iterating = setOfWindows.iterator();//Now iterate using iterator
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div[1]/form/div/div[2]/div[2]/fieldset/div[3]/label")));
		while (iterating.hasNext() ) {
			String child = iterating.next();
			
			if (!parent.equalsIgnoreCase(child)) {
		String title = driver.switchTo().window(child).getTitle();
				System.out.println(title + " (This is the Title of child window)");
				
			driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/form/div/div[2]/div[2]/fieldset/div[3]/label")).click();
			WebElement email =	driver.findElement(By.xpath("//*[@id=\"inputProp0\"]"));
     		email.sendKeys("shani@gmail.com");
     		
     		driver.findElement(By.xpath("//*[@id=\"update-profile-submit-btn\"]")).click();
     		
     	System.out.println("\n" + driver.findElement(By.xpath("//*[@id=\"optinSuccess\"]")).getText());
     	
     	
     	
     	 
        // switching back to main window
     
     	     
     		System.out.println(" \n LETS TRY GOING BACK TO MAIN WINDOW AND GET TITLE \n " + driver.switchTo().window(parent).getTitle() +" (This is the Title of main window)");
     		
     		
     		
			}
		}
		
		
		
		
	}
	

 
	
 
	
}
