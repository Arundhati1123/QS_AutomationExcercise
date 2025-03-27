package automationexcercise;


import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. take input name and email address from keyboard
7. Click 'Signup' button
8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
9. Fill details: Title, Name, Email, Password, Date of birth
10. Fill details: First name, Last name, Address, Address2, Country, State, City, Zipcode, Mobile Number
11. Click 'Create Account button'
12. Verify that 'ACCOUNT CREATED!' is visible
13. Click 'Continue' button
14. Click 'Logout' button
15. verify sign up page for invalid credentials
18. Take a screenshots
*/


public class User_Registration_TC 
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
	public void signUp()
		{
			//click on signup button
			driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();
			
			//.verify new user signup text is visible  
			
			boolean signUptext=driver.findElement(By.xpath("//h2[text()='New User Signup!']")).isDisplayed();
			assertTrue(signUptext,"'New User Signup!'is not visible");
		}
	
	
	
    
	@Test(priority=2)
	public void signUpPositive()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Username ");
		String un=sc.next();
		System.out.println("Enter Email ");
		String ue=sc.next();			
					
		WebElement Uname=driver.findElement(By.xpath("//input[@placeholder='Name']"));
		Uname.sendKeys(un);
	    WebElement Uemail=driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
	    Uemail.sendKeys(ue);
	    WebElement signupButton=driver.findElement(By.xpath("//button[text()='Signup']"));
	    signupButton.click();	       
            
	    boolean nextPageText=driver.findElement(By.xpath("//h2/b[text()='Enter Account Information']")).isDisplayed();
		assertTrue(nextPageText,"sign up page is not visible");

driver.findElement(By.xpath("//input[@id='id_gender2']")).click();
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Abc@123");
		
		driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Jivannya");
		driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Patil");
		
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Ravet");
		driver.findElement(By.xpath("//input[@id='state']")).sendKeys("maharastra");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("pune");
		driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("412101");
		driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("9011223388");
		
		driver.findElement(By.xpath("//button[text()='Create Account']")).click();
		// Verify successful account create 
         boolean acctText=driver.findElement(By.xpath("//h2/b[text()='Account Created!']")).isDisplayed();
		assertTrue(acctText,"'account crete 'is not visible");
		System.out.println("account cretaed ...");
		
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
		driver.findElement(By.xpath("//a[text()=' Logout']")).click();
		System.out.println("LogoutfromAccountCreate sucssesfuly...");
		
		} 
	@Test(priority=3)
	public void signUpNegitiveEmpty()
	{
	
		WebElement Uname=driver.findElement(By.xpath("//input[@placeholder='Name']"));
		Uname.clear();
	    WebElement Uemail=driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
	    Uemail.clear();
	    WebElement signupButton=driver.findElement(By.xpath("//button[text()='Signup']"));
	    signupButton.click();	       
            // Verify successful opening next page
        }
	
	@Test(priority=4)
	public void signUpNegitiveInvalid()
	{
		
		WebElement Uname=driver.findElement(By.xpath("//input[@placeholder='Name']"));
		Uname.sendKeys("Arundhati");
	    WebElement Uemail=driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
	    Uemail.sendKeys("aru@gmail com");
	    WebElement signupButton=driver.findElement(By.xpath("//button[text()='Signup']"));
	    signupButton.click();	       
      }
	
	@Test(priority = 5)
	public void testScreenshot() {

		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			 // Get the user's home directory dynamically
            String userDir = System.getProperty("user.dir");

            // Define the universal path
            String screenshotPath = userDir + File.separator + "Screenshots" + File.separator + "SignUp-screenshot.png";
//System.out.println(screenshotPath);          
            // Save the screenshot
            FileUtils.copyFile(srcFile, new File(screenshotPath));
			} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
	
	

