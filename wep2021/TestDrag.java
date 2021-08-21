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

public class TestDrag {
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
	// position absolute-parent position
	// id varsa her xzaman id yi almak gerekiuor
	//# cropImage (#= id demek cssSelectorDE), .dg-drop(.= class) parent-child iliskisi var
	//kenarlara cekmek icin move by offset kullaniliyor
	//assertEquals first expected value, actually value second.
	
	@Test
	public void testDrag() throws IOException {
		driver.get("http://www.dhtmlgoodies.com/scripts/dg-crop/dg-crop.html");
		WebElement drag = driver.findElement(By.cssSelector("#cropImage .dg-crop"));
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(srcFile, new File("./screenshots/before-drag.png"));		
		
		assertEquals("absolute", drag.getCssValue("position"));
		assertEquals("66px", drag.getCssValue("top"));
		assertEquals("66px", drag.getCssValue("left"));
		
		Actions builder = new Actions(driver);
		builder.clickAndHold(drag).moveByOffset(100, 50).release().perform();
		
		srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(srcFile, new File("./screenshots/after-drag.png"));		

		assertEquals("116px", drag.getCssValue("top"));
		assertEquals("166px", drag.getCssValue("left"));
	}
}
