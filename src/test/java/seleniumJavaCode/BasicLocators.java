package seleniumJavaCode;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicLocators {

public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();		
		driver.get("https://demo-opencart.com/");				
		driver.manage().window().maximize();		
		Thread.sleep(1000);
		
		driver.findElement(By.name("search")).sendKeys("Mac");
		driver.findElement(By.xpath("//button[@class='btn btn-light btn-lg']")).click();
		
//		boolean s=driver.findElement(By.id("logo")).isDisplayed();
//		System.out.println("Logo displayed status: "+s);
			
//		driver.findElement(By.linkText("Tablets")).click();
		
//		List<WebElement>links=driver.findElements(By.className("list-inline-item"));
//		System.out.println("number of links in header of page: "+links.size());
		
//		List<WebElement>links=driver.findElements(By.className("list-inline-item"));
//		for(WebElement a : links) {
//			System.out.println(a.getText()+"-"+a.getAttribute("href"));
//		}
		
//		List<WebElement>lins=driver.findElements(By.tagName("a"));
//		System.out.println("number of total links in page: "+lins.size());
	 
		driver.close();
		
	}
}
