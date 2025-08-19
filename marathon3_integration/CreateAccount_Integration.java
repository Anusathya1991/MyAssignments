package marathon3_integration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class CreateAccount_Integration extends BaseClass_Integration {
		
	@Test(dataProvider="fetchdata")
	
	public void runCreateAccount(String accountName,String billingstr, String shippingstr) throws InterruptedException {

   
        // to add new accountname
        driver.findElement(By.xpath("//a[@title='New']")).click();
        driver.findElement(By.xpath("//label[text()='Account Name']/following::input")).sendKeys(accountName);
        
        // to click dropdown
        WebElement ownershipDD = driver.findElement(By.xpath("//button[@aria-label='Ownership']"));
        driver.executeScript("arguments[0].click()",ownershipDD);
        driver.findElement(By.xpath("//span[@title='Public']")).click();
        
        //to save the contact
        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
        String toastMessage = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
        System.out.println(toastMessage);
        
        
        Assert.assertTrue(toastMessage.contains(accountName),"Verify the Account name");
    }

}
