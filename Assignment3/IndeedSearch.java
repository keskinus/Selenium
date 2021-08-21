
	package odev3;

	import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.How;
	import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class IndeedSearch {
		private static String URL = "https://www.indeed.com/";
	
		
		private WebDriver driver;
		private WebDriverWait wait;
		
		// PageFactory:
		// every WebElement you are going to interact with is an instance variable in POM
		@FindBy (id ="text-input-what")
		private WebElement whatButton;
		
		
		@FindBy (id ="text-input-where")
		private WebElement whereButton;
		
		
		@FindBy(xpath="//button[@type='submit']")
		private WebElement searchBtn;
	

		
		public IndeedSearch(WebDriver driver) {
			driver.get(URL);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			PageFactory.initElements(driver, this);
		}
		
		
		public IndeedSearch searchJob(String what, String where) {
			enterWhat(what);
			enterWhere(where);
			search();
			
			
			return new IndeedSearch(driver);
		}
		
		private void enterWhat(String what) {
			whatButton.click();
			whatButton.clear();
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(whatButton));
			whatButton.sendKeys(what);
			
		}
		
		private void enterWhere(String where) {
			whereButton.click();
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(whereButton));
			whereButton.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END));
			whereButton.clear();
			whereButton.sendKeys(where);
			
		
		}
		
		private void search() {
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
			searchBtn.click();
		}
	}
		



