package main.pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Navigation {

	static WebDriver driver;

	public static void main(String[] args) {

		// Topic 2
		// navigate().back(), navigate().forward(), navigate().refresh(),navigate().to
		// these methods are used for navigating in a web apps

		String URL1 = "https://www.ebay.ca/";
		String URL2 = "https://www.amazon.ca/";

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL1);
		driver.navigate().to(URL2);
		;
		// the difference between get() and navigate().to() is that get is used to
		// navigate particular ULR
		// and wait till page load
		// navigate().to() is used to navigate to particular URL and doesn't wait for
		// page load.

		delayDisplay(1000);

		driver.navigate().back();
		delayDisplay(1000);
		driver.navigate().forward();

		driver.navigate().refresh();
		delayDisplay(500);

		closeBrowser();

	}

	public static void delayDisplay(long miliseconds) {

		try {
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	public static void closeBrowser() {
		driver.quit();
	}

}
