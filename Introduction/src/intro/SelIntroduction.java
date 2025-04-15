package intro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelIntroduction {

	public static void main(String[] args) {
		
		// Invoking Browser
		// Chrome - ChromeDriver -> Methods
		// You can either use the Selenium Manager to invoke the browser or l.13; either works!
		// System.setProperty("webdriver.chrome.driver", "C:\\Users\\dadaskalopoulos\\eclipse-workspace\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();


	}
}
