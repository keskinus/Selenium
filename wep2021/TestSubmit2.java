package wat2021;

	import static org.junit.jupiter.api.Assertions.assertEquals;

	import org.junit.After;
	import org.junit.Before;
	import org.junit.Test;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class TestSubmit2 {
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
			driver.get("http://localhost:8080/workspace/form.php");
			// I am in the first page with a blank form
			WebElement display = driver.findElement(By.id("display"));
			assertEquals("", display.getText());
			WebElement name = driver.findElement(By.id("id"));
			name.clear();
			name.sendKeys("John");
			WebElement btn = driver.findElement(By.id("btn"));
			btn.click();
			// I am in the second page with a blank form and a name displayed below
			// org.openqa.selenium.StaleElementReferenceException: 
			// 	stale element reference: element is not attached to the page document
			display = driver.findElement(By.id("display"));
			assertEquals("John", display.getText());
		}
	}



