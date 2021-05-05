package main.pack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenLinkNewPage {

	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		String URL = "https://www.pexels.com/";

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);

		String tab = Keys.chord(Keys.CONTROL, Keys.RETURN);

		driver.findElement(By.linkText("Explore")).sendKeys(tab);
	}

}
