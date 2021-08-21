 import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindCheckedSkills {
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
	public void testCheckedSkills() {
		driver.get("http://localhost:8080/workspace/xpath.html");
		List<WebElement> skills = driver.findElements(By.cssSelector("#skills > li"));
		String[] expected = {"Java", "C#"};
		List<String> actual = new ArrayList();
		
		for (WebElement skill: skills) {
			// Is there a checked checkbox
			try {
				skill.findElement(By.cssSelector("input:checked"));
				actual.add(skill.getText());
			} catch (NoSuchElementException e) {}
		}
		assertArrayEquals(expected, actual.toArray());
	}
	
	@Test
	public void testCheckedSkills2() {
		driver.get("http://localhost:8080/workspace/xpath.html");
		List<WebElement> skills = driver.findElements(By.cssSelector("#skills > li"));
		String[] expected = {"Java", "C#"};
		List<String> actual = new ArrayList();
		
		for (WebElement skill: skills) {
			// Is there a checked checkbox
			WebElement checkbox = skill.findElement(By.tagName("input"));
			if (
				checkbox.getAttribute("checked") != null 
				&& 
				checkbox.getAttribute("checked").equals("true")
			) {
				actual.add(skill.getText());
			}
		}
		assertArrayEquals(expected, actual.toArray());
	}
	
	@Test
	public void testCheckedSkillsByXPath() {
		driver.get("http://localhost:8080/workspace/xpath.html");
		List<WebElement> checkedLis = driver.findElements(By.xpath(
			"//*[@id='skills']//input[@checked]/.."
		));
		String[] expected = {"Java", "C#"};
		List<String> actual = new ArrayList();
		for (WebElement li: checkedLis) {
			actual.add(li.getText());
		}
		assertArrayEquals(expected, actual.toArray());
	}
}
