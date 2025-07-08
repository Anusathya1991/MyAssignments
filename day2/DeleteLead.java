package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DeleteLead {

	public static void main(String[] args)
	throws InterruptedException
	{
		EdgeOptions options=new EdgeOptions();
		options.addArguments("Guest");
		EdgeDriver driver=new EdgeDriver(options);
		
		driver.get("http://leaftaps.com/opentaps/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		 driver.findElement(By.id("username")).sendKeys("demosalesmanager");
	     driver.findElement(By.id("password")).sendKeys("crmsfa");
	     driver.findElement(By.className("decorativeSubmit")).click();
	     driver.findElement(By.partialLinkText("CRM/SFA")).click();
	     driver.findElement(By.linkText("Leads")).click();
	     driver.findElement(By.partialLinkText("Find Leads")).click();
	     //driver.findElement(By.xpath("//span[text()='Phone']")).click();
	     driver.findElement(By.xpath("//span[text()='Email']")).click();
	     driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("anu123@gmail.com");
	     //driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("8148145954");
	     
	     driver.findElement(By.id("ext-gen334")).click();
	     Thread.sleep(5000);
	     WebElement lead = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']"));
	     String LeadID=lead.getText();
	     System.out.println("The first resulting lead is"+ LeadID);
	     driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	     driver.findElement(By.xpath("//a[text()='Delete']")).click();
	     driver.findElement(By.linkText("Find Leads")).click();
	     driver.findElement(By.name("id")).sendKeys(LeadID);
	     driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	     WebElement output=driver.findElement(By.xpath("//div[text()='No records to display']"));
			String result=output.getText();
			if (result.equals("No records to display"))
			{
				System.out.println("The Lead is successfully deleted");
			} else {
				System.out.println("The lead is not deleted. check again");
			}
		
			driver.quit();
	}

}
