package marathon3_integration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class EditAccount_Integration extends BaseClass_Integration {
	    
		@Test(dataProvider="fetchdata")
		 public void runEditAccount(String accountName, String billingstr, String shippingstr) throws InterruptedException {
       
        // to enter in seachlist
        driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys(accountName + Keys.ENTER);
        Thread.sleep(3000);
        
        // to edit the fields
        WebElement DDicon = driver.findElement(By.xpath("//span[text()='Show Actions']"));
        driver.executeScript("arguments[0].click()", DDicon);
        driver.findElement(By.xpath("//a[@title='Edit']")).click();
        
        WebElement typeDD = driver.findElement(By.xpath("//button[@aria-label='Type']"));
        driver.executeScript("arguments[0].click()",typeDD);
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Technology Partner']")).click();
        
        WebElement industryDD = driver.findElement(By.xpath("//button[@aria-label='Industry']"));
        driver.executeScript("arguments[0].click()",industryDD);
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Healthcare']")).click();
       
        WebElement billingStreet = driver.findElement(By.xpath("//label[text()='Billing Street']/following::textarea"));
        billingStreet.clear();
        billingStreet.sendKeys(billingstr);
        
        WebElement shippingStreet = driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]"));
        shippingStreet.clear();
        shippingStreet.sendKeys(shippingstr);
        
        WebElement priorityDD = driver.findElement(By.xpath("//button[@aria-label='Customer Priority']"));
        driver.executeScript("arguments[0].click()",priorityDD);
        
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Low']")).click();
        driver.findElement(By.xpath("//button[@aria-label='SLA']")).click();
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Silver']")).click();
        
        WebElement activeDD = driver.findElement(By.xpath("//button[@aria-label='Active']"));
        driver.executeScript("arguments[0].click()",activeDD);
       
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='No']")).click();
        int randomNum1 = (int)(Math.random()*999999);
        int randomNum2 = (int)(Math.random()*999999);
        String phno = ""+randomNum1+randomNum2;
        phno = phno.substring(0,10);
        System.out.println(phno);
        
        WebElement phnoField = driver.findElement(By.xpath("//input[@name='Phone']"));
        phnoField.clear();
        phnoField.sendKeys(phno);
        
        WebElement upsellOpportunityDD = driver.findElement(By.xpath("//button[@aria-label='Upsell Opportunity']"));
        driver.executeScript("arguments[0].click()",upsellOpportunityDD);
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='No']")).click();
        
        //to click save
        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
        String phnoStr = driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]")).getText();
        System.out.println(phnoStr);
        //Assert.assertTrue(phnoStr.contains(phno),"verify the mobileNumber");
        if (phno.contains(phnoStr)) 
		{
			System.out.println("mobile number verified");
			
		} 
		else 
		{
			System.out.println("mobile number  not verified");

		}



    }

}
