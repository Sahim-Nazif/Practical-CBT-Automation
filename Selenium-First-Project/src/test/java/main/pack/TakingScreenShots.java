package main.pack;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakingScreenShots {
	static WebDriver driver;

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		String URL = "https://demo.nopcommerce.com/";

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);

		// Take full page screenshot
		// TakesScreenshot screenshot = (TakesScreenshot) driver;
		// File src = screenshot.getScreenshotAs(OutputType.FILE);
		// File target = new File(".\\screenshots\\homepage.png");
		// FileUtils.copyFile(src, target);

		// Capturing screenshot of a section of page
		WebElement section = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		File src = section.getScreenshotAs(OutputType.FILE);
		File target = new File(".\\screenshots\\features.png");
		FileUtils.copyFile(src, target);
		driver.close();

	}

}
