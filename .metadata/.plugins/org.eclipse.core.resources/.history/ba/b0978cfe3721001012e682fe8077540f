package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dropdown {

	public static void main(String[] args) throws InterruptedException {
		// This is for the From and To dropdowns
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		// Select From as Benguluru & To as Chennai.
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(2500);
		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		
		// This chooses the date!
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();
	}
}
