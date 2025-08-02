package marathon2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Tatacliq {

	public static void main(String[] args) 
	throws IOException, InterruptedException 
	{
		//Initialize the chromedriver
		ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //Load the url
        driver.get("https://www.tatacliq.com/");
        driver.findElement(By.xpath("//button[@id='moe-dontallow_button']")).click();
        
        //instantiate Action class
        Actions actions = new Actions(driver);
        
        //To  MouseHover on 'Brands'
        WebElement Brand = driver.findElement(By.xpath("//div[text()='Brands']"));
        actions.moveToElement(Brand).perform();
        
        //To  MouseHover on 'Watches & Accessories'
        WebElement Watches = driver.findElement(By.xpath("(//div[@class='DesktopHeader__categoryDetailsValue'])[4]"));
		actions.moveToElement(Watches).perform();
		
		//To Choose the first option from the 'Featured brands'
		WebElement FirstBrand = driver.findElement(By.xpath("//div[@class='DesktopHeader__featureBrands']/div[2]"));
		actions.click(FirstBrand).perform();
		
		//To  Select sortby: New Arrivals
		WebElement sort = driver.findElement(By.xpath("//select[@class='SelectBoxDesktop__hideSelect']"));
		Select option = new Select(sort);
		option.selectByVisibleText("New Arrivals");
		
		//To choose men from catagories filter
		WebElement selectmen = driver.findElement(By.xpath("(//div[@class='FilterDesktop__newFilName'])[1]"));
		selectmen.click();
		Thread.sleep(3000);
		
		//To print all price of watches
		List<WebElement> price = driver.findElements(By.xpath("//div[@class='ProductDescription__priceHolder']/h3"));
		System.out.println("PRICE OF WATCH LIST: ");
		for (WebElement pricelist : price)
		{
			System.out.println(pricelist.getText());
		}
			
		
		//To click on the first resulting watch
		WebElement firstwatch = driver.findElement(By.xpath("(//div[@class='ProductModule__flagHolder'])[1]"));
		driver.executeScript("arguments[0].click();",firstwatch);
		Thread.sleep(3000);
		
		//Window Handling 
		Set<String> windows=driver.getWindowHandles();
		List<String> window1=new ArrayList<String>(windows);
		driver.switchTo().window(window1.get(1));
		
		//To compare two price are similar
		WebElement watchrate = driver.findElement(By.xpath("//div[@class='ProductDetailsMainCard__price']//h3"));
		String watchrate1 = watchrate.getText();
		WebElement discountwatchrate = driver.findElement(By.xpath("//span[@class='ProductDescriptionPage__offerprice']"));
		String watchrate2 = discountwatchrate.getText();
		
		
		String price1= watchrate1.replaceAll("[^0-9]", "");
		String price2= watchrate2.replaceAll("[^0-9]", "");
		
		if (price1.equals(price2)) 
		{
			System.out.println("PRICE IS EQUAL");
		} 
		else 
		{
			System.out.println("PRICE IS NOT EQUAL");
		}
		
		//To take snapshot
		File src=driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("./snapshots/tatacliq.png");
		FileUtils.copyFile(src, dest);
		 System.out.println("SCREENSHOT TAKEN");
		
		//To click Add to cart and get count from the cart icon
		WebElement addcart = driver.findElement(By.xpath("(//span[@data-test='button'])[3]"));
		addcart.click();
		WebElement cartcount = driver.findElement(By.xpath("//span[@class='DesktopHeader__cartCount']"));
		String cartnumber = cartcount.getText();
		System.out.println("CARTCOUNT IS: "+cartnumber);
		
		//To Click on the cart
		driver.findElement(By.xpath("//div[@class='DesktopHeader__myBagShow']")).click();
		
		//To Close All the opened windows one by one
        driver.close();
		driver.switchTo().window(window1.get(0));
		//driver.quit();
		
	}

}
