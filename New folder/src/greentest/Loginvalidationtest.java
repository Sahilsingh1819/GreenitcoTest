package greentest;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Loginvalidationtest {

	public static void main(String[] args) {
		WebDriver driver;
		driver = new ChromeDriver();
		
		driver.get(" https://itassetmanagementsoftware.com/rolepermission/admin/login ");
		driver.manage().window().maximize();
		
		WebElement usernameTextbox = driver.findElement(By.id("username"));
		WebElement continuebutton = driver.findElement(By.xpath("//button[@type='button']"));
		
		//Fill Text in username
		usernameTextbox.sendKeys("Sahil12");
	
		//click to continue button
		continuebutton.click();
			
		 Duration timeoutDuration = Duration.ofSeconds(10);
	     WebDriverWait wait = new WebDriverWait(driver, timeoutDuration);
	     
	     WebElement errormessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='validateUserMsg']")));
	     
	     // Wait for the error message element to be visible
	     wait.until(ExpectedConditions.visibilityOf(errormessage));
	     System.out.println("Error message is : " + errormessage.getText());  
	
	
	     // Log the error message to a text file
	     try {
	         FileWriter writer = new FileWriter("error_log.txt", true);
	         writer.write("Error message: " + errormessage.getText() + "\n");
	         writer.close();
	         System.out.println("Error message logged to file.");
	     } catch (IOException e) {
	         System.out.println("An error occurred while logging to file.");
	         e.printStackTrace();
	     }
	     
	     
	     
	     


	}

}
