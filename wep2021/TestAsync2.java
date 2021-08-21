 package wat2021;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestAsync2 {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void testSubmit() {
		driver.get("http://localhost:8080/workspace/jswaitec2.html");
		WebElement input = driver.findElement(By.id("name"));
		input.clear();
		input.sendKeys("John");
		WebElement btn = driver.findElement(By.id("btn"));
		btn.click();
		
		// I want Selenium to wait until <p id="display"> is visible
		WebElement display = driver.findElement(By.id("display"));
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(
			ExpectedConditions.visibilityOf(display)
		);		
		assertEquals("John", display.getText());		
	}
}
