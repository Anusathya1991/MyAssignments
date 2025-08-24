package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSalesforceStatic extends BaseClass  {
	/*@Given("Launch the url")
	public void launch_the_url() {
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://login.salesforce.com/");
	}

	@When("Enter the loginname as (.*)$")
	public void enter_the_loginname(String uname) {
		driver.findElement(By.id("username")).sendKeys(uname);
	}

	@When("Enter the loginpassword as(.*)$")
	public void enter_the_loginpassword(String pwd) {
		driver.findElement(By.id("password")).sendKeys(pwd);
	}

	@When("Click on the ok button")
	public void click_on_the_ok_button() {
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

	@Then("Search for the account using your unique accountname as (.*)$")
	public void search_for_the_account_using_your_unique_accountname_as_anusathya(String accountname) throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys(accountname + Keys.ENTER);
	      Thread.sleep(3000);
	}*/

	@Then("Click the dropdown icon next to the account and select Edit")
	public void click_the_dropdown_icon_next_to_the_account_and_select_edit() throws InterruptedException {
		WebElement DDicon = driver.findElement(By.xpath("//span[text()='Show Actions']"));
	    driver.executeScript("arguments[0].click()", DDicon);
	    driver.findElement(By.xpath("//a[@title='Edit']")).click();
	    Thread.sleep(3000);
	}

	@Then("Set Type to Technology Partner")
	public void set_type_to_technology_partner() throws InterruptedException {
		WebElement typeDD = driver.findElement(By.xpath("//button[@aria-label='Type']"));
	    driver.executeScript("arguments[0].click()",typeDD);
	    driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Technology Partner']")).click();
	    Thread.sleep(3000);
	}

	@Then("Set Industry to Healthcare")
	public void set_industry_to_healthcare() throws InterruptedException {
		WebElement industryDD = driver.findElement(By.xpath("//button[@aria-label='Industry']"));
	    driver.executeScript("arguments[0].click()",industryDD);
	    driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Healthcare']")).click();
	    Thread.sleep(3000);
	}

	@When("Enter the Billing Address as (.*)$")
	public void enter_the_billing_address_as_tekwood_street(String billingstr) throws InterruptedException {
		WebElement billingStreet = driver.findElement(By.xpath("//label[text()='Billing Street']/following::textarea"));
	    billingStreet.clear();
	    billingStreet.sendKeys(billingstr);
	    Thread.sleep(3000);
	}

	@When("Enter the Shipping Address as (.*)$")
	public void enter_the_shipping_address_as_wipro_street(String shippingstr) throws InterruptedException {
		 WebElement shippingStreet = driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]"));
	     shippingStreet.clear();
	     shippingStreet.sendKeys(shippingstr);
	     Thread.sleep(3000);
	}

	@When("Select Customer Priority to Low")
	public void select_customer_priority_to_low() throws InterruptedException {
		WebElement priorityDD = driver.findElement(By.xpath("//button[@aria-label='Customer Priority']"));
	    driver.executeScript("arguments[0].click()",priorityDD);    
	    driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Low']")).click();
	    Thread.sleep(3000);
	}

	@When("Select SLA to Silver")
	public void select_sla_to_silver() throws InterruptedException {
		driver.findElement(By.xpath("//button[@aria-label='SLA']")).click();
	    driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Silver']")).click();
	    Thread.sleep(3000);
	}

	@When("Set Active to NO")
	public void set_active_to_no() throws InterruptedException {
		WebElement activeDD = driver.findElement(By.xpath("//button[@aria-label='Active']"));
	    driver.executeScript("arguments[0].click()",activeDD);   
	    driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='No']")).click();
	    Thread.sleep(3000);
	}

	@When("Enter a unique number in the Phone field as (.*)$")
	public void enter_a_unique_number_in_the_phone_field_as(String phno) throws InterruptedException {
		WebElement phnoField = driver.findElement(By.xpath("//input[@name='Phone']"));
	    phnoField.clear();
	    phnoField.sendKeys(phno);
	    Thread.sleep(3000);
	}

	@When("Set Upsell Opportunity to No")
	public void set_upsell_opportunity_to_no() throws InterruptedException {
		WebElement upsellOpportunityDD = driver.findElement(By.xpath("//button[@aria-label='Upsell Opportunity']"));
	    driver.executeScript("arguments[0].click()",upsellOpportunityDD);
	    driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='No']")).click();
	    Thread.sleep(3000);
	}

	@When("Click Save and verify the phone number as (.*)$")
	public void click_save_and_verify_the_phone_number_as(String phno) {
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
	    String phnoStr = driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]")).getText();
	    System.out.println(phnoStr);
	}
	
	
}