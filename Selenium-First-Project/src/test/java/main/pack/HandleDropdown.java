package main.pack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropdown {

	private static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		String URL = "https://the-internet.herokuapp.com/dropdown";
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get(URL);

		WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdown']"));

		Select dropdownOptions = new Select(dropdown);

		// 1- use index to select the drop down item
		// dropdownOptions.selectByIndex(1);

		// 2- use visible text to select drop down item

		// dropdownOptions.selectByVisibleText("Option 2");

		// 3- select by value
		dropdownOptions.selectByValue("1");

		System.out.println(dropdown.getAttribute("value"));

		// 4- selecting option from drop down without using the above methods

		List<WebElement> allOptions = dropdownOptions.getOptions();
		for (WebElement option : allOptions) {
			if (option.getText().equals("Option 2")) {

				option.click();
				break;
			}
		}
		delayDisplay(2000);

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
