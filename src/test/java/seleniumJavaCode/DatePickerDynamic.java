package seleniumJavaCode;

import java.time.Duration;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePickerDynamic {
	
	
	static Month convertMonth(String month)
	{
		HashMap<String, Month> monthMap=new HashMap<String, Month>();
		
		monthMap.put("January", Month.JANUARY);
		monthMap.put("February", Month.FEBRUARY);
		monthMap.put("March", Month.MARCH);
		monthMap.put("April", Month.APRIL);
		monthMap.put("May", Month.MAY);
		monthMap.put("June", Month.JUNE);
		monthMap.put("July", Month.JULY);
		monthMap.put("August", Month.AUGUST);
		monthMap.put("September", Month.SEPTEMBER);
		monthMap.put("October", Month.OCTOBER);
		monthMap.put("November", Month.NOVEMBER);
		monthMap.put("December", Month.DECEMBER);
		
		Month vmonth = monthMap.get(month);
		
		if(vmonth == null)
		{
			System.out.println("Invalid Month....");
		}
		return vmonth;
	}
	
	static void selectDate(WebDriver driver, String requiredYear, String requiredMonth, String requiredDay)
	{
		//select year
				WebElement yearDropdown= driver.findElement(By.xpath("//select[@aria-label='Select year']"));
				Select selectYear=new Select(yearDropdown);
				selectYear.selectByVisibleText(requiredYear);
				
				//select month
				while(true)
				{
					String displayedMonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
					//convert requiredMonth & displayedMonth into Month Object
					Month expectedMonth=convertMonth(requiredMonth);
					Month currentMonth=convertMonth(displayedMonth);
					
					//compare
					int result=expectedMonth.compareTo(currentMonth);
					
					//	0	months are equal					
					//	<0	past month
					//	>0	future month
					
					if(result<0)
					{
						driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
					}
					else if(result>0)
					{
						driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
					}
					else
					{
						break;
					}
					
				}
				
				//select date 
				List<WebElement>allDates=driver.findElements(By.xpath("//table//tbody//tr//td//a"));
				
				for(WebElement dt : allDates)
				{
					String currentDate=dt.getText();
					if(currentDate.equals(requiredDay))
					{	
						dt.click();
						break;
					}
					
				}
	}

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		String requiredYear="1995";
		String requiredMonth="May";
		String requiredDay="5";
		
		//driver.switchTo().frame(0);
		WebElement frame=driver.findElement(By.xpath("//iframe[@id='frame-one796456169']"));
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("//input[@id='RESULT_TextField-0']")).sendKeys("John");
		driver.findElement(By.xpath("//label[normalize-space()='Male']")).click();
		driver.findElement(By.xpath("//span[@role='button']")).click();
		
		selectDate(driver, requiredYear, requiredMonth, requiredDay);
		
		
	}

}
