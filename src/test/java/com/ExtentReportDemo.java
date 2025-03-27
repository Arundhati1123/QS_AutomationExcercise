package com;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentReports.*;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ExtentReportDemo

{
WebDriver driver;
public static ExtentReports report;
public static ExtentTest test;


@BeforeTest
public void launch()
{
WebDriverManager.chromedriver().setup();
driver=new ChromeDriver();
driver.manage().window().maximize();

// Generate/creating path for   report in project
ExtentSparkReporter htmlReporter = new ExtentSparkReporter("G:\\\\Arundhati\\\\QuantumsoftProj\\\\QS_Automation\\\\reports\\\\report.html");

//calling reportclass after launching url or // Initialize the report
report=new ExtentReports();

//Attach the htmlreport to the report
report.attachReporter(htmlReporter);


//// Initialize the test here ontest start()
test=report.createTest("Extent Report Demo");


driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.get("https://www.google.com/");
}

@AfterTest
public void teardown()
{
	driver.close();

report.flush();
	}

@Test(priority=1)
public void validateTitle()
{
	//to show test log status
			test.log(Status.INFO, "TestCase validate tile is started");
	String title=driver.getTitle();
	System.err.println(title);
			test.log(Status.PASS, title);
	
	}

@Test(priority=2)
public void gmailValidate()
{
			test.log(Status.INFO, "TestCase gmailvalidate  is started");
	driver.findElement(By.linkText("Gmail")).click();
	//giving warning
			test.log(Status.WARNING, "User is redirected ");
	
driver.findElement(By.linkText("Sign in")).click();

String title=driver.getTitle();
System.err.println(title);
			test.log(Status.PASS, title);
}

@Test(priority=4)
public void skipTest()
{
	test.log(Status.SKIP, "Skip test ... ");
	throw new SkipException("This test is skipped..");
}


@Test (priority=3)
public void loginTest() throws IOException
{
	try
	{
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("ARU");
		test.log(Status.PASS, "User entered password scuessfully... ");
		
	}
	catch (Exception e)
	{
		test.log(Status.FAIL,test.addScreenCaptureFromPath(CaptureScreenShot(driver))+"login testcase failed ... ");
		//to add screenshot for failtest case call method frm extent test class addscreencapturefrompath(call our screenshot function)
		
	}
	
}


public static String CaptureScreenShot(WebDriver driver) throws IOException   //userdefine function
{
	
	File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	File destFile= new File("src/../Report_ScreenShots/"+System.currentTimeMillis()+".png" );
	
	// Get the user's home directory dynamically
  //  String userDir = System.getProperty("user.dir");
    // Define the universal path
   // String screenshotPath = userDir + File.separator + "Report_ScreenShots" + File.separator + "SignUp-screenshot.png";
	//File destFile=new File(screenshotPath);   
	
    String absolutePath=destFile.getAbsolutePath(); 
 	// Save the screenshot
	 FileUtils.copyFile(srcFile,destFile);

	 return absolutePath; //return abs path for giving extent report
	 
				
}

}



