package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsDemo {

	public static void main(String[] args) throws InterruptedException {
		// Create an Actions class with an object "a".
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com");
		Thread.sleep(15000);
		WebElement move = driver.findElement(By.id("nav-link-accountList"));			// See l.27.
		
		// Actions class: Enter "HELLO", mouse over to a specific element!
		Actions a = new Actions(driver); 		// "driver" as argument will now get the capabilities of the Actions class methods.
		
		// Enter HELLO in big main text field & double click on it to select!
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click()
			.keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
		// Mouse over Accounts & Lists & right click!
		a.moveToElement(move).contextClick().build().perform();

	}

}
