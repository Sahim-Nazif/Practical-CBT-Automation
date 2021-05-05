package main.pack;

import java.time.Duration;
import java.util.List;

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
		String day = "20";

		List<WebElement> days = driver.findElements(By.xpath("//a[normalize-space()='20']"));

		for (WebElement dates : days) {

			String expectedDay = dates.getText();

			if (expectedDay.equals(day)) {
				dates.click();
				break;
			}
		}

		delayDisplay(4000);
		closeBrowser();

	}

	public static void closeBrowser() {
		driver.close();
	}

	public static void delayDisplay(long miliseconds) {

		try {
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

}
