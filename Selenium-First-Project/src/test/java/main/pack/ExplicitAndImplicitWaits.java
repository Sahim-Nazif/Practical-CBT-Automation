package main.pack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
		 * Explicit wait is used to tell the Web Driver to wait for certain conditions
		 * (Expected Conditions) or maximum time exceeded before throwing
		 * "ElementNotVisibleException" exception
		 */
		// create an instance of explicit wait
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		/*
		 * Implicit wait: is used to tell the web driver to wait for a certain amount of
		 * time before it throws a "No Such Element Exception The default setting is 0
		 */

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement searchBar = driver.findElement(By.xpath("//input[@name='q']"));
		searchBar.sendKeys("Cherry Blossom");
		searchBar.sendKeys(Keys.RETURN);

		// WebElement searchElement =
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By
		// .xpath("/html//ol[@id='b_results']/li[3]/h2/a[@href='https://en.wikipedia.org/wiki/Cherry_blossom']")));
		// System.out.println(searchElement.getText());

		WebElement searchElement = driver.findElement(By
				.xpath("/html//ol[@id='b_results']/li[3]/h2/a[@href='https://en.wikipedia.org/wiki/Cherry_blossom']"));
		searchElement.click();

		endSession();

	}

	public static void endSession() {

		driver.close();
	}

}
