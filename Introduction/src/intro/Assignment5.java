package intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		
		// Get the text "Middle"! Concentrate on the frames tags! There are 2 frames: frame_top & frame_bottom
		System.out.println("Number of frames: " + driver.findElements(By.tagName("frame")).size());
		driver.switchTo().frame("frame-top");
		// Go to the Middle frame!
		driver.switchTo().frame("frame-middle");
		System.out.println(driver.findElement(By.id("content")).getText());
		
		//Shutdown
		Thread.sleep(2500);
		driver.quit();
	}
}
