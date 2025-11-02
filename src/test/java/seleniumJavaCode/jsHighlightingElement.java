package seleniumJavaCode;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class jsHighlightingElement {
	
	
		public static void main(String[] args) throws InterruptedException {
		
			WebDriver driver = new ChromeDriver();	
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get("https://adactin.com/HotelApp/index.php");
			driver.manage().window().maximize();
			JavascriptExecutor j = (JavascriptExecutor) driver;
			// username and password highlighted by yellow color and red box
			WebElement username = driver.findElement(By.id("username"));
			j.executeScript("arguments[0].setAttribute('style','background: yellow;border: solid 2px red');", username);
			username.sendKeys("John");
			WebElement password = driver.findElement(By.id("password"));
			j.executeScript("arguments[0].setAttribute('style','background: yellow;border: solid 2px red');", password);
			j.executeScript("arguments[0].value=('style','background: yellow;border: solid 2px red');", password);
			password.sendKeys("John@1234");
			Thread.sleep(4000);
			// Login button highlighted by green color and red box
			WebElement login = driver.findElement(By.id("login"));
			j.executeScript("arguments[0].setAttribute('style','background: green;border: solid 2px red');", login);
			Thread.sleep(2000);
			login.click();
			
		
		}
}


