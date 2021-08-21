package wat2021;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileReader;
import java.io.IOException;
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

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

@RunWith(Parameterized.class)
public class BmiDdtPom {
	private WebDriver driver;
	private String height;
	private String weight;
	private String bmi;
	private String bmiCategory;
	
	private BmiPage page;
	
	public BmiDdtPom(String height, String weight, String bmi, String bmiCategory) {
		this.height = height;
		this.weight = weight;
		this.bmi = bmi;
		this.bmiCategory = bmiCategory;
	}
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		driver = new ChromeDriver();
		page = new BmiPage(driver);
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Parameters
	public static List<String[]> getBmiTestData() throws IOException, CsvException {
		String filename = "./data/bmi.csv";
		CSVReader reader = new CSVReader(new FileReader(filename));
		List<String[]> entries = reader.readAll();
		reader.close();
		return entries;
	}
	
	@Test
	public void testBmi() {
		page.setHeight(height);
		page.setWeight(weight);
		page.calculate();
		assertEquals(bmi, page.getBmi());
		assertEquals(bmiCategory, page.getBmiCategory());
	}
}
