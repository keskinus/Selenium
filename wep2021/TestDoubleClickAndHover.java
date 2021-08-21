package wat2021;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestDoubleClickAndHover {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		driver = new ChromeDriver();
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	//CssValue renkleri almak icin kullaniliyor
	//assert equal yapmayi unutmamak gerekiyor
	//double click for certain element
	//perform for the action
	@Test
	public void testDoubleClick() {
		driver.get("http://localhost:8080/workspace/dblclick.html");
		WebElement square = driver.findElement(By.id("square"));
		
		assertEquals("rgba(255, 255, 0, 1)", square.getCssValue("background-color"));
		
		Actions builder = new Actions(driver);
		builder.doubleClick(square).perform();
		
		assertEquals("rgba(255, 0, 0, 1)", square.getCssValue("background-color"));
	}
	
	
	//hover-fareyle uzerinde gezinme-moveToElement kullaniliyor.
	@Test
	public void testHover() {
		driver.get("http://localhost:8080/workspace/hover.html");
		WebElement square = driver.findElement(By.id("square"));
		
		assertEquals("rgba(255, 255, 0, 1)", square.getCssValue("background-color"));
		
		Actions builder = new Actions(driver);
		builder.moveToElement(square).perform();
		
		assertEquals("rgba(255, 0, 0, 1)", square.getCssValue("background-color"));
	}

}

