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

public class TestSelect {
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
	public void testOptions() {
		driver.get("http://localhost:8080/workspace/select.html");
		Select pickCar = new Select(driver.findElement(By.id("car")));
		List<WebElement> options = pickCar.getOptions();
		String[] expected = {"Pick a car", "Volvo", "Saab", "Mercedes", "Audi"};
		List<String> actual = new ArrayList();
		for (WebElement option: options) {
			actual.add(option.getText());
		}
		assertArrayEquals(expected, actual.toArray());
	}
	
	@Test
	public void testSelect() {
		driver.get("http://localhost:8080/workspace/select.html");
		Select pickCar = new Select(driver.findElement(By.id("car")));
		WebElement display = driver.findElement(By.id("display"));
		
		WebElement selected = pickCar.getFirstSelectedOption();
		assertEquals("Pick a car", selected.getText());
		
		pickCar.selectByVisibleText("Audi");
		selected = pickCar.getFirstSelectedOption();
		assertEquals("Audi", selected.getText());
		assertEquals("audi", selected.getAttribute("value"));
		assertEquals("Audi", display.getText());

		pickCar.selectByIndex(3);
		selected = pickCar.getFirstSelectedOption();
		assertEquals("Mercedes", selected.getText());
		assertEquals("mercedes", selected.getAttribute("value"));
		assertEquals("Mercedes", display.getText());

		pickCar.selectByValue("saab");
		selected = pickCar.getFirstSelectedOption();
		assertEquals("Saab", selected.getText());
		assertEquals("saab", selected.getAttribute("value"));
		assertEquals("Saab", display.getText());
	}
}
