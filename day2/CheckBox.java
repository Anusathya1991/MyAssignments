package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CheckBox {

	public static void main(String[] args) throws InterruptedException{
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("Guest");
		ChromeDriver driver =new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://leafground.com/checkbox.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//to click basic		
		WebElement Basic=driver.findElement(By.xpath("//span[@class='ui-chkbox-label']"));
        Basic.click();
//to click ajax
		driver.findElement(By.xpath("//span[text()='Ajax']")).click();
		//Thread.sleep(5000);
		WebElement basicAjaxCheckbox=driver.findElement(By.className("ui-growl-title"));
		if (basicAjaxCheckbox.isDisplayed())
		{
			System.out.println("Expected Message is checked ");
		}
			else
			{
				System.out.println("Expected Message is unchecked");
			}
//to click java			
		driver.findElement(By.xpath("//label[text()='Java']/preceding-sibling::div")).click();
//to click tristate		
		driver.findElement(By.xpath("//div[@id='j_idt87:ajaxTriState']")).click();

//check pop up works after clicked tristate
		WebElement stateCheck = driver.findElement(By.xpath("//p[text()='State = 1']"));

		if (stateCheck.isDisplayed()) {
			System.out.println("The Tri-state option is State 1");
		}

		driver.findElement(By.xpath("//div[@class='ui-toggleswitch-slider']")).click();

//check the toggle switch is selected or not
		WebElement toggleSwitch = driver.findElement(By.xpath("//input[@id='j_idt87:j_idt100_input']"));

		if (toggleSwitch.isSelected()) {
			System.out.println("The Toggle switch is enabled");
		} else {
			System.out.println("The toggle switch is disabled");

		}	
		
//check whether the disable check box is enabled or disabled
		WebElement disablecheckbox=driver.findElement(By.xpath("//input[@id='j_idt87:j_idt102_input']"));
		
		if (disablecheckbox.isEnabled()) {
			System.out.println("The checkbox is enabled");
		} else {
			System.out.println("The checkbox is disabled");
		}

		driver.findElement(By.xpath("//ul[@data-label='Cities']")).click();
		
		driver.findElement(By.xpath("(//label[text()='Paris'])[2]")).click();
		
		//driver.close();
		}
	    
	    

	}
