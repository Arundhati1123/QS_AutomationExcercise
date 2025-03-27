package automationexcercise;


import static org.testng.Assert.assertTrue;

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

/*
  1. Launch browser
            2. Navigate to url 'http://automationexercise.com'
            3. Verify that home page is visible successfully
            4. Click on 'Products' button
            5. Verify user is navigated to ALL PRODUCTS page successfully
            6. The products list is visible
            7. Click on 'View Product' of first product
            8. User is landed to product detail page
            9. Verify that detail detail is visible: product name, category, price, availability, condition, brand""")
 */
public class ProductDetails
{

	WebDriver driver = new ChromeDriver();

	@Test(priority = 1)
	public void setUp() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		driver.get("https://www.automationexercise.com/");
	}

	@Test(priority = 2)
	public void testproductsText() {
		WebElement products = driver.findElement(By.xpath("//a[@href='/products']"));
		products.click();
		
		boolean allproducts=driver.findElement(By.xpath("//h2[text()='All Products']")).isDisplayed();
		assertTrue(allproducts,"'prodcuts! are  not visible");
	
	}
	
	
	 @Test(priority = 3)
	    public void clickOnProduct() {
	        // Click on the first "View Product" link available on the homepage
	        WebElement viewProductLink = driver.findElement(By.xpath("(//a[contains(text(),'View Product')])[1]"));
	        viewProductLink.click();
	    }
	    
	    @Test(priority = 4)
	    public void validateProductDetails() {
	        // Validate product name is displayed
	        WebElement productName = driver.findElement(By.xpath("//div[@class='product-information']/h2"));
	        Assert.assertTrue(productName.isDisplayed(), "Product name is not displayed");

	        // Validate product price is displayed
	        WebElement productPrice = driver.findElement(By.xpath("//div[@class='product-information']/span/span"));
	        Assert.assertTrue(productPrice.isDisplayed(), "Product price is not displayed");

	        // Validate product description is displayed
	        WebElement productDescription = driver.findElement(By.xpath("//div[@class='product-information']/p[1]"));
	        Assert.assertTrue(productDescription.isDisplayed(), "Product description is not displayed");

	        // Validate product availability is displayed (assuming it contains the word "Availability")
	        WebElement productAvailability = driver.findElement(By.xpath("//b[normalize-space()='Availability:']"));
	        Assert.assertTrue(productAvailability.isDisplayed(), "Product availability is not displayed");
	    }
}
