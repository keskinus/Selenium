package wat2021;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestFrame {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		driver = new ChromeDriver();	
		driver.get("http://localhost:8080/workspace/frames.html");
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void testLeftFrame() {
//		driver.switchTo().frame("left");
//		driver.switchTo().frame(0);
		
		WebElement squareFrame = driver.findElement(By.cssSelector("frame[src='frames/square.html']"));
		driver.switchTo().frame(squareFrame);
		// I am in the left frame
		WebElement square = driver.findElement(By.id("square"));
		assertEquals("150px", square.getCssValue("height"));
		assertEquals("150px", square.getCssValue("width"));
		assertEquals("rgba(255, 0, 0, 1)", square.getCssValue("background-color"));
	}
	
	@Test
	public void testMiddleFrame() {
//		driver.switchTo().frame("hello");
//		driver.switchTo().frame(1);
		
		WebElement helloFrame = driver.findElement(By.cssSelector("frame[src='frames/hello.html']"));
		driver.switchTo().frame(helloFrame);
		// I am in the middle frame
		WebElement h1 = driver.findElement(By.tagName("h1"));
		assertEquals("Hello World", h1.getText());
	}
	
	@Test
	public void testMultiFrames() {
		WebElement squareFrame = driver.findElement(By.cssSelector("frame[src='frames/square.html']"));
		driver.switchTo().frame(squareFrame);
		// I am in the left frame
		WebElement square = driver.findElement(By.id("square"));
		assertEquals("rgba(255, 0, 0, 1)", square.getCssValue("background-color"));

		// I am back to the main page with three frames
		driver.switchTo().defaultContent();
		
		WebElement helloFrame = driver.findElement(By.cssSelector("frame[src='frames/hello.html']"));
		driver.switchTo().frame(helloFrame);
		// I am in the middle frame
		WebElement h1 = driver.findElement(By.tagName("h1"));
		assertEquals("Hello World", h1.getText());
	}
}
