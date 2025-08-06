package assignments.week6day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DynamicParametrization {
	@Test(dataProvider = "fetchData")
	@Parameters({"name","companyname","description"})

	public void staticParameter(String name, String companyname, String description) 
	throws InterruptedException 
	{
		
		//To Login to salesforce application
		ChromeOptions options=new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver=new ChromeDriver(options);
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("username")).sendKeys("vidyar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Sales@123");
		driver.findElement(By.id("Login")).click();
		
		//To Click on the toggle menu button from the left corner 
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
				
		//To Click View All and click Legal Entities from App Launcher
		driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
		WebElement legal = driver.findElement(By.xpath("//p[text()='Legal Entities']"));
		driver.executeScript("arguments[0].click();",legal);
		Thread.sleep(2000);
			
		//To Click on the Dropdown icon in the legal Entities tab
		driver.findElement(By.xpath("//button[@title='Select a List View: Legal Entities']")).click();
		Thread.sleep(2000);
				
		//To Click on New Legal Entity
		driver.findElement(By.xpath("//a[@title='New']")).click();
		Thread.sleep(2000);
		
		//To Enter the Company name as 'TestLeaf'
		driver.findElement(By.xpath("(//input[@class='slds-input'])[2]")).sendKeys(name);
		driver.findElement(By.xpath("(//input[@class='slds-input'])[3]")).sendKeys(companyname);
		driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]")).sendKeys(description);
		Thread.sleep(2000);
				
		//To Select Status as 'Active' 
		WebElement status = driver.findElement(By.xpath("//button[@data-value='--None--']"));
		driver.executeScript("arguments[0].click();",status);
		driver.findElement(By.xpath("//span[text()='Active']")).click();
		Thread.sleep(2000);
				
		//To Click on Save 
		driver.findElement(By.xpath("//button[text()='Save']")).click();
				
		
	}
	
	@DataProvider(name="fetchData")
	public String[][] passdata(){
		String[][] data = new String[3][3];
		data[0][0] = "Salesforce Automation by Anusathya";
		data[0][1] = "TestLeaf";
		data[0][2] = "salesforce";
		
		data[1][0] = "Salesforce Automation by Asvini";
		data[1][1] = "Infosys";
		data[1][2] = "Salesforce";
		
		data[2][0] = "Salesforce Automation by Nivedita";
		data[2][1] = "TCS";
		data[2][2] = "Salesforce";
		
		return data;
}
}
