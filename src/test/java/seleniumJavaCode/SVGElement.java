package seleniumJavaCode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SVGElement {

	public static void main(String[] args) {
		
		  WebDriver driver = new ChromeDriver();

	        // Navigate to the website containing the SVG element
	        driver.get("https://www.swiggy.com/");

	        // Locate the SVG element using XPath***//Dynamic
	        WebElement svgElement = driver.findElement(By.xpath("(//*[name()='svg'][@role='img'])[4]"));

	        // Perform actions with the SVG element (e.g., click, getText, etc.)
	        System.out.println("SVG element found: " + svgElement.isDisplayed());
	        
	        svgElement.click();

	        // Close the browser
	        //driver.quit();

	}

}
