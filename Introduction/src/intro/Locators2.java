package intro;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class Locators2 {

	public static void main(String[] args) throws InterruptedException {

		String name = "rahul";
		// System.setProperty("webdriver.chrome.webdriver", "C:\\Users\\dadaskalopoulos\\eclipse-workspace\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String password = getPassword(driver);																// This turns getPassword() static no object.method needed!
																											// This is at the class level, so static in l.43!
																											// Otherwise, this would need Locators.method syntax!
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello " + name + ",");
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		driver.quit();
	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException						// Try to get the password & put in variable in l. 46! For dynamic changes!
	{																									// Use the same driver from l.16!
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String passwordText = (driver.findElement(By.cssSelector("form p")).getText());					// Put password into the variable: passwordText
		// Please use temporary password 'rahulshettyacademy' to Login. 								// Split this string!
		String[] passwordArray = passwordText.split("'");												// Split the string on the first single quote!
		// 0th index - Please use temporary password													// There is now an array with two indices: [0][1]
		// 1st index - rahulshettyacademy' to Login.													// Below, split the string again on the second single quote!
		String password = passwordArray[1].split("'")[0];												//[1]splits string to left → [0] splits string to the right!
		return password;																				// Send the password back to main! You are returning a String!
	}
}
