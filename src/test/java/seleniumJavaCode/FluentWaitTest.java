package seleniumJavaCode;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

	public class FluentWaitTest 
	{
	    public static void main(String[] args)
	    {	        
	        WebDriver driver = new ChromeDriver();
	        driver.get("https://testautomationpractice.blogspot.com/");
	        driver.manage().window().maximize();
	        
	        // Define Fluent Wait with a maximum timeout of 30 seconds and polling every 2 sec	         
	        Wait<WebDriver> wait = new FluentWait<>(driver)
					                  .withTimeout(Duration.ofSeconds(30))
					                  .pollingEvery(Duration.ofSeconds(3))
					                  .ignoring(Exception.class);

	        try 
	        {
	        	JavascriptExecutor js = (JavascriptExecutor) driver;
	            // Wait until the element is clickable	            
	            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@class='wikipedia-icon']")));
	            js.executeScript("arguments[0].setAttribute('style','background: yellow;border: solid 3px red');", element);
	            Thread.sleep(3000);
	            // Once the element is clickable, perform desired actions	             
	            element.click();
	            Thread.sleep(3000);
	            System.out.println("Element clicked successfully!");
	        }
	        catch (Exception e) 
	        {
	            System.out.println("Timed out waiting for element to be clickable..");
	        }
	        finally 
	        {
	            driver.quit();
	        }
	 }
	
}



