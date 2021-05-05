package main.pack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleMultipleDropdowns {

	private static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		String URL = "https://www.orangehrm.com/orangehrm-30-day-trial/";

		driver.manage().window().maximize();

		driver.get(URL);

		// selecting multiple dropdown - will use two approaches (1- with Select class
		// and the other with
		// user created method)

		WebElement noOfemployees = driver.findElement(By.xpath("//select[@name='NoOfEmployees']"));
		// approach 1
		// Select employeesdropdown = new Select(noOfemployees);

		// employeesdropdown.selectByVisibleText("51 - 75");

		// approach 2

		selectMultipleOptionsfromDropDown(noOfemployees, "51 - 75");
		WebElement industryDropdown = driver.findElement(By.xpath("//select[@name='Industry']"));
		// approach 1
		// Select allIndustry = new Select(industryDropdown);

		// allIndustry.selectByVisibleText("Automotive");

		// approach 2
		selectMultipleOptionsfromDropDown(industryDropdown, "Automotive");
		WebElement counryDropDown = driver.findElement(By.xpath("//select[@name='Country']"));

		// approach 1
		// Select country = new Select(counryDropDown);

		// country.selectByVisibleText("Afghanistan");

		// approach 2
		selectMultipleOptionsfromDropDown(counryDropDown, "Afghanistan");

		delayRun(2000);

		closeBrowser();

	}

	public static void selectMultipleOptionsfromDropDown(WebElement element, String value) {

		Select dropdown = new Select(element);

		List<WebElement> allOptions = dropdown.getOptions();

		for (WebElement option : allOptions) {
			if (option.getText().equals(value)) {
				option.click();

				break;
			}
		}

	}

	public static void delayRun(long miliseconds) {

		try {
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public static void closeBrowser() {

		driver.close();
	}

}
