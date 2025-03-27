package automationexcercise;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class User_Login_TC
{
	public 	WebDriver driver=new ChromeDriver();
	
	@BeforeClass
	public void setup()
	{		
		//Launch Browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		//Navigate to URL
		driver.get("https://www.automationexercise.com");
		
	}
		
	@Test(priority=1)
	public void signUpText()
		{
			//click on signup button
			driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();
			
			//.verify new user signup text is visible  
			
			boolean signUptext=driver.findElement(By.xpath("//h2[text()='Login to your account']")).isDisplayed();
			assertTrue(signUptext,"'Login to your account'is not visible");
		}
	
	@Test(priority=2)
	public void loginPositive()
	{
	    WebElement Uemail=driver.findElement(By.xpath("//input[@data-qa='login-email']"));
	    Uemail.sendKeys("aru@gmail.com");
		WebElement Upass=driver.findElement(By.xpath("//input[@data-qa='login-password']")); 
		Upass.sendKeys("Aru@123");
	    WebElement loginButton=driver.findElement(By.xpath("//button[text()='Login']"));
	    loginButton.click();	       
            // Verify successful opening next page
           
            boolean logoutLink=driver.findElement(By.xpath("//a[text()=' Logout']")).isDisplayed();
			assertTrue(logoutLink,"'Login page 'is not visible");
		System.out.println("Login Positive TC passed...");
		driver.findElement(By.xpath("//a[text()=' Logout']")).click();
		assertTrue(logoutLink,"'Login page 'is not visible");
		System.out.println("Logout sucssesfuly...");
		}
	
	@Test(priority=3)
	public void loginEmptyFeilds()
	{
	    WebElement Uemail=driver.findElement(By.xpath("//input[@data-qa='login-email']"));
	    Uemail.clear();
	    WebElement Upass=driver.findElement(By.xpath("//input[@data-qa='login-password']")); 
		Upass.clear();
	    WebElement loginButton=driver.findElement(By.xpath("//button[text()='Login']"));
	    loginButton.click();	       
         
	}
	
	@Test(priority=4)
	public void loginInvalidFeilds()
	{
	    WebElement Uemail=driver.findElement(By.xpath("//input[@data-qa='login-email']"));
	    Uemail.sendKeys("aru@gmailcom");
	    WebElement Upass=driver.findElement(By.xpath("//input[@data-qa='login-password']")); 
		Upass.sendKeys("12345");
	    WebElement loginButton=driver.findElement(By.xpath("//button[text()='Login']"));
	    loginButton.click();	       
         
	}
	
	@Test(priority = 5)
	public void testScreenshot() {

		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			 // Get the user's home directory dynamically
            String userDir = System.getProperty("user.dir");

            // Define the universal path
            String screenshotPath = userDir + File.separator + "Screenshots" + File.separator + "LoginInvalid-screenshot.png";
//System.out.println(screenshotPath);          
            // Save the screenshot
            FileUtils.copyFile(srcFile, new File(screenshotPath));
			} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
