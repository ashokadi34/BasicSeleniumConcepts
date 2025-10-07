package seleniumJavaCode;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * 1) Check link has href attriute value or not. || Link herf="https://xyz.com"
 * 2) Hit link to server and get status code from server.
 * 3) Status code>=400  Broken link || Status code<400  Not a broken link
 */

public class BrokenLinks {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://www.deadlinkcity.com/");				
		driver.manage().window().maximize();
		
		//capture all links from website
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total number of links: "+links.size());
		
		int noOfBrokenLinks=0;
		int notBrokenLinks=0;
		
		//1)Check link has href attriute value or not.
		for(WebElement linkElement : links)
		{
			String hrefValue = linkElement.getAttribute("href");
			
			if(hrefValue==null || hrefValue.isEmpty())
			{
				System.out.println("href value is null or empty");
				continue;
			}
			
			
			try 
			{
				//2)Hit link to server and get status code from server.
				URL linkURL = new URL(hrefValue); // convert href value from string to URL
				HttpURLConnection conn = (HttpURLConnection) linkURL.openConnection(); //open connection to the server
				conn.connect(); // connect to server and send request the server
			
				//3)Status code>=400  Broken link || Status code<400  Not a broken link
				if(conn.getResponseCode()>=400)
				{
					System.out.println("Broken link=========>"+hrefValue);
					noOfBrokenLinks++;
				}
				else
				{
					System.out.println("Not Broken link=========>"+hrefValue);
					notBrokenLinks++;
				}
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			} 
			
		}
			System.out.println("Number of broken links: "+noOfBrokenLinks);
			System.out.println("Not Broken links: "+notBrokenLinks);

	}

}
