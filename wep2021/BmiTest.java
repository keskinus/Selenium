package wat2021;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Parameterized.class)
public class BmiTest {
	private WebDriver driver;
	private String height;
	private String weight;
	private String bmi;
	private String bmiCategory;
	
	public BmiTest(String height, String weight, String bmi, String bmiCategory) {
		this.height = height;
		this.weight = weight;
		this.bmi = bmi;
		this.bmiCategory = bmiCategory;
	}
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/workspace/bmicalculator.html");
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Parameters
	public static List<String[]> getBmiTestData() {
		String[][] data = {
				{"160", "45","17.6", "Underweight"},
				{"168", "70","24.8", "Normal"},
				{"181", "89","27.2", "Overweight"},
				{"178", "100","31.6", "Obesity"}
		};
		return Arrays.asList(data);
	}
	
	@Test
	public void testBmi() {
		WebElement heightField = driver.findElement(By.id("heightCMS"));
		heightField.clear();
		heightField.sendKeys(height);
		WebElement weightField = driver.findElement(By.id("weightKg"));
		weightField.clear();
		weightField.sendKeys(weight);
		WebElement btn = driver.findElement(By.id("Calculate"));
		btn.click();
		WebElement bmiField = driver.findElement(By.id("bmi"));
		WebElement bmiCategoryField = driver.findElement(By.id("bmi_category"));
		
		assertEquals(bmi, bmiField.getAttribute("value"));
		assertEquals(bmiCategory, bmiCategoryField.getAttribute("value"));
	}
}
