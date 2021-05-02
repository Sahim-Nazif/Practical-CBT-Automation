package main.pack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDropDown {

	private static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		String URL = "https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/";

		driver.manage().window().maximize();

		driver.get(URL);

		WebElement jqueryElement = driver.findElement(By.xpath("//input[@id='justAnInputBox']"));

		jqueryElement.click();

		delayRun(2000);
		selectChoiceValues(driver, "choice 1", "choice 2", "choice 2 1");

		delayRun(2000);

		closeBrowser();

	}

	public static void selectChoiceValues(WebDriver driver, String... value) {

		List<WebElement> choiceList = driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));

		if (!value[0].equalsIgnoreCase("all")) {

			for (WebElement item : choiceList) {
				String text = item.getText();

				for (String val : value) {
					if (text.equals(val)) {
						item.click();

						break;
					}
				}

			}

		} else {
			for (WebElement item : choiceList) {
				item.click();
			}
		}

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
