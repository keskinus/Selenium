import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElemntByXPath {
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
	public void testRow () {
		driver.get("http://localhost:8080/workspace/xpath.html");
		// find product and price based its quality of '200'
		WebElement product = driver.findElement(By.xpath(
				"//table[@id='tbl']//td[text()='200']/preceding-sibling::td[2]"
				)); 
		WebElement price = driver.findElement(By.xpath(
				"//table[@id='tbl']//td[text()='200']/preceding-sibling::td[1]"
				));
		assertEquals("DVDs", product.getText());
		assertEquals("$45", price.getText());
		
		
	}
		
}


