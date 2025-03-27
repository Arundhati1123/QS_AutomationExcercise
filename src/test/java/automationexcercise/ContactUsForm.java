package automationexcercise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContactUsForm {
	
	 WebDriver driver = new ChromeDriver();

	    @Test(priority = 1)
	    public void setUp() {
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.get("https://www.automationexercise.com/");
	        driver.findElement(By.xpath("//a[normalize-space()='Contact us']")).click();
	        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Arundhati");
	        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("AruShinde@gmail.com");
	        driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys("About product");
	        driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys("delevering..");
	        driver.findElement(By.xpath("//input[@name='submit']")).click();
	        
	        
	        
	    }

}
