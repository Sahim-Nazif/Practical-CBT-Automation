package main.pack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseDoubleClickAction {

	private static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		String URL = "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick";

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);

		// switch to iframe since there are two iframes on the page
		driver.switchTo().frame("iframeResult");

		WebElement btn = driver.findElement(By.xpath("//body/button[.='Double-click me']"));
		Actions action = new Actions(driver);

		action.doubleClick(btn).perform();

		delayDisplay(3000);
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
