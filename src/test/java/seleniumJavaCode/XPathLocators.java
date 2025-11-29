package seleniumJavaCode;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class XPathLocators {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo-opencart.com/");
		driver.manage().window().maximize();
		
//		Xpath with single attribute
//		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("MacBook");
//		driver.findElement(By.xpath("//*[@type='text']")).sendKeys("MacBook");
		
//		Xpath with multiple attribute
//		driver.findElement(By.xpath("//*[@name='search'][@placeholder='Search']")).sendKeys("MacBook");
		
//		Xpath with 'and' 'or' operators
//		driver.findElement(By.xpath("//*[@name='search' and @type='text']")).sendKeys("MacBook");
//		driver.findElement(By.xpath("//*[@name='search' or @type='textxxx']")).sendKeys("MacBook");
		
//		Xpath with inner text
//		driver.findElement(By.xpath("//a[text()='Cameras']")).click();	//inner text & link text	
//		boolean b = driver.findElement(By.xpath("//*[text()='Featured']")).isDisplayed(); //inner text  & not link text
//		System.out.println("Displayed status : "+b);
//		String d = driver.findElement(By.xpath("//*[text()='Featured']")).getText(); //inner text  & not link text
//		System.out.println("Text of element : "+d);
		
//		Xpath with contains() and starts-with()
//		driver.findElement(By.xpath("//*[contains(@placeholder,'earc')]")).sendKeys("MacBook");
//		driver.findElement(By.xpath("//*[starts-with(@placeholder,'Sea')]")).sendKeys("MacBook");
		
//		Xpath with chained Xpath
		boolean c = driver.findElement(By.xpath("//div[@id='logo']/a/img")).isDisplayed(); 
		System.out.println("Image Displayed status : "+c);
		
		
	}

}
