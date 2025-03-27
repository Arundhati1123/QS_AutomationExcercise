package automationexcercise;


import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;





public class HomePage_TC
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
	//verify that home page is visible sucessfully
		@Test(priority=1)
		public void homePageTitleVerification()
		{
	
	String PageTitle=driver.getTitle();
	System.out.println("GET TITLE = "+PageTitle);
	Assert.assertEquals(PageTitle,"Automation Exercise","Incorrect Title");
	//assertEquals(PageTitle,"Automation Exercise","Incorrect Title");
	
		}
		
		//verify that Logo is visible sucessfully
		@Test(priority=1)
		public void LogoVerification()
		{
			boolean logoimg=driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']")).isDisplayed();
			assertTrue(logoimg,"Logo is not visible");
		}
		
		
		@Test(priority=3)
		public void signUpText()
		{
			//click on signup button
			driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();
			
			//.verify new user signup is visible  
			
			boolean signUptext=driver.findElement(By.xpath("//h2[text()='New User Signup!']")).isDisplayed();
			assertTrue(signUptext,"'New User Signup!'is not visible");
		} 
		
		@Test(priority=2)
		public void productsText()
		{
			//click on signup button
			driver.findElement(By.xpath("//a[text()=' Products']")).click();
			
			//.verify new user signup is visible
			
			boolean signUptext=driver.findElement(By.xpath("//img[@src='/static/images/shop/sale.jpg']")).isDisplayed();
			assertTrue(signUptext,"'Products are not visible");
		} 
		@Test(priority=4)
		public void testCasesText()
		{
			//click on signup button
			driver.findElement(By.xpath("//a[text()=' Test Cases']")).click();
			
			//.verify new user signup is visible  
			
			boolean signUptext=driver.findElement(By.xpath("//span[text()='Below is the list of test Cases for you to practice the Automation. Click on the scenario for detailed Test Steps:']")).isDisplayed();
			assertTrue(signUptext,"'Test Cases list !'is not visible");
		} 
		@Test(priority=5)
		public void contactUsText()
		{
			//click on signup button
			driver.findElement(By.xpath("//a[text()=' Contact us']")).click();
			//WebElement contactUsLink = driver.findElement(By.xpath("//a[normalize-space()='Contact us']"));
			//contactUsLink.click();
			//Assert.assertTrue(driver.getCurrentUrl().contains("contact_us"), "Navigation to Contact Us failed");
			//driver.navigate().back();
			
			//.verify new user signup is visible 
			
			boolean signUptext=driver.findElement(By.xpath("//h2[text()='Get In Touch']")).isDisplayed();
			assertTrue(signUptext,"'New User Signup!'is not visible");
		} 
		
 		@Test(priority=8)
		public void videoTutorialText()
		{
			//click on signup button
			driver.findElement(By.xpath("//a[text()=' Video Tutorials']")).click();
			
		System.out.println("TcPassed");	
		driver.navigate().back();

		} 
 		
 				@Test(priority=6)
 		public void testScrollingUp() 
 				{
 			JavascriptExecutor js = (JavascriptExecutor) driver;
 			// fetch the maximum height of the webpage from DOm and scroll down
 			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
 			//Scrolling up
 			driver.findElement(By.xpath("//*[@id='scrollUp']")).click();
 			System.out.println("Scrooling-DwonUp");
 			
 			//WebElement Element = driver.findElement(By.linkText("Auto Testing"));
 			//This will scroll the page Horizontally till the element is found
 			//  js.executeScript("arguments[0].scrollIntoView();", Element);
 		}
 		
 				@Test(priority=7)
 				public void responsiveTest()
 				{
 					
 					 // Configure ChromeOptions (optional, for headless mode)
 			        ChromeOptions options = new ChromeOptions();
 			       // options.addArguments("--headless"); // Comment this line if you want to see the browser
 			        
 			        // Create WebDriver instance
 			        WebDriver driver = new ChromeDriver(options);
 			        
 			        // Define screen sizes to test (width x height)
 			        int[][] screenSizes = 
 			        	{
 			            {1920, 1080}, // Desktop Full HD
 			            {1366, 768},  // Desktop HD
 			            {768, 1024},  // Tablet
 			            {360, 640},   // Mobile Portrait
 			            {640, 360}    // Mobile Landscape
 			        };

 			    // Test responsiveness by resizing the window and checking elements
 			        for (int[] size : screenSizes) 
 			        {
 			            int width = size[0];
 			            int height = size[1];

 			            // Resize the window
 			            driver.manage().window().setSize(new Dimension(width, height));
 			            System.out.println("Testing responsiveness at " + width + "x" + height);

 			            // Wait for the page to adjust (you can use WebDriverWait here for specific elements)
 			            try {
 			                Thread.sleep(3000); // Simulate waiting for page adjustments
 			            } catch (InterruptedException e) {
 			                e.printStackTrace();
 			            }
 			        }
 			        
 				}
 		
}

