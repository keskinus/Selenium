package odev3;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import wat2021.LocatorMap;

public class IndeedResultPage extends LoadableComponent<IndeedResultPage>{
	private WebDriver driver;
		@FindAll({
			@FindBy(xpath = "//div[@class='job_seen_beacon']")
		})
		private List<WebElement> results;
		private LocatorMap jobMap;
		
		
		
		protected void load() {}
		protected void isLoaded() throws Error {
			if (!isResultSearchable()) {
				throw new Error("Failed to search");
			}
		}
		
		
		private boolean isResultSearchable() {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 60);
//				wait.until(ExpectedConditions.invisibilityOf(loadingBar));
//				wait = new WebDriverWait(driver, 60);
				wait.until(ExpectedConditions.visibilityOf(searchBtn));
			} catch (Exception ex) {
				return false;
			}
			return true;
		}
		
		
		public IndeedResultPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			jobMap = new LocatorMap("properties/indeed.property");
		}
			
		
		
		public void report() {
			 System.out.println(results.size());
			for (WebElement result : results) {
				WebElement jobTitle = result.findElement(jobMap.getLocator("jobTitle"));
				WebElement companyName = result.findElement(jobMap.getLocator("companyName"));
				WebElement companyLocation = result.findElement(jobMap.getLocator("companyLocation"));
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				System.out.println("<============================>");  
				System.out.println(jobTitle.getText()+ "\n " + companyName.getText()+"\n " + companyLocation.getText());

			}

		}
	




		  WebElement jobTitle = result.findElement(By.xpath(
				"//div[@class='seo-breadcrumbs-centered']/div/a//span"));
		  WebElement companyName = result.findElement(By.cssSelector(".companyName"));
		  WebElement companyLocation = result.findElement(By.cssSelector(".companyLocation"));
	

