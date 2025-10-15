package seleniumJavaCode;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownBootstrap {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //implicit wait
		driver.get("http://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().window().maximize();
		
		WebElement multi=driver.findElement(By.xpath("//button[contains(@class,'multiselect')]"));
		multi.click();
		Thread.sleep(2000);
		
		//select only single option
//		driver.findElement(By.xpath("//input[@value='Java']")).click();
		
		//capture all option and find the size 
//		List<WebElement> options = driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//label"));
		List<WebElement> options = driver.findElements(By.xpath("//ul/li//a//label"));
		System.out.println("Number of options:"+options.size());
		
//		for(WebElement a : options)
//		{
//			System.out.println(a.getText());
//		}
		//select desired single option through iteration
		for (WebElement a : options)
		{
			String s = a.getText();
			if(s.equals("Java") || s.equals("MySQL"))
			{
				a.click();
			}
		}
		

	}

}
