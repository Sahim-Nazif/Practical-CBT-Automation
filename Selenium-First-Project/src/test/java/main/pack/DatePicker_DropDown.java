package main.pack;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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

	}

}
