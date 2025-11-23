package seleniumJavaCode;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebTableDynamic {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(50));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //implicit wait
		driver.get("https://demo-opencart.com/admin/index.php?route=common/login");
		driver.manage().window().maximize();
		
		WebElement user = driver.findElement(By.xpath("//input[@id='input-username']"));
		user.clear();
		user.sendKeys("demo");
		WebElement pass = driver.findElement(By.xpath("//input[@id='input-password']"));
		pass.clear();
		pass.sendKeys("demo");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		Thread.sleep(3000);
		
		if (driver.findElement(By.xpath("//button[@class='btn-close']")).isDisplayed())
		{
			driver.findElement(By.xpath("//button[@class='btn-close']")).click();
		}
		
		driver.findElement(By.xpath("//ul//li[@id='menu-customer']")).click();
		driver.findElement(By.xpath("//ul[@id='collapse-5']//a[contains(text(),'Customers')]")).click();
		
		String txt = driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();
		System.out.println(txt);
		String text = txt.substring(txt.indexOf("(")+1, txt.indexOf("Pages")-1);
		int pages = Integer.parseInt(text);
		System.out.println("total pages of table: "+pages);
		
		//WebElement active_page = driver.findElement(By.xpath("//a[normalize-space()='3']")).click();
		//active_page.click();
				
		for(int p=1;p<=4;p++)
		{
			
			if(p>1)
			{
				
				WebElement active_page = driver.findElement(By.xpath("//ul[@class='pagination']//*[text()="+p+"]"));
								
				//Thread.sleep(3000);
				System.out.println(active_page.getText());
				//active_page.click();
			}
			
		}
		
		
	}

}
