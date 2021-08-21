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

public class TestAlert {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		driver = new ChromeDriver();		
	}
	
	@After
	public void tearDown() {
//		driver.quit();
	}
	
	@Test
	public void testAlert() {
		driver.get("http://localhost:8080/workspace/alert.html");
		WebElement btn = driver.findElement(By.cssSelector("[value='Click Me']"));
		btn.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alert = driver.switchTo().alert();
		assertEquals("Hello World", alert.getText());
		alert.accept();
	}
}
