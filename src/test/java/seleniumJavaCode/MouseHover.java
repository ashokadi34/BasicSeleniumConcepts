package seleniumJavaCode;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demo-opencart.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		WebElement desktop=driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
		WebElement mac=driver.findElement(By.xpath("//a[normalize-space()='Mac (2)']"));
//		actions class
		Actions act = new Actions(driver);
		act.moveToElement(desktop).moveToElement(mac).click().build().perform();
		//act.moveToElement(desktop).moveToElement(mac).click().perform();
				
	}

}
