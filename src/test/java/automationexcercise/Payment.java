package automationexcercise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Payment
{
	WebDriver driver = new ChromeDriver();
	
	 @Test(priority = 1)
	 public void payment() {
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.get("https://www.automationexercise.com/payment");
	        driver.findElement(By.xpath("//button[@id='submit']")).click();
	        
	        driver.findElement(By.xpath("//input[@name='name_on_card']")).sendKeys("Arundhati");
	        driver.findElement(By.xpath("//input[@name='card_number']")).sendKeys("11g55h7799");
	        driver.findElement(By.xpath("//input[@name='cvc']")).sendKeys("912");
	        driver.findElement(By.xpath("//input[@name='expiry_month']")).sendKeys("12");
	        driver.findElement(By.xpath("//input[@name='expiry_year']")).sendKeys("2030");
	        driver.findElement(By.xpath("//button[@id='submit']")).click();
	    }
}
