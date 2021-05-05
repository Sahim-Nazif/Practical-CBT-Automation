package main.pack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleKeyBoardAction {

	private static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		String URL = "https://text-compare.com/";

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);

		WebElement txtarea1 = driver.findElement(By.xpath("//textarea[@id='inputText1']"));
		WebElement txtarea2 = driver.findElement(By.xpath("//textarea[@id='inputText2']"));

	}

}
