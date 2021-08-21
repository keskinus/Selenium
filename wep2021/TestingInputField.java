package wat2021;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestingInputField {
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
	public void testInput() {
		driver.get("http://localhost:8080/workspace/input.html");
		WebElement name = driver.findElement(By.id("name"));
		name.clear();
		name.sendKeys("John");
		WebElement btn = driver.findElement(By.id("btn"));
		btn.click();
		WebElement display = driver.findElement(By.id("display"));
		assertEquals("Hello John", display.getText());
	}
}
