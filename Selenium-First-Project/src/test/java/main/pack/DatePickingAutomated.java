package main.pack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickingAutomated {

	private static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		String URL = "https://www.cheapflights.ca/";
		driver.manage().window().maximize();

		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String year = "2021";
		String month = "August";
		String date = "11";
		WebElement departDate = driver.findElement(By.xpath("//div[@class='date-input-inner-text _j0H']"));
		departDate.click();
		// departDate.sendKeys(year, month, date);

		while (true) {
			String monthYear = driver.findElement(By.xpath("//div[normalize-space()='May 2021']")).getText();

			String array[] = monthYear.split(" ");
			String mon = array[0];
			String yr = array[1];

			if (mon.equalsIgnoreCase(month) && yr.equalsIgnoreCase(year))
				break;

			else
				driver.findElement(By.xpath("//div[@id='stl-jam-cal-nextMonth']//*[local-name()='svg']")).click();

		}

		delayDisplay(3000);
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
