package testNGpckg;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;



public class WindowHandles extends BaseClass {

	
	
	
	@Test
	public void handleWindow() throws InterruptedException {
		 
		
		
		
	  //  System.out.println(driver.getTitle()); 	//Title of main window coming from BaseClass alongside driver
		
		String parent = driver.getWindowHandle(); // getting parent window as a string...
		
		
		
	    driver.findElement(By.xpath("/html/body/div/footer/div[2]/div[2]/div/div/div/div/a")).click();
		
	    
		driver.switchTo().alert().accept();// alert handling here
		//Thread.sleep(4000); //this need to be replaced with explicit wait i think. But Nothing is working
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));//here 2 represents the current window and the new window to be opened
		 
				//driver.getWindowHandles();
		
		//The new window needs to be opened before the code below should run
		 
		
		
		 
		 
		Set<String> setOfWindows = driver.getWindowHandles(); // getting all other windows
		
		Iterator <String> iterating = setOfWindows.iterator();//Now iterate using iterator
		
		
		while (iterating.hasNext() ) {
			String child = iterating.next();
			
			if (!parent.equals(child)) {
		     driver.switchTo().window(child); //switching to child window
		
				System.out.println(driver.getTitle()+ " (This is the Title of child window)");
				
			driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/form/div/div[2]/div[2]/fieldset/div[3]/label")).click();
			WebElement email =	driver.findElement(By.xpath("//*[@id=\"inputProp0\"]"));
     		email.sendKeys("shani@gmail.com");
     		driver.findElement(By.xpath("//*[@id=\"update-profile-submit-btn\"]")).click();
     		
     		System.out.println("\n" + driver.findElement(By.xpath("//*[@id=\"optinSuccess\"]")).getText());
     	
     	
     	
     	 
        // switching back to main window
     
     	     driver.close();// now closing child window only
     		System.out.println(" \n LETS TRY GOING BACK TO MAIN WINDOW AND GET TITLE AGAIN. \n "); 
     		driver.switchTo().window(parent);
     		System.out.println(driver.getTitle() +" (We are back to main window and this is the Title of main window)");
			} 
				
				
				
				
			
     		
     		
			
		}
		
		
		
		
	}
	

 
	
 
	
}
