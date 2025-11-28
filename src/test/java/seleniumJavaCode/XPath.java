package seleniumJavaCode;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XPath{
	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		JavascriptExecutor j = (JavascriptExecutor) driver; //js class
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		WebElement element=driver.findElement(By.xpath("//a[normalize-space()='Cart']"));
		j.executeScript("arguments[0].setAttribute('style','background: yellow;border: solid 2px red');", element);
		
		
	}
	
}
