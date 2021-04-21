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

public class FindByCssAttribute {
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
	public void testFindElementByName() {
		driver.get("http://localhost:8080/workspace/search.html");
		WebElement input = driver.findElement(By.cssSelector("[name='keyword']"));
		assertEquals("Type in your keyword", input.getAttribute("value"));
	}
	
	@Test
	public void testFindLinksWithTarget() {
		driver.get("http://localhost:8080/workspace/links.html");
		List<WebElement> links = driver.findElements(By.cssSelector("a[target]"));
		String[] expected = {"Google site", "MSN Link"};
		List<String> actual = new ArrayList();
		for (WebElement link: links) {
			actual.add(link.getText());
		}
		assertArrayEquals(expected, actual.toArray());
	}
	
	@Test
	public void testFindLinkThatOpensNewTab() {
		driver.get("http://localhost:8080/workspace/links.html");
		WebElement link = driver.findElement(By.cssSelector("a[target='_blank']"));
		assertEquals("MSN Link", link.getText());
	}
	
	@Test
	public void testFindFirstSecureLink() {
		driver.get("http://localhost:8080/workspace/links.html");
		WebElement link = driver.findElement(By.cssSelector("a[href^='https']"));
		assertEquals("Google site", link.getText());
	}
	
	@Test
	public void testFindFirstSecureLinkInList() {
		driver.get("http://localhost:8080/workspace/links.html");
		// first approach:
//		WebElement ol = driver.findElement(By.id("list2"));
//		WebElement link = ol.findElement(By.cssSelector("a[href^='https']"));
		// second approach:
//		WebElement link = driver.findElement(By.id("list2"))
//								.findElement(By.cssSelector("a[href^='https']"));
		// third approach:
		WebElement link = driver.findElement(By.cssSelector("#list2 a[href^='https']"));
		assertEquals("Facebook", link.getText());
	}
	
	@Test
	public void testFindFirstPDFLink() {
		driver.get("http://localhost:8080/workspace/links.html");
		WebElement link = driver.findElement(By.cssSelector("a[href$='.pdf']"));
		assertEquals("Contract draft 2", link.getText());
	}
	
	@Test
	public void testFindPasswordField() {
		driver.get("http://localhost:8080/workspace/xpath.html");
		WebElement password = driver.findElement(By.cssSelector("input[type='password']"));
		assertEquals("secret", password.getAttribute("value"));
	}
}
