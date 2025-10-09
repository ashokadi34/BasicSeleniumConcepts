package seleniumJavaCode;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsClass {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		//options.addExtensions(new File("/path/to/extension.crx"));		
		//options.addArguments("--disable-extensions");
		//options.addArguments("--headless=new");
		//options.addArguments("--incognito");				
		//options.addArguments("--disable-notifications");
		
		options.addArguments("--start-maximized", "--incognito");
		//options.setBinary(new File("/path/to/your/chrome/binary")); //launching page in specific chrome and default
		//options.setBinary("C:\\Path\\To\\chrome.exe");
		
		//options.setPageLoadStrategy(PageLoadStrategy.NORMAL);	//NORMAL-NONE-EAGER//
		
//		HashMap<String, Object> prefs = new HashMap<>();
		// 0 - Default, 1 - Allow, 2 - Block //*****
//		prefs.put("geolocation", 1);
//		prefs.put("profile.default_content_setting_values.notifications", 2);
//		options.setExperimentalOption("prefs", prefs);
		
		//options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"}); //**
//		options.setAcceptInsecureCerts(true);
		
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demo-opencart.com/");				
		//driver.manage().window().maximize();
		Thread.sleep(3000);			
		String actual_title=driver.getTitle();		
		
		if (actual_title.equals("Opencart Extensions"))		
		  { 
			System.out.println("Test Passed"); 
		  }
		else 
			{
				System.out.println("Test Failed"); 
			}
//		   		driver.close();

	}

}
