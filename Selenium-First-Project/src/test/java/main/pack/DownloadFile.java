package main.pack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadFile {

	private static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

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
