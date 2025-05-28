package intro;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment3 {

	public static void main(String[] args) throws InterruptedException {
		// Assignment after Lesson 83!
		WebDriver driver = new ChromeDriver();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		// Fill out form from top to bottom!
		driver.findElement(By.name("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.name("password")).sendKeys("learning");
		driver.findElement(By.xpath("(//span)[5]")).click();				// Radio button followed by modal > "Okay".
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		driver.findElement(By.cssSelector("div select")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("option[value='consult']")));
		driver.findElement(By.cssSelector("option[value='consult']")).click();
		driver.findElement(By.name("terms")).click();
		driver.findElement(By.name("signin")).click();
		
		// Use Explicit Wait to go to next page & Choose all the phones on the next page and push Checkout button!
		Thread.sleep(3000);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1")));
		System.out.println(driver.findElement(By.xpath("//h1")).getText());
		System.out.println(driver.findElement(By.xpath("//a[normalize-space()='iphone X']")).getText());
		Thread.sleep(2500);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@class='btn btn-info'][normalize-space()='Add'])[1]")));
		driver.findElement(By.xpath("(//button[@class='btn btn-info'][normalize-space()='Add'])[1]")).click();
		driver.findElement(By.xpath("(//button[@class='btn btn-info'][normalize-space()='Add'])[2]")).click();
		driver.findElement(By.xpath("(//button[@class='btn btn-info'][normalize-space()='Add'])[3]")).click();
		driver.findElement(By.xpath("(//button[@class='btn btn-info'][normalize-space()='Add'])[4]")).click();
		
		// Push the Checkout button!
		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
		
		// Confirm price element on the Checkout page!
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td[class='text-right'] h3 strong")));
		System.out.println(driver.findElement(By.cssSelector("td[class='text-right'] h3 strong")).getText());
		Assert.assertEquals("₹. 300000", "₹. 300000");
		driver.quit();
	}

}
