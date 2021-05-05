package main.pack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyBoardAction {

	private static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		String URL = "https://the-internet.herokuapp.com/key_presses";

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);

		WebElement input = driver.findElement(By.xpath("//input[@id='target']"));

		Actions action = new Actions(driver);

		action.sendKeys(input, "L").perform();

		// Well-known keyboard actions can be implemented via action
		action.sendKeys(Keys.ENTER).perform();
		action.sendKeys(Keys.ESCAPE).perform();

	}

}
