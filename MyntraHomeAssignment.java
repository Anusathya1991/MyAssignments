package alert.setassignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyntraHomeAssignment {

	public static void main(String[] args) 	throws InterruptedException
					{
					ChromeDriver driver=new ChromeDriver();
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
							
						 //Open myntra
					
					
				        driver.get("https://www.myntra.com/");

				        //Search bags
				        driver.findElement(By.xpath("//input[@class='desktop-searchBar']")).sendKeys("bags",Keys.ENTER);
				        Thread.sleep(1000);
				        
				        //Click Men under Gender 
				        driver.findElement(By.xpath("//label[@class='common-customRadio gender-label']")).click();
				        Thread.sleep(1000);
				        
				        //Click laptop Bags under Category 
				        driver.findElement(By.xpath("(//label[@class='common-customCheckbox vertical-filters-label'])[1]")).click();
				        Thread.sleep(1000);
				       	                 
				        //To print count items
				        WebElement Bagcount = driver.findElement(By.xpath("//div[@class='title-container']"));
				        String count = Bagcount.getText();
				        System.out.println("Total number of products: " +count);

				        //list of all brand names
				        List<WebElement> brandlist = driver.findElements(By.xpath("//h3[@class='product-brand']"));
				        List<String> brand = new ArrayList<String>();
				        for (WebElement total: brandlist) 
				        {
				        	String names= total.getText();
				            brand.add(names);
				        }
				        System.out.println("\nList of Brands:" +brand);
				        
				        //list of bag names
				        List<WebElement> baglist = driver.findElements(By.xpath("//h4[@class='product-product']"));
				        System.out.println("\n List of bag names:");
				        for (WebElement bags : baglist)
				        {
				        System.out.println(bags.getText());
				        }
				        // Close the browser
				        //driver.quit();
				    }

	}
