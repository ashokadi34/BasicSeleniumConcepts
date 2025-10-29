package seleniumJavaCode;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JsExecutorClickSendkeys {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//Elements
		WebElement input=driver.findElement(By.xpath("//input[@id='name']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].setAttribute('value','JohnDeer')", input);
		js.executeScript("arguments[0].value='New Value'", input);
		WebElement radio=driver.findElement(By.xpath("//input[@id='male']"));
		js.executeScript("arguments[0].click()", radio);
		
//		String toDisable = "document.getElementById('email').setAttribute('disabled', '');";
		js.executeScript("document.getElementById('email').setAttribute('disabled', '');");
		Thread.sleep(2000);
		js.executeScript("document.getElementById('email').removeAttribute('disabled', );");

	}

}
