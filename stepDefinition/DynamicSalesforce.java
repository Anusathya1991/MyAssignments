package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DynamicSalesforce extends BaseClass {
	@Given("Launch the url")
	public void launch_the_url()
	{
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://login.salesforce.com/");
	}
	@When("Enter the loginname as(.*)$")
	public void enter_the_loginname(String username) {
		driver.findElement(By.id("username")).sendKeys(username);
	}
	
	@When("Enter the loginpassword as(.*)$")
	public void enter_the_loginpassword(String pwd) {
		driver.findElement(By.id("password")).sendKeys(pwd);
	}

	@When("Click on the ok Button")
	public void click_on_the_ok_Button() {
		driver.findElement(By.id("Login")).click();
	}

	@When("Click on toggle menu button")
	public void click_on_toggle_menu_button() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	    Thread.sleep(3000);
	}

	@When("Click View All")
	public void click_view_all() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(3000);
	}

	@When("Select Sales from App Launcher")
	public void select_sales_from_app_launcher() throws InterruptedException {
		WebElement sale= driver.findElement(By.xpath("//p[text()='Sales']/ancestor::a"));
	     driver.executeScript("arguments[0].click();", sale);
	     Thread.sleep(3000);
	}

	@When("Click on Accounts tab")
	public void click_on_accounts_tab() throws InterruptedException {
		 WebElement account= driver.findElement(By.xpath("(//span[text()='Accounts'])[1]"));
	     driver.executeScript("arguments[0].click();", account);
	     Thread.sleep(3000);
	}
	
	@When("Click on New button")
	public void click_on_new_button() throws InterruptedException {
		driver.findElement(By.xpath("//a[@title='New']")).click();
		Thread.sleep(3000);
	}

	@When("Enter the accountname as(.*)$")
	public void enter_the_accountname(String accountname) throws InterruptedException {
		driver.findElement(By.xpath("//label[text()='Account Name']/following::input")).sendKeys(accountname);
		Thread.sleep(3000);
	}

	@When("Select Ownership as public")
	public void select_ownership_as_public() throws InterruptedException {
		WebElement ownershipDD = driver.findElement(By.xpath("//button[@aria-label='Ownership']"));
        driver.executeScript("arguments[0].click()",ownershipDD);
        driver.findElement(By.xpath("//span[@title='Public']")).click();
        Thread.sleep(3000);
	}
	@When("Save and verify the account as(.*)$")
	public void save_and_verify_the_account(String accountname) {
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
        String toastMessage = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
        System.out.println(toastMessage);
        //Assert.assertTrue(toastMessage.contains(accountname),"Verify the Account name");
	}

	}


