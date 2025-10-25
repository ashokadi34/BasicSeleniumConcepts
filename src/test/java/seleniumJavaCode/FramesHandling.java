package seleniumJavaCode;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FramesHandling {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		
		WebElement frame1 = driver.findElement(By.xpath("//*[@src='frame_1.html']"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.name("mytext1")).sendKeys("welcome");
		driver.switchTo().defaultContent();
		
		WebElement frame2 = driver.findElement(By.xpath("//*[@src='frame_2.html']"));
		driver.switchTo().frame(frame2);
		driver.findElement(By.name("mytext2")).sendKeys("selenium");
		driver.switchTo().defaultContent();
		
		WebElement frame3 = driver.findElement(By.xpath("//*[@src='frame_3.html']"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.name("mytext3")).sendKeys("java");		
		Thread.sleep(3000);				
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//div[@id='i8']//div[@class='AB7Lab Id5V1']")).click();		
		driver.switchTo().defaultContent();
		
		WebElement frame4 = driver.findElement(By.xpath("//*[@src='frame_4.html']"));
		driver.switchTo().frame(frame4);
		driver.findElement(By.name("mytext4")).sendKeys("automation");
		driver.switchTo().defaultContent();
		
		WebElement frame5 = driver.findElement(By.xpath("//*[@src='frame_5.html']"));
		driver.switchTo().frame(frame5);
		driver.findElement(By.name("mytext5")).sendKeys("framework");		
		driver.findElement(By.xpath("//a[@href='https://a9t9.com']")).click();
		Thread.sleep(3000);
		boolean logostatus =driver.findElement(By.xpath("//img[@alt='UI Vision by a9t9 software - Image-Driven Automation']")).isDisplayed();
		System.out.println("logo present status on 5th frame window : "+logostatus);
		driver.switchTo().defaultContent();
		
		driver.close();

	}

}
