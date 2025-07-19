package casestudy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonCasestudy2 {
	public static void main(String[] args) throws InterruptedException
	{
		ChromeDriver driver=new ChromeDriver();
		//Launch the browser
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		//Clicking the search Bar
	    WebElement searchbar=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchbar.sendKeys("T shirts",Keys.ENTER);
	    
	    Thread.sleep(2000);
	    //select the t shirt
	    driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-tall-aspect'])[1]")).click();
	    
	    Thread.sleep(1000);
	    //Add to cart
	    driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
	    
	    WebElement cart= driver.findElement(By.xpath("//div[@id='sw-subtotal']"));
	    String amount=cart.getText();
	    System.out.println("product added successfully");
	    System.out.println(amount);    
	}
}
