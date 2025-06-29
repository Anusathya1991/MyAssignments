package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLogin {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.facebook.com/");
		driver.manage().window().maximize();
        driver.findElement(By.id("username")).sendKeys("testleaf.2023@gmail.com");
        driver.findElement(By.name("PASSWORD")).sendKeys("Tuna@321");
        driver.findElement(By.name("Login")).click();
        driver.findElement(By.linkText("Forgetten password?")).click();
        String title =driver.getTitle();
        System.out.println(title);
	}
}
