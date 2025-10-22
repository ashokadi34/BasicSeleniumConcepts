package seleniumJavaCode;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitEx {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(20)); //explicit wait declaration
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		//explicit wait usage-ExpectedConditions
		WebElement img = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='company-branding']")));
		System.out.println(img.isDisplayed());  
		//explicit wait usage
		WebElement inp = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
		System.out.println(inp.isEnabled());
//		System.out.println(driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed());
//		System.out.println(driver.findElement(By.xpath("//input[@placeholder='Username']")).isEnabled());
		driver.close();
	}

}
