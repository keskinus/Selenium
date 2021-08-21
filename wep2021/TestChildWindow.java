package wat2021;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestChildWindow {
	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		driver = new ChromeDriver();	
		driver.get("http://localhost:8080/workspace/childwindow.html");
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void testChildWindowByName() {
		List<WebElement> btns = driver.findElements(By.cssSelector("[value^='Click Me']"));
		for (WebElement btn: btns) {
			btn.click();
		}
		
		String mainWindowHandle = driver.getWindowHandle();
		System.out.println("Main window handle: " + mainWindowHandle);
		Set<String> handles = driver.getWindowHandles();
		System.out.println("All windows:");
		for (String handle: handles) {
			System.out.println(handle);
		}
		
		driver.switchTo().window("HelpWindow");
		// I am a subwindow
		WebElement h1 = driver.findElement(By.tagName("h1"));
		assertEquals("Q & A", h1.getText());
		
		// I am back to the main window
		driver.switchTo().window(mainWindowHandle);
		
		btns = driver.findElements(By.cssSelector("[value^='Click Me']"));
		assertEquals(3, btns.size());
	}
	
	@Test
	public void testAllChildWindows() {
		List<WebElement> btns = driver.findElements(By.cssSelector("[value^='Click Me']"));
		for (WebElement btn: btns) {
			btn.click();
		}

		Set<String> handles = driver.getWindowHandles();
		assertEquals(4, handles.size());
		
		for (String handle: handles) {
			driver.switchTo().window(handle);
			String url = driver.getCurrentUrl();
			
			if (url.endsWith("form.html")) {
				WebElement input = driver.findElement(By.id("name"));
				input.clear();
				input.sendKeys("John");
				input.submit();
				
				WebElement message = driver.findElement(By.tagName("p"));
				assertEquals("Hello John", message.getText());
			} else if (url.endsWith("square.html")) {
				WebElement square = driver.findElement(By.id("square"));
				assertEquals("150px", square.getCssValue("height"));
				assertEquals("150px", square.getCssValue("width"));
				assertEquals("rgba(255, 0, 0, 1)", square.getCssValue("background-color"));
			} else if (url.endsWith("help.html")) {
				WebElement h1 = driver.findElement(By.tagName("h1"));
				assertEquals("Q & A", h1.getText());
			} else if (!url.endsWith("childwindow.html")) {
				fail("Wrong url in a window");
			}
		}
	}
	
	@Test
	public void testSingleChildWindow() {
		WebElement btn = driver.findElement(By.cssSelector("[value='Click Me']"));
		btn.click();
		String main = driver.getWindowHandle();
		String sub = "";
		for (String handle: driver.getWindowHandles()) {
			if (!handle.equals(main)) {
				sub = handle;
				break;
			}
		}
		if (!sub.equals("")) {
			driver.switchTo().window(sub);
			WebElement h1 = driver.findElement(By.tagName("h1"));
			assertEquals("Q & A", h1.getText());			
		}
	}
}
