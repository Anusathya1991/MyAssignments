package week2.day1;

import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.facebook.com/"); //Enter the url as rrquired
		driver.manage().window().maximize(); //maximize the screen
		driver.close(); //close the window
		
	}

}
