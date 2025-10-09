package intro;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarTest {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Look for this information!
		String monthNumber = "6";
		String date = "15";
		String year = "2027";
		
		// This array is for the assertion below!
		String[] expectedList = {monthNumber, date, year};
		
		// Go to the calendar web page and find the calendar!
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
		// Find year! Go to year by clicking the same element twice!
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.xpath("//button[text()='" + year + "']")).click();
		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month"))
			.get(Integer.parseInt(monthNumber) -1 ).click();
		driver.findElement(By.xpath("//abbr[text()='" + date + "']")).click();
		
		// Now grab the date! First, notice that there are three separate elements for month/day/year, so iterate through!
		List<WebElement> actualList =  driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		
		for(int i = 0; i < actualList.size(); i++) {
		
			System.out.println(actualList.get(i).getAttribute("value"));
			Assert.assertEquals(actualList.get(i).getAttribute("value"), expectedList[i]);
		}
		driver.quit();
	}
}
