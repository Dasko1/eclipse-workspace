package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class frameTest {

	public static void main(String[] args) throws InterruptedException {
		// Frames display content independent of the container.
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		
		// Locate the elements to drag & drop!  Remember the entire box with id=draggable is in a frame!  Identify frame first by index(0) or locator (iframe.demo-frame)!
		System.out.println("Number of frames: " + driver.findElements(By.tagName("iframe")).size());
		driver.switchTo().frame(0);
		
		// This sections defines & performs the drag & drop actions!
		Actions a = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		a.dragAndDrop(source, target).build().perform();
		
		// Get out of frame!
		driver.switchTo().defaultContent();
		
		// Success or fail?
		System.out.println("\nIf you got this far, the test passed!");
		Thread.sleep(2000);
		driver.quit();
	}
}
