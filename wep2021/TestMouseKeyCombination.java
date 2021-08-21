package wat2021;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TestMouseKeyCombination {
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
	// Select element then find option element
	@Test
	public void testShiftClick() {
		driver.get("http://localhost:8080/workspace/longselect.html");
		WebElement list = driver.findElement(By.tagName("select"));
		
		//icindeki texti almak icin xpath kulaniyoruz
		//inside webelement start  with ". " indicate current webelement and then immidiate child single / and text.
		WebElement row3 = list.findElement(By.xpath("./option[text()='row 3']"));
		WebElement row5 = list.findElement(By.xpath("./option[text()='row 5']"));
		
		//click row 5 press shift key and click row 3.
		Actions builder = new Actions(driver);
		builder.keyDown(Keys.SHIFT).click(row5).click(row3).keyUp(Keys.SHIFT).perform();
		
		String[] expected = {"row 3", "row 4", "row 5"};
		
		//create select object. Select from the list.
		Select select = new Select(list);
		List<String> actual = new ArrayList();
		for (WebElement option: select.getAllSelectedOptions()) {
			actual.add(option.getText());
		}
		
		assertArrayEquals(expected, actual.toArray());
	}
}
