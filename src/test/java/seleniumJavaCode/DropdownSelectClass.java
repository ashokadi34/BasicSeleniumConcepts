package seleniumJavaCode;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DropdownSelectClass {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //implicit wait
		driver.get("http://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		
		WebElement dropdownElement = driver.findElement(By.xpath("//*[@id='country']"));
		Actions act = new Actions(driver);
		Select drpCountry = new Select(dropdownElement);  // using SELECT class		
//		drpCountry.selectByIndex(1);
//		drpCountry.selectByValue("uk"); //only VALUE attribute available in HTML
//		drpCountry.selectByVisibleText("France");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement country = driver.findElement(By.xpath("//label[normalize-space()='Country:']"));
		js.executeScript("arguments[0].scrollIntoView()", country);
		drpCountry.selectByValue("france");
		List<WebElement>options = drpCountry.getOptions();
		
		System.out.println("Total count dropdown options : "+options.size());
		
//		for(int i=0; i<options.size(); i++)
//		{
//			drpCountry.selectByIndex(i);
//			Thread.sleep(3000);
//		}
		
		for(WebElement opt:options)
		{
			System.out.println(opt.getText());
		}
		
		
	}

}
