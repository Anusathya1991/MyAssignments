package assignments.week6day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class StaticParametrization {
	@Parameters({"url","username","password"})
	@Test
	public void staticParameter(String url, String username, String password) 
	throws InterruptedException 
	{
		
		//To Login to salesforce application
		ChromeOptions options=new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver=new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
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
		driver.findElement(By.xpath("(//input[@class='slds-input'])[2]")).sendKeys("Anusathya");
		driver.findElement(By.xpath("(//input[@class='slds-input'])[3]")).sendKeys("TestLeaf");
		driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]")).sendKeys("salesforce");
		Thread.sleep(2000);
		
		//To Select Status as 'Active' 
		WebElement status = driver.findElement(By.xpath("//button[@data-value='--None--']"));
		driver.executeScript("arguments[0].click();",status);
		driver.findElement(By.xpath("//span[text()='Active']")).click();
		Thread.sleep(2000);
		
		//To Click on Save 
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		//To Verify the Alert message (Complete this field) displayed for Name
		WebElement Alert = driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']"));
		if (Alert.isDisplayed())
		{
			System.out.println("The Alert message is displayed");
		} 
		else
		{
			System.out.println("The Alert message is not displayed");
		}
			
	}
}
