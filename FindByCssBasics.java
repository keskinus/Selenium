import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindByCssBasics {
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
	public void testFindElementById() {
		driver.get("http://localhost:8080/workspace/helloworld.html");
		WebElement h1 = driver.findElement(By.cssSelector("#title"));
		assertEquals("Hello World", h1.getText());
	}
	
	@Test
	public void testFindElementByClassName() {
		driver.get("http://localhost:8080/workspace/search.html");
		WebElement label = driver.findElement(By.cssSelector(".label"));
		assertEquals("Search", label.getText());
	}
		
	@Test
	public void testFindElementByTagName() {
		driver.get("http://localhost:8080/workspace/search.html");
		WebElement label = driver.findElement(By.cssSelector("label"));
		assertEquals("Search2", label.getText());
	}
	
	@Test
	public void testFindElementsByTagName() {
		driver.get("http://localhost:8080/workspace/search.html");
		List<WebElement> labels = driver.findElements(By.cssSelector("label"));
		
		assertEquals(2, labels.size());
		
		String[] expected = {"Search2", "Search"};
		List<String> actual = new ArrayList();
		for (WebElement label: labels) {
			actual.add(label.getText());
		}
		
		assertArrayEquals(expected, actual.toArray());
	}
}
