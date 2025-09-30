package seleniumJavaCode;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticatedPopupHandle {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/basic_auth");
		
		//Syntax
		//http://username:password@the-internet.herokuapp.com/basic_auth
//		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("alert('Hello, World!');");

	}

}
