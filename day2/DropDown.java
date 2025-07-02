package week2.day2;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;



public class DropDown {

	public static void main(String[] args) {
		EdgeOptions options=new EdgeOptions();
		options.addArguments("guest");
		
		EdgeDriver driver=new EdgeDriver(options);
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		
        driver.findElement(By.id("username")).sendKeys("demosalesmanager");
        driver.findElement(By.id("password")).sendKeys("crmsfa");
        driver.findElement(By.className("decorativeSubmit")).click();
        //driver.findElement(By.name("Login")).click();
        driver.findElement(By.partialLinkText("CRM/SFA")).click();
        driver.findElement(By.linkText("Leads")).click();
        driver.findElement(By.linkText("Create Lead")).click();
        driver.findElement(By.id("createLeadForm_companyName")).sendKeys("SELENIUM");
        driver.findElement(By.id("createLeadForm_firstName")).sendKeys("ANUSATHYA");
        driver.findElement(By.id("createLeadForm_lastName")).sendKeys("G");
        
        WebElement source= driver.findElement(By.id("createLeadForm_dataSourceId"));
        Select obj=new Select(source);
        obj.selectByIndex(4);
        
        WebElement industry=driver.findElement(By.id("createLeadForm_industryEnumId"));
        Select obj1=new Select(industry);
        obj1.selectByIndex(5);
        
        WebElement ownership=driver.findElement(By.id("createLeadForm_ownershipEnumId"));
        Select obj2=new Select(ownership);
        obj2.selectByVisibleText("S-Corporation");
        
        driver.findElement(By.name("submitButton")).click();
        System.out.println(driver.getTitle());

	}

}
