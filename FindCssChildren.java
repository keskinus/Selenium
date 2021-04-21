import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindCssChildren {
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
	public void testFindUserName() {
		driver.get("http://localhost:8080/workspace/xpath.html");
		WebElement username = 
			driver.findElement(By.cssSelector("form input:first-of-type"));
		assertEquals("username2307", username.getAttribute("name"));
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testNotFindUserName() {
		driver.get("http://localhost:8080/workspace/xpath.html");
		driver.findElement(By.cssSelector("form input:first-child"));		
	}
}
