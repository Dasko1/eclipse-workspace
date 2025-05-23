package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		// Maximize browser
		driver.manage().window().maximize();
		
		// Name
		driver.findElement(By.name("name")).sendKeys("Tester Name");
		// Email
		driver.findElement(By.name("email")).sendKeys("tester_name@test.com");
		// Password
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("test_password12&");
		// Checkbox
		driver.findElement(By.id("exampleCheck1")).click();
		// Gender dropdown
		driver.findElement(By.id("exampleFormControlSelect1")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//option[1]")).click();
		// Radio button: click on Student
		driver.findElement(By.id("inlineRadio1")).click();
		// Date of Birth
		driver.findElement(By.xpath("//input[@name='bday']")).sendKeys("01/01/1980");
		// Push Submit button
		driver.findElement(By.cssSelector(".btn.btn-success")).click();
		// Grab success notification text
		System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText());
	}

}
