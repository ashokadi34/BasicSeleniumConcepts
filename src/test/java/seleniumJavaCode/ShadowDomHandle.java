package seleniumJavaCode;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDomHandle {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://dev.automationtesting.in/shadow-dom");
		driver.get("https://books-pwakit.appspot.com/");
		driver.manage().window().maximize();
		//use only css selector***
		//shadow host-> shadow root-> shadow element
		SearchContext shadow = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
		Thread.sleep(1000);
		shadow.findElement(By.cssSelector("#input")).sendKeys("WELCOME");

	}

}
