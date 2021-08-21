package wat2021;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.google.common.io.Files;

public class TestScreenshot {
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
	
	//screenshot alamk icingetScreenshotAs kullaniliyor
	// nerede saklanacagini gostermek icin file tanimlaniyor
	//Throw IO Expection?
	//png file uzantisi 
	

	@Test
	public void testDoubleClick() throws IOException {
		driver.get("http://localhost:8080/workspace/dblclick.html");
		WebElement square = driver.findElement(By.id("square"));
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(srcFile, new File("./screenshots/yellow-square.png"));
		
		assertEquals("rgba(255, 255, 0, 1)", square.getCssValue("background-color"));
		
		Actions builder = new Actions(driver);
		builder.doubleClick(square).perform();

		srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(srcFile, new File("./screenshots/red-square.png"));

		assertEquals("rgba(255, 0, 0, 1)", square.getCssValue("background-color"));
	}
}
