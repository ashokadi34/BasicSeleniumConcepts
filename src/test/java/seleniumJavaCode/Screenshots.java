package seleniumJavaCode;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshots {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		//full page screenshot
		/*TakesScreenshot ts = (TakesScreenshot)driver;
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
//		File targetfile = new File("C:\\Workspace\\seleniumJava\\screenshots\\fullpage.png");
		File targetfile = new File(System.getProperty("user.dir")+"\\screenshots\\fullpage.png");		
		sourcefile.renameTo(targetfile);	//copy source file to target file
		*/
//		capture specific element
		WebElement ss=driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		File source=ss.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"\\screenshots\\ss1.png");		
		source.renameTo(target);	//copy source file to target file

	}

}
