package intro;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class base {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		// Explicit wait: this kind of wait targets a specific element!
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);		// This is the global implicit wait.
		
		// To find several products, declare an array!
		String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot", "Carrot"};
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(3000);
		addItems(driver, itemsNeeded);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(), 'PROCEED TO CHECKOUT')]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		// This has been defined by the explicit wait in ll.22-23.
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
	}
	
	// Create a new method for adding items into the Cart! Remember that you leave the main method to drive the methods and not contain them!
	public static void addItems(WebDriver driver, String[] itemsNeeded){
	// Add a cucumber!  XPath or CSS!
	int j = 0;
	driver.findElement(By.xpath("//div[3]//div[3]//button[1]")).click();
	
	// Use findElements (note the plural ending!)
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
			
			for(int i = 0; i < products.size(); i++) {
				
				String[] name = products.get(i).getText().split("-");
				String formattedName = name[0].trim();									
				
				// Remove space after "Broccoli ".
				// Format to get actual vegetable name; it will fail if it doesn't see the " - 1 Kg".  When you split the string "Brocolli - 1 Kg", you are creating an array of two 
				// elements, one with "Broccoli " & the other with " - 1 Kg".  You just want the first element of the array. 
				// Check whether name you extracted is present in the array or not; convert array into array list for easy search!
				
				List itemsNeededList = Arrays.asList(itemsNeeded);
				
				// Click on Add To Cart
				if(itemsNeededList.contains(formattedName)) {
					
					j++;
						driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
					
						if(j == itemsNeeded.length){
							break;
						}	
				}
			
			}	
	}
}
