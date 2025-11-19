package seleniumJavaCode;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchBrowserWindows {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //implicit wait
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(3000);
//		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		driver.findElement(By.xpath("//div[@class='d-flex web-menu-btn']//li[1]//a[1]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@id='Form_submitForm_action_request']")).click();
		Thread.sleep(3000);
		Set<String> windowsList = driver.getWindowHandles();
		System.out.println(windowsList);
		List<String> windowIds = new ArrayList(windowsList);
		System.out.println("Number of windows: "+windowIds.size());
		
//		String parentID = windowIds.get(0);
//		String childID = windowIds.get(1);
//		driver.switchTo().window(parentID);
//		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		
		for (String winID : windowsList)
		{
			String title = driver.switchTo().window(winID).getTitle();
			System.out.println(title);
			
//			if (title.equals("OrangeHRM"))
//			{
//				driver.close();
//			}
		}

	}

}
