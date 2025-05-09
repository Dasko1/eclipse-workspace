package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class end2end {

	public static void main(String[] args) throws InterruptedException {
		// End to End test of the dropdowns, checkboxes, radio buttons, et al. 
		
		// Open browser!
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		
		// 'From:' option city & 'To:' option city
		// Select From as Benguluru & To as Chennai.
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='DEL']")).click();
		Thread.sleep(2500);
		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		
		// This chooses the date!
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();
		// 
		if(driver.findElement(By.id("Div1")).getDomAttribute("style").contains("0.5")) {
			
			System.out.println("It's Disabled!");
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		
		
		// Count the number of checkboxes, then click on a checkbox!
		System.out.println("Number of checkboxes: " + driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		// Radio buttons!
		Assert.assertFalse(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());
		driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();
		Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());

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
		
		// Currency selection!
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByIndex(3);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByVisibleText("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByValue("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByValue("USD");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		// Push the Search button, wait a bit, then quit!
		driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();
		Thread.sleep(2000);
		System.out.println("\nThe tests passed!");
		driver.quit();
		
	}

}
