package wat2021;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestStatus {
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
	
	@Test
	public void testDefault() {
		driver.get("http://localhost:8080/workspace/enable.html");
		WebElement checkbox = driver.findElement(By.id("chk"));
		WebElement select = driver.findElement(By.id("sel"));
		WebElement display = driver.findElement(By.id("display"));
		assertFalse(checkbox.isSelected());
		assertFalse(select.isEnabled());
		assertFalse(display.isDisplayed());
	}
	
	@Test
	public void testClickCheckbox() {
		driver.get("http://localhost:8080/workspace/enable.html");
		WebElement checkbox = driver.findElement(By.id("chk"));
		WebElement select = driver.findElement(By.id("sel"));
		WebElement display = driver.findElement(By.id("display"));
		checkbox.click();
		assertTrue(checkbox.isSelected());
		assertTrue(select.isEnabled());
		assertTrue(display.isDisplayed());
	}
}
