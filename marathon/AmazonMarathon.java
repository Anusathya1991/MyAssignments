package marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonMarathon {
	public static void main(String[] args) 
			throws InterruptedException 
	{
	ChromeDriver driver=new ChromeDriver();
	
	//launch url
	driver.get("https://www.amazon.in/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	//searchbar
	driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("bags for boys",Keys.ENTER);
	
	//print the number of bags
	WebElement results = driver.findElement(By.xpath("//h2[@class='a-size-base a-spacing-small a-spacing-top-small a-text-normal']"));
	System.out.println("Total no. of bags: " +results.getText());
	
	//Select the two brands
	driver.findElement(By.xpath("//li[@id='p_123/648962']//i")).click();
	driver.findElement(By.xpath("//li[@id='p_123/418063']//i")).click();
	Thread.sleep(2000);	
	
	//To Click the sort option
	driver.findElement(By.xpath("//span[@class='a-button-text a-declarative']")).click();
	driver.findElement(By.xpath("(//a[text()='Newest Arrivals'])[1]")).click();
	Thread.sleep(2000);
	
	//To print the first result
	WebElement firstBag = driver.findElement(By.xpath("(//h2[@class='a-size-base-plus a-spacing-none a-color-base a-text-normal'])[1]"));
	WebElement BagPrice = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
	System.out.println("The firstbag name after the search:  "+firstBag.getText());
	System.out.println("Discount Price : "+BagPrice.getText());
	Thread.sleep(2000);
	
	//To print page title
    System.out.println("Page Title: " + driver.getTitle());
    
    //driver.quit();
}
}