package marathon3_integration;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class BaseClass_Integration {

	public static ChromeDriver driver;
	public static ChromeOptions options;
	
	@Parameters({"url","username","password"})
	@BeforeMethod
	
	public void base(String URL, String Uname, String Pwrd) throws InterruptedException {
	//to instantiate the chrome driver
    options = new ChromeOptions();
    options.addArguments("--disable-notifications");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    
    // to login salesforce application
    driver.get(URL);
    driver.findElement(By.id("username")).sendKeys(Uname);
    driver.findElement(By.id("password")).sendKeys(Pwrd);
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
	}
	@DataProvider(name="fetchdata")
	public String[][] senddata() throws IOException{
		return LoginData_Integration.readdata();
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}
}
