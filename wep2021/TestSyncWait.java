package wat2021;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSyncWait {
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
	public void testSubmit() {
		driver.get("http://localhost:8080/workspace/wait.php");
		// I am in the first page- default or home page
		WebElement input = driver.findElement(By.id("name"));
		//First clear
		input.clear();
		input.sendKeys("John");
		input.submit();
		
		// Selenium waits for 5 seconds! automaticly
		// I am in the second page
		WebElement display = driver.findElement(By.id("display"));
		assertEquals("John", display.getText());
	}
}
