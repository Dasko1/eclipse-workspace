package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {

	public static void main(String[] args) {
		// This is for Alerts
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// Enter string into "Enter Your Name" textbox & click Alert button!
		String text = "Dasko";
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.id("alertbtn")).click();
		
		// To contact elements in the alert: the alert is not HTML, so you can't click & inspect! Switch context to alert!
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		// Push the Confirm button
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
	}

}
