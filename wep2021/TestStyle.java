package wat2021;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestStyle {
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
	public void testH1Style() {
		driver.get("http://localhost:8080/workspace/css.html");
		WebElement h1 = driver.findElement(By.tagName("h1"));
		assertEquals("center", h1.getCssValue("text-align"));
	}
	
	@Test
	public void testH1Colors() {
		driver.get("http://localhost:8080/workspace/css.html");
		WebElement h1 = driver.findElement(By.tagName("h1"));
//		System.out.println(h1.getCssValue("color"));
//		System.out.println(h1.getCssValue("background-color"));
		assertEquals("rgba(51, 51, 51, 1)", h1.getCssValue("color"));
		assertEquals("rgba(255, 255, 0, 1)", h1.getCssValue("background-color"));
	}
	
	@Test
	public void testH2Style() {
		driver.get("http://localhost:8080/workspace/css.html");
		WebElement h2 = driver.findElement(By.tagName("h2"));
		System.out.println(h2.getCssValue("border"));
		System.out.println(h2.getCssValue("border-style"));
		System.out.println(h2.getCssValue("border-width"));
		System.out.println(h2.getCssValue("border-color"));
		System.out.println(h2.getCssValue("border-top-style"));
		System.out.println(h2.getCssValue("border-left-width"));
		System.out.println(h2.getCssValue("border-bottom-color"));
	}
}
