package main.pack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleLinks {

	private static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		String URL = "https://www.amazon.ca/";

		driver.get(URL);

		driver.manage().window().maximize();

		// 1-LinkText requires complete text
		WebElement fullLink = driver.findElement(By.linkText("Best Sellers"));

		// fullLink.click();
		// 2- PartialLinkText pass only part of a text

		WebElement partialLink = driver.findElement(By.partialLinkText("Releases"));

		partialLink.click();

		// 3 - How to capture all the links from the webpage

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println(allLinks.size());

		delayRun(2000);
		closeBrowser();

	}

	public static void delayRun(long seconds) {

		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public static void closeBrowser() {

		driver.close();
	}

}
