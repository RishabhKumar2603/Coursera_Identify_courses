package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

//	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@placeholder='What do you want to learn?']")
	WebElement searchBox;
	
	@FindBy(xpath="//span[normalize-space()='webdevelopment courses']")
	WebElement firstelement;
	
	
	
	
	public void search() {
		searchBox.sendKeys("webdevlopment");
	}
	
	public void clickOnSearchedResult() {
		firstelement.click();
	}
	
	

}
