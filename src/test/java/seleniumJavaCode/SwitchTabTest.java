package seleniumJavaCode;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class SwitchTabTest {
	
	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions opt = new ChromeOptions();
		opt.addExtensions();//(crx filepath)
		Thread.sleep(3000);
		
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //implicit wait
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		Actions act=new Actions(driver);
		WebElement reg1=driver.findElement(By.xpath("//a[normalize-space()='Fresh']"));
		act.keyDown(Keys.CONTROL).click(reg1).keyUp(Keys.CONTROL).perform();
		Thread.sleep(3000);
		
		
		WebElement reg2=driver.findElement(By.xpath("//a[normalize-space()='Mobiles']"));
		act.keyDown(Keys.CONTROL).click(reg2).keyUp(Keys.CONTROL).perform();
		Thread.sleep(4000);
		
		Set<String> windowsList = driver.getWindowHandles();
		System.out.println(windowsList);
		List<String> windowIds = new ArrayList(windowsList);
		System.out.println("Number of windows: "+windowIds.size());
		
		for (String winID : windowsList)
		{
			String title = driver.switchTo().window(winID).getTitle();
			Thread.sleep(6000);
			System.out.println(title);
		}
		
	}

}
