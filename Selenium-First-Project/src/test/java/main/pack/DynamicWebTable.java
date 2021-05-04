package main.pack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicWebTable {

	private static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		String URL = "https://demo.opencart.com/admin/index.php?route=common/login";

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(URL);

		WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
		userName.clear();
		userName.sendKeys("demo");

		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.clear();
		password.sendKeys("demo");

		WebElement btn = driver.findElement(By.xpath("//button[@type='submit']"));

		btn.click();

		WebElement salesLink = driver.findElement(By.xpath("//a[normalize-space()='Sales']"));

		salesLink.click();
		closeBrowser();

	}

	public static void closeBrowser() {
		driver.close();
	}

	public static void delayDisplay(long seconds) {

		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

}
