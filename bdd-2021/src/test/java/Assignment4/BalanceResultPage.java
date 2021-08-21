package Assignment4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BalanceResultPage {
	@FindBy(xpath = "//*[@id='balenquiry']/tbody/tr[6]/td[2]")
	
	private WebElement account;
	
	@FindBy(xpath = "//*[@id='balenquiry']/tbody/tr[11]/td[2]")
	private WebElement type;
	
	@FindBy(xpath = "//*[@id='balenquiry']/tbody/tr[16]/td[2]")
	private WebElement balance;
	
	public BalanceResultPage(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(driver, this);
	}
	
	public String getAccount() {
		return account.getText();
	}
	public String getType() {
		return type.getText();
	}
	public String getBalance() {
		return balance.getText();
	}
}
