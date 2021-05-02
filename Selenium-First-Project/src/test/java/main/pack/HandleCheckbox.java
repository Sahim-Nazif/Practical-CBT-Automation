package main.pack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCheckbox {

	private static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		String URL = "https://itera-qa.azurewebsites.net/home/automation";

		driver.get(URL);

		driver.manage().window().maximize();

		// 1- select single checkbox
		WebElement chkboxMonday = driver.findElement(By.xpath("//input[@id='monday']"));

		// chkboxMonday.click();

		// 2- select all check boxes
		List<WebElement> allChkBoxes = driver
				.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'day')]"));

//		for (WebElement items : allChkBoxes) {
//
//			items.click();
//
//		}
//		delayRun(2000);

		// 3 - Select multiple check boxes
		// for instance want to select Friday and Saturday

		for (WebElement items : allChkBoxes) {
			String checkboxName = items.getAttribute("id");

			if (checkboxName.equals("friday") || checkboxName.equals("saturday")) {
				items.click();
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
