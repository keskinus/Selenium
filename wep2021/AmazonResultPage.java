package wat2021;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonResultPage {
	@FindAll({
		@FindBy(css = ".s-main-slot.s-result-list > [data-asin][data-uuid]")
	})
	private List<WebElement> books;
	private LocatorMap amazonLocator;
	
	public AmazonResultPage(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
		amazonLocator = new LocatorMap("properties/amazon.property");
	}
	
	public void printTitles() {
		for (WebElement book: books) {
			String title = book.findElement(amazonLocator.getLocator("title")).getText();
			System.out.println(title);
		}
	}
}
