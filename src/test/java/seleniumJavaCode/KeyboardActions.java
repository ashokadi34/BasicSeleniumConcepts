package seleniumJavaCode;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://text-compare.com/");
//		driver.get("https://demo-opencart.com/");	//**
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//textarea[@id='inputText1']")).sendKeys("WELCOME");
		//driver.findElement(By.xpath("//textarea[@id='inputText2']"));
		Actions act = new Actions(driver);	//**
//		WebElement a=driver.findElement(By.xpath("//p[contains(text(),'Powered By')]"));	//**
//		act.scrollToElement(a).perform();	//**
		//Ctrl+A
		act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		//Ctrl+C
		act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
		//Tab
		act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		//Ctrl+V
		act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
		//Enter key
		//act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
		//Ctrl+Shift+A
		//act.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys("A").keyUp(Keys.SHIFT).keyUp(Keys.CONTROL).perform();
		
	}

}
