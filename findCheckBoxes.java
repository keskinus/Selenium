import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class findCheckBoxes {
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
	public void testCheckedLanguages() {
		driver.get("http://localhost:8080/workspace/xpath.html");
		List<WebElement> languages = driver.findElements(By.cssSelector(
				"#languages li input:checked ~ label"));
		String[] expected = {"English", "Spanish"};
		List<String> actual = new ArrayList();
		for(WebElement language:languages) {
			actual.add(language.getText());
		}
		
		assertArrayEquals(expected,actual.toArray());
	}
	

	
	@Test
	public void testCheckedSkills() {
		driver.get("http://localhost:8080/workspace/xpath.html");
		List<WebElement> skills = driver.findElements(By.cssSelector(
				"#skills li input:checked~p"));

		String[] expected = {"Java", "C#"};
		List<String> actual = new ArrayList();
		for(WebElement skill:skills) {
			actual.add(skill.getText());
		
		}
		
		assertArrayEquals(expected,actual.toArray());
}

}