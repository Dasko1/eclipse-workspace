package intro;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment6 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// Click any checkbox 3 and grab its text! Use that to select from the dropdown on the left!
		driver.findElement(By.xpath("//input[@id='checkBoxOption3']")).click();
		String checkBoxText = driver.findElement(By.xpath("//label[normalize-space()='Option3']")).getText();
		new Select (driver.findElement(By.name("dropdown-class-example"))).selectByVisibleText(checkBoxText);
		
		// Enter the text from l.18 into the Alert text field, click Alert and verify text in the popup message (accept Alert)!
		driver.findElement(By.name("enter-name")).sendKeys(checkBoxText);
		driver.findElement(By.id("alertbtn")).click();	
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Option3", checkBoxText);
		Thread.sleep(2000);
		alert.accept();
		
		// End test!
		driver.quit();
		

	}

}
