package wat2021;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAsync1 {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		driver = new ChromeDriver();
		//ten second max wait time
		//if you coulnt't element, selenium wqaits and keep cheking until find it.
		//we can't specified wait which element, generic wait 
		//it is only deal with  if elemnt is node is not Dom tree and then appear later
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void testSubmit() {
		driver.get("http://localhost:8080/workspace/jswait.html");
		WebElement input = driver.findElement(By.id("name"));
		input.clear();
		input.sendKeys("John");
		WebElement btn = driver.findElement(By.id("btn"));
		btn.click();
		
		// By default, Selenium fails to wait
		// delay of 5 seconds by JS
		// I want Selenium to wait until <p id="display"> is a DOM element 
		//implicity wait
		WebElement display = driver.findElement(By.id("display"));
		assertEquals("John", display.getText());		
	}
}

