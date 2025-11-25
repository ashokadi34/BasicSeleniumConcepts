package basicSeleniumJava;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

public class WebTableTest {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.navigate().to("https://www.google.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("q")).sendKeys("List of Marvel Cinematic Universe films");	
		Thread.sleep(1000);
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//h3[normalize-space()='List of Marvel Cinematic Universe films']")).click();
		Thread.sleep(2000);
		
		String website_Title = driver.getTitle();
		System.out.println("Title of Web Page: "+website_Title);
		Thread.sleep(1000);
		
		try {
		
		List<String> phase_1_movies=new ArrayList<>();
		List<String> phase_2_movies=new ArrayList<>();
		List<String> phase_3_movies=new ArrayList<>();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement ph1=driver.findElement(By.xpath("//h4[@id='Phase_One']"));
		js.executeScript("arguments[0].scrollIntoView()", ph1);
		Thread.sleep(1000);
		
		for(int i=2;i<=7;i++) {
			String s1=driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[3]/main[1]/div[3]/div[3]/div[1]/table[3]/tbody[1]/tr["+i+"]/th[1]/i[1]/a[1]")).getText();
			phase_1_movies.add(s1);
		}
			System.out.println("Phase 1 movies: "+phase_1_movies);
			Thread.sleep(1000);
		
		WebElement ph2=driver.findElement(By.xpath("//h4[@id='Phase_Two']"));
		js.executeScript("arguments[0].scrollIntoView()", ph2);
		Thread.sleep(1000);
		
		for(int i=2;i<=7;i++) {
			String s2=driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[3]/main[1]/div[3]/div[3]/div[1]/table[4]/tbody[1]/tr["+i+"]/th[1]/i[1]/a[1]")).getText();
			phase_2_movies.add(s2);
		}
			System.out.println("Phase 2 movies: "+phase_2_movies);
			Thread.sleep(1000);
		
		WebElement ph3=driver.findElement(By.xpath("//h4[@id='Phase_Three']"));
		js.executeScript("arguments[0].scrollIntoView()", ph3);
		Thread.sleep(1000);
		
		for(int i=2;i<=12;i++) {
			String s3=driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[3]/main[1]/div[3]/div[3]/div[1]/table[5]/tbody[1]/tr["+i+"]/th[1]/i[1]/a[1]")).getText();
			phase_3_movies.add(s3);
		}
			System.out.println("Phase 3 movies: "+phase_3_movies);
			Thread.sleep(1000);
			
		}
		catch(Exception e) {
			System.out.println("NO DATA FOUND");
		}
			
			driver.close();
		
	}
}