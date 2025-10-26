package seleniumJavaCode;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetConditionalMethods {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicit wait
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();		
		
//		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		
		System.out.println("current window url : "+driver.getCurrentUrl());
		System.out.println("current window title : "+driver.getTitle());
//		System.out.println(driver.getPageSource());
//		
//		System.out.println("window handle : "+driver.getWindowHandle());
		System.out.println("window handles : "+driver.getWindowHandles());
		
		Thread.sleep(3000);
		
		System.out.println(driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//input[@placeholder='Username']")).isEnabled());
		
		// close the driver			
		driver.quit();
	}

}
