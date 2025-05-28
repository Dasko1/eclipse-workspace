package intro;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WindowHandlingAssignment {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		
		// Click on the Multiple Windows link to proceed and go to child window & capture the 'New Window' text!
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.linkText("Click Here")).click();
		
		// All this is needed to navigate to a child window!
		Set<String> windows = driver.getWindowHandles();     // parentID, childId
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		
		// Assert the expected text appears in the child window then return to parent window & get that text!
		String expectedChildText = "New Window";
		String expectedParentText = "Opening a new window";
		System.out.println(driver.findElement(By.cssSelector("div h3")).getText());
		Assert.assertEquals("New Window", expectedChildText);
		driver.switchTo().window(parentId);
		System.out.println(driver.findElement(By.cssSelector("div h3")).getText());
		Assert.assertEquals("Opening a new window", expectedParentText);
		driver.quit();
	}
}
