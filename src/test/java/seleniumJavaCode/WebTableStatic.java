package seleniumJavaCode;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableStatic {

	public static void main(String[] args)  {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //implicit wait
		driver.get("http://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		System.out.println("No. of rows: "+rows);
		
		int columns = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		System.out.println("No. of columns: "+columns);
		
//		String recordName = driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]")).getText();
//		System.out.println(recordName);
		
		//read data from all rows and columns
//		String header = driver.findElement(By.xpath("//table[@name='BookTable']//tr[1]")).getText();
//		System.out.println(header);
		
//		for(int r=2; r<=rows; r++)
//		{
//			for(int c=1; c<=columns; c++)
//			{
//				String value = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
//				System.out.print(value+"\t");
//			}
//				System.out.println();			
//		}
		
		//print book names whose author is Mukesh//***
//		for(int r=2; r<=rows; r++)
//		{
//			String aName = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
//			if(aName.equals("Mukesh"))
//			{
//				String bName = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
//				System.out.println(bName+ "\t"+ aName);
//			}
//		}
//		
		//count total price of all books
		int total=0;
		for(int i=2;i<=rows; i++)
		{
			String price = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[4]")).getText();
			total = total+Integer.parseInt(price);
		}
		System.out.println("total price of all books: "+total);

	}

}
