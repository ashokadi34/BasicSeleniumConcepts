package seleniumJavaCode;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsUsingSwitch {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		//Normal alert
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		Alert myalert = driver.switchTo().alert();
		System.out.println("Alert message - "+myalert.getText());
		myalert.accept();
		WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
		System.out.println("Result message - "+result.getText());
				
		//Alert with OK & CANCLE 
//		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
//		Alert myalert = driver.switchTo().alert();
//		System.out.println("Alert message - "+myalert.getText());
//		myalert.dismiss();
//		WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
//		System.out.println("Result message - "+result.getText());
		
		//Alert with prompt
//		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
//		Alert myalert = driver.switchTo().alert();
//		System.out.println("Alert message - "+myalert.getText());
//		myalert.sendKeys("WELCOME");
//		myalert.accept();
//		WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
//		System.out.println("Result message - "+result.getText());
				
		
		driver.close();
	}

}
