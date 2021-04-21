import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTest {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");

		driver = new ChromeDriver();
		driver.get("http://www.amazon.com/");		
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void testSearch() {
		// I am in the amazon home page
		WebElement input = driver.findElement(By.id("twotabsearchtextbox"));
		input.sendKeys("Harry Potter");

		WebElement searchIcon = driver.findElement(By.id("nav-search-submit-button"));
		searchIcon.click();
		
		// I am in a different page, which is the search result page
		WebElement status = driver.findElement(By.cssSelector(
			"#search > span > div > span > h1 > div > div.sg-col-14-of-20.sg-col.s-breadcrumb.sg-col-10-of-16.sg-col-6-of-12 > div > div > span:nth-child(1)"
		));
		assertTrue(status.getText().startsWith("1-16"));		
	}
}
