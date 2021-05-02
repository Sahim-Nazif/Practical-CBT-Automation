package main.pack;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestDropDown {

	private static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		String URL = "https://www.bing.com/";

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);

		WebElement searchBar = driver.findElement(By.xpath("//input[@id='sb_form_q']"));
		searchBar.sendKeys("selenium");

		List<WebElement> autoSuggestedOptions = driver.findElements(By.xpath("//li[@class='sa_sg']//span"));

		System.out.println(autoSuggestedOptions.size());

		for (WebElement list : autoSuggestedOptions) {

			if (list.getText().equals("selenium webdriver")) {
				list.click();

				break;
			}

		}
		delayDisplay(2000);
		closeBrowser();
	}

	public static void delayDisplay(long seconds) {

		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	public static void closeBrowser() {
		driver.quit();
	}

}
