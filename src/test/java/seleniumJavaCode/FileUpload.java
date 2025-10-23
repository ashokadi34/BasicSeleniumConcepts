package seleniumJavaCode;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

	public static void main(String[] args) {		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().window().maximize();
		//For uploading one file
		/*driver.findElement(By.xpath("//input[@id='filesToUpload']"))
				.sendKeys("C:\\Users\\ASUS\\OneDrive\\Desktop\\test1.txt");
		if(driver.findElement(By.xpath("//ul[@id='fileList']//li")).getText().equals("test1.txt"))
		{
			System.out.println("File Sucessfully uploaded");
		}
		else
		{
			System.out.println("File Upload failed");
		}*/
		//For uploading two files
		String file1="C:\\Users\\ASUS\\OneDrive\\Desktop\\test1.txt";
		String file2="C:\\Users\\ASUS\\OneDrive\\Desktop\\test2.txt";
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(file1+"\n"+file2);
		int count=driver.findElements(By.xpath("//ul[@id='fileList']//li")).size();
		//validation for count of files uploaded
		if(count==2)
		{
			System.out.println("All files uploaded");
		}
		else
		{
			System.out.println("All files not uploaded");
		}
		//validation for file names
		if(driver.findElement(By.xpath("//ul[@id='fileList']//li[1]")).getText().equals("test1.txt") 
				&& driver.findElement(By.xpath("//ul[@id='fileList']//li[2]")).getText().equals("test2.txt") )
		{
			System.out.println("File names are matching");
		}
		else
		{
			System.out.println("Files are not matching");
		}

	}

}
