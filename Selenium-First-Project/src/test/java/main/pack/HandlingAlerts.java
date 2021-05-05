package main.pack;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingAlerts {

	private static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		String URL = "https://the-internet.herokuapp.com/javascript_alerts";

		driver.get(URL);

		driver.manage().window().maximize();

		WebElement jsAlert = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
		// jsAlert.click();
		// delayRun(3000);
		// driver.switchTo().alert().accept();

		WebElement jsAlertConfirm = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
		// jsAlertConfirm.click();
		// driver.switchTo().alert().accept();

		// driver.switchTo().alert().dismiss();
		delayRun(3000);

		WebElement jsAlertPrompt = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
		jsAlertPrompt.click();

		Alert alertWindow = driver.switchTo().alert();

		alertWindow.sendKeys("Hey there");
		delayRun(2000);

		alertWindow.accept();
		delayRun(2000);
		closeBrowser();

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
