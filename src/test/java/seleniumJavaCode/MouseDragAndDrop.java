package seleniumJavaCode;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MouseDragAndDrop {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();	
		
		WebElement drag=driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement drop=driver.findElement(By.xpath("//div[@id='droppable']"));
		
		Actions act = new Actions(driver);
		//act.dragAndDrop(drag, drop).build().perform();
		
//		Action myaction=act.dragAndDrop(drag, drop).build();
//		Thread.sleep(3000);
//		myaction.perform();
		
		act.clickAndHold(drag).moveToElement(drop).release(drop).perform();		//***
						
		String msg=drop.getText();
		System.out.println(msg);		
		
		if(msg.equals("Dropped!"))
		{
			System.out.println("Test Passed.");
		}
		else
		{
			System.out.println("Test failed.");
		}
		

	}

}
