package wat2021;

	import static org.junit.jupiter.api.Assertions.assertEquals;

	import org.junit.After;
	import org.junit.Before;
	import org.junit.Test;
	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class TestSubmit {
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
			WebElement name = driver.findElement(By.id("id"));
			name.clear();
			name.sendKeys("John");
			WebElement btn = driver.findElement(By.id("btn"));
			btn.click();
			WebElement display = driver.findElement(By.id("display"));
			assertEquals("John", display.getText());
		}
		
		@Test
		public void testSubmit2() {
			driver.get("http://localhost:8080/workspace/form.php");
			WebElement name = driver.findElement(By.id("id"));
			name.clear();
			name.sendKeys("John");
			name.sendKeys(Keys.ENTER);
			WebElement display = driver.findElement(By.id("display"));
			assertEquals("John", display.getText());
		}
		
		@Test
		public void testSubmit3() {
			driver.get("http://localhost:8080/workspace/form.php");
			WebElement name = driver.findElement(By.id("id"));
			name.clear();
			name.sendKeys("John");
			name.submit();
			WebElement display = driver.findElement(By.id("display"));
			assertEquals("John", display.getText());
		}
	}



