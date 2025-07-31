package assignments.week5day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeaftabWindowHandling {

	public static void main(String[] args) 
	throws InterruptedException
	{
		ChromeDriver driver=new ChromeDriver();
		//launch url
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));	
		
		//load the inputs
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//to click contact button
		WebElement contacts = driver.findElement(By.xpath("//a[text()='Contacts']"));
		contacts.click();
		WebElement MergeContacts = driver.findElement(By.xpath("//a[text()='Merge Contacts']"));
		MergeContacts.click();
		
		//To click the widget "from contact"
		WebElement widget1 = driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]"));
		widget1.click();
		
		//to click on first resulting contact
		Set<String> contactwindow1 = driver.getWindowHandles();
		List<String> windowdetail1 = new ArrayList<String>(contactwindow1);
		driver.switchTo().window(windowdetail1.get(1));
		Thread.sleep(2000);
		WebElement contact1 = driver.findElement(By.xpath("//a[text()='DemoCustomer']"));
		contact1.click();
		
		//switch to parent window
		driver.switchTo().window(windowdetail1.get(0));
		
		//click on to contact widget
		WebElement widget2 = driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]"));
		widget2.click();
		
		//to click on second resulting contact
		Set<String> contactwindow2 = driver.getWindowHandles();
		List<String> windowdetail2 = new ArrayList<String>(contactwindow2);
		driver.switchTo().window(windowdetail2.get(1));
		WebElement contact2 = driver.findElement(By.xpath("(//a[@class='linktext'])[5]"));
		contact2.click();
		
		//switch to parent window
		driver.switchTo().window(windowdetail2.get(0));
		WebElement merge = driver.findElement(By.xpath("//a[text()='Merge']"));
		merge.click();
		
		//to accept the alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		//driver.quit();
		
		
	}

}
