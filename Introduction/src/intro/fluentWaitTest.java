package intro;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class fluentWaitTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// Fluent Wait example
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.cssSelector("div[id='start'] button")).click();
		
		//Fluent Wait!
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		
		WebElement foo = wait.until(new Function<WebDriver, WebElement>(){
			
			public WebElement apply(WebDriver driver) {
				if(driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed())
				{
				return driver.findElement(By.cssSelector("[id='finish'] h4"));
				}
				else
					return null;
			}
		});
		
	System.out.println(driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed());
	System.out.println("Expected text: " + driver.findElement(By.cssSelector("[id='finish'] h4")).getText());
	}
}


/* The important part starts at l.25: here you are creating the "wait" object of the Wait class; this will be a new implementation of FluentWait which is a 
 * part of the WebDriver interface. The WebElement foo gets the value of the wait object with the until method; this means wait will be a FluentWait that lasts
 * for 30 seconds and will poll ever 3 seconds until "Hello World!" in the locator '[id='finish'] h4' appears!
 */
