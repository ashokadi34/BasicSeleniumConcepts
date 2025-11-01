package seleniumJavaCode;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JsExecutorScrollBar {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//1)scroll down page by pixel number
//		js.executeScript("window.scrollBy(0,1500)","");
//		System.out.println(js.executeScript("return window.pageYOffset",""));
		
		//2)scroll page till element is visible
//		WebElement element=driver.findElement(By.xpath("//strong[normalize-space()='Featured products']"));
//		js.executeScript("arguments[0].scrollIntoView()", element);		
//		System.out.println(js.executeScript("return window.pageYOffset",""));
		
		//3)scroll till end of the page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)","");
		System.out.println(js.executeScript("return window.pageYOffset",""));
		
		Thread.sleep(2000);
		
		//4)scroll to top of page
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)","");
		System.out.println(js.executeScript("return window.pageYOffset",""));
	
	}

}
