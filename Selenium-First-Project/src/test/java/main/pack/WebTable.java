package main.pack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {

	private static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		String URL = "https://www.selenium.dev/downloads/";

		driver.manage().window().maximize();

		driver.get(URL);

		// step 1 Find number of Rows in the table
		List<WebElement> tbRows = driver.findElements(By.xpath("//table[@class='data-list']/tbody/tr"));

		System.out.println(tbRows.size());
		// step 2 Find number of Columns in the table
		List<WebElement> tbCols = driver.findElements(By.xpath("//table[@class='data-list']/thead/tr/th"));

		System.out.println(tbCols.size());

	}

}
