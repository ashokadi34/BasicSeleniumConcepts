package seleniumJavaCode;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Slider {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);
		//Minimum slider
		WebElement min_slider=driver.findElement(By.xpath("//div[@class='price-range-block']//span[1]"));
		System.out.println("Current location of min_slider 	"+min_slider.getLocation());	//(59, 250)
		act.dragAndDropBy(min_slider, 100, 250).perform();
		System.out.println("Location of min_slider after moving "+min_slider.getLocation());	//(158, 250)
		
		//Maximum slider
		WebElement max_slider=driver.findElement(By.xpath("//div[@class='price-range-block']//span[2]"));
		System.out.println("Current location of max_slider 	"+max_slider.getLocation());	//(612, 250)
		act.dragAndDropBy(max_slider, -100, 250).perform();
		System.out.println("Location of max_slider after moving "+max_slider.getLocation());	//(512, 250)

	}

}
