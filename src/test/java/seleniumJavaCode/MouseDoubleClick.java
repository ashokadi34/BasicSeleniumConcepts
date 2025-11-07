package seleniumJavaCode;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MouseDoubleClick {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		driver.manage().window().maximize();
		
		driver.switchTo().frame("iframeResult");
		WebElement field1=driver.findElement(By.xpath("//input[@id='field1']"));
		field1.clear();
		field1.sendKeys("WELCOME!");
		
		WebElement button=driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		Actions act = new Actions(driver);		//Actions class 
		Action myaction=act.doubleClick(button).build(); //Action interface
		myaction.perform();
		
		Thread.sleep(3000);
		WebElement field2=driver.findElement(By.xpath("//input[@id='field2']"));		
		String field2res=field2.getAttribute("value");
		System.out.println(field2res);		
		
		if(field2res.equals("WELCOME!"))
		{
			System.out.println("Test Passed.");
		}
		else
		{
			System.out.println("Test failed.");
		}
		
	}

}
