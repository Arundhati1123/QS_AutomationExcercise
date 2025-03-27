package com;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class temp_testng
{

	@Test
	public void StartBrowserAndOpenURL()
	{
	 ChromeDriver D = new ChromeDriver();
     D.manage().window().maximize();
     D.get("https://www.automationexercise.com");
		D.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test
	public void launch()
	{
		System.out.println("ARundhati");
		
	}
}
