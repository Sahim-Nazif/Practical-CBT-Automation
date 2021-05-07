package main.pack;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadFile {

	private static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		String URL = "https://file-examples.com/index.php/sample-documents-download/";
		driver.manage().window().maximize();

		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

}
