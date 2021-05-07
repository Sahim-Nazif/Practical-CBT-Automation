package main.pack;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadFile {

	private static WebDriver driver;

	public static void main(String[] args) {

		// file location to be downloaded in this project
		String location = System.getProperty("user.dir") + "\\Downloads";
		HashMap preferences = new HashMap();
		preferences.put("download.default_directory", location);

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", preferences);

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);

		String URL = "https://file-examples.com/index.php/sample-documents-download/sample-doc-download/";
		driver.manage().window().maximize();

		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement btn = driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]"));
		System.out.println(btn.getAttribute("href"));
		System.out.println(btn.getText());
		// download the MS Word file
		btn.click();

	}

}
