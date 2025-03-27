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

/*1 Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'Products' button
5. Hover over first product and click 'Add to cart'
6. Click 'Continue Shopping' button
7. Hover over second product and click 'Add to cart'
8. Click 'View Cart' button
9. Verify both products are added to Cart
10. Verify their prices, quantity and total price
*/
public class AddToCart {
	
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
	public void addProductFromHomePage() {
		// Click on the "Add to cart" button for a  Blue top product on the home page
		
		   
		WebElement addToCartButton = driver.findElement(By.xpath("//a[@data-product-id='1']"));
		addToCartButton.click();
		
		// Handle modal if it appears (clicking on "Continue Shopping")
        WebElement continueButton = driver.findElement(By.xpath("//button[contains(text(),'Continue Shopping')]"));
        continueButton.click();
        
     // Click on the "Add to cart" button for a  Mens shirt  product on the home page
		   
     		WebElement addToCartButton1 = driver.findElement(By.xpath("//a[@data-product-id='2']"));
     		addToCartButton1.click();  
     		
     		// Handle modal if it appears (clicking on "Continue Shopping")
             WebElement continueButton1 = driver.findElement(By.xpath("//button[contains(text(),'Continue Shopping')]"));
             continueButton1.click();
             
             //Handle modal if it appears (clicking on view cart link
             WebElement viewcart = driver.findElement(By.xpath("//a[@href='/view_cart']"));
             viewcart.click();
        System.out.println("two items added in cart ");
        
	}

	@Test(priority = 4)
	  public void pricevalidation() {  
		 // Verify first product details
		boolean firstProductName=driver.findElement(By.xpath("//*[@id=\"product-1\"]/td[2]/h4/a[text()='Blue Top']")).isDisplayed();
		assertTrue(firstProductName,"Blue Top is not in cart"); 
		boolean firstProductPrice=driver.findElement(By.xpath("//*[@id=\"product-1\"]/td[3]/p[text()='Rs. 500']")).isDisplayed();
		assertTrue(firstProductPrice,"Incorrect price for Blue Top");  
		boolean firstProductQty=driver.findElement(By.xpath("//*[@id=\"product-1\"]/td[4]/button[text()='1']")).isDisplayed();
		assertTrue(firstProductQty,"Incorrect quantity for Blue Top"); 
		boolean firstProductTotalPrice=driver.findElement(By.xpath("//*[@id=\"product-1\"]/td[5]/p[text()='Rs. 500']")).isDisplayed();
		assertTrue(firstProductTotalPrice,"Incorrect Total Price for Blue Top");
		  System.out.println("validate first item details from cart ");
		
		// Verify second product details
			boolean secondProductName=driver.findElement(By.xpath("//*[@id=\"product-2\"]/td[2]/h4/a[text()='Men Tshirt']")).isDisplayed();
			assertTrue(secondProductName,"Men Tshirt is not in cart");   
			boolean secondProductPrice=driver.findElement(By.xpath("//*[@id=\"product-2\"]/td[3]/p[text()='Rs. 400']")).isDisplayed();
			assertTrue(secondProductPrice,"Incorrect price for Men Tshirt");  
			boolean secondProductQty=driver.findElement(By.xpath("//*[@id=\"product-2\"]/td[4]/button[text()='1']")).isDisplayed();
			assertTrue(secondProductQty,"Incorrect quantity for Men Tshirt"); 
			boolean secondProductTotalPrice=driver.findElement(By.xpath("//*[@id=\"product-2\"]/td[5]/p[text()='Rs. 400']")).isDisplayed();
			assertTrue(secondProductTotalPrice,"Incorrect Total Price for Men Tshirt");
			  System.out.println("validate Second item details from cart ");
			  
}
}
