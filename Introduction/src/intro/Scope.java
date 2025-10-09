package intro;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		// Give a count of the links of the page. Find and count the anchor (a)
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// Find the 'a' tags and count them!
		System.out.println("Number of links on page: " + driver.findElements(By.tagName("a")).size());
		
		// Now get the links in just the footer: Inspect footer & create footer WebElement to search just by footer; 
		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
		System.out.println("Number of links just in footer: " + footerdriver.findElements(By.tagName("a")).size());
		
		// Now get the number of links just in the first (left side) of the footer column!
		WebElement leftcolumnfooterdriver = driver.findElement(By.xpath("//*[@id='gf-BIG']/table/tbody/tr/td[1]/ul"));
		System.out.println("Number of links in left column: " + leftcolumnfooterdriver.findElements(By.tagName("a")).size());
		
		// Click on each link in the column and check if the pages are opening!  The for loop opens all the tabs!
		for(int i = 1; i < leftcolumnfooterdriver.findElements(By.tagName("a")).size(); i++){
			
			// The line below holds down CTRL key while clicking! Note the element is defined and put into sendKeys as an argument!
			String clickonlinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			leftcolumnfooterdriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
			Thread.sleep(1500L);
			}
			
			//Get new tab titles!
			Set<String> abc = driver.getWindowHandles();
			Iterator<String> it = abc.iterator();
			System.out.println("\nThe titles of the opened tabs are: ");

			
			while(it.hasNext())
			{
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
			}

			driver.quit();
	}
}

