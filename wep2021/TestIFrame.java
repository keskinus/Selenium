package wat2021;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestIFrame {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		driver = new ChromeDriver();	
		driver.get("http://localhost:8080/workspace/iframe.html");
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void testIFrame() {
		WebElement iframe = driver.findElement(By.cssSelector("iframe[src$='button.html']"));
		driver.switchTo().frame(iframe);
		
		// I am in the iframe
		WebElement btn = driver.findElement(By.cssSelector("[value='Click Me']"));
		btn.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.alertIsPresent());

		Alert alert = driver.switchTo().alert();
		assertEquals("Hello World", alert.getText());
		alert.accept();
		// I am still in the iframe!
		
		// I need to go back to the main page!
		driver.switchTo().defaultContent();
		WebElement h1 = driver.findElement(By.tagName("h1"));
		assertEquals("Hello World", h1.getText());
	}
}
