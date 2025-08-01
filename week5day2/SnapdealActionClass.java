package assignments.week5day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SnapdealActionClass {

	public static void main(String[] args)
			throws IOException, InterruptedException 
	{
		   //Initialize the chromedriver
			ChromeDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	        //Load the url
	        driver.get("https://www.snapdeal.com/");
	        
	        //instantiate Action class
	        Actions actions = new Actions(driver);
	        
	        // Go to "Men's Fashion"
	        WebElement Mensfashion = driver.findElement(By.linkText("Men's Fashion"));
	        actions.moveToElement(Mensfashion).perform();
	        
	        //Go to "Sports Shoes"
	        WebElement Sportsshoe = driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]"));
	        Sportsshoe.click();
	        
	        //To Get the count of sports shoes
	        WebElement count = driver.findElement(By.xpath("//span[@class='category-name category-count']"));
	        System.out.println("COUNT OF SPORTS SHOES: "+count.getText());
	        
	        //To Click on "Training Shoes"
	        WebElement Trainingshoe = driver.findElement(By.xpath("//div[text()='Training Shoes']"));
	        Trainingshoe.click();
	        
	        //To  Sort the products by "Low to High"
	        driver.findElement(By.xpath("//div[@class='sort-drop clearfix']")).click();
	        driver.findElement(By.xpath("//li[@data-sorttype='plth']")).click();
	        
	        //To  Check if the displayed items are sorted correctly
	        List<WebElement> prices = driver.findElements(By.className("product-price"));
	        if (prices.size() >= 2) 
	        {
	        	int price1 = Integer.parseInt(prices.get(0).getText().replaceAll("[^0-9]", ""));
	            int price2 = Integer.parseInt(prices.get(1).getText().replaceAll("[^0-9]", ""));
	            if (price1 <= price2) 
	            {
	                System.out.println("Sorted correctly");
	            } else
	            {
	                System.out.println("Sorting incorrect");
	            }
	        }
	        
	        
	        //To Select any price range ex:(500-700)
	        driver.findElement(By.name("fromVal")).clear();
	        driver.findElement(By.name("fromVal")).sendKeys("500");
	        driver.findElement(By.name("toVal")).clear();
	        driver.findElement(By.name("toVal")).sendKeys("700");
	        driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
	        Thread.sleep(3000);
	        
	        //To Filter by any colour
	        WebElement colour= driver.findElement(By.xpath("//a[text()=' White & Blue']"));
	        driver.executeScript("arguments[0].click();",colour);
	        
	        //To Verify all the applied filters
	        List<WebElement> filters = driver.findElements(By.xpath("//div[@class='filters']/div/a"));
	        System.out.println("APPLIED FILTERS: ");
	        for (WebElement filter : filters) 
	        {
	            System.out.println(filter.getText());
	        }
	        
	        //To Mouse hover on the first resulting "Training Shoes"
	        WebElement firstshoe = driver.findElement(By.xpath("//img[@class='product-image wooble']"));
	        actions.moveToElement(firstshoe).perform();
	        
	        //To Click the "Quick View" button
	        driver.findElement(By.xpath("(//div[contains (text(), 'Quick View')])[1]")).click();
	       
	        
	        //To  Print the cost and the discount percentage
	        WebElement cost_discount = driver.findElement(By.xpath("//div[@class='product-price pdp-e-i-PAY-l clearfix']"));
	        System.out.println("COST AND DISCOUNT% ; " + cost_discount.getText());
	        Thread.sleep(3000);
	        
	        //To Take a snapshot of the shoes
	        File src=driver.getScreenshotAs(OutputType.FILE);
			File dest=new File("./snapshots/snapdeal.png");
			FileUtils.copyFile(src, dest);
	       
	        
	       //To Close windows
	        driver.quit();
	        
	        
	        
	        
	        
	        
	        
	
	}

}
