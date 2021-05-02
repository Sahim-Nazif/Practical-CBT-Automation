package main.pack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StatusofWebElement {
	
	
	static WebDriver driver;

	public static void main(String[] args) {
	
		
		//Topic 1
		//How to check WebElement is displayed, Enabled and selected
		//Methods for these are conditional ones such as: isDisplay(),isEnabled(),isSelected()
		
		String URL="https://demo.nopcommerce.com/register";
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(URL);
		
		driver.manage().window().maximize();
		
		
		delayDisplay(1000);
		//Element displayed or not will return boolean
		WebElement searchBar=driver.findElement(By.xpath("//input[@name=\"q\"]"));
		System.out.println(searchBar.isDisplayed());
		
		WebElement searchBarEnabled=driver.findElement(By.xpath("//input[@name=\"q\"]"));
		System.out.println(searchBarEnabled.isEnabled());
		//isSelected() boolean will return
		WebElement maleGenderRd=driver.findElement(By.xpath("//input[@id=\"gender-male\"]"));
		
		maleGenderRd.click();
		System.out.println(maleGenderRd.isSelected());
		delayDisplay(1000);
	
		closeBrowser();

	}
	
	public static void delayDisplay(long seconds) {
		
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void closeBrowser() {
		driver.quit();
	}

}
