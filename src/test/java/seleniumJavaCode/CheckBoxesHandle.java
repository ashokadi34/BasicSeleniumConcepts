package seleniumJavaCode;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CheckBoxesHandle {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //implicit wait
		driver.get("http://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();	
		
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@class='form-check-input'and@type='checkbox']"));
		
		System.out.println("Total count checkbox options : "+checkboxes.size());
		
//		for (WebElement ch : checkboxes)
//		{							
//			ch.click();
//		}
		
		for (int i=4;i<checkboxes.size();i++)  // select last 3 checkboxes (7-4)
		{
			checkboxes.get(i).click();
		}
			
	}

}
