package marathon3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;

public class CreateAccount {

    public static void main(String[] args) throws InterruptedException {
    	
    	//to instantiate the chrome driver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        
        // to login salesforce application
        driver.get("https://login.salesforce.com/");
        driver.findElement(By.id("username")).sendKeys("vidyar@testleaf.com");
        driver.findElement(By.id("password")).sendKeys("Sales@123");
        driver.findElement(By.id("Login")).click();
        
        //to click toggle,viewall
        driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        
        //to click sale
        WebElement sale= driver.findElement(By.xpath("//p[text()='Sales']/ancestor::a"));
        driver.executeScript("arguments[0].click();", sale);
        Thread.sleep(3000);
        
        //to click account
        WebElement account= driver.findElement(By.xpath("(//span[text()='Accounts'])[1]"));
        driver.executeScript("arguments[0].click();", account);
        Thread.sleep(3000);
        
        // to add new accountname
        driver.findElement(By.xpath("//a[@title='New']")).click();
        String accountName = "Gokul";
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
