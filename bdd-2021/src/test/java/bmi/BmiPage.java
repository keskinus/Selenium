package bmi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BmiPage {
	private static String URL = "http://localhost:8080/workspace/bmicalculator.html";
	
	// PageFactory:
	// every WebElement you are going to interact with is an instance variable in POM
	@FindBy(id = "heightCMS")
	private WebElement heightField;
	
	@FindBy(how = How.ID, using="weightKg")
	private WebElement weightField;
	
	@FindBy(id = "Calculate")
	private WebElement calculateBtn;
	
	@FindBy(id = "bmi")
	private WebElement bmiField;
	
	@FindBy(id = "bmi_category")
	private WebElement bmiCategoryField;
	
	public BmiPage(WebDriver driver) {
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}
	
	public void setHeight(String height) {
		heightField.clear();
		heightField.sendKeys(height);
	}
	
	public void setWeight(String weight) {
		weightField.clear();
		weightField.sendKeys(weight);		
	}
	
	public void calculate() {
		calculateBtn.click();
	}
	
	public String getBmi() {
		return bmiField.getAttribute("value");
	}
	
	public String getBmiCategory() {
		return bmiCategoryField.getAttribute("value");		
	}
}



