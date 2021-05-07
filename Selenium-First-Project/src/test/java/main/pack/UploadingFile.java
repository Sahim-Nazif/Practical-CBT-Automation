package main.pack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadingFile {

	private static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		String URL = "https://the-internet.herokuapp.com/upload";

		driver.get(URL);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// upload file by using sendkeys method
		driver.findElement(By.id("file-upload")).sendKeys("C://Users//nazif//Downloads//dummy.docx");
		// click upload button to upload file to destination
		driver.findElement(By.xpath("//input[@class='button']")).click();

	}

}
