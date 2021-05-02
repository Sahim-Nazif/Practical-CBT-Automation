package main.pack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootstrapDropDown {

	private static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		String URL = "https://www.hdfcbank.com/";

		driver.manage().window().maximize();

		driver.get(URL);

		// handling bootstrap dropdown
		WebElement dropdown = driver.findElement(By.xpath("//a[.='Select Product Type']"));
		dropdown.click();

		delayRun(3000);

		List<WebElement> productTypes = driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']/li"));
		System.out.println("Number of elements: " + productTypes.size());

		for (WebElement elements : productTypes) {
			if (elements.getText().equals("Invest")) {
				elements.click();
				break;
			}

		}

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
