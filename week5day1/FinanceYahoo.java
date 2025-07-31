package assignments.week5day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class FinanceYahoo {

	public static void main(String[] args) 
	throws InterruptedException 
	{
	EdgeDriver driver=new EdgeDriver();
	
	//launch url
	driver.get("https://finance.yahoo.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	//MouseHover on MARKET option
	WebElement market=driver.findElement(By.xpath("(//span[@class='_yb_1ad2758'])[3]"));
	
	//instantiate action class
	Actions act=new Actions (driver);
	act.moveToElement(market).perform();
	
	//to click the CRYPTO option
	driver.findElement(By.xpath("(//div[text()='Crypto'])[2]")).click();
	//Locate the table
    List<WebElement> table= driver.findElements(By.xpath("//table[@class='yf-ao6als bd']/tbody/tr/td[2]"));
    
    for(WebElement names : table)
    {
    	System.out.println(names.getText());
    
    }
    // Close the browser
   // driver.quit();
	
	}
}