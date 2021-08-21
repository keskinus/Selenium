package wat2021;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.net.URI;
import java.net.URISyntaxException;

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

public class TestConfirm {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		driver = new ChromeDriver();	
		driver.get("http://localhost:8080/workspace/confirm.html");
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void testDismiss() {
		WebElement btn = driver.findElement(By.cssSelector("[value='Leave this page']"));
		btn.click();
		
		
		//every time add wait
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());

		Alert alert = driver.switchTo().alert();
		
		assertEquals("Do you really want to leave?", alert.getText());
		
		alert.dismiss();
		
		WebElement message = driver.findElement(By.tagName("p"));
		assertEquals("Thank you!", message.getText());
	}
	
	@Test
	public void testAccept() {
		WebElement btn = driver.findElement(By.cssSelector("[value='Leave this page']"));
		btn.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());

		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		String url = driver.getCurrentUrl();
		System.out.println(url);
		
		try {
			String host = new URI(url).getHost();
			assertEquals("www.google.com", host);
		} catch (URISyntaxException e) {
			fail("bad url string");
		}
	}
}
