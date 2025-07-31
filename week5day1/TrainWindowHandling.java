package assignments.week5day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TrainWindowHandling {

	public static void main(String[] args) 
	throws  InterruptedException
	{
		ChromeDriver driver=new ChromeDriver();
		
		//launch url
		
		driver.get(" https://www.irctc.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//accept the alert
		WebElement alertbutton = driver.findElement(By.xpath("//button[text()='OK']"));
		alertbutton.click();
		
	    //to select FLIGHT option
		WebElement flightoption = driver.findElement(By.xpath("(//label[text()='FLIGHTS'])[2]"));
		flightoption.click();
		
		//to handle the windows
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowlist = new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(windowlist.get(1));
		System.out.println("Child Window : " + driver.getTitle());
		
		driver.switchTo().window(windowlist.get(0));
		System.out.println("Parent Window : " + driver.getTitle());
		
		driver.close();
		
			
	}

}

