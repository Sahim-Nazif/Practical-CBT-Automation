package main.pack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker_DropDown {

	private static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		String URL = "https://www.dummyticket.com/dummy-ticket-for-visa-application/";
		driver.manage().window().maximize();

		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement dob = driver.findElement(By.xpath("//input[@id='dob']"));
		dob.click();

		// selecting month from the drop-down
		WebElement month = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Select selectMonth = new Select(month);
		selectMonth.selectByVisibleText("Dec");

		// selecting year from the drop-down
		WebElement year = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select selectYear = new Select(year);
		selectYear.selectByVisibleText("1988");
		// pick day
		WebElement day = driver.findElement(By.xpath("//a[normalize-space()='20']"));
		day.click();

		delayDisplay(2000);
		closeBrowser();

	}

	public static void closeBrowser() {
		driver.close();
	}

	public static void delayDisplay(long seconds) {

		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

}
