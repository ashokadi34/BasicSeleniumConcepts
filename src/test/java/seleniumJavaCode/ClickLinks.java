package seleniumJavaCode;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ClickLinks {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        // Initialize the Chrome driver
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // implicit wait
        driver.get("http://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        // Locate the search box and perform a search
        driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("selenium");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        
        WebElement all= driver.findElement(By.xpath("//div[@id='Wikipedia1_wikipedia-search-results']"));
        List<WebElement> allTags = all.findElements(By.tagName("a"));
        System.out.println("allTags: "+allTags.size());
        int allTagLinks=0;
        
        
        for(WebElement eachTag:allTags)
        {
        	String eachTagName=eachTag.getText();
        	String eachTagLink = eachTag.getAttribute("href");       
        	System.out.println("eachTagName: "+eachTagName);
        	System.out.println("eachTagLink: "+eachTagLink);
        	
        	Actions act = new Actions(driver);
        	act.moveToElement(eachTag).click().build().perform();
        	Thread.sleep(2000);
        	//driver.switchTo().defaultContent();
        	
        }
        
        
        /*
        // Locate the link elements
        List<WebElement> linkElements = driver.findElements(By.xpath("//*[@id='wikipedia-search-result-link']"));        
        System.out.println("Total number of links: " + linkElements.size());

        // Click on each link
        for (WebElement linkElement : linkElements) {
            try {
                // Print the link text or URL
            	String linkValue = linkElement.getDomAttribute("href");
            	Thread.sleep(1000);
                System.out.println("Clicking on link : " + linkValue);
                System.out.println("Links Test : " + linkElement.getText());                   
                
                // Click the link
                //linkElement.click();               

                // Wait for a few seconds to observe the navigation
                Thread.sleep(2000);

                // Navigate back to the search results page
//                driver.navigate().back();

                // Re-locate the link elements (DOM might be refreshed)
//                linkElements = driver.findElements(By.xpath("//*[@id='wikipedia-search-result-link']"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Close the browser
        driver.quit();
        
        */
    }
}
