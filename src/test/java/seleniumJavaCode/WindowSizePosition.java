package seleniumJavaCode;



import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowSizePosition {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();		
		driver.get("https://demo-opencart.com/");		
		Thread.sleep(1000);
		
		driver.manage().deleteAllCookies();	// delete all cookies
		
		Dimension size = driver.manage().window().getSize();
		System.out.println("actual size while opening: "+size);
		Thread.sleep(2000);
						
		org.openqa.selenium.Dimension d = new org.openqa.selenium.Dimension(600, 600);
		driver.manage().window().setSize(d);	//setSize
		Thread.sleep(2000);
		
		Point p = new Point(250,250);
		driver.manage().window().setPosition(p);	//setPosition
		Thread.sleep(2000);
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		boolean s=driver.findElement(By.id("logo")).isDisplayed();
		System.out.println("Logo displayed status: "+s);

	}

}
