package marathon3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;

public class EditAccount {


    public static void main(String[] args) throws InterruptedException {
    	
    	// to instantiate the chrome driver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
       
        //to login to salesforce app
        driver.get("https://login.salesforce.com/");
        driver.findElement(By.id("username")).sendKeys("vidyar@testleaf.com");
        driver.findElement(By.id("password")).sendKeys("Sales@123");
        driver.findElement(By.id("Login")).click();
       
        //to click toggle, and view all
        driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        
        //to click sales
        WebElement sale = driver.findElement(By.xpath("//p[text()='Sales']/ancestor::a"));
        driver.executeScript("arguments[0].click()",sale);
        
        //to click accounts
        WebElement accountsTab = driver.findElement(By.xpath("//a[@title='Accounts']"));
        driver.executeScript("arguments[0].click()",accountsTab);
       
        // to enter in seachlist
        driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys("Gokul"+ Keys.ENTER);
        Thread.sleep(3000);
        
        // to edit the fields
        driver.findElement(By.xpath("//table/tbody/tr[1]/td[6]")).click();
        driver.findElement(By.xpath("//a[@title='Edit']")).click();
        
        WebElement typeDD = driver.findElement(By.xpath("//button[@aria-label='Type']"));
        driver.executeScript("arguments[0].click()",typeDD);
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Technology Partner']")).click();
        
        WebElement industryDD = driver.findElement(By.xpath("//button[@aria-label='Industry']"));
        driver.executeScript("arguments[0].click()",industryDD);
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Healthcare']")).click();
       
        WebElement biilingStreet = driver.findElement(By.xpath("//label[text()='Billing Street']/following::textarea"));
        biilingStreet.clear();
        biilingStreet.sendKeys("Testleaf, Wipro street, Tek meadows");
        
        WebElement shippingStreet = driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]"));
        shippingStreet.clear();
        shippingStreet.sendKeys("Testleaf, Wipro street, Tek meadows");
        
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
        Assert.assertTrue(phnoStr.contains(phno),"verify the mobileNumber");



    }

}
