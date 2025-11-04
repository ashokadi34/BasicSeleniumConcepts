package seleniumJavaCode;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JsWindowHeightWidth {
	
    public static void main(String[] args) throws InterruptedException {
       
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo-opencart.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        // Execute JavaScript to get window.innerWidth and window.innerHeight
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Long innerWidth = (Long) js.executeScript("return window.innerWidth;");
        Long innerHeight = (Long) js.executeScript("return window.innerHeight;");
        Thread.sleep(1000);
        // Execute JavaScript to get window.outerWidth and window.outerHeight
        Long outerWidth = (Long) js.executeScript("return window.outerWidth;");
        Long outerHeight = (Long) js.executeScript("return window.outerHeight;");
        Thread.sleep(1000);
        // Execute JavaScript to get document.documentElement.clientWidth and clientHeight
        Long clientWidth = (Long) js.executeScript("return document.documentElement.clientWidth;");
        Long clientHeight = (Long) js.executeScript("return document.documentElement.clientHeight;");
        Thread.sleep(1000);

        // Print the inner width and height
        System.out.println("Inner Width: " + innerWidth);
        System.out.println("Inner Height: " + innerHeight);
        // Print the outer width and height
        System.out.println("Outer Width: " + outerWidth);
        System.out.println("Outer Height: " + outerHeight);
        // Print the client width and height
        System.out.println("Client Width: " + clientWidth);
        System.out.println("Client Height: " + clientHeight);

        // Close the browser driver
        driver.quit();
    }
}

