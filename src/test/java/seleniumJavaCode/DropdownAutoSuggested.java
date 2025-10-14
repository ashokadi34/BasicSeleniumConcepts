package seleniumJavaCode;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropdownAutoSuggested {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //implicit wait
		driver.get("http://google.com/");
		//driver.get("https://www.bjs.com/"); //bjs.com
		driver.manage().window().maximize();
		
		driver.findElement(By.name("q")).sendKeys("selenium");
		//driver.findElement(By.name("search")).sendKeys("mobile"); //bjs
		Thread.sleep(5000);
		
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@role='option']"));  //google
		//driver.findElement(By.xpath("//span[contains(.,'mobile phones')]")).click(); //bjs
		//List<WebElement> list = driver.findElements(By.xpath("//*[contains(@class,'list list-group')]")); //bjs
		System.out.println(list.size());
		
		for(int i=0; i<list.size();i++)
		{
			System.out.println(list.get(i).getText());
			if (list.get(i).getText().equals("selenium"))
			{
				list.get(i).click();
				break;
			}
		}
		
	}

}
