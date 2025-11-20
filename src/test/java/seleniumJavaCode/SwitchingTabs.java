package seleniumJavaCode;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SwitchingTabs {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions opt = new ChromeOptions();
		opt.addExtensions(new File("C:\\\\Users\\\\ASUS\\\\Downloads\\\\atab.crx"));
		//opt.addExtensions(new File("C:\\\\Users\\\\ASUS\\\\Downloads\\\\aaaw.crx"));
		Thread.sleep(4000);
		
				
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //implicit wait
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		Thread.sleep(10000);
		
		String activeTab = driver.getWindowHandle(); // Current active tab
		String title = driver.switchTo().window(activeTab).getTitle();
		System.out.println("Active Tab: " + title +" "+ "=" +" "+ activeTab);
		Thread.sleep(1000);
		
		driver.switchTo().newWindow(WindowType.TAB);
		Thread.sleep(1000);
		driver.get("https://www.orangehrm.com/");
		
		driver.switchTo().newWindow(WindowType.TAB);
		Thread.sleep(1000);
		driver.get("https://www.flipkart.com/");
		
		// Get all open tabs
//        Set<String> allTabs = driver.getWindowHandles();
//        String activeTab = driver.getWindowHandle(); // Current active tab
//        System.out.println("Active Tab: " + activeTab);
//
//        for (String tab : allTabs) {
//        	Thread.sleep(2000);
//            System.out.println("Open Tab: " + tab);
//        }

		Set<String> windowsList = driver.getWindowHandles();
		System.out.println("All window id's: "+windowsList);
		Thread.sleep(1000);
		
		List<String> windowIds = new ArrayList<String>(windowsList);
		System.out.println("Number of windows: "+windowIds.size());
		
		for (String winID : windowsList)
		{
			String titlee = driver.switchTo().window(winID).getTitle();
			Thread.sleep(5000);
			System.out.println(titlee);
		}

	}

}
