package wat2021;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestMultiSelect {
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
	public void testMultiSelect() {
		driver.get("http://localhost:8080/workspace/multiple.html");
		Select pick = new Select(driver.findElement(By.id("color")));
		assertEquals(true, pick.isMultiple());
		
		pick.selectByVisibleText("Red");
		pick.selectByVisibleText("White");
		
		WebElement display = driver.findElement(By.id("display"));
		assertEquals("White,Red", display.getText());
	}
	
	@Test
	public void testMultiSelect2() {
		driver.get("http://localhost:8080/workspace/multiple.html");
		Select pick = new Select(driver.findElement(By.id("color")));
		pick.selectByVisibleText("Red");
		pick.selectByVisibleText("White");
		pick.deselectByIndex(1);
		pick.selectByValue("rb");
		
		WebElement display = driver.findElement(By.id("display"));
		assertEquals("Red,Brown", display.getText());
		
		List<WebElement> selected = pick.getAllSelectedOptions();
		String[] expected = {"Red", "Brown"};
		List<String> actual = new ArrayList();
		for (WebElement option: selected) {
			actual.add(option.getText());
		}
		assertArrayEquals(expected, actual.toArray());
	}
}
