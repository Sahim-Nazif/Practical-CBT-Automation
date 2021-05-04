package main.pack;

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
		int tbRows = driver.findElements(By.xpath("//table[@class='data-list']/tbody/tr")).size();

		System.out.println(tbRows);
		// step 2 Find number of Columns in the table
		int tbCols = driver.findElements(By.xpath("//table[@class='data-list']/thead/tr/th")).size();

		System.out.println(tbCols);

		// step 3 Retrieve the specific row/column data
		WebElement value = driver.findElement(By.xpath("//table[@class='data-list']//tr[2]/td[1]"));
		System.out.println(value.getText());

		// step 4 Retrieve all the rows and columns

		for (int r = 1; r <= tbRows; r++) {
			for (int c = 1; c <= tbCols; c++) {
				WebElement tbData = driver
						.findElement(By.xpath("//table[@class='data-list']//tr[" + r + "]/td[" + c + "]"));
				System.out.println(tbData.getText());
			}
		}
		closeBrowser();

	}

	public static void closeBrowser() {

		driver.close();
	}

}
