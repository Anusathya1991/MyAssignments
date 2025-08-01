package assignments.week5day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AmazonActionclass {

	public static void main(String[] args)
			throws IOException, InterruptedException 
	  {
	        //Initialize Chrome Driver
	        ChromeDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	        //Load the URL
	        driver.get("https://www.amazon.in/");
	        
	        //Search for oneplus 9 pro mobile
	        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
	        search.sendKeys("oneplus 9 pro mobile");
	        search.submit();
	        
	        //To get the price of the first product
	        String Firstproductprice = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
	        System.out.println("FIRST PRODUCT PRICE: " + Firstproductprice);
	        
	        //To  Print the number of customer ratings for the first displayed product
	        WebElement Customerrating = driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]"));
	        System.out.println("CUSTOMER RATING OF THE PRODUCT: "+ Customerrating.getText());
	        
	        // To Click the first text link of the first image
	        WebElement firstlink = driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-fixed-height'])[1]"));
	        Actions actions = new Actions(driver);
	        actions.moveToElement(firstlink).click().perform();
	        
	        //Switch to new window
	        for (String newwindow: driver.getWindowHandles())
	        {
	            driver.switchTo().window(newwindow);
	        }
	        
	       //To Take a screenshot of the product displayed
	        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(org.openqa.selenium.OutputType.FILE);
	        File destFile = new File("OnePlus9Pro_Screenshot.png");
	        FileUtils.copyFile(srcFile, destFile);
	        System.out.println("SCREENSHOT TAKEN");
	        
	        //To Click the 'Add to Cart' button
	        WebElement Addcart = driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[2]"));
	        Addcart.click();
	        Thread.sleep(3000);
	        
	               
	        //To Get the cart subtotal
	        String Subtotal = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();	
	        System.out.println("SUBTOTAL : "+Subtotal);
			
			// To verify the Subtotal
			if(Firstproductprice.equals(Subtotal))
			{
				System.out.println("SUBTOTAL IS SAME ");
			}
			else 
			{
				System.out.println("SUBTOTAL IS NOT SAME");
			}
			
			//driver.close();
	        
	        
	  }
}
		
