package seleniumJavaCode;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AddExtensionsRuntime {

	public static void main(String[] args) {
		
		ChromeOptions opt = new ChromeOptions();
		//File file = new File("C:\\Users\\ASUS\\Downloads\\SelectorsHub-Chrome-Web-Store.crx");
		opt.addExtensions(new File("C:\\Users\\ASUS\\Downloads\\SelectorsHub-Chrome-Web-Store.crx"));
		//File file = new File("C:\\Users\\ASUS\\Downloads\\KeepTabActive.crx");
		//opt.addExtensions(new File("C:\\\\Users\\\\ASUS\\\\Downloads\\\\KeepTabActive.crx"));
		
		WebDriver driver = new ChromeDriver(opt);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.flipkart.com/"); //https://demoqa.com/
		driver.manage().window().maximize();
	}

}
