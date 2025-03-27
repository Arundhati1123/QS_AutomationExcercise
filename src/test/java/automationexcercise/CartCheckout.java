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


public class CartCheckout {
	WebDriver driver = new ChromeDriver();

	@BeforeClass
	public void setUp() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.automationexercise.com/");
	}

	@Test(priority = 1)
	public void testCartAndCheckout() throws InterruptedException {
		WebElement product = driver.findElement(By.xpath("//a[@href='/products']"));
		product.click();

		driver.findElement(By.xpath("//a[@data-product-id='1']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();
		
		driver.findElement(By.xpath("//a[@data-product-id='2']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a//u[text()='View Cart']")).click();
		
		//List <WebElement> firstProduct = driver.findElements(By.id("product-1"));
		//List <WebElement> secondProduct = driver.findElements(By.id("product-2"));
		
		driver.findElement(By.xpath("//a[text()='Proceed To Checkout']")).click();
	}

}
