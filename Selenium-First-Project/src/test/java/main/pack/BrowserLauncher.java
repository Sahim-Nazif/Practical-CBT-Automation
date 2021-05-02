package main.pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLauncher {
	
	static WebDriver driver;

	public static void main(String[] args) {
	
		//System.setProperty("webdriver.chrome.driver", "src//main//resources//chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		String url="https://the-internet.herokuapp.com/";
		
		driver.get(url);
		
		driver.manage().window().maximize();
		
		System.out.println("Web page is opened");
		System.out.println("Title of the web page is " + driver.getTitle());
		System.out.println("URL of the webpage is " + driver.getCurrentUrl());
		
		
		
		driver.quit();
		
	}

}
