package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;



public class CreateAccount {

	public static void main(String[] args) {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("Guest");
		ChromeDriver driver=new ChromeDriver(options);
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.partialLinkText("Accounts")).click();
		driver.findElement(By.partialLinkText("Create Account")).click();
		driver.findElement(By.id("accountName")).sendKeys("Anusathya G");
		//driver.findElement(By.name("lastName")).sendKeys("G");
		driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester");
		
		WebElement industry=driver.findElement(By.name("industryEnumId"));
		Select obj=new Select(industry);
		obj.selectByIndex(3);
		
		WebElement ownership=driver.findElement(By.name("ownershipEnumId"));
		Select obj1=new Select(ownership);
		obj1.selectByVisibleText("S-Corporation");
		
		WebElement source=driver.findElement(By.id("dataSourceId"));
	    Select obj2=new Select(source);
		obj2.selectByIndex(4);
		
		WebElement campaign=driver.findElement(By.id("marketingCampaignId"));
		Select obj3=new Select(campaign);
		obj3.selectByIndex(6);
		
		WebElement province=driver.findElement(By.id("generalStateProvinceGeoId"));
		Select obj4=new Select(province);
		obj4.selectByValue("TX");
		
		
		driver.findElement(By.className("smallSubmit")).click();
		System.out.println(driver.getTitle());
	}
	

}

