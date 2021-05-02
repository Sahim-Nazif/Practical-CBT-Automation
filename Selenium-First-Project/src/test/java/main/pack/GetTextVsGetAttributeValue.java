package main.pack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetTextVsGetAttributeValue {

	private static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		String URL = "https://admin-demo.nopcommerce.com/login";
		driver.get(URL);
		WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
		delayScreen(3000);
		// capturing text (value) from the input box
		System.out.println(email.getAttribute("value"));

		email.clear();
		email.sendKeys("grandapanda@grand.com");

		delayScreen(2000);

		closeBrowser();

	}

	public static void delayScreen(long seconds) {

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
