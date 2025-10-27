package seleniumJavaCode;

import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleOfWebpage {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();		
		driver.get("https://www.flipkart.com/");				
		driver.manage().window().maximize();		
		Thread.sleep(3000);
			
		String actual_title=driver.getTitle(); 
		
		if (actual_title.equals("Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!"))
			
		  { 
			System.out.println("Test Passed"); 
		  }
		else {
				System.out.println("Test Failed"); 
			 }
		  
		  		driver.close();
		 
	}

}
