package seleniumJavaCode;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {
	
	static void selectFutureDate(WebDriver driver,String year,String month,String date)
	{
		while(true)
		{
			String currentMonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentYear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			if (currentMonth.equals(month) && currentYear.equals(year))
			{
				break;
			}
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); //next
			
		}
			
		List<WebElement>allDates=driver.findElements(By.xpath("//table//tbody//tr//td//a"));
		
		for(WebElement d : allDates)
		{
			String currentDate=d.getText();
			if(currentDate.equals(date))
			{	
				d.click();
				break;
			}
			
		}
	}
	
	 static void selectPastDate(WebDriver driver,String year,String month,String date)
	{
		while(true)
		{
			String currentMonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentYear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			if (currentMonth.equals(month) && currentYear.equals(year))
			{
				break;
			}
			
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); //previous
		}
			
		List<WebElement>allDates=driver.findElements(By.xpath("//table//tbody//tr//td//a"));
		
		for(WebElement d : allDates)
		{
			String currentDate=d.getText();
			if(currentDate.equals(date))
			{	
				d.click();
				break;
			}
			
		}
	}

	public static void main(String[] args) {
				
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();		
//		driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("05/10/2020");
		
		String year="2023";
		String month="April";
		String date="15";
		
		//selectFutureDate(driver, year, month, date); //for Future date
		selectPastDate(driver, year, month, date);
		

	}

}
