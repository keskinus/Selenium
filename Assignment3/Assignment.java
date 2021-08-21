package odev3;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment {
		private WebDriver driver;
		
		@Before
		public void setUp() {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
			driver = new ChromeDriver();	
			driver.get("https://www.indeed.com/");
		}
		
		@After
		public void tearDown() {
			driver.quit();
		}

		@Test
		
		public void job() throws InterruptedException {
	
			
			WebElement whatButton = driver.findElement( By.id ("text-input-what"));
			whatButton.clear();
		    WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));		
			//whatButton.clear();
			whatButton.sendKeys("QA");
	
			
			  
	
			 WebElement whereButton = driver.findElement( By.id ("text-input-where"));
			//driver.findElement(By.name("l")).clear();
			
			 //whereButton.clear();
			 whereButton.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END));
			 //whereButton.sendKeys(Keys.DELETE);
			 WebDriverWait wait1 = new WebDriverWait(driver, 10);
			 wait1.until(ExpectedConditions.visibilityOfElementLocated(By.name("l")));			
			 whereButton.sendKeys("San Jose, CA" );

			
			
			 //Click Search Button
			  WebDriverWait wait2 = new WebDriverWait(driver, 10);
			  WebElement FindJobsButton=wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));	
			  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			  FindJobsButton.click();
			 
			 
			  List<WebElement> results = driver.findElements(By.xpath(
					 // "//t[@class='resultContent']"
			 			 "//div[@class='job_seen_beacon']"
					  ));
				  System.out.println(results.size());
				  for (WebElement result: results){
					  WebElement jobTitle = result.findElement(By.xpath(
							"//div[@class='seo-breadcrumbs-centered']/div/a//span"));
					  WebElement companyName = result.findElement(By.cssSelector(".companyName"));
					  WebElement companyLocation = result.findElement(By.cssSelector(".companyLocation"));
					
					  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

					  System.out.println("<============================>");  
					System.out.println(jobTitle.getText()+ "\n " + companyName.getText()+"\n " + companyLocation.getText());

				  }
}
}