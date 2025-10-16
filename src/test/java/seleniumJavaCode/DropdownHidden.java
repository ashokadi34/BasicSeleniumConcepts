package seleniumJavaCode;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropdownHidden {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click();
		//click on drop down XPATH is important***
		driver.findElement(By.xpath("//body/div[@id='app']/div[@class='oxd-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='oxd-table-filter']/div[@class='oxd-table-filter-area']/form[@class='oxd-form']/div[@class='oxd-form-row']/div[@class='oxd-grid-4 orangehrm-full-width-grid']/div[6]/div[1]/div[2]/div[1]/div[1]")).click();
		//select single dropdown option
//		driver.findElement(By.xpath("//span[normalize-space()='Finance Manager']")).click();
		//count all options
		List<WebElement> allOpt = driver.findElements(By.xpath("//div[@role='listbox']//span"));////div//div//div[2]//div//span
//		List<WebElement> allOpt = driver.findElements(By.xpath("//div//div//div[2]//div//span"));
		System.out.println("count the all options : "+allOpt.size());
		
		for(WebElement a : allOpt)
			{
				System.out.println(a.getText());
			}
		
		
	}

}
