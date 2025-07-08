package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class EditLead {

	public static void main(String[] args) {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("Guest");
		ChromeDriver driver=new ChromeDriver(options);
		
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().window().maximize();
		
		 driver.findElement(By.id("username")).sendKeys("demosalesmanager");
	     driver.findElement(By.id("password")).sendKeys("crmsfa");
	     driver.findElement(By.className("decorativeSubmit")).click();
	  	 driver.findElement(By.partialLinkText("CRM/SFA")).click();
	     driver.findElement(By.linkText("Leads")).click();
	     driver.findElement(By.linkText("Create Lead")).click();
		
		 driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("EditLeadXpath");
		 driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("Anu");
	     driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("G");
	     driver.findElement(By.xpath("//input[@id='createLeadForm_firstNameLocal']")).sendKeys("Viswabharathy");
	     driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Software");
	     driver.findElement(By.id("createLeadForm_description")).sendKeys("Learn Selenium");
	     driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("anu123@gmail.com");
	     
	     
	     WebElement state=driver.findElement(By.xpath("//select[@name='generalStateProvinceGeoId']"));
	    	Select obj=new Select(state);
	    	obj.selectByVisibleText("New York");
	    	


			
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		
		driver.findElement(By.xpath("//textarea[@id='updateLeadForm_description']")).clear();
		
		driver.findElement(By.xpath("//textarea[@id='updateLeadForm_description']")).sendKeys("Selenenium Webdriver");
		
		driver.findElement(By.name("smallSubmit")).click();
		
		System.out.println(driver.getTitle());
		
		driver.close();
			
		
	}

}
