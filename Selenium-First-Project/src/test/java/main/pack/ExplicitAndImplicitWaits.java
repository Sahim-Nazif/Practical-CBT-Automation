package main.pack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitAndImplicitWaits {

	private static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		String URL = "https://www.bing.com/";

		driver.get(URL);
		driver.manage().window().maximize();

		/*
		 * Explicit wait Explicit wait is used to tell the Web Driver to wait for
		 * certain conditions (Expected Conditions) or maximum time exceeded before
		 * throwing "ElementNotVisibleException" exception
		 */

		// create an instance of explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement searchBar = driver.findElement(By.xpath("//input[@name='q']"));
		searchBar.sendKeys("Cherry Blossom");
		searchBar.sendKeys(Keys.RETURN);

		WebElement searchElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("/html//ol[@id='b_results']/li[3]/h2/a[@href='https://en.wikipedia.org/wiki/Cherry_blossom']")));
		System.out.println(searchElement.getText());

		endSession();

	}

	public static void endSession() {

		driver.close();
	}

}
