package marathon2;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;


public class Servicenow_mobileorder {
	
	public static void main(String[] args) 
	throws InterruptedException
	{
				
		//Launch the Browser
		EdgeDriver driver= new EdgeDriver();
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://dev209663.service-now.com/");

        //To Login
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("user_password")).sendKeys("qy/Q6A=vOM3x"); 
        driver.findElement(By.id("sysverb_login")).click();
        Thread.sleep(2000);
        
        //To Handle Shadow DOM 
        Shadow sh = new Shadow(driver);
        sh.setImplicitWait(20);
        
        //To click "All" option
        sh.findElementByXPath("//div[text()='All']").click();
        Thread.sleep(3000);
        
        //To click "Service catalog"
        sh.findElementByXPath("//span[text()='Service Catalog']").click();
        Thread.sleep(3000);
        
        //Switch to iframe
        WebElement iframe = sh.findElementByXPath("//iframe[@id='gsft_main']");
        driver.switchTo().frame(iframe);

        //Click Mobiles
        driver.findElement(By.xpath("//h2[contains(text(),'Mobiles')]")).click();
        
        //To Click Apple iPhone 13 Pro
        driver.findElement(By.xpath("//table[@class='no_underline_table']//tbody/tr/td")).click();
        
        // To Choose yes option in lost or broken iPhone
        driver.findElement(By.xpath("//label[text()='Yes']")).click();
        
        //To  Enter phonenumber as 99 in original phonenumber field
        driver.findElement(By.xpath("//input[@class='cat_item_option sc-content-pad form-control']")).sendKeys("99");
        
        // To Select Unlimited from the dropdown in Monthly data allowance
        WebElement data = driver.findElement(By.xpath("//select[@class='form-control cat_item_option ']"));
        Select sel=new Select(data);
        sel.selectByVisibleText("Unlimited [add $4.00]");
        
        //To Update color field to SierraBlue and storage field to 512GB
        driver.findElement(By.xpath("//label[text()='Blue']")).click();
        driver.findElement(By.xpath("//label[text()='512 GB [add $300.00]']")).click();
        
        //To Click on Order now option
        driver.findElement(By.xpath("//button[text()='Order Now']")).click();
        
        //To Verify order is placed
      	String orderStatus = driver.findElement(By.xpath("//dl[@class='dl-horizontal sc-dl-horizontal']/dt")).getText();
      	String verifyOrder = "Order Placed";
      		
      	      		if(orderStatus.contains(verifyOrder))
      				{
      			System.out.println("ORDER IS PLACED");
      				}
      		else
      		{
      			System.out.println("ORDER IS NOT PLACED");
      		}
        
        //To print the request number
        String requestNumber = driver.findElement(By.xpath("//a[@id='requesturl']")).getText();
        System.out.println("REQUEST NUMBER: " + requestNumber);
        
        //To close windows
        //driver.quit();
           

		}
}