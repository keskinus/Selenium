package odev3;

import java.util.concurrent.TimeUnit;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

@RunWith(JUnitPlatform.class)
public class IndeedHomePage extends LoadableComponent<IndeedHomePage> {
	private static final String URL = "https://www.indeed.com/";
	private WebDriver driver;	
	
	protected void load() {
		driver.get(URL);
	}
	
	
	protected void isLoaded() throws Error {
		String url = driver.getCurrentUrl();
		if (!url.contains("indeed")) {
			throw new Error("Invalid page");
		
	}
	}
	
	public IndeedHomePage (WebDriver driver) {
			this.driver= driver;
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			PageFactory.initElements(driver,this);
	
	}
	
}

