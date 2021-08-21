package wat2021;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestRadioButtons {
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
	public void testMenu() {
		driver.get("http://localhost:8080/workspace/radiobuttons.html");
//		WebElement fishRadioButton = 
//			driver.findElement(By.cssSelector("[name='burger'][value='fish']"));
//		fishRadioButton.click();
//		WebElement pickleRadioButton = 
//			driver.findElement(By.cssSelector("[name='side'][value='pickle']"));
//		pickleRadioButton.click();
//		WebElement orangeRadioButton = 
//		driver.findElement(By.cssSelector("[name='drink'][value='juice']"));
//		orangeRadioButton.click();
		
		// check the radio button with the visible text "Fish Burger $2"
		// check the radio button with the visible text "Pickle $3"
		// check the radio button with the visible text "Orange Juice $3"
		
		WebElement burgerRadioButton = findRadioButtonByVisibleText("Fish Burger $2");
		WebElement sideRadioButton = findRadioButtonByVisibleText("Pickle $3");
		WebElement drinkRadioButton = findRadioButtonByVisibleText("Orange Juice $3");
		
		if (burgerRadioButton != null) { burgerRadioButton.click(); }
		if (sideRadioButton != null) { sideRadioButton.click(); }
		if (drinkRadioButton != null) { drinkRadioButton.click(); }
		
		WebElement price = driver.findElement(By.id("price"));
		assertEquals("8", price.getText());
		
		WebElement cheeseBurgerRadioButton = findRadioButtonByVisibleText("Cheese Burger $1");
		assertFalse(cheeseBurgerRadioButton.isSelected());
		assertTrue(burgerRadioButton.isSelected());
	}
	
	@Test
	public void testDrinks() {
		driver.get("http://localhost:8080/workspace/radiobuttons.html");
		WebElement juice = findRadioButtonByVisibleText("Orange Juice $3");
		juice.click();
		WebElement milk = findRadioButtonByVisibleText("Milk $2");
		milk.click();
		
		// check all the radio buttons in the "Drink:" section
		// the radio button with value="milk" is selected
		// all other radio buttons are not selected
		List<WebElement> drinks = 
			driver.findElements(By.xpath(
				"//p[text()='Drink:']/following-sibling::*[1]//input[@type='radio']"
			));
		for (WebElement drink: drinks) {
			if (drink.getAttribute("value").equals("milk")) {
				assertTrue(drink.isSelected());
			} else {
				assertFalse(drink.isSelected());
			}
		}
		
		int count = 0;
		for (WebElement drink: drinks) {
			if (drink.isSelected()) {
				count++;
			}
		}
		assertEquals(1, count);
	}
	
	private WebElement findRadioButtonByVisibleText(String text) {
		List<WebElement> lis = driver.findElements(By.tagName("li"));
		for (WebElement li: lis) {
			if (li.getText().trim().equals(text)) {
				return li.findElement(By.tagName("input"));
			}
		}
		return null;
	}
}
