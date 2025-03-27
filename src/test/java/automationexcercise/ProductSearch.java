package automationexcercise;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class ProductSearch 
{	
	WebDriver driver = new ChromeDriver();

	@Test(priority = 1)
	public void setUp() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		driver.get("https://www.automationexercise.com/");
	}

	@Test(priority = 2)
	public void testproducts() {
		WebElement products = driver.findElement(By.xpath("//a[@href='/products']"));
		products.click();
	}

	@Test(priority = 3)
	public void testProductSearch() {
		// Locate the search input field and enter a product name (e.g., "Top")
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='search_product']"));
		searchBox.sendKeys("Top");

		// Click the search button
		WebElement searchButton = driver.findElement(By.xpath("//button[@id='submit_search']"));
		searchButton.click();

		
	}

	@Test(priority = 4)
	public void testFilterByCategoryAndBrand() {

		
		// Click on a brand filter (example: "BIBA")
				WebElement brandFilter = driver.findElement(By.xpath("//a[text()='Biba']"));
				brandFilter.click();
				
				System.out.println("Filter Tc Passed");
				
		// Click on a sub category filter (example: "Women--->Dress")
			//	WebElement subcategoryFilter = driver.findElement(By.xpath("//div[text()='DRESS ']"));
				//System.out.println(subcategoryFilter);
				//subcategoryFilter.click();
	
			   
		
        // Wait for "WOMEN" category to be visible and click
				WebElement womenCategory = driver.findElement(By.xpath("//a[@href='#Women']"));
				 womenCategory.click();    
				 
				  // Initialize WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for "DRESS" subcategory to be visible and click
        WebElement dressCategory = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/category_products/1']")));
        dressCategory.click();
        System.out.println("women-->dress sub category clicked");
		 
        
	}

}
