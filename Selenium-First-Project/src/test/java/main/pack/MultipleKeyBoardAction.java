package main.pack;

import java.time.Duration;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleKeyBoardAction {

	@Test
	public void keyBoardActionTest() {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		String URL = "https://text-compare.com/";

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);

		WebElement txtarea1 = driver.findElement(By.xpath("//textarea[@id='inputText1']"));
		WebElement txtarea2 = driver.findElement(By.xpath("//textarea[@id='inputText2']"));

		txtarea1.sendKeys("Automation Developer");

		Actions action = new Actions(driver);

		// CTRL + A (select the text)
		action.keyDown(Keys.CONTROL);
		action.sendKeys("a");
		action.keyUp(Keys.CONTROL);
		action.perform();

		// CTRL + C (copy the text)
		action.keyDown(Keys.CONTROL);
		action.sendKeys("c");
		action.keyUp(Keys.CONTROL);
		action.perform();

		// CTRL + TAB (switch the next text-area to paste the text)
		action.sendKeys(Keys.TAB);
		action.perform();

		// CTRL + V (paste the text)
		action.keyDown(Keys.CONTROL);
		action.sendKeys("v");
		action.keyUp(Keys.CONTROL);
		action.perform();

		String expectedResult = txtarea1.getText();
		String actualResult = txtarea2.getText();

		Assert.assertEquals(expectedResult, actualResult);

	}

}
