package intro;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdatedDropdown {

	public static void main(String[] args) throws InterruptedException {
		// This is for the passengers dropdown: choose 5 adults with while loop.
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		// Radio buttons!
		Assert.assertFalse(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());
		driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();
		Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());
		
		// To confirm if an element is enabled or not!  This starts with the Return Date dropdown inactive by default.
		System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));
		if(driver.findElement(By.id("Div1")).getDomAttribute("style").contains("1")) {
			
			System.out.println("It's Enabled!");
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		
		
		// Count the number of checkboxes!
		System.out.println("Number of checkboxes: " + driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		// Number of passengers
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		
		// Choose 5 adult passengers!
		int i = 1;
		while( i < 5) {
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		driver.findElement(By.id("btnclosepaxoption")).click();
		
	}

}
