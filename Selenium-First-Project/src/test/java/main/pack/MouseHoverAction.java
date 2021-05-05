package main.pack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHoverAction {

	private static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		String URL = "https://demoqa.com/menu/#";

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);

		WebElement menu2 = driver.findElement(By.xpath("// a[normalize-space()='Main Item 2']"));
		WebElement subItem = driver.findElement(By.xpath("// ul[@id='nav']/li[2]/ul/li[1]/a[@href='#']"));

	}
}
