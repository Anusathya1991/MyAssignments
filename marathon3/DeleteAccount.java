package marathon3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;

public class DeleteAccount {


    public static void main(String[] args) throws InterruptedException {
    	
    	// To instantiate chrome driver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        
        // to load the url, username, password
        driver.get("https://login.salesforce.com/");
        driver.findElement(By.id("username")).sendKeys("vidyar@testleaf.com");
        driver.findElement(By.id("password")).sendKeys("Sales@123");
        driver.findElement(By.id("Login")).click();
        
        //to click the toggle
        driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
        
        //to click view all
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        
        //to click sales option
        driver.findElement(By.xpath("//p[text()='Sales']/ancestor::a")).click();
        
        //to click accounts option
        WebElement accountsTab = driver.findElement(By.xpath("//a[@title='Accounts']"));
        driver.executeScript("arguments[0].click()",accountsTab);
        
        //to feed the seacrchlist
        driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys("Gokul"+ Keys.ENTER);
        Thread.sleep(2000);
       
        // to delete the recently viewed contact
        String noOfItems = driver.findElement(By.xpath("//span[@aria-label='Recently Viewed']")).getText();
        String[] s = noOfItems.split(" ");
        int countBeforeDelete = Integer.parseInt(s[0]);
        
        driver.findElement(By.xpath("//table/tbody/tr[1]/td[6]")).click();
        driver.findElement(By.xpath("//a[@title='Delete']")).click();
        driver.findElement(By.xpath("//button[@title='Delete']")).click();
        Thread.sleep(2000);
        
        noOfItems = driver.findElement(By.xpath("//span[@aria-label='Recently Viewed']")).getText();
        s = noOfItems.split(" ");
        int countAfterDelete = Integer.parseInt(s[0]);
        System.out.println("-----------");
       
        Assert.assertTrue(countBeforeDelete==(countAfterDelete+1),"Verify the account has deleted");

    }


}
